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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.llvm.ir.*;


/// \brief This is an IRBuilder insertion helper that forwards to
/// CodeGenFunction::InsertHelper, which adds necessary metadata to
/// instructions.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderInserter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 26,
 FQN="clang::CodeGen::CGBuilderInserter", NM="_ZN5clang7CodeGen17CGBuilderInserterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen17CGBuilderInserterE")
//</editor-fold>
public class CGBuilderInserter implements /*protected*/ IRBuilderDefaultInserter {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderInserter::CGBuilderInserter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 28,
   FQN="clang::CodeGen::CGBuilderInserter::CGBuilderInserter", NM="_ZN5clang7CodeGen17CGBuilderInserterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen17CGBuilderInserterC1Ev")
  //</editor-fold>
  public CGBuilderInserter() {
    // : IRBuilderDefaultInserter(), CGF(null)/* = default*/ 
    //START JInit
    $IRBuilderDefaultInserter();
    /*InClass*/this.CGF = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderInserter::CGBuilderInserter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 29,
   FQN="clang::CodeGen::CGBuilderInserter::CGBuilderInserter", NM="_ZN5clang7CodeGen17CGBuilderInserterC1EPNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen17CGBuilderInserterC1EPNS0_15CodeGenFunctionE")
  //</editor-fold>
  public /*explicit*/ CGBuilderInserter(CodeGenFunction /*P*/ CGF) {
    // : IRBuilderDefaultInserter(), CGF(CGF) 
    //START JInit
    $IRBuilderDefaultInserter();
    this.CGF = CGF;
    //END JInit
  }

/*protected:*/
  /// \brief This forwards to CodeGenFunction::InsertHelper.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderInserter::InsertHelper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 1917,
   FQN="clang::CodeGen::CGBuilderInserter::InsertHelper", NM="_ZNK5clang7CodeGen17CGBuilderInserter12InsertHelperEPN4llvm11InstructionERKNS2_5TwineEPNS2_10BasicBlockENS2_14ilist_iteratorIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZNK5clang7CodeGen17CGBuilderInserter12InsertHelperEPN4llvm11InstructionERKNS2_5TwineEPNS2_10BasicBlockENS2_14ilist_iteratorIS3_EE")
  //</editor-fold>
  public/*protected*/ void InsertHelper(Instruction /*P*/ I, final /*const*/ Twine /*&*/ Name, BasicBlock /*P*/ BB, 
              ilist_iterator<Instruction> InsertPt) /*const*/ {
    IRBuilderDefaultInserter.super.InsertHelper(I, Name, BB, new ilist_iterator<Instruction>(InsertPt));
    if ((CGF != null)) {
      CGF.InsertHelper(I, Name, BB, new ilist_iterator<Instruction>(InsertPt));
    }
  }

/*private:*/
  private CodeGenFunction /*P*/ CGF/* = null*/;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderInserter::CGBuilderInserter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 26,
   FQN="clang::CodeGen::CGBuilderInserter::CGBuilderInserter", NM="_ZN5clang7CodeGen17CGBuilderInserterC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen17CGBuilderInserterC1ERKS1_")
  //</editor-fold>
  public /*inline*/ CGBuilderInserter(final /*const*/ CGBuilderInserter /*&*/ $Prm0) {
    // : IRBuilderDefaultInserter(), CGF(.CGF) 
    //START JInit
    $IRBuilderDefaultInserter($Prm0);
    this.CGF = $Prm0.CGF;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderInserter::CGBuilderInserter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 26,
   FQN="clang::CodeGen::CGBuilderInserter::CGBuilderInserter", NM="_ZN5clang7CodeGen17CGBuilderInserterC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen17CGBuilderInserterC1EOS1_")
  //</editor-fold>
  public /*inline*/ CGBuilderInserter(JD$Move _dparam, final CGBuilderInserter /*&&*/$Prm0) {
    // : IRBuilderDefaultInserter(static_cast<CGBuilderInserter &&>()), CGF(static_cast<CGBuilderInserter &&>().CGF) 
    //START JInit
    $IRBuilderDefaultInserter(JD$Move.INSTANCE, $Prm0);
    this.CGF = $Prm0.CGF;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + super.toString(); // NOI18N
  }
}
