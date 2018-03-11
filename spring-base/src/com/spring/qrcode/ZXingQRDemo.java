package com.spring.qrcode;

/*public class ZXingQRDemo {
	@RequestMapping(params="downloadQRCode")
	public void downloadQRCode(HttpServletRequest request,HttpServletResponse response){
		//设置字符集编码
		Map<EncodeHintType,Object> his = new HashMap<EncodeHintType,Object>();
		his.put(EncodeHintType.CHARACTER_SET, "utf-8");
		//his.put(EncodeHintType.MARGIN, 1);
		
		String contents = "http://www.baidu.com";
		int width = 200;
		int height = 200;
		try {
			BitMatrix matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, his);
			//将二维码放入缓冲流
 			OutputStream os = response.getOutputStream();
 			response.setContentType("multipart/form-data");
 			response.addHeader("Content-Disposition", "attachment;filename=hi.png");
 			//response.setContentType("application/octet-stream");
 			matrix = deleteWhite(matrix);
			MatrixToImageWriter.writeToStream(matrix, "png", response.getOutputStream());
			//os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(params="downloadQRCode3")
	public void downloadQRCode3(HttpServletRequest request,HttpServletResponse response){
		//设置字符集编码
		Map<EncodeHintType,Object> his = new HashMap<EncodeHintType,Object>();
		his.put(EncodeHintType.CHARACTER_SET, "utf-8");
		his.put(EncodeHintType.MARGIN, 1);
		
		int BLACK = 0xFF000000;
		int WHITE = 0xFFFFFFFF;
		String contents = "http://www.baidu.com";
		int width = 100;
		int height = 100;
		try {
			BitMatrix matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, his);
			//获取二维码宽高
			int codeWidth = matrix.getWidth();
			int codeHeight = matrix.getHeight();
			//将二维码放入缓冲流
			BufferedImage image = new BufferedImage(codeWidth,codeHeight,BufferedImage.TYPE_INT_RGB);
			for(int i=0;i<codeWidth;i++){
				for(int j=0;j<codeHeight;j++){
					image.setRGB(i, j, matrix.get(i, j) ? BLACK : WHITE);
				}
			}
 			OutputStream os = response.getOutputStream();
 			response.setContentType("multipart/form-data");
 			response.addHeader("Content-Disposition", "attachment;filename=hii.jpg");
 			//response.setContentType("application/octet-stream");
 			ImageIO.write(image, "jpg", os);
			//os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static BitMatrix deleteWhite(BitMatrix matrix) {
        int[] rec = matrix.getEnclosingRectangle();
        int resWidth = rec[2] + 1;
        int resHeight = rec[3] + 1;

        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();
        for (int i = 0; i < resWidth; i++) {
            for (int j = 0; j < resHeight; j++) {
                if (matrix.get(i + rec[0], j + rec[1]))
                    resMatrix.set(i, j);
            }
        }
        return resMatrix;
    }
}
*/