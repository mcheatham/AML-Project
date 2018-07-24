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
* Computes the linear weighted combination between two alignments (simple     *
* mappings only).                                                             *
*                                                                             *
* @author Catarina Martins, Daniel Faria                                      *
******************************************************************************/
package aml.alignment;

public class LWC
{

//Constructors
	
	private LWC(){}
	
//Public Methods
	
	/**
	 * Computes the linear weighted combination between two alignments.
	 * @param a: the first alignment to combine
	 * @param b: the second alignment to combine
	 * @param weight: the weight to use in combining the alignment
	 * (similarities from a are multiplied by weight and similarities from b are
	 * multiplied by 1-weight)
	 * @return: the combined alignment
	 */
	public static SimpleAlignment combine(SimpleAlignment a, SimpleAlignment b, double weight)
	{
		SimpleAlignment combine = new SimpleAlignment();
	
		for(AbstractMapping m: a)
		{
			if(m instanceof SimpleMapping)
			{
				double similarity = m.getSimilarity()*weight;
				if(b.contains(m))
					similarity += b.getSimilarity((String)m.getEntity1(), (String)m.getEntity2())*(1-weight);
				combine.add((String)m.getEntity1(),(String)m.getEntity2(),similarity);
			}
		}
		for(AbstractMapping m : b)
		{
			if(!a.contains(m) && m instanceof SimpleMapping)
			{
				double similarity = m.getSimilarity()*(1-weight);
				combine.add((String)m.getEntity1(),(String)m.getEntity2(),similarity);
			}
		}
		return combine;
	}	
}