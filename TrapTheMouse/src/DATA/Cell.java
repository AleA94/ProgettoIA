package DATA;

public class Cell {

	private String element;
	private int row;
	private int column;

	public Cell() {
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public String toString() {
		return "(" + element + ", " + row + ", " + column + ")";
	}

}
