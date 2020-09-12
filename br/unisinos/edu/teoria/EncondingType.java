package br.unisinos.edu.teoria;

public enum EncondingType {
	Golomb(0), EliasGama(1), Fibonacci(2), Unary(3), Delta(4);

	private final byte code;

	private EncondingType(final int code) {
		this.code = (byte) code;
	}

	public byte getCode() {
		return code;
	}
}