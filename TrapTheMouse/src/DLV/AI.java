package DLV;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import DATA.Cell;

public class AI {

	public List<Cell> mossa(int sg[][], List<Object> ar, List<Object> paths) {
		Set<Cell> matrix = new HashSet<Cell>();
		Set<Cell> minPath = new HashSet<Cell>();
		Set<Cell> endPaths = new HashSet<Cell>();
		int size = ar.size();
		List<Cell> res = new ArrayList<Cell>();
		for (int i = 0; i < sg.length; i++) {
			for (int j = 0; j < sg.length; j++) {
				Cell a = new Cell();
				a.setRow(i);
				a.setColumn(j);
				if (sg[i][j] == 0)
					a.setElement("jdlv_null_value");
				else if (sg[i][j] == 1)
					a.setElement("Wall");
				else
					a.setElement("Mouse");
				matrix.add(a);
			}
		}
		for (Object o : ar) {
			Cell a = new Cell();
			String s[] = o.toString().split(" ");
			a.setRow(Integer.parseInt(s[0]));
			a.setColumn(Integer.parseInt(s[1]));
			if (s[2].equals("0"))
				a.setElement("jdlv_null_value");
			else if (s[2].equals("1"))
				a.setElement("Wall");
			else
				a.setElement("Mouse");
			minPath.add(a);
		}
		for (Object o : paths) {
			Cell a = new Cell();
			String s[] = o.toString().split(" ");
			a.setRow(Integer.parseInt(s[0]));
			a.setColumn(Integer.parseInt(s[1]));
			if (s[2].equals("0"))
				a.setElement("jdlv_null_value");
			else if (s[2].equals("1"))
				a.setElement("Wall");
			else
				a.setElement("Mouse");
			endPaths.add(a);
		}

		// ---- START - startProgram ----
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Creation EXECUTING JDLV module.");
		it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_EXECUTING = new it.unical.mat.wrapper.DLVInputProgramImpl();
		_JDLV_PROGRAM_EXECUTING.cleanText();
		java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_EXECUTING = new java.lang.StringBuffer();
		it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_EXECUTING;

		// ---- END - startProgram ----

		// ---- START - addInMapping ----
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(matrix, "grafo"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add in-mapping 'matrix::grafo' in module EXECUTING:"
						+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
								.getPrettyCode(
										it.unical.mat.jdlv.program.TypeSolver
												.getNameTranslation(matrix,
														"grafo"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(minPath, "walls"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add in-mapping 'minPath::walls' in module EXECUTING:"
						+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
								.getPrettyCode(
										it.unical.mat.jdlv.program.TypeSolver
												.getNameTranslation(minPath,
														"walls"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(endPaths, "endPaths"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add in-mapping 'endPaths::endPaths' in module EXECUTING:"
						+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
								.getPrettyCode(
										it.unical.mat.jdlv.program.TypeSolver
												.getNameTranslation(endPaths,
														"endPaths"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(size, "size"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add in-mapping 'size::size' in module EXECUTING:"
						+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
								.getPrettyCode(
										it.unical.mat.jdlv.program.TypeSolver
												.getNameTranslation(size,
														"size"), 0));

		// ---- END - addInMapping ----
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add out-mapping 'res::res' in module EXECUTING.");

		// ---- START - prepareJDLVCall ----
		try {

			_JDLV_INVOCATION_EXECUTING = it.unical.mat.wrapper.DLVWrapper
					.getInstance().createInvocation(
							it.unical.mat.jdlv.util.JdlvProperties
									.getInstance().getDlvExecutablePath());
			_JDLV_PROGRAM_EXECUTING.addText(_JDLV_PROGRAM_BUFFER_EXECUTING
					.toString());
			_JDLV_PROGRAM_EXECUTING.getFiles().clear();
			_JDLV_PROGRAM_EXECUTING.addFile("src/DLV/risolviMossa.dl");
			_JDLV_INVOCATION_EXECUTING.setNumberOfModels(1);
			_JDLV_PROGRAM_BUFFER_EXECUTING.append("");
			_JDLV_INVOCATION_EXECUTING.setInputProgram(_JDLV_PROGRAM_EXECUTING);
			it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_EXECUTING = new it.unical.mat.wrapper.ModelBufferedHandler(
					_JDLV_INVOCATION_EXECUTING);
			it.unical.mat.jdlv.program.JDLV_Logger
					.getInstance()
					.logInfoMessage(
							"Start execution EXECUTING program: executablePath='"
									+ it.unical.mat.jdlv.util.JdlvProperties
											.getInstance()
											.getDlvExecutablePath()
									+ "', options='"
									+ _JDLV_INVOCATION_EXECUTING
											.getOptionsString()
									+ "'"
									+ '\n'
									+ "Code execution: "
									+ it.unical.mat.jdlv.program.JDLV_Logger
											.getInstance().getPrettyCode(
													_JDLV_INVOCATION_EXECUTING
															.getInputProgram()
															.getCompleteText(),
													0)
									+ '\n'
									+ "Files execution: src/DLV/risolviMossa.dl");
			_JDLV_INVOCATION_EXECUTING.run();
			while (_BUFFERED_HANDLER_EXECUTING.hasMoreModels()) {
				it.unical.mat.wrapper.Model _temporary_JDLV_MODELEXECUTING = _BUFFERED_HANDLER_EXECUTING
						.nextModel();
				it.unical.mat.jdlv.program.TypeSolver.loadPredicate(res, "res",
						_temporary_JDLV_MODELEXECUTING, Cell.class);
				it.unical.mat.jdlv.program.JDLV_Logger
						.getInstance()
						.logInfoMessage(
								"Process new answer_set"
										+ '\n'
										+ "Results:"
										+ '\n'
										+ "res "
										+ res.size()
										+ " elements"
										+ '\n'
										+ it.unical.mat.jdlv.program.JDLV_Logger
												.getInstance().getPrettyObject(
														res, 0));
			}
			if (_JDLV_INVOCATION_EXECUTING.haveModel() == false) {
			}
			if (!_JDLV_INVOCATION_EXECUTING.getErrors().isEmpty()) {
				throw new java.lang.RuntimeException(_JDLV_INVOCATION_EXECUTING
						.getErrors().get(0).getText());
			}
		} catch (java.lang.Throwable _JDLV_EXCEPTION_EXECUTING) {
			it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
					.logErrorMessage(_JDLV_EXCEPTION_EXECUTING.getMessage());
		}
		_JDLV_PROGRAM_EXECUTING.cleanText();

		// ---- END - prepareJDLVCall ----
		return res;
	}
}
