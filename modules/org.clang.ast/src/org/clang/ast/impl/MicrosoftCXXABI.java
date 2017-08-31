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
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.impl.MicrosoftCXXABIStatics.*;
import org.clang.basic.target.TargetInfo;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 67,
 FQN="(anonymous namespace)::MicrosoftCXXABI", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABIE")
//</editor-fold>
public class MicrosoftCXXABI extends /*public*/ CXXABI implements Destructors.ClassWithDestructor {
  private final ASTContext /*&*/ Context;
  private SmallDenseMap<CXXRecordDecl /*P*/ , CXXConstructorDecl /*P*/ > RecordToCopyCtor;
  private SmallDenseMap<std.pairTypeUInt</*const*/ CXXConstructorDecl /*P*/ >, Expr /*P*/ > CtorToDefaultArgExpr;
  
  private SmallDenseMap<TagDecl /*P*/ , DeclaratorDecl /*P*/ > UnnamedTagDeclToDeclaratorDecl;
  private SmallDenseMap<TagDecl /*P*/ , TypedefNameDecl /*P*/ > UnnamedTagDeclToTypedefNameDecl;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::MicrosoftCXXABI">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 79,
   FQN="(anonymous namespace)::MicrosoftCXXABI::MicrosoftCXXABI", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABIC1ERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABIC1ERN5clang10ASTContextE")
  //</editor-fold>
  public MicrosoftCXXABI(final ASTContext /*&*/ Ctx) {
    // : CXXABI(), Context(Ctx), RecordToCopyCtor(), CtorToDefaultArgExpr(), UnnamedTagDeclToDeclaratorDecl(), UnnamedTagDeclToTypedefNameDecl() 
    //START JInit
    super();
    this./*&*/Context=/*&*/Ctx;
    this.RecordToCopyCtor = new SmallDenseMap<CXXRecordDecl /*P*/ , CXXConstructorDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (CXXConstructorDecl /*P*/ )null);
    this.CtorToDefaultArgExpr = new SmallDenseMap<std.pairTypeUInt</*const*/ CXXConstructorDecl /*P*/ >, Expr /*P*/ >(DenseMapInfoPairTypePtrUInt.$Info(), (Expr /*P*/ )null);
    this.UnnamedTagDeclToDeclaratorDecl = new SmallDenseMap<TagDecl /*P*/ , DeclaratorDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (DeclaratorDecl /*P*/ )null);
    this.UnnamedTagDeclToTypedefNameDecl = new SmallDenseMap<TagDecl /*P*/ , TypedefNameDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (TypedefNameDecl /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getMemberPointerWidthAndAlign">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 241,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getMemberPointerWidthAndAlign", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI29getMemberPointerWidthAndAlignEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI29getMemberPointerWidthAndAlignEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  @Override public std.pairULongUInt getMemberPointerWidthAndAlign(/*const*/ MemberPointerType /*P*/ MPT) /*const*//* override*/ {
    // The nominal struct is laid out with pointers followed by ints and aligned
    // to a pointer width if any are present and an int width otherwise.
    final /*const*/ TargetInfo /*&*/ Target = Context.getTargetInfo();
    /*uint*/int PtrSize = $ulong2uint(Target.getPointerWidth(0));
    /*uint*/int IntSize = Target.getIntWidth();
    
    /*uint*/int Ptrs, Ints;
    // JAVA: unfold tie
    pairUIntUInt $msMemberPointerSlots = getMSMemberPointerSlots(MPT);
    Ptrs = $msMemberPointerSlots.first;
    Ints = $msMemberPointerSlots.second;
//    std.tie(Ptrs, Ints).$assign_pair$_U1$_U2(getMSMemberPointerSlots(MPT));
    long/*uint64_t*/ Width = $uint2ulong(Ptrs * PtrSize + Ints * IntSize);
    /*uint*/int Align;
    
    // When MSVC does x86_32 record layout, it aligns aggregate member pointers to
    // 8 bytes.  However, __alignof usually returns 4 for data memptrs and 8 for
    // function memptrs.
    if ($greater_uint(Ptrs + Ints, 1) && Target.getTriple().isArch32Bit()) {
      Align = 64;
    } else if ((Ptrs != 0)) {
      Align = $ulong2uint(Target.getPointerAlign(0));
    } else {
      Align = Target.getIntAlign();
    }
    if (Target.getTriple().isArch64Bit()) {
      Width = llvm.alignTo(Width, $uint2ulong(Align));
    }
    return std.make_pair_ullong_uint(Width, Align);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getDefaultMethodCallConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 84,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getDefaultMethodCallConv", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI24getDefaultMethodCallConvEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI24getDefaultMethodCallConvEb")
  //</editor-fold>
  @Override public CallingConv getDefaultMethodCallConv(boolean isVariadic) /*const*//* override*/ {
    if (!isVariadic
       && Context.getTargetInfo().getTriple().getArch() == Triple.ArchType.x86) {
      return CallingConv.CC_X86ThisCall;
    }
    return CallingConv.CC_C;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::isNearlyEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 91,
   FQN="(anonymous namespace)::MicrosoftCXXABI::isNearlyEmpty", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI13isNearlyEmptyEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI13isNearlyEmptyEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public boolean isNearlyEmpty(/*const*/ CXXRecordDecl /*P*/ RD) /*const*//* override*/ {
    throw new llvm_unreachable("unapplicable to the MS ABI");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::addDefaultArgExprForConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 95,
   FQN="(anonymous namespace)::MicrosoftCXXABI::addDefaultArgExprForConstructor", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI31addDefaultArgExprForConstructorEPKN5clang18CXXConstructorDeclEjPNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI31addDefaultArgExprForConstructorEPKN5clang18CXXConstructorDeclEjPNS1_4ExprE")
  //</editor-fold>
  @Override public void addDefaultArgExprForConstructor(/*const*/ CXXConstructorDecl /*P*/ CD, 
                                 /*uint*/int ParmIdx, Expr /*P*/ DAE)/* override*/ {
    CtorToDefaultArgExpr.$set(std.make_pair_Ptr_uint(CD, ParmIdx), DAE);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getDefaultArgExprForConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 100,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getDefaultArgExprForConstructor", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI31getDefaultArgExprForConstructorEPKN5clang18CXXConstructorDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI31getDefaultArgExprForConstructorEPKN5clang18CXXConstructorDeclEj")
  //</editor-fold>
  @Override public Expr /*P*/ getDefaultArgExprForConstructor(/*const*/ CXXConstructorDecl /*P*/ CD, 
                                 /*uint*/int ParmIdx)/* override*/ {
    return CtorToDefaultArgExpr.$at_T1$RR(std.make_pair_Ptr_uint(CD, ParmIdx));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getCopyConstructorForExceptionObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 105,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getCopyConstructorForExceptionObject", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI36getCopyConstructorForExceptionObjectEPN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI36getCopyConstructorForExceptionObjectEPN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public /*const*/ CXXConstructorDecl /*P*/ getCopyConstructorForExceptionObject(CXXRecordDecl /*P*/ RD)/* override*/ {
    return RecordToCopyCtor.$at_T1$C$R(RD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::addCopyConstructorForExceptionObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 110,
   FQN="(anonymous namespace)::MicrosoftCXXABI::addCopyConstructorForExceptionObject", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI36addCopyConstructorForExceptionObjectEPN5clang13CXXRecordDeclEPNS1_18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI36addCopyConstructorForExceptionObjectEPN5clang13CXXRecordDeclEPNS1_18CXXConstructorDeclE")
  //</editor-fold>
  @Override public void addCopyConstructorForExceptionObject(CXXRecordDecl /*P*/ RD, 
                                      CXXConstructorDecl /*P*/ CD)/* override*/ {
    assert (CD != null);
    assert (RecordToCopyCtor.$at_T1$C$R(RD) == null || RecordToCopyCtor.$at_T1$C$R(RD) == CD);
    RecordToCopyCtor.$set(RD, CD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::addTypedefNameForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use ref$at*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 118,
   FQN="(anonymous namespace)::MicrosoftCXXABI::addTypedefNameForUnnamedTagDecl", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI31addTypedefNameForUnnamedTagDeclEPN5clang7TagDeclEPNS1_15TypedefNameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI31addTypedefNameForUnnamedTagDeclEPN5clang7TagDeclEPNS1_15TypedefNameDeclE")
  //</editor-fold>
  @Override public void addTypedefNameForUnnamedTagDecl(TagDecl /*P*/ TD, 
                                 TypedefNameDecl /*P*/ DD)/* override*/ {
    TD = TD.getCanonicalDecl();
    DD = cast(TypedefNameDecl.class, DD.getCanonicalDecl());
    final type$ref<TypedefNameDecl /*P*/> /*&*/ I = UnnamedTagDeclToTypedefNameDecl.ref$at(TD);
    if (!(I.$deref() != null)) {
      I.$set(DD);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getTypedefNameForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 127,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getTypedefNameForUnnamedTagDecl", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI31getTypedefNameForUnnamedTagDeclEPKN5clang7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI31getTypedefNameForUnnamedTagDeclEPKN5clang7TagDeclE")
  //</editor-fold>
  @Override public TypedefNameDecl /*P*/ getTypedefNameForUnnamedTagDecl(/*const*/ TagDecl /*P*/ TD)/* override*/ {
    return UnnamedTagDeclToTypedefNameDecl.lookup(((/*const_cast*/TagDecl /*P*/ )(TD.getCanonicalDecl$Const())));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::addDeclaratorForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use ref$at*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 132,
   FQN="(anonymous namespace)::MicrosoftCXXABI::addDeclaratorForUnnamedTagDecl", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI30addDeclaratorForUnnamedTagDeclEPN5clang7TagDeclEPNS1_14DeclaratorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI30addDeclaratorForUnnamedTagDeclEPN5clang7TagDeclEPNS1_14DeclaratorDeclE")
  //</editor-fold>
  @Override public void addDeclaratorForUnnamedTagDecl(TagDecl /*P*/ TD, 
                                DeclaratorDecl /*P*/ DD)/* override*/ {
    TD = TD.getCanonicalDecl();
    DD = cast(DeclaratorDecl.class, DD.getCanonicalDecl());
    final type$ref<DeclaratorDecl /*P*/> /*&*/ I = UnnamedTagDeclToDeclaratorDecl.ref$at(TD);
    if (!(I.$deref() != null)) {
      I.$set(DD);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getDeclaratorForUnnamedTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 141,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getDeclaratorForUnnamedTagDecl", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI30getDeclaratorForUnnamedTagDeclEPKN5clang7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI30getDeclaratorForUnnamedTagDeclEPKN5clang7TagDeclE")
  //</editor-fold>
  @Override public DeclaratorDecl /*P*/ getDeclaratorForUnnamedTagDecl(/*const*/ TagDecl /*P*/ TD)/* override*/ {
    return UnnamedTagDeclToDeclaratorDecl.lookup(((/*const_cast*/TagDecl /*P*/ )(TD.getCanonicalDecl$Const())));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::createMangleNumberingContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 146,
   FQN="(anonymous namespace)::MicrosoftCXXABI::createMangleNumberingContext", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI28createMangleNumberingContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI28createMangleNumberingContextEv")
  //</editor-fold>
  @Override public MangleNumberingContext /*P*/ createMangleNumberingContext() /*const*//* override*/ {
    return new MicrosoftNumberingContext();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::~MicrosoftCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp", line = 67,
   FQN="(anonymous namespace)::MicrosoftCXXABI::~MicrosoftCXXABI", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABID0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    UnnamedTagDeclToTypedefNameDecl.$destroy();
    UnnamedTagDeclToDeclaratorDecl.$destroy();
    CtorToDefaultArgExpr.$destroy();
    RecordToCopyCtor.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Context=" + Context // NOI18N
              + ", RecordToCopyCtor=" + RecordToCopyCtor // NOI18N
              + ", CtorToDefaultArgExpr=" + CtorToDefaultArgExpr // NOI18N
              + ", UnnamedTagDeclToDeclaratorDecl=" + UnnamedTagDeclToDeclaratorDecl // NOI18N
              + ", UnnamedTagDeclToTypedefNameDecl=" + UnnamedTagDeclToTypedefNameDecl // NOI18N
              + super.toString(); // NOI18N
  }
}
