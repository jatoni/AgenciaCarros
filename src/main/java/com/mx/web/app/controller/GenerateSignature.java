package com.mx.web.app.controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

@Named
@SessionScoped
public class GenerateSignature implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1168715152640209284L;
	private String signature;
	private static final String IMAGE_FORMAT = "png";
	private static final int SIGNATURE_HEIGHT = 200;
	private static final int SIGNATURE_WIDTH = 400;

	private static class Point {
		private int x;
		private int y;

		public Point(float x, float y) {
			this.x = Math.round(x);
			this.y = Math.round(y);
		}
	}

	public void guardar() {
		OutputStream out;
		try {
			out = new FileOutputStream("C:\\Users\\jat_a\\OneDrive\\Escritorio\\Escuela");
			generateSignature(signature, out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void generateSignature(String jsonEncoding, OutputStream output) {
		try {
			output.write(redrawSignature(extractSignature(jsonEncoding)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<List<Point>> extractSignature(String jsonEncoding) {
		List<List<Point>> lines = new ArrayList<List<Point>>();
		Matcher lineMatcher = Pattern.compile("(\\[(?:,?\\[-?[\\d\\.]+,-?[\\d\\.]+\\])+\\])").matcher(jsonEncoding);
		while (lineMatcher.find()) {
			Matcher pointMatcher = Pattern.compile("\\[(-?[\\d\\.]+),(-?[\\d\\.]+)\\]").matcher(lineMatcher.group(1));
			List<Point> line = new ArrayList<Point>();
			lines.add(line);
			while (pointMatcher.find()) {
				line.add(new Point(Float.parseFloat(pointMatcher.group(1)), Float.parseFloat(pointMatcher.group(2))));
			}
		}
		return lines;
	}

	private static byte[] redrawSignature(List<List<Point>> lines) throws IOException {
		BufferedImage signature = new BufferedImage(SIGNATURE_WIDTH, SIGNATURE_HEIGHT, BufferedImage.TYPE_BYTE_GRAY);
		Graphics2D g = (Graphics2D) signature.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, signature.getWidth(), signature.getHeight());
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Point lastPoint = null;
		for (List<Point> line : lines) {
			for (Point point : line) {
				if (lastPoint != null) {
					g.drawLine(lastPoint.x, lastPoint.y, point.x, point.y);
				}
				lastPoint = point;
			}
			lastPoint = null;
		}
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageIO.write(signature, IMAGE_FORMAT, output);
		ImageIO.write(signature, IMAGE_FORMAT, output);
		return output.toByteArray();
	}

	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

}
