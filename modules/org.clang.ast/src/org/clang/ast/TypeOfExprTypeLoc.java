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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::TypeOfExprTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1627,
 FQN="clang::TypeOfExprTypeLoc", NM="_ZN5clang17TypeOfExprTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17TypeOfExprTypeLocE")
//</editor-fold>
public class TypeOfExprTypeLoc extends /*public*/ TypeofLikeTypeLoc<TypeOfExprTypeLoc, TypeOfExprType, TypeOfExprTypeLocInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeOfExprTypeLoc::getUnderlyingExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1631,
   FQN="clang::TypeOfExprTypeLoc::getUnderlyingExpr", NM="_ZNK5clang17TypeOfExprTypeLoc17getUnderlyingExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK5clang17TypeOfExprTypeLoc17getUnderlyingExprEv")
  //</editor-fold>
  public Expr /*P*/ getUnderlyingExpr() /*const*/ {
    return getTypePtr().getUnderlyingExpr();
  }

  // Reimplemented to account for GNU/C++ extension
  //     typeof unary-expression
  // where there are no parentheses.
  // Reimplemented to account for GNU/C++ extension
  //     typeof unary-expression
  // where there are no parentheses.
  
  // Reimplemented to account for GNU/C++ extension
  //     typeof unary-expression
  // where there are no parentheses.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeOfExprTypeLoc::getLocalSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp", line = 280,
   FQN="clang::TypeOfExprTypeLoc::getLocalSourceRange", NM="_ZNK5clang17TypeOfExprTypeLoc19getLocalSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang17TypeOfExprTypeLoc19getLocalSourceRangeEv")
  //</editor-fold>
  public SourceRange getLocalSourceRange() /*const*/ {
    if (getRParenLoc().isValid()) {
      return new SourceRange(getTypeofLoc(), getRParenLoc());
    } else {
      return new SourceRange(getTypeofLoc(), 
          getUnderlyingExpr().getSourceRange().getEnd());
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TypeOfExprTypeLoc::TypeOfExprTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1627,
   FQN="clang::TypeOfExprTypeLoc::TypeOfExprTypeLoc", NM="_ZN5clang17TypeOfExprTypeLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17TypeOfExprTypeLocC1Ev")
  //</editor-fold>
  public /*inline*/ TypeOfExprTypeLoc() {
    // : TypeofLikeTypeLoc<TypeOfExprTypeLoc, TypeOfExprType, TypeOfExprTypeLocInfo>() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeOfExprTypeLoc::TypeOfExprTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1627,
   FQN="clang::TypeOfExprTypeLoc::TypeOfExprTypeLoc", NM="_ZN5clang17TypeOfExprTypeLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17TypeOfExprTypeLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TypeOfExprTypeLoc(final /*const*/ TypeOfExprTypeLoc /*&*/ $Prm0) {
    // : TypeofLikeTypeLoc<TypeOfExprTypeLoc, TypeOfExprType, TypeOfExprTypeLocInfo>() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeOfExprTypeLoc::TypeOfExprTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 1627,
   FQN="clang::TypeOfExprTypeLoc::TypeOfExprTypeLoc", NM="_ZN5clang17TypeOfExprTypeLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang17TypeOfExprTypeLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ TypeOfExprTypeLoc(JD$Move _dparam, final TypeOfExprTypeLoc /*&&*/$Prm0) {
    // : TypeofLikeTypeLoc<TypeOfExprTypeLoc, TypeOfExprType, TypeOfExprTypeLocInfo>(static_cast<TypeOfExprTypeLoc &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  @Override protected TypeOfExprTypeLocInfo createJavaEmptyLocalTypeLocInfo() {  return new TypeOfExprTypeLocInfo(); }
  
  @Override protected Class<TypeOfExprType> getTypeClass() { return TypeOfExprType.class; }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
