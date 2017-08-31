/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.parse.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.sema.*;


/// \brief RAIIObject to destroy the contents of a SmallVector of
/// TemplateIdAnnotation pointers and clear the vector.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyTemplateIdAnnotationsRAIIObj">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 44,
 FQN="(anonymous namespace)::DestroyTemplateIdAnnotationsRAIIObj", NM="_ZN12_GLOBAL__N_135DestroyTemplateIdAnnotationsRAIIObjE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN12_GLOBAL__N_135DestroyTemplateIdAnnotationsRAIIObjE")
//</editor-fold>
public class DestroyTemplateIdAnnotationsRAIIObj implements Destructors.ClassWithDestructor {
  private SmallVectorImpl<TemplateIdAnnotation /*P*/ > /*&*/ Container;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyTemplateIdAnnotationsRAIIObj::DestroyTemplateIdAnnotationsRAIIObj">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 48,
   FQN="(anonymous namespace)::DestroyTemplateIdAnnotationsRAIIObj::DestroyTemplateIdAnnotationsRAIIObj", NM="_ZN12_GLOBAL__N_135DestroyTemplateIdAnnotationsRAIIObjC1ERN4llvm15SmallVectorImplIPN5clang20TemplateIdAnnotationEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN12_GLOBAL__N_135DestroyTemplateIdAnnotationsRAIIObjC1ERN4llvm15SmallVectorImplIPN5clang20TemplateIdAnnotationEEE")
  //</editor-fold>
  public DestroyTemplateIdAnnotationsRAIIObj(SmallVectorImpl<TemplateIdAnnotation /*P*/ > /*&*/ Container) {
    // : Container(Container) 
    //START JInit
    this./*&*/Container=/*&*/Container;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DestroyTemplateIdAnnotationsRAIIObj::~DestroyTemplateIdAnnotationsRAIIObj">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 52,
   FQN="(anonymous namespace)::DestroyTemplateIdAnnotationsRAIIObj::~DestroyTemplateIdAnnotationsRAIIObj", NM="_ZN12_GLOBAL__N_135DestroyTemplateIdAnnotationsRAIIObjD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN12_GLOBAL__N_135DestroyTemplateIdAnnotationsRAIIObjD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (type$ptr<TemplateIdAnnotation /*P*/ /*P*/> I = $tryClone(Container.begin()), 
        /*P*/ E = $tryClone(Container.end());
         $noteq_iter(I, E); I.$preInc())  {
      (I.$star()).Destroy();
    }
    Container.clear();
  }

  
  @Override public String toString() {
    return "" + "Container=" + Container; // NOI18N
  }
}
