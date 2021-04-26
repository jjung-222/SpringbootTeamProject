package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Product;
import com.mycompany.webapp.dto.ProductImgs;
import com.mycompany.webapp.service.ProductImgsService;
import com.mycompany.webapp.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController{
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
   @Autowired
   private ProductService productService;
   @Autowired   
   private ProductImgsService productImgsService;
   
   
   @GetMapping("")
   public Map<String, Object> list(@RequestParam(defaultValue="1") int pageNo) {
      int totalRows = productService.getCount();
      Pager pager = new Pager(5, 5, totalRows, pageNo);
      List<Product> list = productService.pSelectByPage(pager);
      Map<String, Object> map = new HashMap<>();
      map.put("products", list);
      map.put("pager", pager);
      return map;
   }
   
   @GetMapping("/mainlist")
   public Map<String, Object> mainlist() {
      int totalRows = productService.getCount();
      List<Product> best = productService.pSelectBest();      
      List<Product> newitem = productService.pSelectBest();      
      Map<String, Object> map = new HashMap<>();
      map.put("totalRows", totalRows);
      map.put("best", best);
      map.put("newitem", newitem);      
      return map;
   }
   
   @PostMapping("")
   public void create(Product product) {
	  if(product.getPattach1() != null && !product.getPattach1().isEmpty()) {
          MultipartFile mf = product.getPattach1();
          product.setDetailimgoname(mf.getOriginalFilename());
          product.setDetailimgsname(new Date().getTime() + "-" + mf.getOriginalFilename());
          product.setDetailimgtype(mf.getContentType());
          try {
             File file = new File("C:/team5_spring_img/image/" + product.getDetailimgsname());
             mf.transferTo(file);
          } catch (Exception e) {
             e.printStackTrace();
          }
       }     
      productService.pInsert(product);
      List<ProductImgs> imglist = new ArrayList<ProductImgs>();
      if(product.getPattach2() != null && !product.getPattach2().isEmpty()) {
    	  ProductImgs productImgs2 = new ProductImgs(product.getPattach2());
    	  productImgs2.setIpriority(1);  
    	  imglist.add(productImgs2);
      }else {
    	  ProductImgs productimg = new ProductImgs("null", "null", "null", 0);
    	  productimg.setProductno(product.getProductno());
    	  imglist.add(productimg);
      }
      if(product.getPattach3() != null && !product.getPattach3().isEmpty()) {
    	  ProductImgs productImgs3 = new ProductImgs(product.getPattach3());
    	  productImgs3.setIpriority(0);
    	  imglist.add(productImgs3);
      }else {
    	  ProductImgs productimg = new ProductImgs("null", "null", "null", 0);
    	  productimg.setProductno(product.getProductno());  
    	  imglist.add(productimg);
      }
      if(product.getPattach4() != null && !product.getPattach4().isEmpty()) {
    	  ProductImgs productImgs4 = new ProductImgs(product.getPattach4());
    	  productImgs4.setIpriority(0);  
    	  imglist.add(productImgs4);
      }else {
    	  ProductImgs productimg = new ProductImgs("null", "null", "null", 0);
    	  productimg.setProductno(product.getProductno()); 
    	  imglist.add(productimg);
      }
      if(product.getPattach5() != null && !product.getPattach5().isEmpty()) {
    	  ProductImgs productImgs5 = new ProductImgs(product.getPattach5());
    	  productImgs5.setIpriority(0);    
    	  imglist.add(productImgs5); 
      }else {
    	  ProductImgs productimg = new ProductImgs("null", "null", "null", 0);
    	  productimg.setProductno(product.getProductno()); 
    	  imglist.add(productimg);
      }
                
      for(int i=0; i<imglist.size(); i++) {
          if(imglist.get(i).getPattach() != null && !imglist.get(i).getPattach().isEmpty()) {
              MultipartFile mf = imglist.get(i).getPattach();
              imglist.get(i).setIoriginalname(mf.getOriginalFilename());
              imglist.get(i).setIsavename(new Date().getTime() + "-" + mf.getOriginalFilename());
              imglist.get(i).setImgtype(mf.getContentType());
              imglist.get(i).setProductno(product.getProductno());
              try {
                 File file = new File("C:/team5_spring_img/image/" + imglist.get(i).getIsavename());
                 mf.transferTo(file);
              } catch (Exception e) {
                 e.printStackTrace();
              }
           } 
          productImgsService.pImgInsert(imglist.get(i));
      }
   }
   
   @GetMapping("/{productno}")
   public Map<String, Object> read(@PathVariable int productno) {
      Product product = productService.pSelectByPno(productno);
      List<ProductImgs> imglist = productImgsService.pImgSelectByPno(productno);
      logger.info("리드 이미지넘:"+Integer.toString(imglist.get(0).getImgno()));
      Map<String, Object> map = new HashMap<>();
      map.put("product", product);
      map.put("imglist", imglist);
      return map;
   }   
   
   @GetMapping("/battach/{productno}") //이 순서에 맞게 postman 작성
   public void download(@PathVariable int productno, HttpServletResponse response) {
      try {
    	 Product product = productService.pSelectByPno(productno);
         String battachoname = product.getDetailimgoname();
         if(battachoname == null) return;
         battachoname = new String(battachoname.getBytes("UTF-8"),"ISO-8859-1");
         String battachsname = product.getDetailimgsname();      
         String battachspath = "C:/team5_spring_img/image/" + battachsname;
         String battachtype = product.getDetailimgtype();
   
         response.setHeader("Content-Disposition", "attachment; filename=\""+battachoname+"\";");
         response.setContentType(battachtype);

         InputStream is = new FileInputStream(battachspath);
         OutputStream os = response.getOutputStream();
         FileCopyUtils.copy(is, os);
         is.close();
         os.flush();
         os.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   @GetMapping("/imgbattach/{imgno}") //이 순서에 맞게 postman 작성
   public void imgdownload(@PathVariable int imgno, HttpServletResponse response) {
      try {
    	 ProductImgs productimgs = productImgsService.pImgSelectByIno(imgno);
    	 if(!productimgs.getIoriginalname().equals("null")) {
	         String battachoname = productimgs.getIoriginalname();
	         if(battachoname == null) return;
	         battachoname = new String(battachoname.getBytes("UTF-8"),"ISO-8859-1");
	         String battachsname = productimgs.getIsavename();      
	         String battachspath = "C:/team5_spring_img/image/" + battachsname;
	         String battachtype = productimgs.getImgtype();
	   
	         response.setHeader("Content-Disposition", "attachment; filename=\""+battachoname+"\";");
	         response.setContentType(battachtype);
	
	         InputStream is = new FileInputStream(battachspath);
	         OutputStream os = response.getOutputStream();
	         FileCopyUtils.copy(is, os);
	         is.close();
	         os.flush();
	         os.close();
    	 }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @PutMapping("")
   public void update(Product product) {
	  if(product.getPattach1() != null && !product.getPattach1().isEmpty()) {
          MultipartFile mf = product.getPattach1();
          product.setDetailimgoname(mf.getOriginalFilename());
          product.setDetailimgsname(new Date().getTime() + "-" + mf.getOriginalFilename());
          product.setDetailimgtype(mf.getContentType());
          try {
             File file = new File("C:/team5_spring_img/image/" + product.getDetailimgsname());
             mf.transferTo(file);
          } catch (Exception e) {
             e.printStackTrace();
          }
       } 
	  productService.pUpdate(product);
	  
      List<ProductImgs> imglist = new ArrayList<ProductImgs>();
      if(product.getPattach2() != null && !product.getPattach2().isEmpty()) {
    	  ProductImgs productImgs2 = productImgsService.pImgSelectByIno(product.getImgno1());
    	  productImgs2.setPattach(product.getPattach2());
    	  imglist.add(productImgs2);
      }else {
    	  ProductImgs productimg = productImgsService.pImgSelectByIno(product.getImgno1());
    	  imglist.add(productimg);
      }
      if(product.getPattach3() != null && !product.getPattach3().isEmpty()) {
    	  ProductImgs productImgs3 = productImgsService.pImgSelectByIno(product.getImgno2());
    	  productImgs3.setPattach(product.getPattach3());
    	  imglist.add(productImgs3);
      }else {
    	  ProductImgs productimg = productImgsService.pImgSelectByIno(product.getImgno2());
    	  imglist.add(productimg);
      }
      if(product.getPattach4() != null && !product.getPattach4().isEmpty()) {
    	  ProductImgs productImgs4 = productImgsService.pImgSelectByIno(product.getImgno3());
    	  productImgs4.setPattach(product.getPattach4());
    	  imglist.add(productImgs4);
      }else {
    	  ProductImgs productimg = productImgsService.pImgSelectByIno(product.getImgno3());
    	  imglist.add(productimg);
      }
      if(product.getPattach5() != null && !product.getPattach5().isEmpty()) {
    	  ProductImgs productImgs5 = productImgsService.pImgSelectByIno(product.getImgno4());
    	  productImgs5.setPattach(product.getPattach5());
    	  imglist.add(productImgs5); 
      }else {
    	  ProductImgs productimg = productImgsService.pImgSelectByIno(product.getImgno4());
    	  imglist.add(productimg);
      }
      
      for(int i=0; i<imglist.size(); i++) {
          if(imglist.get(i).getPattach() != null && !imglist.get(i).getPattach().isEmpty()) {
              MultipartFile mf = imglist.get(i).getPattach();
              imglist.get(i).setIoriginalname(mf.getOriginalFilename());
              imglist.get(i).setIsavename(new Date().getTime() + "-" + mf.getOriginalFilename());
              imglist.get(i).setImgtype(mf.getContentType());
              imglist.get(i).setProductno(product.getProductno());
              try {
                 File file = new File("C:/team5_spring_img/image/" + imglist.get(i).getIsavename());
                 mf.transferTo(file);
              } catch (Exception e) {
                 e.printStackTrace();
              }
           }
          
          productImgsService.pImgUpdate(imglist.get(i));
      }   
   }
   
   @DeleteMapping("/{productno}")
   public void delete(@PathVariable int productno) {
      productService.pUpdateEnable(productno);
   }
}