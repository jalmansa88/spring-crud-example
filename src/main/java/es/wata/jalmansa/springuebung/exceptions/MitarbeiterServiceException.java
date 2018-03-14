package es.wata.jalmansa.springuebung.exceptions;

public class MitarbeiterServiceException extends Exception {

	private static final long serialVersionUID = 4330076778983700200L;

	private Integer exceptionCode;
	
	public MitarbeiterServiceException(Integer exceptionCode) {
		super();
		this.exceptionCode = exceptionCode;
	}
	
	public MitarbeiterServiceException(Integer exceptionCode, String message) {
		super(message);
		this.exceptionCode = exceptionCode;
	}

	public Integer getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(Integer exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

}
