package com.example.demo.utils;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;
import java.util.Objects;

public class TextView extends AbstractView {

	private CharBuffer text;
	private Charset charset;

	public TextView(CharBuffer text, Charset charset) {
		Objects.requireNonNull(text);
		Objects.requireNonNull(charset);
		setContentType("text/plain");
		this.text = text;
		this.charset = charset;
	}

	public TextView(CharBuffer text, String charsetName) throws UnsupportedCharsetException {
		this(text, Charset.forName(charsetName));
	}

	public TextView(String text, Charset charset) {
		this(CharBuffer.wrap(text), charset);
	}

	public TextView(String text, String charsetName) throws UnsupportedCharsetException {
		this(CharBuffer.wrap(text), Charset.forName(charsetName));
	}

	public TextView(CharSequence text, Charset charset) {
		this(text instanceof CharBuffer ? (CharBuffer) text : CharBuffer.wrap(text), charset);
	}

	public TextView(CharSequence text, String charsetName) throws UnsupportedCharsetException {
		this(text, Charset.forName(charsetName));
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try (ServletOutputStream out = response.getOutputStream()) {
			ByteBuffer encoded = charset.encode(text);
			out.write(encoded.array());
		}
	}

}
