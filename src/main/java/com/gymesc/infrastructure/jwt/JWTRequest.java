package com.gymesc.infrastructure.jwt;

import java.util.Date;

import com.google.gson.JsonObject;

public class JWTRequest {

	private String issuer;
	private String secret;
	private String audience;
	private String type;
	private Date issuedAt;
	private Date expiration;
	private JsonObject request;

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getAudience() {
		return audience;
	}

	public void setAudience(String audience) {
		this.audience = audience;
	}

	public Date getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public JsonObject getRequest() {
		return request;
	}

	public void setRequest(JsonObject request) {
		this.request = request;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
