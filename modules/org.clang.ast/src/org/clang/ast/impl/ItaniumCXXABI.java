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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.basic.target.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 97,
 FQN="(anonymous namespace)::ItaniumCXXABI", NM="_ZN12_GLOBAL__N_113ItaniumCXXABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABIE")
//</editor-fold>
public class ItaniumCXXABI extends /*public*/ CXXABI implements Destructors.ClassWithDestructor {
/*protected:*/
  protected final ASTContext /*&*/ Context;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::ItaniumCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 101,
   FQN="(anonymous namespace)::ItaniumCXXABI::ItaniumCXXABI", NM="_ZN12_GLOBAL__N_113ItaniumCXXABIC1ERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABIC1ERN5clang10ASTContextE")
  //</editor-fold>
  public ItaniumCXXABI(final ASTContext /*&*/ Ctx) {
    // : CXXABI(), Context(Ctx) 
    //START JInit
    super();
    this./*&*/Context=/*&*/Ctx;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getMemberPointerWidthAndAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 103,
   FQN="(anonymous namespace)::ItaniumCXXABI::getMemberPointerWidthAndAlign", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI29getMemberPointerWidthAndAlignEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI29getMemberPointerWidthAndAlignEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  @Override public std.pairULongUInt getMemberPointerWidthAndAlign(/*const*/ MemberPointerType /*P*/ MPT) /*const*//* override*/ {
    final /*const*/ TargetInfo /*&*/ Target = Context.getTargetInfo();
    TargetInfo.IntType PtrDiff = Target.getPtrDiffType(0);
    long/*uint64_t*/ Width = $uint2ulong(Target.getTypeWidth(PtrDiff));
    /*uint*/int Align = Target.getTypeAlign(PtrDiff);
    if (MPT.isMemberFunctionPointer()) {
      Width = $int2ullong(2) * Width;
    }
    return std.make_pair_ullong_uint(Width, Align);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getDefaultMethodCallConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 114,
   FQN="(anonymous namespace)::ItaniumCXXABI::getDefaultMethodCallConv", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI24getDefaultMethodCallConvEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI24getDefaultMethodCallConvEb")
  //</editor-fold>
  @Override public CallingConv getDefaultMethodCallConv(boolean isVariadic) /*const*//* override*/ {
    final /*const*/ Triple /*&*/ T = Context.getTargetInfo().getTriple();
    if (!isVariadic && T.isWindowsGNUEnvironment()
       && T.getArch() == Triple.ArchType.x86) {
      return CallingConv.CC_X86ThisCall;
    }
    return CallingConv.CC_C;
  }

  
  // We cheat and just check that the class has a vtable pointer, and that it's
  // only big enough to have a vtable pointer and nothing more (or less).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::isNearlyEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 124,
   FQN="(anonymous namespace)::ItaniumCXXABI::isNearlyEmpty", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI13isNearlyEmptyEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI13isNearlyEmptyEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public boolean isNearlyEmpty(/*const*/ CXXRecordDecl /*P*/ RD) /*const*//* override*/ {
    
    // Check that the class has a vtable pointer.
    if (!RD.isDynamicClass()) {
      return false;
    }
    
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    CharUnits PointerSize = Context.toCharUnitsFromBits(Context.getTargetInfo().getPointerWidth(0));
    return Layout.getNonVirtualSize().$eq(PointerSize);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getCopyConstructorForExceptionObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 136,
   FQN="(anonymous namespace)::ItaniumCXXABI::getCopyConstructorForExceptionObject", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI36getCopyConstructorForExceptionObjectEPN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI36getCopyConstructorForExceptionObjectEPN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public /*const*/ CXXConstructorDecl /*P*/ getCopyConstructorForExceptionObject(CXXRecordDecl /*P*/ RD)/* override*/ {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::addCopyConstructorForExceptionObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 141,
   FQN="(anonymous namespace)::ItaniumCXXABI::addCopyConstructorForExceptionObject", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI36addCopyConstructorForExceptionObjectEPN5clang13CXXRecordDeclEPNS1_18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI36addCopyConstructorForExceptionObjectEPN5clang13CXXRecordDeclEPNS1_18CXXConstructorDeclE")
  //</editor-fold>
  @Override public void addCopyConstructorForExceptionObject(CXXRecordDecl /*P*/ RD, 
                                      CXXConstructorDecl /*P*/ CD)/* override*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::addDefaultArgExprForConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 144,
   FQN="(anonymous namespace)::ItaniumCXXABI::addDefaultArgExprForConstructor", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI31addDefaultArgExprForConstructorEPKN5clang18CXXConstructorDeclEjPNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI31addDefaultArgExprForConstructorEPKN5clang18CXXConstructorDeclEjPNS1_4ExprE")
  //</editor-fold>
  @Override public void addDefaultArgExprForConstructor(/*const*/ CXXConstructorDecl /*P*/ CD, 
                                 /*uint*/int ParmIdx, Expr /*P*/ DAE)/* override*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getDefaultArgExprForConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 147,
   FQN="(anonymous namespace)::ItaniumCXXABI::getDefaultArgExprForConstructor", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI31getDefaultArgExprForConstructorEPKN5clang18CXXConstructorDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI31getDefaultArgExprForConstructorEPKN5clang18CXXConstructorDeclEj")
  //</editor-fold>
  @Override public Expr /*P*/ getDefaultArgExprForConstructor(/*const*/ CXXConstructorDecl /*P*/ CD, 
                                 /*uint*/int ParmIdx)/* override*/ {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::addTypedefNameForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 152,
   FQN="(anonymous namespace)::ItaniumCXXABI::addTypedefNameForUnnamedTagDecl", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI31addTypedefNameForUnnamedTagDeclEPN5clang7TagDeclEPNS1_15TypedefNameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI31addTypedefNameForUnnamedTagDeclEPN5clang7TagDeclEPNS1_15TypedefNameDeclE")
  //</editor-fold>
  @Override public void addTypedefNameForUnnamedTagDecl(TagDecl /*P*/ TD, 
                                 TypedefNameDecl /*P*/ DD)/* override*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getTypedefNameForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 155,
   FQN="(anonymous namespace)::ItaniumCXXABI::getTypedefNameForUnnamedTagDecl", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI31getTypedefNameForUnnamedTagDeclEPKN5clang7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI31getTypedefNameForUnnamedTagDeclEPKN5clang7TagDeclE")
  //</editor-fold>
  @Override public TypedefNameDecl /*P*/ getTypedefNameForUnnamedTagDecl(/*const*/ TagDecl /*P*/ TD)/* override*/ {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::addDeclaratorForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 159,
   FQN="(anonymous namespace)::ItaniumCXXABI::addDeclaratorForUnnamedTagDecl", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI30addDeclaratorForUnnamedTagDeclEPN5clang7TagDeclEPNS1_14DeclaratorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI30addDeclaratorForUnnamedTagDeclEPN5clang7TagDeclEPNS1_14DeclaratorDeclE")
  //</editor-fold>
  @Override public void addDeclaratorForUnnamedTagDecl(TagDecl /*P*/ TD, 
                                DeclaratorDecl /*P*/ DD)/* override*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getDeclaratorForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 162,
   FQN="(anonymous namespace)::ItaniumCXXABI::getDeclaratorForUnnamedTagDecl", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI30getDeclaratorForUnnamedTagDeclEPKN5clang7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI30getDeclaratorForUnnamedTagDeclEPKN5clang7TagDeclE")
  //</editor-fold>
  @Override public DeclaratorDecl /*P*/ getDeclaratorForUnnamedTagDecl(/*const*/ TagDecl /*P*/ TD)/* override*/ {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::createMangleNumberingContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 166,
   FQN="(anonymous namespace)::ItaniumCXXABI::createMangleNumberingContext", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI28createMangleNumberingContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI28createMangleNumberingContextEv")
  //</editor-fold>
  @Override public MangleNumberingContext /*P*/ createMangleNumberingContext() /*const*//* override*/ {
    return new ItaniumNumberingContext();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::~ItaniumCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp", line = 97,
   FQN="(anonymous namespace)::ItaniumCXXABI::~ItaniumCXXABI", NM="_ZN12_GLOBAL__N_113ItaniumCXXABID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABID0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + super.toString(); // NOI18N
  }
}
