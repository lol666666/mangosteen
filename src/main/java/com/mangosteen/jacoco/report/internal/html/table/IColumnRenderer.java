/*******************************************************************************
 * Copyright (c) 2009, 2019 Mountainminds GmbH & Co. KG and Contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Marc R. Hoffmann - initial API and implementation
 *
 *******************************************************************************/
package com.mangosteen.jacoco.report.internal.html.table;

import com.mangosteen.jacoco.core.analysis.ICoverageNode;
import com.mangosteen.jacoco.report.internal.ReportOutputFolder;
import com.mangosteen.jacoco.report.internal.html.resources.Resources;
import com.mangosteen.jacoco.report.internal.html.HTMLElement;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

/**
 * Renderer for a single column of a coverage table. The methods are always
 * called in the sequence <code>init header footer item*</code>. Implementations
 * might be stateful.
 */
public interface IColumnRenderer {

	/**
	 * Initializes the column before any output method is called.
	 *
	 * @param items
	 *            all items that will be displayed in the table
	 * @param total
	 *            the summary of all coverage data items in the table
	 * @return <code>true</code> if the column should be visible
	 */
	boolean init(List<? extends ITableItem> items, ICoverageNode total);

	/**
	 * Renders the footer for this column.
	 *
	 * @param td
	 *            the parent table cell
	 * @param total
	 *            the summary of all coverage data items in the table
	 * @param resources
	 *            static resources that might be referenced
	 * @param base
	 *            base folder of the table
	 * @throws IOException
	 *             in case of IO problems with the element output
	 */
	void footer(HTMLElement td, ICoverageNode total, Resources resources,
                ReportOutputFolder base) throws IOException;

	/**
	 * Renders a single item in this column.
	 *
	 * @param td
	 *            the parent table cell
	 * @param item
	 *            the item to display
	 * @param resources
	 *            static resources that might be referenced
	 * @param base
	 *            base folder of the table
	 * @throws IOException
	 *             in case of IO problems with the element output
	 */
	void item(HTMLElement td, ITableItem item, Resources resources,
              ReportOutputFolder base) throws IOException;

	/**
	 * Returns the comparator to sort this table column.
	 *
	 * @return comparator for this column
	 */
	Comparator<ITableItem> getComparator();

}
