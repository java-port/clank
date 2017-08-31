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

package org.clang.ast.llvm;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::CanQual<clang::Type> >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeOrdering.h", line = 58,
 FQN="llvm::DenseMapInfo<clang::CanQual<clang::Type> >", NM="_ZN4llvm12DenseMapInfoIN5clang7CanQualINS1_4TypeEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang7CanQualINS1_4TypeEEEEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoCanQual$Type extends DenseMapInfoBase<CanQual<Type>>{
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::CanQual<clang::Type> >::getEmptyKey">

  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::CanQual<clang::Type> >::getHashValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeOrdering.h", line = 68,
   FQN="llvm::DenseMapInfo<clang::CanQual<clang::Type> >::getHashValue", NM="_ZN4llvm12DenseMapInfoIN5clang7CanQualINS1_4TypeEEEE12getHashValueES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang7CanQualINS1_4TypeEEEE12getHashValueES4_")
  //</editor-fold>
  public /*uint*/int getHashValueImpl(CanQual<Type> Val) {
    int hash = Val.$hashcode();
    return hash ^ hash >>> 9;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::CanQual<clang::Type> >::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeOrdering.h", line = 73,
   FQN="llvm::DenseMapInfo<clang::CanQual<clang::Type> >::isEqual", NM="_ZN4llvm12DenseMapInfoIN5clang7CanQualINS1_4TypeEEEE7isEqualES4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang7CanQualINS1_4TypeEEEE7isEqualES4_S4_")
  //</editor-fold>
  public boolean isEqualImpl(CanQual<Type>/*CanQual<Type>*/ LHS, CanQual<Type>/*CanQual<Type>*/ RHS) {
    return AstClangGlobals.$eq_CanQual$T_CanQual$U(LHS, RHS);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final DenseMapInfoCanQual$Type INFO = new DenseMapInfoCanQual$Type();  
          
  private DenseMapInfoCanQual$Type() {
    super(new CanQual<>(), new CanQual<>());
  }

  public static DenseMapInfoCanQual$Type $Info() {
    return INFO;
  }
  
  @Override
  public boolean isKeyPointerLike() {
    return false;
  }  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
