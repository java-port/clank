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

package org.clang.sema;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;


/// Designation - Represent a full designation, which is a sequence of
/// designators.  This class is mostly a helper for InitListDesignations.
//<editor-fold defaultstate="collapsed" desc="clang::Designation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 181,
 FQN="clang::Designation", NM="_ZN5clang11DesignationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang11DesignationE")
//</editor-fold>
public class Designation implements Destructors.ClassWithDestructor {
  /// Designators - The actual designators for this initializer.
  private SmallVector<Designator> Designators;
/*public:*/
  /// AddDesignator - Add a designator to the end of this list.
  //<editor-fold defaultstate="collapsed" desc="clang::Designation::AddDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 187,
   FQN="clang::Designation::AddDesignator", NM="_ZN5clang11Designation13AddDesignatorENS_10DesignatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang11Designation13AddDesignatorENS_10DesignatorE")
  //</editor-fold>
  public void AddDesignator(Designator D) {
    Designators.push_back(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designation::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 191,
   FQN="clang::Designation::empty", NM="_ZNK5clang11Designation5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang11Designation5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Designators.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Designation::getNumDesignators">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 193,
   FQN="clang::Designation::getNumDesignators", NM="_ZNK5clang11Designation17getNumDesignatorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang11Designation17getNumDesignatorsEv")
  //</editor-fold>
  public /*uint*/int getNumDesignators() /*const*/ {
    return Designators.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Designation::getDesignator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 194,
   FQN="clang::Designation::getDesignator", NM="_ZNK5clang11Designation13getDesignatorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZNK5clang11Designation13getDesignatorEj")
  //</editor-fold>
  public /*const*/ Designator /*&*/ getDesignator(/*uint*/int Idx) /*const*/ {
    assert ($less_uint(Idx, Designators.size()));
    return Designators.$at$Const(Idx);
  }

  
  /// ClearExprs - Null out any expression references, which prevents them from
  /// being 'delete'd later.
  //<editor-fold defaultstate="collapsed" desc="clang::Designation::ClearExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 201,
   FQN="clang::Designation::ClearExprs", NM="_ZN5clang11Designation10ClearExprsERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang11Designation10ClearExprsERNS_4SemaE")
  //</editor-fold>
  public void ClearExprs(final Sema /*&*/ Actions) {
  }

  
  /// FreeExprs - Release any unclaimed memory for the expressions in this
  /// designation.
  //<editor-fold defaultstate="collapsed" desc="clang::Designation::FreeExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 205,
   FQN="clang::Designation::FreeExprs", NM="_ZN5clang11Designation9FreeExprsERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang11Designation9FreeExprsERNS_4SemaE")
  //</editor-fold>
  public void FreeExprs(final Sema /*&*/ Actions) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Designation::Designation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 181,
   FQN="clang::Designation::Designation", NM="_ZN5clang11DesignationC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang11DesignationC1Ev")
  //</editor-fold>
  public /*inline*/ Designation() {
    // : Designators() 
    //START JInit
    this.Designators = new SmallVector<Designator>(2, new Designator());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Designation::~Designation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Designator.h", line = 181,
   FQN="clang::Designation::~Designation", NM="_ZN5clang11DesignationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp -nm=_ZN5clang11DesignationD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Designators.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Designators=" + Designators; // NOI18N
  }
}
