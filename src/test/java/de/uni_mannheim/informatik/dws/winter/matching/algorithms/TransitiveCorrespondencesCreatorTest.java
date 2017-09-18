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
package de.uni_mannheim.informatik.dws.winter.matching.algorithms;

import de.uni_mannheim.informatik.dws.winter.model.Correspondence;
import de.uni_mannheim.informatik.dws.winter.model.Matchable;
import de.uni_mannheim.informatik.dws.winter.model.defaultmodel.Record;
import de.uni_mannheim.informatik.dws.winter.processing.Processable;
import de.uni_mannheim.informatik.dws.winter.processing.ProcessableCollection;
import junit.framework.TestCase;

/**
 * @author Oliver Lehmberg (oli@dwslab.de)
 *
 */
public class TransitiveCorrespondencesCreatorTest extends TestCase {

	/**
	 * Test method for {@link de.uni_mannheim.informatik.dws.winter.matching.algorithms.TransitiveCorrespondencesCreator#run()}.
	 */
	public void testRun() {
		
		ProcessableCollection<Correspondence<Record, Matchable>> cors = new ProcessableCollection<>();
		Correspondence<Record, Matchable> ab = new Correspondence<Record, Matchable>(new Record("a"), new Record("b"), 1.0);
		Correspondence<Record, Matchable> bc = new Correspondence<Record, Matchable>(new Record("b"), new Record("c"), 1.0);
		cors.add(ab);
		cors.add(bc);
		
		TransitiveCorrespondencesCreator<Record, Matchable> transitivity = new TransitiveCorrespondencesCreator<>(cors);
		transitivity.run();
		
		Processable<Correspondence<Record, Matchable>> result = transitivity.getResult();
		
		Correspondence<Record, Matchable> expected = new Correspondence<Record, Matchable>(new Record("a"), new Record("c"), 1.0);
		
		assertEquals(true, result.get().contains(ab));
		assertEquals(true, result.get().contains(bc));
		assertEquals(true, result.get().contains(expected));
		
	}

}
