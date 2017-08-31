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

package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.impl.ItaniumCXXABIStatics.findAnonymousUnionVarDeclName;


/// \brief Keeps track of the mangled names of lambda expressions and block
/// literals within a particular context.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumNumberingContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 55,
 FQN="(anonymous namespace)::ItaniumNumberingContext", NM="_ZN12_GLOBAL__N_123ItaniumNumberingContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_123ItaniumNumberingContextE")
//</editor-fold>
public class ItaniumNumberingContext extends /*public*/ MangleNumberingContext implements Destructors.ClassWithDestructor {
  private DenseMapTypeUInt</*const*/ Type /*P*/ > ManglingNumbers;
  private DenseMapTypeUInt</*const*/ IdentifierInfo /*P*/ > VarManglingNumbers;
  private DenseMapTypeUInt</*const*/ IdentifierInfo /*P*/ > TagManglingNumbers;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumNumberingContext::getManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 61,
   FQN="(anonymous namespace)::ItaniumNumberingContext::getManglingNumber", NM="_ZN12_GLOBAL__N_123ItaniumNumberingContext17getManglingNumberEPKN5clang13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_123ItaniumNumberingContext17getManglingNumberEPKN5clang13CXXMethodDeclE")
  //</editor-fold>
  @Override public /*uint*/int getManglingNumber(/*const*/ CXXMethodDecl /*P*/ CallOperator)/* override*/ {
    /*const*/ FunctionProtoType /*P*/ Proto = CallOperator.getType().$arrow().getAs(FunctionProtoType.class);
    final ASTContext /*&*/ Context = CallOperator.getASTContext();
    
    QualType Key = Context.getFunctionType(Context.VoidTy.$QualType(), Proto.getParamTypes(), 
        new FunctionProtoType.ExtProtoInfo());
    Key.$assignMove(Context.getCanonicalType(/*NO_COPY*/Key).$QualType());
    return ManglingNumbers.ref$at(Key.$arrow().castAs(FunctionProtoType.class)).$set$preInc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumNumberingContext::getManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 73,
   FQN="(anonymous namespace)::ItaniumNumberingContext::getManglingNumber", NM="_ZN12_GLOBAL__N_123ItaniumNumberingContext17getManglingNumberEPKN5clang9BlockDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_123ItaniumNumberingContext17getManglingNumberEPKN5clang9BlockDeclE")
  //</editor-fold>
  @Override public /*uint*/int getManglingNumber(/*const*/ BlockDecl /*P*/ BD)/* override*/ {
    /*const*/ Type /*P*/ Ty = null;
    return ManglingNumbers.ref$at(Ty).$set$preInc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumNumberingContext::getStaticLocalNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 78,
   FQN="(anonymous namespace)::ItaniumNumberingContext::getStaticLocalNumber", NM="_ZN12_GLOBAL__N_123ItaniumNumberingContext20getStaticLocalNumberEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_123ItaniumNumberingContext20getStaticLocalNumberEPKN5clang7VarDeclE")
  //</editor-fold>
  @Override public /*uint*/int getStaticLocalNumber(/*const*/ VarDecl /*P*/ VD)/* override*/ {
    return 0;
  }

  
  /// Variable decls are numbered by identifier.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumNumberingContext::getManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 83,
   FQN="(anonymous namespace)::ItaniumNumberingContext::getManglingNumber", NM="_ZN12_GLOBAL__N_123ItaniumNumberingContext17getManglingNumberEPKN5clang7VarDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_123ItaniumNumberingContext17getManglingNumberEPKN5clang7VarDeclEj")
  //</editor-fold>
  @Override public /*uint*/int getManglingNumber(/*const*/ VarDecl /*P*/ VD, /*uint*/int $Prm1)/* override*/ {
    /*const*/ IdentifierInfo /*P*/ Identifier = VD.getIdentifier();
    if (!(Identifier != null)) {
      // VarDecl without an identifier represents an anonymous union declaration.
      Identifier = findAnonymousUnionVarDeclName($Deref(VD));
    }
    return VarManglingNumbers.ref$at(Identifier).$set$preInc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumNumberingContext::getManglingNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 92,
   FQN="(anonymous namespace)::ItaniumNumberingContext::getManglingNumber", NM="_ZN12_GLOBAL__N_123ItaniumNumberingContext17getManglingNumberEPKN5clang7TagDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_123ItaniumNumberingContext17getManglingNumberEPKN5clang7TagDeclEj")
  //</editor-fold>
  @Override public /*uint*/int getManglingNumber(/*const*/ TagDecl /*P*/ TD, /*uint*/int $Prm1)/* override*/ {
    return TagManglingNumbers.ref$at(TD.getIdentifier()).$set$preInc();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumNumberingContext::~ItaniumNumberingContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 55,
   FQN="(anonymous namespace)::ItaniumNumberingContext::~ItaniumNumberingContext", NM="_ZN12_GLOBAL__N_123ItaniumNumberingContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_123ItaniumNumberingContextD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    TagManglingNumbers.$destroy();
    VarManglingNumbers.$destroy();
    ManglingNumbers.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumNumberingContext::ItaniumNumberingContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 55,
   FQN="(anonymous namespace)::ItaniumNumberingContext::ItaniumNumberingContext", NM="_ZN12_GLOBAL__N_123ItaniumNumberingContextC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_123ItaniumNumberingContextC1Ev")
  //</editor-fold>
  public /*inline*/ ItaniumNumberingContext() {
    // : MangleNumberingContext(), ManglingNumbers(), VarManglingNumbers(), TagManglingNumbers() 
    //START JInit
    super();
    this.ManglingNumbers = new DenseMapTypeUInt</*const*/ Type /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.VarManglingNumbers = new DenseMapTypeUInt</*const*/ IdentifierInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.TagManglingNumbers = new DenseMapTypeUInt</*const*/ IdentifierInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "ManglingNumbers=" + ManglingNumbers // NOI18N
              + ", VarManglingNumbers=" + VarManglingNumbers // NOI18N
              + ", TagManglingNumbers=" + TagManglingNumbers // NOI18N
              + super.toString(); // NOI18N
  }
}
