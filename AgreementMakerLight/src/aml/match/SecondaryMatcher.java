/******************************************************************************
* Copyright 2013-2018 LASIGE                                                  *
*                                                                             *
* Licensed under the Apache License, Version 2.0 (the "License"); you may     *
* not use this file except in compliance with the License. You may obtain a   *
* copy of the License at http://www.apache.org/licenses/LICENSE-2.0           *
*                                                                             *
* Unless required by applicable law or agreed to in writing, software         *
* distributed under the License is distributed on an "AS IS" BASIS,           *
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.    *
* See the License for the specific language governing permissions and         *
* limitations under the License.                                              *
*                                                                             *
*******************************************************************************
* A matching algorithm that extends a previous Alignment, returning new       *
* Mappings between the source and target ontologies.                          *
*                                                                             *
* @author Daniel Faria                                                        *
******************************************************************************/
package aml.match;

import aml.alignment.SimpleAlignment;
import aml.ontology.EntityType;
import aml.ontology.Ontology;

public interface SecondaryMatcher
{
	/**
	 * Extends the given Alignment between the source and target Ontologies
	 * @param o1: the source Ontology to match
	 * @param o2: the target Ontology to match
	 * @param a: the existing alignment to extend
	 * @param e: the EntityType to match
	 * @param thresh: the similarity threshold for the extention
	 * @return the alignment with (only) the new mappings between the Ontologies
	 */
	public SimpleAlignment extendAlignment(Ontology o1, Ontology o2, SimpleAlignment a, EntityType e, double thresh);
}
