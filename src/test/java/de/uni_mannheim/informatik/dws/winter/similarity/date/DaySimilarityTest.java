/*
 * Copyright (c) 2017 Data and Web Science Group, University of Mannheim, Germany (http://dws.informatik.uni-mannheim.de/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package de.uni_mannheim.informatik.dws.winter.similarity.date;

import org.joda.time.DateTime;

import de.uni_mannheim.informatik.dws.winter.similarity.date.DaySimilarity;
import junit.framework.TestCase;

public class DaySimilarityTest extends TestCase {

	public void testCalculateDateTimeDateTime() {
		DaySimilarity sim = new DaySimilarity(300);
		
		DateTime dt1 = DateTime.parse("2015-01-01");
		DateTime dt2 = DateTime.parse("2015-01-31");
		DateTime dt3 = DateTime.parse("2015-05-31");
		DateTime dt4 = DateTime.parse("2005-01-01");
		DateTime dt5 = DateTime.parse("1905-01-01");
		
		assertEquals(1.0, sim.calculate(dt1, dt1));
		assertEquals(0.9, sim.calculate(dt1, dt2));
		assertEquals(0.9, sim.calculate(dt2, dt1));
		assertEquals(0.5, sim.calculate(dt1, dt3));
		assertEquals(0.0, sim.calculate(dt1, dt4));
		assertEquals(0.0, sim.calculate(dt1, dt5));
	}

}