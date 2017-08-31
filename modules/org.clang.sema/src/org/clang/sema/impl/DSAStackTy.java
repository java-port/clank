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

package org.clang.sema.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.OMPClauseMappableExprCommon.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.sema.impl.SemaOpenMPStatics.*;
import org.clang.sema.impl.DSAStackTy.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// \brief Stack for tracking declarations used in OpenMP directives and
/// clauses and their data-sharing attributes.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 50,
 FQN="(anonymous namespace)::DSAStackTy", NM="_ZN12_GLOBAL__N_110DSAStackTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTyE")
//</editor-fold>
public final class DSAStackTy implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::DSAVarData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 52,
   FQN="(anonymous namespace)::DSAStackTy::DSAVarData", NM="_ZN12_GLOBAL__N_110DSAStackTy10DSAVarDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy10DSAVarDataE")
  //</editor-fold>
  public static final class/*struct*/ DSAVarData {
    public OpenMPDirectiveKind DKind/* = OMPD_unknown*/;
    public OpenMPClauseKind CKind/* = OMPC_unknown*/;
    public Expr /*P*/ RefExpr/* = null*/;
    public DeclRefExpr /*P*/ PrivateCopy/* = null*/;
    public SourceLocation ImplicitDSALoc;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::DSAVarData::DSAVarData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 58,
     FQN="(anonymous namespace)::DSAStackTy::DSAVarData::DSAVarData", NM="_ZN12_GLOBAL__N_110DSAStackTy10DSAVarDataC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy10DSAVarDataC1Ev")
    //</editor-fold>
    public DSAVarData() {
      // : DKind(OMPD_unknown), CKind(OMPC_unknown), RefExpr(null), PrivateCopy(null), ImplicitDSALoc() 
      //START JInit
      /*InClass*/this.DKind = OpenMPDirectiveKind.OMPD_unknown;
      /*InClass*/this.CKind = OpenMPClauseKind.OMPC_unknown;
      /*InClass*/this.RefExpr = null;
      /*InClass*/this.PrivateCopy = null;
      this.ImplicitDSALoc = new SourceLocation();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::DSAVarData::DSAVarData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 52,
     FQN="(anonymous namespace)::DSAStackTy::DSAVarData::DSAVarData", NM="_ZN12_GLOBAL__N_110DSAStackTy10DSAVarDataC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy10DSAVarDataC1ERKS1_")
    //</editor-fold>
    public /*inline*/ DSAVarData(final /*const*/ DSAVarData /*&*/ $Prm0) {
      // : DKind(.DKind), CKind(.CKind), RefExpr(.RefExpr), PrivateCopy(.PrivateCopy), ImplicitDSALoc(.ImplicitDSALoc) 
      //START JInit
      this.DKind = $Prm0.DKind;
      this.CKind = $Prm0.CKind;
      this.RefExpr = $Prm0.RefExpr;
      this.PrivateCopy = $Prm0.PrivateCopy;
      this.ImplicitDSALoc = new SourceLocation($Prm0.ImplicitDSALoc);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::DSAVarData::DSAVarData">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 52,
     FQN="(anonymous namespace)::DSAStackTy::DSAVarData::DSAVarData", NM="_ZN12_GLOBAL__N_110DSAStackTy10DSAVarDataC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy10DSAVarDataC1EOS1_")
    //</editor-fold>
    public /*inline*/ DSAVarData(JD$Move _dparam, final DSAVarData /*&&*/$Prm0) {
      // : DKind(static_cast<DSAVarData &&>().DKind), CKind(static_cast<DSAVarData &&>().CKind), RefExpr(static_cast<DSAVarData &&>().RefExpr), PrivateCopy(static_cast<DSAVarData &&>().PrivateCopy), ImplicitDSALoc(static_cast<DSAVarData &&>().ImplicitDSALoc) 
      //START JInit
      this.DKind = $Prm0.DKind;
      this.CKind = $Prm0.CKind;
      this.RefExpr = $Prm0.RefExpr;
      this.PrivateCopy = $Prm0.PrivateCopy;
      this.ImplicitDSALoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.ImplicitDSALoc);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::DSAVarData::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 52,
     FQN="(anonymous namespace)::DSAStackTy::DSAVarData::operator=", NM="_ZN12_GLOBAL__N_110DSAStackTy10DSAVarDataaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy10DSAVarDataaSERKS1_")
    //</editor-fold>
    public /*inline*/ DSAVarData /*&*/ $assign(final /*const*/ DSAVarData /*&*/ $Prm0) {
      this.DKind = $Prm0.DKind;
      this.CKind = $Prm0.CKind;
      this.RefExpr = $Prm0.RefExpr;
      this.PrivateCopy = $Prm0.PrivateCopy;
      this.ImplicitDSALoc.$assign($Prm0.ImplicitDSALoc);
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::DSAVarData::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 52,
     FQN="(anonymous namespace)::DSAStackTy::DSAVarData::operator=", NM="_ZN12_GLOBAL__N_110DSAStackTy10DSAVarDataaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy10DSAVarDataaSEOS1_")
    //</editor-fold>
    public /*inline*/ DSAVarData /*&*/ $assignMove(final DSAVarData /*&&*/$Prm0) {
      this.DKind = $Prm0.DKind;
      this.CKind = $Prm0.CKind;
      this.RefExpr = $Prm0.RefExpr;
      this.PrivateCopy = $Prm0.PrivateCopy;
      this.ImplicitDSALoc.$assignMove($Prm0.ImplicitDSALoc);
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "DKind=" + DKind // NOI18N
                + ", CKind=" + CKind // NOI18N
                + ", RefExpr=" + RefExpr // NOI18N
                + ", PrivateCopy=" + PrivateCopy // NOI18N
                + ", ImplicitDSALoc=" + ImplicitDSALoc; // NOI18N
    }
  };
  /*typedef llvm::SmallVector<std::pair<Expr *, OverloadedOperatorKind>, 4> OperatorOffsetTy*/
//  public final class OperatorOffsetTy extends SmallVector<std.pair<Expr /*P*/ , OverloadedOperatorKind>>{ };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::DSAInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 64,
   FQN="(anonymous namespace)::DSAStackTy::DSAInfo", NM="_ZN12_GLOBAL__N_110DSAStackTy7DSAInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy7DSAInfoE")
  //</editor-fold>
  private static final class/*struct*/ DSAInfo {
    public OpenMPClauseKind Attributes/* = OMPC_unknown*/;
    /// Pointer to a reference expression and a flag which shows that the
    /// variable is marked as lastprivate(true) or not (false).
    public PointerBoolPair<Expr /*P*/ > RefExpr;
    public DeclRefExpr /*P*/ PrivateCopy/* = null*/;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::DSAInfo::DSAInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 64,
     FQN="(anonymous namespace)::DSAStackTy::DSAInfo::DSAInfo", NM="_ZN12_GLOBAL__N_110DSAStackTy7DSAInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy7DSAInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ DSAInfo(final /*const*/ DSAInfo /*&*/ $Prm0) {
      // : Attributes(.Attributes), RefExpr(.RefExpr), PrivateCopy(.PrivateCopy) 
      //START JInit
      this.Attributes = $Prm0.Attributes;
      this.RefExpr = new PointerBoolPair<Expr /*P*/ >($Prm0.RefExpr);
      this.PrivateCopy = $Prm0.PrivateCopy;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::DSAInfo::DSAInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 64,
     FQN="(anonymous namespace)::DSAStackTy::DSAInfo::DSAInfo", NM="_ZN12_GLOBAL__N_110DSAStackTy7DSAInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy7DSAInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ DSAInfo(JD$Move _dparam, final DSAInfo /*&&*/$Prm0) {
      // : Attributes(static_cast<DSAInfo &&>().Attributes), RefExpr(static_cast<DSAInfo &&>().RefExpr), PrivateCopy(static_cast<DSAInfo &&>().PrivateCopy) 
      //START JInit
      this.Attributes = $Prm0.Attributes;
      this.RefExpr = new PointerBoolPair<Expr /*P*/ >(JD$Move.INSTANCE, $Prm0.RefExpr);
      this.PrivateCopy = $Prm0.PrivateCopy;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::DSAInfo::DSAInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 64,
     FQN="(anonymous namespace)::DSAStackTy::DSAInfo::DSAInfo", NM="_ZN12_GLOBAL__N_110DSAStackTy7DSAInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy7DSAInfoC1Ev")
    //</editor-fold>
    public /*inline*/ DSAInfo() {
      // : Attributes(OMPC_unknown), RefExpr(), PrivateCopy(null) 
      //START JInit
      /*InClass*/this.Attributes = OpenMPClauseKind.OMPC_unknown;
      this.RefExpr = new PointerBoolPair<Expr /*P*/ >();
      /*InClass*/this.PrivateCopy = null;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Attributes=" + Attributes // NOI18N
                + ", RefExpr=" + RefExpr // NOI18N
                + ", PrivateCopy=" + PrivateCopy; // NOI18N
    }
  };
  /*typedef llvm::DenseMap<ValueDecl *, DSAInfo> DeclSAMapTy*/
//  public final class DeclSAMapTy extends DenseMap<ValueDecl /*P*/ , DSAInfo>{ };
  /*typedef llvm::DenseMap<ValueDecl *, Expr *> AlignedMapTy*/
//  public final class AlignedMapTy extends DenseMap<ValueDecl /*P*/ , Expr /*P*/ >{ };
  /*typedef std::pair<unsigned int, VarDecl *> LCDeclInfo*/
//  public final class LCDeclInfo extends std.pairUIntType<VarDecl /*P*/ >{ };
  /*typedef llvm::DenseMap<ValueDecl *, LCDeclInfo> LoopControlVariablesMapTy*/
//  public final class LoopControlVariablesMapTy extends DenseMap<ValueDecl /*P*/ , std.pairUIntType<VarDecl /*P*/ >>{ };
  /*typedef llvm::DenseMap<ValueDecl *, OMPClauseMappableExprCommon::MappableExprComponentLists> MappedExprComponentsTy*/
//  public final class MappedExprComponentsTy extends DenseMap<ValueDecl /*P*/ , SmallVector<SmallVector<MappableComponent>>>{ };
  /*typedef llvm::StringMap<std::pair<OMPCriticalDirective *, llvm::APSInt> > CriticalsWithHintsTy*/
//  public final class CriticalsWithHintsTy extends StringMap<std.pair<OMPCriticalDirective /*P*/ , APSInt>>{ };
  /*typedef llvm::DenseMap<OMPDependClause *, OperatorOffsetTy> DoacrossDependMapTy*/
//  public final class DoacrossDependMapTy extends DenseMap<OMPDependClause /*P*/ , SmallVector<std.pair<Expr /*P*/ , OverloadedOperatorKind>>>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::SharingMapTy">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*default values*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 83,
   FQN="(anonymous namespace)::DSAStackTy::SharingMapTy", NM="_ZN12_GLOBAL__N_110DSAStackTy12SharingMapTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy12SharingMapTyE")
  //</editor-fold>
  private static final class/*struct*/ SharingMapTy implements Destructors.ClassWithDestructor, NativeCloneable<SharingMapTy> {
    public DenseMap<ValueDecl /*P*/ , DSAInfo> SharingMap;
    public DenseMap<ValueDecl /*P*/ , Expr /*P*/ > AlignedMap;
    public DenseMap<ValueDecl /*P*/ , SmallVector<SmallVector<MappableComponent>>> MappedExprComponents;
    public DenseMap<ValueDecl /*P*/ , std.pairUIntType<VarDecl /*P*/ >> LCVMap;
    public /*DefaultDataSharingAttributes*//*uint*/int DefaultAttr/* = DSA_unspecified*/;
    public SourceLocation DefaultAttrLoc;
    public OpenMPDirectiveKind Directive/* = OMPD_unknown*/;
    public DeclarationNameInfo DirectiveName;
    public Scope /*P*/ CurScope/* = null*/;
    public SourceLocation ConstructLoc;
    /// Set of 'depend' clauses with 'sink|source' dependence kind. Required to
    /// get the data (loop counters etc.) about enclosing loop-based construct.
    /// This data is required during codegen.
    public DenseMap<OMPDependClause /*P*/ , SmallVector<std.pair<Expr /*P*/ , OverloadedOperatorKind>>> DoacrossDepends;
    /// \brief first argument (Expr *) contains optional argument of the
    /// 'ordered' clause, the second one is true if the regions has 'ordered'
    /// clause, false otherwise.
    public PointerBoolPair<Expr /*P*/ > OrderedRegion;
    public boolean NowaitRegion/* = false*/;
    public boolean CancelRegion/* = false*/;
    public /*uint*/int AssociatedLoops/* = 1*/;
    public SourceLocation InnerTeamsRegionLoc;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::SharingMapTy::SharingMapTy">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*default values*/,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 106,
     FQN="(anonymous namespace)::DSAStackTy::SharingMapTy::SharingMapTy", NM="_ZN12_GLOBAL__N_110DSAStackTy12SharingMapTyC1EN5clang19OpenMPDirectiveKindENS2_19DeclarationNameInfoEPNS2_5ScopeENS2_14SourceLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy12SharingMapTyC1EN5clang19OpenMPDirectiveKindENS2_19DeclarationNameInfoEPNS2_5ScopeENS2_14SourceLocationE")
    //</editor-fold>
    public SharingMapTy(OpenMPDirectiveKind DKind, DeclarationNameInfo Name, 
        Scope /*P*/ CurScope, SourceLocation Loc) {
      // : SharingMap(), AlignedMap(), MappedExprComponents(), LCVMap(), DefaultAttr(DSA_unspecified), DefaultAttrLoc(), Directive(DKind), DirectiveName(Name), CurScope(CurScope), ConstructLoc(Loc), DoacrossDepends(), OrderedRegion(), NowaitRegion(false), CancelRegion(false), AssociatedLoops(1), InnerTeamsRegionLoc() 
      //START JInit
      this.SharingMap = new DenseMap<ValueDecl /*P*/ , DSAInfo>(DenseMapInfo$LikePtr.$Info(), (DSAInfo) null);
      this.AlignedMap = new DenseMap<ValueDecl /*P*/ , Expr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Expr /*P*/ )null);
      this.MappedExprComponents = new DenseMap<ValueDecl /*P*/ , SmallVector<SmallVector<MappableComponent>>>(DenseMapInfo$LikePtr.$Info(), new SmallVector<SmallVector<MappableComponent>>(8, new SmallVector<>(8, new MappableComponent())));
      this.LCVMap = new DenseMap<ValueDecl /*P*/ , std.pairUIntType<VarDecl /*P*/ >>(DenseMapInfo$LikePtr.$Info(), new std.pairUIntPtr<VarDecl /*P*/ >());
      /*InClass*/this.DefaultAttr = DefaultDataSharingAttributes.DSA_unspecified;
      this.DefaultAttrLoc = new SourceLocation();
      this.Directive = DKind;
      this.DirectiveName = new DeclarationNameInfo(Name);
      this.CurScope = CurScope;
      this.ConstructLoc = new SourceLocation(Loc);
      this.DoacrossDepends = new DenseMap<OMPDependClause /*P*/ , SmallVector<std.pair<Expr /*P*/ , OverloadedOperatorKind>>>(DenseMapInfo$LikePtr.$Info(), new SmallVector<std.pair<Expr /*P*/ , OverloadedOperatorKind>>(4, new std.pairPtrType<>(null, OverloadedOperatorKind.valueOf(0))));
      this.OrderedRegion = new PointerBoolPair<Expr /*P*/ >();
      /*InClass*/this.NowaitRegion = false;
      /*InClass*/this.CancelRegion = false;
      /*InClass*/this.AssociatedLoops = 1;
      this.InnerTeamsRegionLoc = new SourceLocation();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::SharingMapTy::SharingMapTy">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*default values*/,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 110,
     FQN="(anonymous namespace)::DSAStackTy::SharingMapTy::SharingMapTy", NM="_ZN12_GLOBAL__N_110DSAStackTy12SharingMapTyC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy12SharingMapTyC1Ev")
    //</editor-fold>
    public SharingMapTy() {
      // : SharingMap(), AlignedMap(), MappedExprComponents(), LCVMap(), DefaultAttr(DSA_unspecified), DefaultAttrLoc(), Directive(OMPD_unknown), DirectiveName(), CurScope(null), ConstructLoc(), DoacrossDepends(), OrderedRegion(), NowaitRegion(false), CancelRegion(false), AssociatedLoops(1), InnerTeamsRegionLoc() 
      //START JInit
      this.SharingMap = new DenseMap<ValueDecl /*P*/ , DSAInfo>(DenseMapInfo$LikePtr.$Info(), (DSAInfo)null);
      this.AlignedMap = new DenseMap<ValueDecl /*P*/ , Expr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Expr /*P*/ )null);
      this.MappedExprComponents = new DenseMap<ValueDecl /*P*/ , SmallVector<SmallVector<MappableComponent>>>(DenseMapInfo$LikePtr.$Info(), new SmallVector<SmallVector<MappableComponent>>(8, new SmallVector<>(8, new MappableComponent())));
      this.LCVMap = new DenseMap<ValueDecl /*P*/ , std.pairUIntType<VarDecl /*P*/ >>(DenseMapInfo$LikePtr.$Info(), new std.pairUIntPtr<VarDecl /*P*/ >());
      /*InClass*/this.DefaultAttr = DefaultDataSharingAttributes.DSA_unspecified;
      this.DefaultAttrLoc = new SourceLocation();
      /*InClass*/this.Directive = OpenMPDirectiveKind.OMPD_unknown;
      this.DirectiveName = new DeclarationNameInfo();
      /*InClass*/this.CurScope = null;
      this.ConstructLoc = new SourceLocation();
      this.DoacrossDepends = new DenseMap<OMPDependClause /*P*/ , SmallVector<std.pair<Expr /*P*/ , OverloadedOperatorKind>>>(DenseMapInfo$LikePtr.$Info(), new SmallVector<std.pair<Expr /*P*/ , OverloadedOperatorKind>>(4, new std.pairPtrType<>(null, OverloadedOperatorKind.valueOf(0))));
      this.OrderedRegion = new PointerBoolPair<Expr /*P*/ >();
      /*InClass*/this.NowaitRegion = false;
      /*InClass*/this.CancelRegion = false;
      /*InClass*/this.AssociatedLoops = 1;
      this.InnerTeamsRegionLoc = new SourceLocation();
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::SharingMapTy::SharingMapTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 83,
     FQN="(anonymous namespace)::DSAStackTy::SharingMapTy::SharingMapTy", NM="_ZN12_GLOBAL__N_110DSAStackTy12SharingMapTyC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy12SharingMapTyC1EOS1_")
    //</editor-fold>
    public /*inline*/ SharingMapTy(JD$Move _dparam, final SharingMapTy /*&&*/$Prm0) {
      // : SharingMap(static_cast<SharingMapTy &&>().SharingMap), AlignedMap(static_cast<SharingMapTy &&>().AlignedMap), MappedExprComponents(static_cast<SharingMapTy &&>().MappedExprComponents), LCVMap(static_cast<SharingMapTy &&>().LCVMap), DefaultAttr(static_cast<SharingMapTy &&>().DefaultAttr), DefaultAttrLoc(static_cast<SharingMapTy &&>().DefaultAttrLoc), Directive(static_cast<SharingMapTy &&>().Directive), DirectiveName(static_cast<SharingMapTy &&>().DirectiveName), CurScope(static_cast<SharingMapTy &&>().CurScope), ConstructLoc(static_cast<SharingMapTy &&>().ConstructLoc), DoacrossDepends(static_cast<SharingMapTy &&>().DoacrossDepends), OrderedRegion(static_cast<SharingMapTy &&>().OrderedRegion), NowaitRegion(static_cast<SharingMapTy &&>().NowaitRegion), CancelRegion(static_cast<SharingMapTy &&>().CancelRegion), AssociatedLoops(static_cast<SharingMapTy &&>().AssociatedLoops), InnerTeamsRegionLoc(static_cast<SharingMapTy &&>().InnerTeamsRegionLoc) 
      //START JInit
      this.SharingMap = new DenseMap<ValueDecl /*P*/ , DSAInfo>(JD$Move.INSTANCE, $Prm0.SharingMap);
      this.AlignedMap = new DenseMap<ValueDecl /*P*/ , Expr /*P*/ >(JD$Move.INSTANCE, $Prm0.AlignedMap);
      this.MappedExprComponents = new DenseMap<ValueDecl /*P*/ , SmallVector<SmallVector<MappableComponent>>>(JD$Move.INSTANCE, $Prm0.MappedExprComponents);
      this.LCVMap = new DenseMap<ValueDecl /*P*/ , std.pairUIntType<VarDecl /*P*/ >>(JD$Move.INSTANCE, $Prm0.LCVMap);
      this.DefaultAttr = $Prm0.DefaultAttr;
      this.DefaultAttrLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.DefaultAttrLoc);
      this.Directive = $Prm0.Directive;
      this.DirectiveName = new DeclarationNameInfo(JD$Move.INSTANCE, $Prm0.DirectiveName);
      this.CurScope = $Prm0.CurScope;
      this.ConstructLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.ConstructLoc);
      this.DoacrossDepends = new DenseMap<OMPDependClause /*P*/ , SmallVector<std.pair<Expr /*P*/ , OverloadedOperatorKind>>>(JD$Move.INSTANCE, $Prm0.DoacrossDepends);
      this.OrderedRegion = new PointerBoolPair<Expr /*P*/ >(JD$Move.INSTANCE, $Prm0.OrderedRegion);
      this.NowaitRegion = $Prm0.NowaitRegion;
      this.CancelRegion = $Prm0.CancelRegion;
      this.AssociatedLoops = $Prm0.AssociatedLoops;
      this.InnerTeamsRegionLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.InnerTeamsRegionLoc);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::SharingMapTy::~SharingMapTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 83,
     FQN="(anonymous namespace)::DSAStackTy::SharingMapTy::~SharingMapTy", NM="_ZN12_GLOBAL__N_110DSAStackTy12SharingMapTyD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy12SharingMapTyD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      DoacrossDepends.$destroy();
      LCVMap.$destroy();
      MappedExprComponents.$destroy();
      AlignedMap.$destroy();
      SharingMap.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::SharingMapTy::SharingMapTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 83,
     FQN="(anonymous namespace)::DSAStackTy::SharingMapTy::SharingMapTy", NM="_ZN12_GLOBAL__N_110DSAStackTy12SharingMapTyC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy12SharingMapTyC1ERKS1_")
    //</editor-fold>
    public /*inline*/ SharingMapTy(final /*const*/ SharingMapTy /*&*/ $Prm0) {
      // : SharingMap(.SharingMap), AlignedMap(.AlignedMap), MappedExprComponents(.MappedExprComponents), LCVMap(.LCVMap), DefaultAttr(.DefaultAttr), DefaultAttrLoc(.DefaultAttrLoc), Directive(.Directive), DirectiveName(.DirectiveName), CurScope(.CurScope), ConstructLoc(.ConstructLoc), DoacrossDepends(.DoacrossDepends), OrderedRegion(.OrderedRegion), NowaitRegion(.NowaitRegion), CancelRegion(.CancelRegion), AssociatedLoops(.AssociatedLoops), InnerTeamsRegionLoc(.InnerTeamsRegionLoc) 
      //START JInit
      this.SharingMap = new DenseMap<ValueDecl /*P*/ , DSAInfo>($Prm0.SharingMap);
      this.AlignedMap = new DenseMap<ValueDecl /*P*/ , Expr /*P*/ >($Prm0.AlignedMap);
      this.MappedExprComponents = new DenseMap<ValueDecl /*P*/ , SmallVector<SmallVector<MappableComponent>>>($Prm0.MappedExprComponents);
      this.LCVMap = new DenseMap<ValueDecl /*P*/ , std.pairUIntType<VarDecl /*P*/ >>($Prm0.LCVMap);
      this.DefaultAttr = $Prm0.DefaultAttr;
      this.DefaultAttrLoc = new SourceLocation($Prm0.DefaultAttrLoc);
      this.Directive = $Prm0.Directive;
      this.DirectiveName = new DeclarationNameInfo($Prm0.DirectiveName);
      this.CurScope = $Prm0.CurScope;
      this.ConstructLoc = new SourceLocation($Prm0.ConstructLoc);
      this.DoacrossDepends = new DenseMap<OMPDependClause /*P*/ , SmallVector<std.pair<Expr /*P*/ , OverloadedOperatorKind>>>($Prm0.DoacrossDepends);
      this.OrderedRegion = new PointerBoolPair<Expr /*P*/ >($Prm0.OrderedRegion);
      this.NowaitRegion = $Prm0.NowaitRegion;
      this.CancelRegion = $Prm0.CancelRegion;
      this.AssociatedLoops = $Prm0.AssociatedLoops;
      this.InnerTeamsRegionLoc = new SourceLocation($Prm0.InnerTeamsRegionLoc);
      //END JInit
    }

    @Override public SharingMapTy clone() {
      return new SharingMapTy(this);
    }
    
    @Override public String toString() {
      return "" + "SharingMap=" + SharingMap // NOI18N
                + ", AlignedMap=" + AlignedMap // NOI18N
                + ", MappedExprComponents=" + MappedExprComponents // NOI18N
                + ", LCVMap=" + LCVMap // NOI18N
                + ", DefaultAttr=" + DefaultAttr // NOI18N
                + ", DefaultAttrLoc=" + DefaultAttrLoc // NOI18N
                + ", Directive=" + Directive // NOI18N
                + ", DirectiveName=" + DirectiveName // NOI18N
                + ", CurScope=" + CurScope // NOI18N
                + ", ConstructLoc=" + ConstructLoc // NOI18N
                + ", DoacrossDepends=" + DoacrossDepends // NOI18N
                + ", OrderedRegion=" + OrderedRegion // NOI18N
                + ", NowaitRegion=" + NowaitRegion // NOI18N
                + ", CancelRegion=" + CancelRegion // NOI18N
                + ", AssociatedLoops=" + AssociatedLoops // NOI18N
                + ", InnerTeamsRegionLoc=" + InnerTeamsRegionLoc; // NOI18N
    }
  };
  
  /*typedef SmallVector<SharingMapTy, 4> StackTy*/
//  public final class StackTy extends SmallVector<SharingMapTy>{ };
  
  /// \brief Stack of used declaration and their data-sharing attributes.
  private SmallVector<SharingMapTy> Stack;
  /// \brief true, if check for DSA must be from parent directive, false, if
  /// from current directive.
  private OpenMPClauseKind ClauseKindMode/* = OMPC_unknown*/;
  private final Sema /*&*/ SemaRef;
  private boolean ForceCapturing/* = false*/;
  private StringMap<std.pair<OMPCriticalDirective /*P*/ , APSInt>> Criticals;
  
  /*typedef SmallVector<SharingMapTy, 8>::reverse_iterator reverse_iterator*/
//  public final class reverse_iterator extends std.reverse_iterator<SharingMapTy>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getDSA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 407,
   FQN="(anonymous namespace)::DSAStackTy::getDSA", NM="_ZN12_GLOBAL__N_110DSAStackTy6getDSAERSt16reverse_iteratorIPNS0_12SharingMapTyEEPN5clang9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy6getDSAERSt16reverse_iteratorIPNS0_12SharingMapTyEEPN5clang9ValueDeclE")
  //</editor-fold>
  private DSAStackTy.DSAVarData getDSA(final std.reverse_iterator<SharingMapTy> /*&*/ Iter, 
        ValueDecl /*P*/ D) {
    D = getCanonicalDecl(D);
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    FieldDecl /*P*/ FD = dyn_cast_FieldDecl(D);
    DSAVarData DVar/*J*/= new DSAVarData();
    if ($eq_reverse_iterator$C(Iter, std.prev(Stack.rend()))) {
      // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
      // in a region but not in construct]
      //  File-scope or namespace-scope variables referenced in called routines
      //  in the region are shared unless they appear in a threadprivate
      //  directive.
      if ((VD != null) && !VD.isFunctionOrMethodVarDecl() && !isa_ParmVarDecl(D)) {
        DVar.CKind = OpenMPClauseKind.OMPC_shared;
      }
      
      // OpenMP [2.9.1.2, Data-sharing Attribute Rules for Variables Referenced
      // in a region but not in construct]
      //  Variables with static storage duration that are declared in called
      //  routines in the region are shared.
      if ((VD != null) && VD.hasGlobalStorage()) {
        DVar.CKind = OpenMPClauseKind.OMPC_shared;
      }
      
      // Non-static data members are shared by default.
      if ((FD != null)) {
        DVar.CKind = OpenMPClauseKind.OMPC_shared;
      }
      
      return DVar;
    }
    
    DVar.DKind = Iter.$arrow().Directive;
    // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
    // in a Construct, C/C++, predetermined, p.1]
    // Variables with automatic storage duration that are declared in a scope
    // inside the construct are private.
    if ((VD != null) && isOpenMPLocal(VD, new std.reverse_iterator<SharingMapTy>(Iter)) && VD.isLocalVarDecl()
       && (VD.getStorageClass() == StorageClass.SC_Auto || VD.getStorageClass() == StorageClass.SC_None)) {
      DVar.CKind = OpenMPClauseKind.OMPC_private;
      return DVar;
    }
    
    // Explicitly specified attributes and local variables with predetermined
    // attributes.
    if ((Iter.$arrow().SharingMap.count(D) != 0)) {
      DVar.RefExpr = Iter.$arrow().SharingMap.$at_T1$C$R(D).RefExpr.getPointer();
      DVar.PrivateCopy = Iter.$arrow().SharingMap.$at_T1$C$R(D).PrivateCopy;
      DVar.CKind = Iter.$arrow().SharingMap.$at_T1$C$R(D).Attributes;
      DVar.ImplicitDSALoc.$assign(Iter.$arrow().DefaultAttrLoc);
      return DVar;
    }
    
    // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
    // in a Construct, C/C++, implicitly determined, p.1]
    //  In a parallel or task construct, the data-sharing attributes of these
    //  variables are determined by the default clause, if present.
    switch (Iter.$arrow().DefaultAttr) {
     case DefaultDataSharingAttributes.DSA_shared:
      DVar.CKind = OpenMPClauseKind.OMPC_shared;
      DVar.ImplicitDSALoc.$assign(Iter.$arrow().DefaultAttrLoc);
      return DVar;
     case DefaultDataSharingAttributes.DSA_none:
      return DVar;
     case DefaultDataSharingAttributes.DSA_unspecified:
      // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
      // in a Construct, implicitly determined, p.2]
      //  In a parallel construct, if no default clause is present, these
      //  variables are shared.
      DVar.ImplicitDSALoc.$assign(Iter.$arrow().DefaultAttrLoc);
      if (isOpenMPParallelDirective(DVar.DKind)
         || isOpenMPTeamsDirective(DVar.DKind)) {
        DVar.CKind = OpenMPClauseKind.OMPC_shared;
        return DVar;
      }
      
      // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
      // in a Construct, implicitly determined, p.4]
      //  In a task construct, if no default clause is present, a variable that in
      //  the enclosing context is determined to be shared by all implicit tasks
      //  bound to the current team is shared.
      if (isOpenMPTaskingDirective(DVar.DKind)) {
        DSAVarData DVarTemp/*J*/= new DSAVarData();
        for (std.reverse_iterator<SharingMapTy> I = std.next(new reverse_iterator<SharingMapTy>(Iter)), EE = Stack.rend();
             $noteq_reverse_iterator$C(I, EE); I.$preInc()) {
          // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables
          // Referenced in a Construct, implicitly determined, p.6]
          //  In a task construct, if no default clause is present, a variable
          //  whose data-sharing attribute is not determined by the rules above is
          //  firstprivate.
          DVarTemp.$assignMove(getDSA(I, D));
          if (DVarTemp.CKind != OpenMPClauseKind.OMPC_shared) {
            DVar.RefExpr = null;
            DVar.CKind = OpenMPClauseKind.OMPC_firstprivate;
            return DVar;
          }
          if (isParallelOrTaskRegion(I.$arrow().Directive)) {
            break;
          }
        }
        DVar.CKind
           = (DVarTemp.CKind == OpenMPClauseKind.OMPC_unknown) ? OpenMPClauseKind.OMPC_firstprivate : OpenMPClauseKind.OMPC_shared;
        return DVar;
      }
    }
    // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
    // in a Construct, implicitly determined, p.3]
    //  For constructs other than task, if no default clause is present, these
    //  variables inherit their data-sharing attributes from the enclosing
    //  context.
    return getDSA(Iter.$preInc(), D);
  }

  
  /// \brief Checks if the variable is a local for OpenMP region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::isOpenMPLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 597,
   FQN="(anonymous namespace)::DSAStackTy::isOpenMPLocal", NM="_ZN12_GLOBAL__N_110DSAStackTy13isOpenMPLocalEPN5clang7VarDeclESt16reverse_iteratorIPNS0_12SharingMapTyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy13isOpenMPLocalEPN5clang7VarDeclESt16reverse_iteratorIPNS0_12SharingMapTyEE")
  //</editor-fold>
  private boolean isOpenMPLocal(VarDecl /*P*/ D, std.reverse_iterator<SharingMapTy> Iter) {
    D = D.getCanonicalDecl();
    if ($greater_uint(Stack.size(), 2)) {
      std.reverse_iterator<SharingMapTy> I = new std.reverse_iterator<SharingMapTy>(Iter);
      std.reverse_iterator<SharingMapTy> E = std.prev(Stack.rend());
      Scope /*P*/ TopScope = null;
      while ($noteq_reverse_iterator$C(I, E) && !isParallelOrTaskRegion(I.$arrow().Directive)) {
        I.$preInc();
      }
      if ($eq_reverse_iterator$C(I, E)) {
        return false;
      }
      TopScope = (I.$arrow().CurScope != null) ? I.$arrow().CurScope.getParent() : null;
      Scope /*P*/ CurScope = getCurScope();
      while (CurScope != TopScope && !CurScope.isDeclScope(D)) {
        CurScope = CurScope.getParent();
      }
      return CurScope != TopScope;
    }
    return false;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::DSAStackTy">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*default values*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 132,
   FQN="(anonymous namespace)::DSAStackTy::DSAStackTy", NM="_ZN12_GLOBAL__N_110DSAStackTyC1ERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTyC1ERN5clang4SemaE")
  //</editor-fold>
  public /*explicit*/ DSAStackTy(final Sema /*&*/ S) {
    // : Stack(1), ClauseKindMode(OMPC_unknown), SemaRef(S), ForceCapturing(false), Criticals() 
    //START JInit
    this.Stack = new SmallVector<SharingMapTy>(JD$UInt_T$C$R.INSTANCE, 4, 1, new SharingMapTy());
    /*InClass*/this.ClauseKindMode = OpenMPClauseKind.OMPC_unknown;
    this./*&*/SemaRef=/*&*/S;
    /*InClass*/this.ForceCapturing = false;
    this.Criticals = new StringMap<std.pair<OMPCriticalDirective /*P*/ , APSInt>>(new std.pairPtrType<OMPCriticalDirective /*P*/ , APSInt>(null, new APSInt()));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::isClauseParsingMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 134,
   FQN="(anonymous namespace)::DSAStackTy::isClauseParsingMode", NM="_ZNK12_GLOBAL__N_110DSAStackTy19isClauseParsingModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy19isClauseParsingModeEv")
  //</editor-fold>
  public boolean isClauseParsingMode() /*const*/ {
    return ClauseKindMode != OpenMPClauseKind.OMPC_unknown;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::setClauseParsingMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 135,
   FQN="(anonymous namespace)::DSAStackTy::setClauseParsingMode", NM="_ZN12_GLOBAL__N_110DSAStackTy20setClauseParsingModeEN5clang16OpenMPClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy20setClauseParsingModeEN5clang16OpenMPClauseKindE")
  //</editor-fold>
  public void setClauseParsingMode(OpenMPClauseKind K) {
    ClauseKindMode = K;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::isForceVarCapturing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 137,
   FQN="(anonymous namespace)::DSAStackTy::isForceVarCapturing", NM="_ZNK12_GLOBAL__N_110DSAStackTy19isForceVarCapturingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy19isForceVarCapturingEv")
  //</editor-fold>
  public boolean isForceVarCapturing() /*const*/ {
    return ForceCapturing;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::setForceVarCapturing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 138,
   FQN="(anonymous namespace)::DSAStackTy::setForceVarCapturing", NM="_ZN12_GLOBAL__N_110DSAStackTy20setForceVarCapturingEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy20setForceVarCapturingEb")
  //</editor-fold>
  public void setForceVarCapturing(boolean V) {
    ForceCapturing = V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::push">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 140,
   FQN="(anonymous namespace)::DSAStackTy::push", NM="_ZN12_GLOBAL__N_110DSAStackTy4pushEN5clang19OpenMPDirectiveKindERKNS1_19DeclarationNameInfoEPNS1_5ScopeENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy4pushEN5clang19OpenMPDirectiveKindERKNS1_19DeclarationNameInfoEPNS1_5ScopeENS1_14SourceLocationE")
  //</editor-fold>
  public void push(OpenMPDirectiveKind DKind, final /*const*/ DeclarationNameInfo /*&*/ DirName, 
      Scope /*P*/ CurScope, SourceLocation Loc) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Stack.push_back_T$RR($c$.track(new SharingMapTy(DKind, new DeclarationNameInfo(DirName), CurScope, new SourceLocation(Loc)))); $c$.clean();
      Stack.back().DefaultAttrLoc.$assign(Loc);
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::pop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 146,
   FQN="(anonymous namespace)::DSAStackTy::pop", NM="_ZN12_GLOBAL__N_110DSAStackTy3popEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy3popEv")
  //</editor-fold>
  public void pop() {
    assert ($greater_uint(Stack.size(), 1)) : "Data-sharing attributes stack is empty!";
    Stack.pop_back();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::addCriticalWithHint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 151,
   FQN="(anonymous namespace)::DSAStackTy::addCriticalWithHint", NM="_ZN12_GLOBAL__N_110DSAStackTy19addCriticalWithHintEPN5clang20OMPCriticalDirectiveEN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy19addCriticalWithHintEPN5clang20OMPCriticalDirectiveEN4llvm6APSIntE")
  //</editor-fold>
  public void addCriticalWithHint(OMPCriticalDirective /*P*/ D, APSInt Hint) {
    Criticals.$at(new StringRef(D.getDirectiveName().getAsString())).$assignMove(std.make_pair_Ptr_T(D, Hint));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getCriticalWithHint">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 154,
   FQN="(anonymous namespace)::DSAStackTy::getCriticalWithHint", NM="_ZNK12_GLOBAL__N_110DSAStackTy19getCriticalWithHintERKN5clang19DeclarationNameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy19getCriticalWithHintERKN5clang19DeclarationNameInfoE")
  //</editor-fold>
  public /*const*/ std.pair<OMPCriticalDirective /*P*/ , APSInt> getCriticalWithHint(final /*const*/ DeclarationNameInfo /*&*/ Name) /*const*/ {
    StringMapConstIterator<pair<OMPCriticalDirective /*P*/ , APSInt> > I = Criticals.find$Const(new StringRef(Name.getAsString()));
    if (I.$noteq(Criticals.end$Const())) {
      return new std.pairPtrType<OMPCriticalDirective /*P*/ , APSInt>(I.$arrow().second);
    }
    return std.make_pair_nullptr_t_T((OMPCriticalDirective /*P*/)null, new APSInt());
  }

  /// \brief If 'aligned' declaration for given variable \a D was not seen yet,
  /// add it and return NULL; otherwise return previous occurrence's expression
  /// for diagnostics.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::addUniqueAligned">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 516,
   FQN="(anonymous namespace)::DSAStackTy::addUniqueAligned", NM="_ZN12_GLOBAL__N_110DSAStackTy16addUniqueAlignedEPN5clang9ValueDeclEPNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy16addUniqueAlignedEPN5clang9ValueDeclEPNS1_4ExprE")
  //</editor-fold>
  public Expr /*P*/ addUniqueAligned(ValueDecl /*P*/ D, Expr /*P*/ NewDE) {
    assert ($greater_uint(Stack.size(), 1)) : "Data sharing attributes stack is empty";
    D = getCanonicalDecl(D);
    DenseMapIterator<ValueDecl /*P*/ , Expr /*P*/ > It = Stack.back().AlignedMap.find(D);
    if (It.$eq(/*NO_ITER_COPY*/Stack.back().AlignedMap.end())) {
      assert ((NewDE != null)) : "Unexpected nullptr expr to be added into aligned map";
      Stack.back().AlignedMap.$set(D, NewDE);
      return null;
    } else {
      assert ((It.$arrow().second != null)) : "Unexpected nullptr expr in the aligned map";
      return It.$arrow().second;
    }
    //JAVA: return null;
  }

  
  /// \brief Register specified variable as loop control variable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::addLoopControlVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 531,
   FQN="(anonymous namespace)::DSAStackTy::addLoopControlVariable", NM="_ZN12_GLOBAL__N_110DSAStackTy22addLoopControlVariableEPN5clang9ValueDeclEPNS1_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy22addLoopControlVariableEPN5clang9ValueDeclEPNS1_7VarDeclE")
  //</editor-fold>
  public void addLoopControlVariable(ValueDecl /*P*/ D, VarDecl /*P*/ Capture) {
    assert ($greater_uint(Stack.size(), 1)) : "Data-sharing attributes stack is empty";
    D = getCanonicalDecl(D);
    Stack.back().LCVMap.insert_pair$KeyT$ValueT(std.make_pair_Ptr_T(D, new std.pairUIntPtr<VarDecl /*P*/ >(JD$T$RR_T1$RR.INSTANCE, Stack.back().LCVMap.size() + 1, Capture)));
  }

  /// \brief Check if the specified variable is a loop control variable for
  /// current region.
  /// \return The index of the loop control variable in the list of associated
  /// for-loops (from outer to inner).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::isLoopControlVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 538,
   FQN="(anonymous namespace)::DSAStackTy::isLoopControlVariable", NM="_ZN12_GLOBAL__N_110DSAStackTy21isLoopControlVariableEPN5clang9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy21isLoopControlVariableEPN5clang9ValueDeclE")
  //</editor-fold>
  public std.pairUIntType<VarDecl /*P*/ > isLoopControlVariable(ValueDecl /*P*/ D) {
    assert ($greater_uint(Stack.size(), 1)) : "Data-sharing attributes stack is empty";
    D = getCanonicalDecl(D);
    return $greater_uint(Stack.back().LCVMap.count(D), 0) ? new std.pairUIntPtr<VarDecl /*P*/ >(Stack.back().LCVMap.$at_T1$C$R(D)) : new std.pairUIntPtr<VarDecl /*P*/ >(JD$T$RR_T1$RR.INSTANCE, 0, null);
  }

  /// \brief Check if the specified variable is a loop control variable for
  /// parent region.
  /// \return The index of the loop control variable in the list of associated
  /// for-loops (from outer to inner).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::isParentLoopControlVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 545,
   FQN="(anonymous namespace)::DSAStackTy::isParentLoopControlVariable", NM="_ZN12_GLOBAL__N_110DSAStackTy27isParentLoopControlVariableEPN5clang9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy27isParentLoopControlVariableEPN5clang9ValueDeclE")
  //</editor-fold>
  public std.pairUIntType<VarDecl /*P*/ > isParentLoopControlVariable(ValueDecl /*P*/ D) {
    assert ($greater_uint(Stack.size(), 2)) : "Data-sharing attributes stack is empty";
    D = getCanonicalDecl(D);
    return $greater_uint(Stack.$at(Stack.size() - 2).LCVMap.count(D), 0) ? new std.pairUIntPtr<VarDecl /*P*/ >(Stack.$at(Stack.size() - 2).LCVMap.$at_T1$C$R(D)) : new std.pairUIntPtr<VarDecl /*P*/ >(JD$T$RR_T1$RR.INSTANCE, 0, null);
  }

  /// \brief Get the loop control variable for the I-th loop (or nullptr) in
  /// parent directive.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getParentLoopControlVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 553,
   FQN="(anonymous namespace)::DSAStackTy::getParentLoopControlVariable", NM="_ZN12_GLOBAL__N_110DSAStackTy28getParentLoopControlVariableEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy28getParentLoopControlVariableEj")
  //</editor-fold>
  public ValueDecl /*P*/ getParentLoopControlVariable(/*uint*/int I) {
    assert ($greater_uint(Stack.size(), 2)) : "Data-sharing attributes stack is empty";
    if ($less_uint(Stack.$at(Stack.size() - 2).LCVMap.size(), I)) {
      return null;
    }
    for (final std.pair<ValueDecl /*P*/ , std.pairUIntType<VarDecl /*P*/ >> /*&*/ Pair : Stack.$at(Stack.size() - 2).LCVMap) {
      if (Pair.second.first == I) {
        return Pair.first;
      }
    }
    return null;
  }

  
  /// \brief Adds explicit data sharing attribute to the specified declaration.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::addDSA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 564,
   FQN="(anonymous namespace)::DSAStackTy::addDSA", NM="_ZN12_GLOBAL__N_110DSAStackTy6addDSAEPN5clang9ValueDeclEPNS1_4ExprENS1_16OpenMPClauseKindEPNS1_11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy6addDSAEPN5clang9ValueDeclEPNS1_4ExprENS1_16OpenMPClauseKindEPNS1_11DeclRefExprE")
  //</editor-fold>
  public void addDSA(ValueDecl /*P*/ D, Expr /*P*/ E, OpenMPClauseKind A) {
    addDSA(D, E, A, 
        (DeclRefExpr /*P*/ )null);
  }
  public void addDSA(ValueDecl /*P*/ D, Expr /*P*/ E, OpenMPClauseKind A, 
        DeclRefExpr /*P*/ PrivateCopy/*= null*/) {
    D = getCanonicalDecl(D);
    if (A == OpenMPClauseKind.OMPC_threadprivate) {
      final DSAInfo /*&*/ Data = Stack.$at(0).SharingMap.$at_T1$C$R(D);
      Data.Attributes = A;
      Data.RefExpr.setPointer(E);
      Data.PrivateCopy = null;
    } else {
      assert ($greater_uint(Stack.size(), 1)) : "Data-sharing attributes stack is empty";
      final DSAInfo /*&*/ Data = Stack.back().SharingMap.$at_T1$C$R(D);
      assert (Data.Attributes == OpenMPClauseKind.OMPC_unknown || (A == Data.Attributes) || (A == OpenMPClauseKind.OMPC_firstprivate && Data.Attributes == OpenMPClauseKind.OMPC_lastprivate) || (A == OpenMPClauseKind.OMPC_lastprivate && Data.Attributes == OpenMPClauseKind.OMPC_firstprivate) || (((isLoopControlVariable(D).first) != 0) && A == OpenMPClauseKind.OMPC_private));
      if (A == OpenMPClauseKind.OMPC_lastprivate && Data.Attributes == OpenMPClauseKind.OMPC_firstprivate) {
        Data.RefExpr.setInt(/*IntVal=*/ true);
        return;
      }
      /*const*/boolean IsLastprivate = A == OpenMPClauseKind.OMPC_lastprivate || Data.Attributes == OpenMPClauseKind.OMPC_lastprivate;
      Data.Attributes = A;
      Data.RefExpr.setPointerAndInt(E, IsLastprivate);
      Data.PrivateCopy = PrivateCopy;
      if ((PrivateCopy != null)) {
        final DSAInfo /*&*/ Data$1 = Stack.back().SharingMap.$at_T1$RR(PrivateCopy.getDecl());
        Data$1.Attributes = A;
        Data$1.RefExpr.setPointerAndInt(PrivateCopy, IsLastprivate);
        Data$1.PrivateCopy = null;
      }
    }
  }

  
  /// \brief Returns data sharing attributes from top of the stack for the
  /// specified declaration.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getTopDSA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 644,
   FQN="(anonymous namespace)::DSAStackTy::getTopDSA", NM="_ZN12_GLOBAL__N_110DSAStackTy9getTopDSAEPN5clang9ValueDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy9getTopDSAEPN5clang9ValueDeclEb")
  //</editor-fold>
  public DSAStackTy.DSAVarData getTopDSA(ValueDecl /*P*/ D, boolean FromParent) {
    D = getCanonicalDecl(D);
    DSAVarData DVar/*J*/= new DSAVarData();
    
    // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
    // in a Construct, C/C++, predetermined, p.1]
    //  Variables appearing in threadprivate directives are threadprivate.
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if (((VD != null) && VD.getTLSKind() != VarDecl.TLSKind.TLS_None
       && !(VD.hasAttr(OMPThreadPrivateDeclAttr.class)
       && SemaRef.getLangOpts().OpenMPUseTLS
       && SemaRef.getASTContext().getTargetInfo().isTLSSupported()))
       || ((VD != null) && VD.getStorageClass() == StorageClass.SC_Register
       && VD.hasAttr(AsmLabelAttr.class) && !VD.isLocalVarDecl())) {
      addDSA(D, buildDeclRefExpr(SemaRef, VD, D.getType().getNonReferenceType(), 
              D.getLocation()), 
          OpenMPClauseKind.OMPC_threadprivate);
    }
    if ((Stack.$at(0).SharingMap.count(D) != 0)) {
      DVar.RefExpr = Stack.$at(0).SharingMap.$at_T1$C$R(D).RefExpr.getPointer();
      DVar.CKind = OpenMPClauseKind.OMPC_threadprivate;
      return DVar;
    }
    if (Stack.size() == 1) {
      // Not in OpenMP execution region and top scope was already checked.
      return DVar;
    }
    
    // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
    // in a Construct, C/C++, predetermined, p.4]
    //  Static data members are shared.
    // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
    // in a Construct, C/C++, predetermined, p.7]
    //  Variables with static storage duration that are declared in a scope
    //  inside the construct are shared.
    final BoolPredicate<OpenMPDirectiveKind> MatchesAlways = /*[]*/ (OpenMPDirectiveKind $Prm0) -> {
          return true;
        };
    if ((VD != null) && VD.isStaticDataMember()) {
      DSAVarData DVarTemp = hasDSA(D, /*FuncArg*/BasicClangGlobals::isOpenMPPrivate, /*FuncArg*/MatchesAlways, FromParent);
      if (DVarTemp.CKind != OpenMPClauseKind.OMPC_unknown && (DVarTemp.RefExpr != null)) {
        return DVar;
      }
      
      DVar.CKind = OpenMPClauseKind.OMPC_shared;
      return DVar;
    }
    
    QualType Type = D.getType().getNonReferenceType().getCanonicalType();
    boolean IsConstant = Type.isConstant(SemaRef.getASTContext());
    Type.$assignMove(SemaRef.getASTContext().getBaseElementType(new QualType(Type)));
    // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
    // in a Construct, C/C++, predetermined, p.6]
    //  Variables with const qualified type having no mutable member are
    //  shared.
    CXXRecordDecl /*P*/ RD = SemaRef.getLangOpts().CPlusPlus ? Type.$arrow().getAsCXXRecordDecl() : null;
    {
      ClassTemplateSpecializationDecl /*P*/ CTSD = dyn_cast_or_null_ClassTemplateSpecializationDecl(RD);
      if ((CTSD != null)) {
        {
          ClassTemplateDecl /*P*/ CTD = CTSD.getSpecializedTemplate();
          if ((CTD != null)) {
            RD = CTD.getTemplatedDecl();
          }
        }
      }
    }
    if (IsConstant
       && !(SemaRef.getLangOpts().CPlusPlus && (RD != null) && RD.hasDefinition()
       && RD.hasMutableFields())) {
      // Variables with const-qualified type having no mutable member may be
      // listed in a firstprivate clause, even if they are static data members.
      DSAVarData DVarTemp = hasDSA(D, /*FuncArg*//*[]*/ (OpenMPClauseKind C) -> {
                return C == OpenMPClauseKind.OMPC_firstprivate;
              }, 
          /*FuncArg*/MatchesAlways, FromParent);
      if (DVarTemp.CKind == OpenMPClauseKind.OMPC_firstprivate && (DVarTemp.RefExpr != null)) {
        return DVar;
      }
      
      DVar.CKind = OpenMPClauseKind.OMPC_shared;
      return DVar;
    }
    
    // Explicitly specified attributes and local variables with predetermined
    // attributes.
    reverse_iterator<SharingMapTy> StartI = std.next(Stack.rbegin());
    reverse_iterator<SharingMapTy> EndI = std.prev(Stack.rend());
    if (FromParent && $noteq_reverse_iterator$C(StartI, EndI)) {
      StartI.$assign(std.next(new reverse_iterator<SharingMapTy>(StartI)));
    }
    reverse_iterator<SharingMapTy> I = std.prev(new reverse_iterator<SharingMapTy>(StartI));
    if ((I.$arrow().SharingMap.count(D) != 0)) {
      DVar.RefExpr = I.$arrow().SharingMap.$at_T1$C$R(D).RefExpr.getPointer();
      DVar.PrivateCopy = I.$arrow().SharingMap.$at_T1$C$R(D).PrivateCopy;
      DVar.CKind = I.$arrow().SharingMap.$at_T1$C$R(D).Attributes;
      DVar.ImplicitDSALoc.$assign(I.$arrow().DefaultAttrLoc);
    }
    
    return DVar;
  }

  /// \brief Returns data-sharing attributes for the specified declaration.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getImplicitDSA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 735,
   FQN="(anonymous namespace)::DSAStackTy::getImplicitDSA", NM="_ZN12_GLOBAL__N_110DSAStackTy14getImplicitDSAEPN5clang9ValueDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy14getImplicitDSAEPN5clang9ValueDeclEb")
  //</editor-fold>
  public DSAStackTy.DSAVarData getImplicitDSA(ValueDecl /*P*/ D, 
                boolean FromParent) {
    D = getCanonicalDecl(D);
    reverse_iterator<SharingMapTy> StartI = Stack.rbegin();
    reverse_iterator<SharingMapTy> EndI = std.prev(Stack.rend());
    if (FromParent && $noteq_reverse_iterator$C(StartI, EndI)) {
      StartI.$assign(std.next(new reverse_iterator<SharingMapTy>(StartI)));
    }
    return getDSA(StartI, D);
  }

  /// \brief Checks if the specified variables has data-sharing attributes which
  /// match specified \a CPred predicate in any directive which matches \a DPred
  /// predicate.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::hasDSA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 746,
   FQN="(anonymous namespace)::DSAStackTy::hasDSA", NM="_ZN12_GLOBAL__N_110DSAStackTy6hasDSAEPN5clang9ValueDeclERKN4llvm12function_refIFbNS1_16OpenMPClauseKindEEEERKNS5_IFbNS1_19OpenMPDirectiveKindEEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy6hasDSAEPN5clang9ValueDeclERKN4llvm12function_refIFbNS1_16OpenMPClauseKindEEEERKNS5_IFbNS1_19OpenMPDirectiveKindEEEEb")
  //</editor-fold>
  public DSAStackTy.DSAVarData hasDSA(ValueDecl /*P*/ D, 
        final /*const*/BoolPredicate<OpenMPClauseKind> /*&*/ CPred, 
        final /*const*/BoolPredicate<OpenMPDirectiveKind> /*&*/ DPred, 
        boolean FromParent) {    
    D = getCanonicalDecl(D);
    reverse_iterator<SharingMapTy> StartI = std.next(Stack.rbegin());
    reverse_iterator<SharingMapTy> EndI = Stack.rend();
    if (FromParent && $noteq_reverse_iterator$C(StartI, EndI)) {
      StartI.$assign(std.next(new reverse_iterator<SharingMapTy>(StartI)));
    }
    for (reverse_iterator<SharingMapTy> I = new reverse_iterator<SharingMapTy>(StartI), EE = new reverse_iterator<SharingMapTy>(EndI); $noteq_reverse_iterator$C(I, EE); I.$preInc()) {
      if (!DPred.$call(I.$arrow().Directive) && !isParallelOrTaskRegion(I.$arrow().Directive)) {
        continue;
      }
      DSAVarData DVar = getDSA(I, D);
      if (CPred.$call(DVar.CKind)) {
        return DVar;
      }
    }
    return new DSAVarData();
  }

  /// \brief Checks if the specified variables has data-sharing attributes which
  /// match specified \a CPred predicate in any innermost directive which
  /// matches \a DPred predicate.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::hasInnermostDSA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 767,
   FQN="(anonymous namespace)::DSAStackTy::hasInnermostDSA", NM="_ZN12_GLOBAL__N_110DSAStackTy15hasInnermostDSAEPN5clang9ValueDeclERKN4llvm12function_refIFbNS1_16OpenMPClauseKindEEEERKNS5_IFbNS1_19OpenMPDirectiveKindEEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy15hasInnermostDSAEPN5clang9ValueDeclERKN4llvm12function_refIFbNS1_16OpenMPClauseKindEEEERKNS5_IFbNS1_19OpenMPDirectiveKindEEEEb")
  //</editor-fold>
  public DSAStackTy.DSAVarData hasInnermostDSA(ValueDecl /*P*/ D, final /*const*/BoolPredicate<OpenMPClauseKind> /*&*/ CPred, 
                 final /*const*/BoolPredicate<OpenMPDirectiveKind> /*&*/ DPred, 
                 boolean FromParent) {  
    D = getCanonicalDecl(D);
    reverse_iterator<SharingMapTy> StartI = std.next(Stack.rbegin());
    reverse_iterator<SharingMapTy> EndI = Stack.rend();
    if (FromParent && $noteq_reverse_iterator$C(StartI, EndI)) {
      StartI.$assign(std.next(new reverse_iterator<SharingMapTy>(StartI)));
    }
    for (reverse_iterator<SharingMapTy> I = new reverse_iterator<SharingMapTy>(StartI), EE = new reverse_iterator<SharingMapTy>(EndI); $noteq_reverse_iterator$C(I, EE); I.$preInc()) {
      if (!DPred.$call(I.$arrow().Directive)) {
        break;
      }
      DSAVarData DVar = getDSA(I, D);
      if (CPred.$call(DVar.CKind)) {
        return DVar;
      }
      return new DSAVarData();
    }
    return new DSAVarData();
  }

  /// \brief Checks if the specified variables has explicit data-sharing
  /// attributes which match specified \a CPred predicate at the specified
  /// OpenMP region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::hasExplicitDSA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 788,
   FQN="(anonymous namespace)::DSAStackTy::hasExplicitDSA", NM="_ZN12_GLOBAL__N_110DSAStackTy14hasExplicitDSAEPN5clang9ValueDeclERKN4llvm12function_refIFbNS1_16OpenMPClauseKindEEEEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy14hasExplicitDSAEPN5clang9ValueDeclERKN4llvm12function_refIFbNS1_16OpenMPClauseKindEEEEjb")
  //</editor-fold>
  public boolean hasExplicitDSA(ValueDecl /*P*/ D, final /*const*/BoolPredicate<OpenMPClauseKind> /*&*/ CPred, 
                /*uint*/int Level) {
    return hasExplicitDSA(D, CPred, 
                Level, false);
  }
  public boolean hasExplicitDSA(ValueDecl /*P*/ D, final /*const*/BoolPredicate<OpenMPClauseKind> /*&*/ CPred, 
                /*uint*/int Level, boolean NotLastprivate/*= false*/) {
    if (CPred.$call(ClauseKindMode)) {
      return true;
    }
    D = getCanonicalDecl(D);
    type$ptr<SharingMapTy /*P*/ > StartI = std.next(Stack.begin());
    type$ptr<SharingMapTy /*P*/ > EndI = $tryClone(Stack.end());
    if (std.distance(StartI, EndI) <= (int)Level) {
      return false;
    }
    std.advance(StartI, Level);
    return ($greater_uint(StartI.$arrow().SharingMap.count(D), 0))
       && (StartI.$arrow().SharingMap.$at_T1$C$R(D).RefExpr.getPointer() != null)
       && CPred.$call(StartI.$arrow().SharingMap.$at_T1$C$R(D).Attributes)
       && (!NotLastprivate || !StartI.$arrow().SharingMap.$at_T1$C$R(D).RefExpr.getInt());
  }

  
  /// \brief Returns true if the directive at level \Level matches in the
  /// specified \a DPred predicate.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::hasExplicitDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 805,
   FQN="(anonymous namespace)::DSAStackTy::hasExplicitDirective", NM="_ZN12_GLOBAL__N_110DSAStackTy20hasExplicitDirectiveERKN4llvm12function_refIFbN5clang19OpenMPDirectiveKindEEEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy20hasExplicitDirectiveERKN4llvm12function_refIFbN5clang19OpenMPDirectiveKindEEEEj")
  //</editor-fold>
  public boolean hasExplicitDirective(final /*const*/BoolPredicate<OpenMPDirectiveKind> /*&*/ DPred, 
                      /*uint*/int Level) {
    type$ptr<SharingMapTy /*P*/ > StartI = std.next(Stack.begin());
    type$ptr<SharingMapTy /*P*/ > EndI = $tryClone(Stack.end());
    if (std.distance(StartI, EndI) <= (int)Level) {
      return false;
    }
    std.advance(StartI, Level);
    return DPred.$call(StartI.$arrow().Directive);
  }

  
  /// \brief Finds a directive which matches specified \a DPred predicate.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::hasDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 816,
   FQN="(anonymous namespace)::DSAStackTy::hasDirective", NM="_ZN12_GLOBAL__N_110DSAStackTy12hasDirectiveERKN4llvm12function_refIFbN5clang19OpenMPDirectiveKindERKNS3_19DeclarationNameInfoENS3_14SourceLocationEEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy12hasDirectiveERKN4llvm12function_refIFbN5clang19OpenMPDirectiveKindERKNS3_19DeclarationNameInfoENS3_14SourceLocationEEEEb")
  //</editor-fold>
  public boolean hasDirective(final /*const*/OpenMPDirectiveKindDeclarationNameInfoSourceLocation2Bool /*&*/ DPred, 
              boolean FromParent) {  
    // We look only in the enclosing region.
    if ($less_uint(Stack.size(), 2)) {
      return false;
    }
    reverse_iterator<SharingMapTy> StartI = std.next(Stack.rbegin());
    reverse_iterator<SharingMapTy> EndI = std.prev(Stack.rend());
    if (FromParent && $noteq_reverse_iterator$C(StartI, EndI)) {
      StartI.$assign(std.next(new reverse_iterator<SharingMapTy>(StartI)));
    }
    for (reverse_iterator<SharingMapTy> I = new reverse_iterator<SharingMapTy>(StartI), EE = new reverse_iterator<SharingMapTy>(EndI); $noteq_reverse_iterator$C(I, EE); I.$preInc()) {
      if (DPred.$call(I.$arrow().Directive, I.$arrow().DirectiveName, /*NO_COPY*/I.$arrow().ConstructLoc)) {
        return true;
      }
    }
    return false;
  }

  
  /// \brief Returns currently analyzed directive.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getCurrentDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 226,
   FQN="(anonymous namespace)::DSAStackTy::getCurrentDirective", NM="_ZNK12_GLOBAL__N_110DSAStackTy19getCurrentDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy19getCurrentDirectiveEv")
  //</editor-fold>
  public OpenMPDirectiveKind getCurrentDirective() /*const*/ {
    return Stack.back$Const().Directive;
  }

  /// \brief Returns parent directive.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getParentDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 230,
   FQN="(anonymous namespace)::DSAStackTy::getParentDirective", NM="_ZNK12_GLOBAL__N_110DSAStackTy18getParentDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy18getParentDirectiveEv")
  //</editor-fold>
  public OpenMPDirectiveKind getParentDirective() /*const*/ {
    if ($greater_uint(Stack.size(), 2)) {
      return Stack.$at$Const(Stack.size() - 2).Directive;
    }
    return OpenMPDirectiveKind.OMPD_unknown;
  }

  
  /// \brief Set default data sharing attribute to none.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::setDefaultDSANone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 237,
   FQN="(anonymous namespace)::DSAStackTy::setDefaultDSANone", NM="_ZN12_GLOBAL__N_110DSAStackTy17setDefaultDSANoneEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy17setDefaultDSANoneEN5clang14SourceLocationE")
  //</editor-fold>
  public void setDefaultDSANone(SourceLocation Loc) {
    Stack.back().DefaultAttr = DefaultDataSharingAttributes.DSA_none;
    Stack.back().DefaultAttrLoc.$assign(Loc);
  }

  /// \brief Set default data sharing attribute to shared.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::setDefaultDSAShared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 242,
   FQN="(anonymous namespace)::DSAStackTy::setDefaultDSAShared", NM="_ZN12_GLOBAL__N_110DSAStackTy19setDefaultDSASharedEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy19setDefaultDSASharedEN5clang14SourceLocationE")
  //</editor-fold>
  public void setDefaultDSAShared(SourceLocation Loc) {
    Stack.back().DefaultAttr = DefaultDataSharingAttributes.DSA_shared;
    Stack.back().DefaultAttrLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getDefaultDSA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 247,
   FQN="(anonymous namespace)::DSAStackTy::getDefaultDSA", NM="_ZNK12_GLOBAL__N_110DSAStackTy13getDefaultDSAEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy13getDefaultDSAEv")
  //</editor-fold>
  public /*DefaultDataSharingAttributes*//*uint*/int getDefaultDSA() /*const*/ {
    return Stack.back$Const().DefaultAttr;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getDefaultDSALocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 250,
   FQN="(anonymous namespace)::DSAStackTy::getDefaultDSALocation", NM="_ZNK12_GLOBAL__N_110DSAStackTy21getDefaultDSALocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy21getDefaultDSALocationEv")
  //</editor-fold>
  public SourceLocation getDefaultDSALocation() /*const*/ {
    return new SourceLocation(Stack.back$Const().DefaultAttrLoc);
  }

  
  /// \brief Checks if the specified variable is a threadprivate.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::isThreadPrivate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 255,
   FQN="(anonymous namespace)::DSAStackTy::isThreadPrivate", NM="_ZN12_GLOBAL__N_110DSAStackTy15isThreadPrivateEPN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy15isThreadPrivateEPN5clang7VarDeclE")
  //</editor-fold>
  public boolean isThreadPrivate(VarDecl /*P*/ D) {
    DSAVarData DVar = getTopDSA(D, false);
    return isOpenMPThreadPrivate(DVar.CKind);
  }

  
  /// \brief Marks current region as ordered (it has an 'ordered' clause).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::setOrderedRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 261,
   FQN="(anonymous namespace)::DSAStackTy::setOrderedRegion", NM="_ZN12_GLOBAL__N_110DSAStackTy16setOrderedRegionEbPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy16setOrderedRegionEbPN5clang4ExprE")
  //</editor-fold>
  public void setOrderedRegion(boolean IsOrdered, Expr /*P*/ Param) {
    Stack.back().OrderedRegion.setInt(IsOrdered);
    Stack.back().OrderedRegion.setPointer(Param);
  }

  /// \brief Returns true, if parent region is ordered (has associated
  /// 'ordered' clause), false - otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::isParentOrderedRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 267,
   FQN="(anonymous namespace)::DSAStackTy::isParentOrderedRegion", NM="_ZNK12_GLOBAL__N_110DSAStackTy21isParentOrderedRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy21isParentOrderedRegionEv")
  //</editor-fold>
  public boolean isParentOrderedRegion() /*const*/ {
    if ($greater_uint(Stack.size(), 2)) {
      return Stack.$at$Const(Stack.size() - 2).OrderedRegion.getInt();
    }
    return false;
  }

  /// \brief Returns optional parameter for the ordered region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getParentOrderedRegionParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 273,
   FQN="(anonymous namespace)::DSAStackTy::getParentOrderedRegionParam", NM="_ZNK12_GLOBAL__N_110DSAStackTy27getParentOrderedRegionParamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy27getParentOrderedRegionParamEv")
  //</editor-fold>
  public Expr /*P*/ getParentOrderedRegionParam() /*const*/ {
    if ($greater_uint(Stack.size(), 2)) {
      return Stack.$at$Const(Stack.size() - 2).OrderedRegion.getPointer();
    }
    return null;
  }

  /// \brief Marks current region as nowait (it has a 'nowait' clause).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::setNowaitRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 279,
   FQN="(anonymous namespace)::DSAStackTy::setNowaitRegion", NM="_ZN12_GLOBAL__N_110DSAStackTy15setNowaitRegionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy15setNowaitRegionEb")
  //</editor-fold>
  public void setNowaitRegion() {
    setNowaitRegion(true);
  }
  public void setNowaitRegion(boolean IsNowait/*= true*/) {
    Stack.back().NowaitRegion = IsNowait;
  }

  /// \brief Returns true, if parent region is nowait (has associated
  /// 'nowait' clause), false - otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::isParentNowaitRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 284,
   FQN="(anonymous namespace)::DSAStackTy::isParentNowaitRegion", NM="_ZNK12_GLOBAL__N_110DSAStackTy20isParentNowaitRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy20isParentNowaitRegionEv")
  //</editor-fold>
  public boolean isParentNowaitRegion() /*const*/ {
    if ($greater_uint(Stack.size(), 2)) {
      return Stack.$at$Const(Stack.size() - 2).NowaitRegion;
    }
    return false;
  }

  /// \brief Marks parent region as cancel region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::setParentCancelRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 290,
   FQN="(anonymous namespace)::DSAStackTy::setParentCancelRegion", NM="_ZN12_GLOBAL__N_110DSAStackTy21setParentCancelRegionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy21setParentCancelRegionEb")
  //</editor-fold>
  public void setParentCancelRegion() {
    setParentCancelRegion(true);
  }
  public void setParentCancelRegion(boolean Cancel/*= true*/) {
    if ($greater_uint(Stack.size(), 2)) {
      Stack.$at(Stack.size() - 2).CancelRegion
         = Stack.$at(Stack.size() - 2).CancelRegion || Cancel;
    }
  }

  /// \brief Return true if current region has inner cancel construct.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::isCancelRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 296,
   FQN="(anonymous namespace)::DSAStackTy::isCancelRegion", NM="_ZNK12_GLOBAL__N_110DSAStackTy14isCancelRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy14isCancelRegionEv")
  //</editor-fold>
  public boolean isCancelRegion() /*const*/ {
    return Stack.back$Const().CancelRegion;
  }

  
  /// \brief Set collapse value for the region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::setAssociatedLoops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 301,
   FQN="(anonymous namespace)::DSAStackTy::setAssociatedLoops", NM="_ZN12_GLOBAL__N_110DSAStackTy18setAssociatedLoopsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy18setAssociatedLoopsEj")
  //</editor-fold>
  public void setAssociatedLoops(/*uint*/int Val) {
    Stack.back().AssociatedLoops = Val;
  }

  /// \brief Return collapse value for region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getAssociatedLoops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 303,
   FQN="(anonymous namespace)::DSAStackTy::getAssociatedLoops", NM="_ZNK12_GLOBAL__N_110DSAStackTy18getAssociatedLoopsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy18getAssociatedLoopsEv")
  //</editor-fold>
  public /*uint*/int getAssociatedLoops() /*const*/ {
    return Stack.back$Const().AssociatedLoops;
  }

  
  /// \brief Marks current target region as one with closely nested teams
  /// region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::setParentTeamsRegionLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 307,
   FQN="(anonymous namespace)::DSAStackTy::setParentTeamsRegionLoc", NM="_ZN12_GLOBAL__N_110DSAStackTy23setParentTeamsRegionLocEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy23setParentTeamsRegionLocEN5clang14SourceLocationE")
  //</editor-fold>
  public void setParentTeamsRegionLoc(SourceLocation TeamsRegionLoc) {
    if ($greater_uint(Stack.size(), 2)) {
      Stack.$at(Stack.size() - 2).InnerTeamsRegionLoc.$assign(TeamsRegionLoc);
    }
  }

  /// \brief Returns true, if current region has closely nested teams region.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::hasInnerTeamsRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 312,
   FQN="(anonymous namespace)::DSAStackTy::hasInnerTeamsRegion", NM="_ZNK12_GLOBAL__N_110DSAStackTy19hasInnerTeamsRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy19hasInnerTeamsRegionEv")
  //</editor-fold>
  public boolean hasInnerTeamsRegion() /*const*/ {
    return getInnerTeamsRegionLoc().isValid();
  }

  /// \brief Returns location of the nested teams region (if any).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getInnerTeamsRegionLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 316,
   FQN="(anonymous namespace)::DSAStackTy::getInnerTeamsRegionLoc", NM="_ZNK12_GLOBAL__N_110DSAStackTy22getInnerTeamsRegionLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy22getInnerTeamsRegionLocEv")
  //</editor-fold>
  public SourceLocation getInnerTeamsRegionLoc() /*const*/ {
    if ($greater_uint(Stack.size(), 1)) {
      return new SourceLocation(Stack.back$Const().InnerTeamsRegionLoc);
    }
    return new SourceLocation();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getCurScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 322,
   FQN="(anonymous namespace)::DSAStackTy::getCurScope", NM="_ZNK12_GLOBAL__N_110DSAStackTy11getCurScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy11getCurScopeEv")
  //</editor-fold>
  public Scope /*P*/ getCurScope$Const() /*const*/ {
    return Stack.back$Const().CurScope;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getCurScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 323,
   FQN="(anonymous namespace)::DSAStackTy::getCurScope", NM="_ZN12_GLOBAL__N_110DSAStackTy11getCurScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy11getCurScopeEv")
  //</editor-fold>
  public Scope /*P*/ getCurScope() {
    return Stack.back().CurScope;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getConstructLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 324,
   FQN="(anonymous namespace)::DSAStackTy::getConstructLoc", NM="_ZN12_GLOBAL__N_110DSAStackTy15getConstructLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy15getConstructLocEv")
  //</editor-fold>
  public SourceLocation getConstructLoc() {
    return new SourceLocation(Stack.back().ConstructLoc);
  }

  
  // Do the check specified in \a Check to all component lists and return true
  // if any issue is found.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::checkMappableExprComponentListsForDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 328,
   FQN="(anonymous namespace)::DSAStackTy::checkMappableExprComponentListsForDecl", NM="_ZN12_GLOBAL__N_110DSAStackTy38checkMappableExprComponentListsForDeclEPN5clang9ValueDeclEbRKN4llvm12function_refIFbNS4_8ArrayRefINS1_27OMPClauseMappableExprCommon17MappableComponentEEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy38checkMappableExprComponentListsForDeclEPN5clang9ValueDeclEbRKN4llvm12function_refIFbNS4_8ArrayRefINS1_27OMPClauseMappableExprCommon17MappableComponentEEEEEE")
  //</editor-fold>
public boolean checkMappableExprComponentListsForDecl(ValueDecl /*P*/ VD, boolean CurrentRegionOnly, 
                                      final /*const*/BoolPredicate<ArrayRef<MappableComponent>> /*&*/ Check) {
    reverse_iterator<SharingMapTy> SI = Stack.rbegin();
    reverse_iterator<SharingMapTy> SE = Stack.rend();
    if ($eq_reverse_iterator$C(SI, SE)) {
      return false;
    }
    if (CurrentRegionOnly) {
      SE.$assign(std.next(new reverse_iterator<SharingMapTy>(SI)));
    } else {
      SI.$preInc();
    }
    
    for (; $noteq_reverse_iterator$C(SI, SE); SI.$preInc()) {
      DenseMapIterator<ValueDecl /*P*/ , SmallVector<SmallVector<MappableComponent>>> MI = SI.$arrow().MappedExprComponents.find(VD);
      if (MI.$noteq(/*NO_ITER_COPY*/SI.$arrow().MappedExprComponents.end())) {
        for (final SmallVector<MappableComponent> /*&*/ L : MI.$arrow().second)  {
          if (Check.$call(new ArrayRef<MappableComponent>(L, false))) {
            return true;
          }
        }
      }
    }
    return false;
  }

  
  // Create a new mappable expression component list associated with a given
  // declaration and initialize it with the provided list of components.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::addMappableExpressionComponents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 356,
   FQN="(anonymous namespace)::DSAStackTy::addMappableExpressionComponents", NM="_ZN12_GLOBAL__N_110DSAStackTy31addMappableExpressionComponentsEPN5clang9ValueDeclEN4llvm8ArrayRefINS1_27OMPClauseMappableExprCommon17MappableComponentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy31addMappableExpressionComponentsEPN5clang9ValueDeclEN4llvm8ArrayRefINS1_27OMPClauseMappableExprCommon17MappableComponentEEE")
  //</editor-fold>
  public void addMappableExpressionComponents(ValueDecl /*P*/ VD, 
                                 ArrayRef<MappableComponent> Components) {
    assert ($greater_uint(Stack.size(), 1)) : "Not expecting to retrieve components from a empty stack!";
    final SmallVector<SmallVector<MappableComponent>> /*&*/ MEC = Stack.back().MappedExprComponents.$at_T1$C$R(VD);
    // Create new entry and append the new components there.
    MEC.resize(MEC.size() + 1);
    MEC.back().append_T(Components.begin(), Components.end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getNestingLevel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 367,
   FQN="(anonymous namespace)::DSAStackTy::getNestingLevel", NM="_ZNK12_GLOBAL__N_110DSAStackTy15getNestingLevelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy15getNestingLevelEv")
  //</editor-fold>
  public /*uint*/int getNestingLevel() /*const*/ {
    assert ($greater_uint(Stack.size(), 1));
    return Stack.size() - 2;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::addDoacrossDependClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 371,
   FQN="(anonymous namespace)::DSAStackTy::addDoacrossDependClause", NM="_ZN12_GLOBAL__N_110DSAStackTy23addDoacrossDependClauseEPN5clang15OMPDependClauseERN4llvm11SmallVectorISt4pairIPNS1_4ExprENS1_22OverloadedOperatorKindEELj4EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTy23addDoacrossDependClauseEPN5clang15OMPDependClauseERN4llvm11SmallVectorISt4pairIPNS1_4ExprENS1_22OverloadedOperatorKindEELj4EEE")
  //</editor-fold>
  public void addDoacrossDependClause(OMPDependClause /*P*/ C, final SmallVector<std.pair<Expr /*P*/ , OverloadedOperatorKind>> /*&*/ OpsOffs) {
    assert ($greater_uint(Stack.size(), 2));
    assert (isOpenMPWorksharingDirective(Stack.$at(Stack.size() - 2).Directive));
    Stack.$at(Stack.size() - 2).DoacrossDepends.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType<OMPDependClause /*P*/ , SmallVector<pair<Expr /*P*/ , OverloadedOperatorKind>> >(JD$T$RR_T1$RR.INSTANCE, C, OpsOffs)/* }*/);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::getDoacrossDependClauses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 376,
   FQN="(anonymous namespace)::DSAStackTy::getDoacrossDependClauses", NM="_ZNK12_GLOBAL__N_110DSAStackTy24getDoacrossDependClausesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_110DSAStackTy24getDoacrossDependClausesEv")
  //</editor-fold>
  public iterator_range</*constconst*/std.pair<OMPDependClause /*P*/ , SmallVector<pair<Expr /*P*/ , OverloadedOperatorKind>>> /*&*/> getDoacrossDependClauses() /*const*/ {
    assert ($greater_uint(Stack.size(), 1));
    if (isOpenMPWorksharingDirective(Stack.$at$Const(Stack.size() - 1).Directive)) {
      final /*const*/ DenseMap<OMPDependClause /*P*/ , SmallVector<std.pair<Expr /*P*/ , OverloadedOperatorKind>>> /*&*/ Ref = Stack.$at$Const(Stack.size() - 1).DoacrossDepends;
      return llvm.make_range(Ref.begin$Const(), Ref.end$Const());
    }
    return llvm.make_range(Stack.$at$Const(0).DoacrossDepends.end$Const(), 
        Stack.$at$Const(0).DoacrossDepends.end$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAStackTy::~DSAStackTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 50,
   FQN="(anonymous namespace)::DSAStackTy::~DSAStackTy", NM="_ZN12_GLOBAL__N_110DSAStackTyD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_110DSAStackTyD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Criticals.$destroy();
    Stack.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Stack=" + Stack // NOI18N
              + ", ClauseKindMode=" + ClauseKindMode // NOI18N
              + ", SemaRef=" + "[Sema]" // NOI18N
              + ", ForceCapturing=" + ForceCapturing // NOI18N
              + ", Criticals=" + Criticals; // NOI18N
  }
}
