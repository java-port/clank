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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 389,
 FQN="clang::ento::SymbolManager", NM="_ZN5clang4ento13SymbolManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManagerE")
//</editor-fold>
public class SymbolManager implements Destructors.ClassWithDestructor {
  /*typedef llvm::FoldingSet<SymExpr> DataSetTy*/
//  public final class DataSetTy extends FoldingSet<SymExpr>{ };
  /*typedef llvm::DenseMap<SymbolRef, SymbolRefSmallVectorTy *> SymbolDependTy*/
//  public final class SymbolDependTy extends DenseMap</*const*/ SymExpr /*P*/ , SmallVector</*const*/ SymExpr /*P*/ > /*P*/>{ };
  
  private FoldingSet<SymExpr> DataSet;
  /// Stores the extra dependencies between symbols: the data should be kept
  /// alive as long as the key is live.
  private DenseMap</*const*/ SymExpr /*P*/ , SmallVector</*const*/ SymExpr /*P*/ > /*P*/> SymbolDependencies;
  private /*uint*/int SymbolCounter;
  private final BumpPtrAllocatorImpl /*&*/ BPAlloc;
  private final BasicValueFactory /*&*/ BV;
  private final ASTContext /*&*/ Ctx;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::SymbolManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 403,
   FQN="clang::ento::SymbolManager::SymbolManager", NM="_ZN5clang4ento13SymbolManagerC1ERNS_10ASTContextERNS0_17BasicValueFactoryERN4llvm20BumpPtrAllocatorImplINS6_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManagerC1ERNS_10ASTContextERNS0_17BasicValueFactoryERN4llvm20BumpPtrAllocatorImplINS6_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public SymbolManager(final ASTContext /*&*/ ctx, final BasicValueFactory /*&*/ bv, 
      final BumpPtrAllocatorImpl /*&*/ bpalloc) {
    // : DataSet(), SymbolDependencies(16), SymbolCounter(0), BPAlloc(bpalloc), BV(bv), Ctx(ctx) 
    //START JInit
    this.DataSet = new FoldingSet<SymExpr>(SymExpr.$Trait());
    this.SymbolDependencies = new DenseMap</*const*/ SymExpr /*P*/ , SmallVector</*const*/ SymExpr /*P*/ > /*P*/>(DenseMapInfo$LikePtr.$Info(), 16, (SmallVector</*const*/ SymExpr /*P*/ > /*P*/)null);
    this.SymbolCounter = 0;
    this./*&*/BPAlloc=/*&*/bpalloc;
    this./*&*/BV=/*&*/bv;
    this./*&*/Ctx=/*&*/ctx;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::~SymbolManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 328,
   FQN="clang::ento::SymbolManager::~SymbolManager", NM="_ZN5clang4ento13SymbolManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManagerD0Ev")
  //</editor-fold>
  public void $destroy() {
    llvm.DeleteContainerSeconds(SymbolDependencies);
    //START JDestroy
    SymbolDependencies.$destroy();
    DataSet.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::canSymbolicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 332,
   FQN="clang::ento::SymbolManager::canSymbolicate", NM="_ZN5clang4ento13SymbolManager14canSymbolicateENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager14canSymbolicateENS_8QualTypeE")
  //</editor-fold>
  public static boolean canSymbolicate(QualType T) {
    T.$assignMove(T.getCanonicalType());
    if (Loc.isLocType(new QualType(T))) {
      return true;
    }
    if (T.$arrow().isIntegralOrEnumerationType()) {
      return true;
    }
    if (T.$arrow().isRecordType() && !T.$arrow().isUnionType()) {
      return true;
    }
    
    return false;
  }

  
  /// \brief Make a unique symbol for MemRegion R according to its kind.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::getRegionValueSymbol">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 150,
   FQN="clang::ento::SymbolManager::getRegionValueSymbol", NM="_ZN5clang4ento13SymbolManager20getRegionValueSymbolEPKNS0_16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager20getRegionValueSymbolEPKNS0_16TypedValueRegionE")
  //</editor-fold>
  public /*const*/ SymbolRegionValue /*P*/ getRegionValueSymbol(/*const*/ TypedValueRegion /*P*/ R) {
    FoldingSetNodeID profile/*J*/= new FoldingSetNodeID();
    SymbolRegionValue.Profile(profile, R);
    final type$ref<type$ptr<SymExpr /*P*/>/*void P*/ > InsertPos = create_type$ref();
    SymExpr /*P*/ SD = DataSet.FindNodeOrInsertPos(profile, InsertPos);
    if (!(SD != null)) {
      SD = (SymExpr /*P*/ )BPAlloc.<SymbolRegionValue>Allocate$T(SymbolRegionValue.class);
      /*NEW_EXPR [System]*/SD = /*new (SD)*/ $new_uint_voidPtr(SD, (type$ptr<?> New$Mem)->{
          return new SymbolRegionValue(SymbolCounter, R);
       });
      DataSet.InsertNode(SD, InsertPos.$deref());
      ++SymbolCounter;
    }
    
    return cast_SymbolRegionValue(SD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::conjureSymbol">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 166,
   FQN="clang::ento::SymbolManager::conjureSymbol", NM="_ZN5clang4ento13SymbolManager13conjureSymbolEPKNS_4StmtEPKNS_15LocationContextENS_8QualTypeEjPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager13conjureSymbolEPKNS_4StmtEPKNS_15LocationContextENS_8QualTypeEjPKv")
  //</editor-fold>
  public /*const*/ SymbolConjured /*P*/ conjureSymbol(/*const*/ Stmt /*P*/ E, 
               /*const*/ LocationContext /*P*/ LCtx, 
               QualType T, 
               /*uint*/int Count) {
    return conjureSymbol(E, 
               LCtx, 
               T, 
               Count, 
               (/*const*/Object/*void P*/ )null);
  }
  public /*const*/ SymbolConjured /*P*/ conjureSymbol(/*const*/ Stmt /*P*/ E, 
               /*const*/ LocationContext /*P*/ LCtx, 
               QualType T, 
               /*uint*/int Count, 
               /*const*/Object/*void P*/ SymbolTag/*= null*/) {
    FoldingSetNodeID profile/*J*/= new FoldingSetNodeID();
    SymbolConjured.Profile(profile, E, /*NO_COPY*/T, Count, LCtx, SymbolTag);
    final type$ref<type$ptr<SymExpr /*P*/>/*void P*/ > InsertPos = create_type$ref();
    SymExpr /*P*/ SD = DataSet.FindNodeOrInsertPos(profile, InsertPos);
    if (!(SD != null)) {
      SD = (SymExpr /*P*/ )BPAlloc.<SymbolConjured>Allocate$T(SymbolConjured.class);
      /*NEW_EXPR [System]*/SD = /*new (SD)*/ $new_uint_voidPtr(SD, (type$ptr<?> New$Mem)->{
          return new SymbolConjured(SymbolCounter, E, LCtx, new QualType(T), Count, SymbolTag);
       });
      DataSet.InsertNode(SD, InsertPos.$deref());
      ++SymbolCounter;
    }
    
    return cast_SymbolConjured(SD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::conjureSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 421,
   FQN="clang::ento::SymbolManager::conjureSymbol", NM="_ZN5clang4ento13SymbolManager13conjureSymbolEPKNS_4ExprEPKNS_15LocationContextEjPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager13conjureSymbolEPKNS_4ExprEPKNS_15LocationContextEjPKv")
  //</editor-fold>
  public /*const*/ SymbolConjured /*P*/ conjureSymbol(/*const*/ Expr /*P*/ E, 
               /*const*/ LocationContext /*P*/ LCtx, 
               /*uint*/int VisitCount) {
    return conjureSymbol(E, 
               LCtx, 
               VisitCount, 
               (/*const*/Object/*void P*/ )null);
  }
  public /*const*/ SymbolConjured /*P*/ conjureSymbol(/*const*/ Expr /*P*/ E, 
               /*const*/ LocationContext /*P*/ LCtx, 
               /*uint*/int VisitCount, 
               /*const*/Object/*void P*/ SymbolTag/*= null*/) {
    return conjureSymbol(E, LCtx, E.getType(), VisitCount, SymbolTag);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::getDerivedSymbol">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 185,
   FQN="clang::ento::SymbolManager::getDerivedSymbol", NM="_ZN5clang4ento13SymbolManager16getDerivedSymbolEPKNS0_7SymExprEPKNS0_16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager16getDerivedSymbolEPKNS0_7SymExprEPKNS0_16TypedValueRegionE")
  //</editor-fold>
  public /*const*/ SymbolDerived /*P*/ getDerivedSymbol(/*const*/ SymExpr /*P*/ parentSymbol, 
                  /*const*/ TypedValueRegion /*P*/ R) {
    
    FoldingSetNodeID profile/*J*/= new FoldingSetNodeID();
    SymbolDerived.Profile(profile, parentSymbol, R);
    final type$ref<type$ptr<SymExpr /*P*/>/*void P*/ > InsertPos = create_type$ref();
    SymExpr /*P*/ SD = DataSet.FindNodeOrInsertPos(profile, InsertPos);
    if (!(SD != null)) {
      SD = (SymExpr /*P*/ )BPAlloc.<SymbolDerived>Allocate$T(SymbolDerived.class);
      /*NEW_EXPR [System]*/SD = /*new (SD)*/ $new_uint_voidPtr(SD, (type$ptr<?> New$Mem)->{
          return new SymbolDerived(SymbolCounter, parentSymbol, R);
       });
      DataSet.InsertNode(SD, InsertPos.$deref());
      ++SymbolCounter;
    }
    
    return cast_SymbolDerived(SD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::getExtentSymbol">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 203,
   FQN="clang::ento::SymbolManager::getExtentSymbol", NM="_ZN5clang4ento13SymbolManager15getExtentSymbolEPKNS0_9SubRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager15getExtentSymbolEPKNS0_9SubRegionE")
  //</editor-fold>
  public /*const*/ SymbolExtent /*P*/ getExtentSymbol(/*const*/ SubRegion /*P*/ R) {
    FoldingSetNodeID profile/*J*/= new FoldingSetNodeID();
    SymbolExtent.Profile(profile, R);
    final type$ref<type$ptr<SymExpr /*P*/>/*void P*/ > InsertPos = create_type$ref();
    SymExpr /*P*/ SD = DataSet.FindNodeOrInsertPos(profile, InsertPos);
    if (!(SD != null)) {
      SD = (SymExpr /*P*/ )BPAlloc.<SymbolExtent>Allocate$T(SymbolExtent.class);
      /*NEW_EXPR [System]*/SD = /*new (SD)*/ $new_uint_voidPtr(SD, (type$ptr<?> New$Mem)->{
          return new SymbolExtent(SymbolCounter, R);
       });
      DataSet.InsertNode(SD, InsertPos.$deref());
      ++SymbolCounter;
    }
    
    return cast_SymbolExtent(SD);
  }

  
  /// \brief Creates a metadata symbol associated with a specific region.
  ///
  /// VisitCount can be used to differentiate regions corresponding to
  /// different loop iterations, thus, making the symbol path-dependent.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::getMetadataSymbol">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 219,
   FQN="clang::ento::SymbolManager::getMetadataSymbol", NM="_ZN5clang4ento13SymbolManager17getMetadataSymbolEPKNS0_9MemRegionEPKNS_4StmtENS_8QualTypeEjPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager17getMetadataSymbolEPKNS0_9MemRegionEPKNS_4StmtENS_8QualTypeEjPKv")
  //</editor-fold>
  public /*const*/ SymbolMetadata /*P*/ getMetadataSymbol(/*const*/ MemRegion /*P*/ R, /*const*/ Stmt /*P*/ S, QualType T, 
                   /*uint*/int Count) {
    return getMetadataSymbol(R, S, T, 
                   Count, (/*const*/Object/*void P*/ )null);
  }
  public /*const*/ SymbolMetadata /*P*/ getMetadataSymbol(/*const*/ MemRegion /*P*/ R, /*const*/ Stmt /*P*/ S, QualType T, 
                   /*uint*/int Count, /*const*/Object/*void P*/ SymbolTag/*= null*/) {
    
    FoldingSetNodeID profile/*J*/= new FoldingSetNodeID();
    SymbolMetadata.Profile(profile, R, S, /*NO_COPY*/T, Count, SymbolTag);
    final type$ref<type$ptr<SymExpr /*P*/>/*void P*/ > InsertPos = create_type$ref();
    SymExpr /*P*/ SD = DataSet.FindNodeOrInsertPos(profile, InsertPos);
    if (!(SD != null)) {
      SD = (SymExpr /*P*/ )BPAlloc.<SymbolMetadata>Allocate$T(SymbolMetadata.class);
      /*NEW_EXPR [System]*/SD = /*new (SD)*/ $new_uint_voidPtr(SD, (type$ptr<?> New$Mem)->{
          return new SymbolMetadata(SymbolCounter, R, S, new QualType(T), Count, SymbolTag);
       });
      DataSet.InsertNode(SD, InsertPos.$deref());
      ++SymbolCounter;
    }
    
    return cast_SymbolMetadata(SD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::getCastSymbol">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 237,
   FQN="clang::ento::SymbolManager::getCastSymbol", NM="_ZN5clang4ento13SymbolManager13getCastSymbolEPKNS0_7SymExprENS_8QualTypeES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager13getCastSymbolEPKNS0_7SymExprENS_8QualTypeES5_")
  //</editor-fold>
  public /*const*/ SymbolCast /*P*/ getCastSymbol(/*const*/ SymExpr /*P*/ Op, 
               QualType From, QualType To) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    SymbolCast.Profile(ID, Op, /*NO_COPY*/From, /*NO_COPY*/To);
    final type$ref<type$ptr<SymExpr /*P*/>/*void P*/ > InsertPos = create_type$ref();
    SymExpr /*P*/ data = DataSet.FindNodeOrInsertPos(ID, InsertPos);
    if (!(data != null)) {
      data = (SymbolCast /*P*/ )BPAlloc.<SymbolCast>Allocate$T(SymbolCast.class);
      /*NEW_EXPR [System]*/data = /*new (data)*/ $new_uint_voidPtr(data, (type$ptr<?> New$Mem)->{
          return new SymbolCast(Op, new QualType(From), new QualType(To));
       });
      DataSet.InsertNode(data, InsertPos.$deref());
    }
    
    return cast_SymbolCast(data);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::getSymIntExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 253,
   FQN="clang::ento::SymbolManager::getSymIntExpr", NM="_ZN5clang4ento13SymbolManager13getSymIntExprEPKNS0_7SymExprENS_18BinaryOperatorKindERKN4llvm6APSIntENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager13getSymIntExprEPKNS0_7SymExprENS_18BinaryOperatorKindERKN4llvm6APSIntENS_8QualTypeE")
  //</editor-fold>
  public /*const*/ SymIntExpr /*P*/ getSymIntExpr_SymExpr$C$P_BinaryOperatorKind_APSInt$C_QualType(/*const*/ SymExpr /*P*/ lhs, 
                                                                BinaryOperatorKind op, 
                                                                final /*const*/ APSInt /*&*/ v, 
                                                                QualType t) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    SymIntExpr.Profile(ID, lhs, op, v, /*NO_COPY*/t);
    final type$ref<type$ptr<SymExpr /*P*/>/*void P*/ > InsertPos = create_type$ref();
    SymExpr /*P*/ data = DataSet.FindNodeOrInsertPos(ID, InsertPos);
    if (!(data != null)) {
      data = (SymIntExpr /*P*/ )BPAlloc.<SymIntExpr>Allocate$T(SymIntExpr.class);
      /*NEW_EXPR [System]*/data = /*new (data)*/ $new_uint_voidPtr(data, (type$ptr<?> New$Mem)->{
          return new SymIntExpr(lhs, op, v, new QualType(t));
       });
      DataSet.InsertNode(data, InsertPos.$deref());
    }
    
    return cast_SymIntExpr(data);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::getSymIntExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 447,
   FQN="clang::ento::SymbolManager::getSymIntExpr", NM="_ZN5clang4ento13SymbolManager13getSymIntExprERKNS0_7SymExprENS_18BinaryOperatorKindERKN4llvm6APSIntENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager13getSymIntExprERKNS0_7SymExprENS_18BinaryOperatorKindERKN4llvm6APSIntENS_8QualTypeE")
  //</editor-fold>
  public /*const*/ SymIntExpr /*P*/ getSymIntExpr_SymExpr$C_BinaryOperatorKind_APSInt$C_QualType(final /*const*/ SymExpr /*&*/ lhs, BinaryOperatorKind op, 
                                                              final /*const*/ APSInt /*&*/ rhs, QualType t) {
    return getSymIntExpr_SymExpr$C$P_BinaryOperatorKind_APSInt$C_QualType($AddrOf(lhs), op, rhs, new QualType(t));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::getIntSymExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 271,
   FQN="clang::ento::SymbolManager::getIntSymExpr", NM="_ZN5clang4ento13SymbolManager13getIntSymExprERKN4llvm6APSIntENS_18BinaryOperatorKindEPKNS0_7SymExprENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager13getIntSymExprERKN4llvm6APSIntENS_18BinaryOperatorKindEPKNS0_7SymExprENS_8QualTypeE")
  //</editor-fold>
  public /*const*/ IntSymExpr /*P*/ getIntSymExpr(final /*const*/ APSInt /*&*/ lhs, 
               BinaryOperatorKind op, 
               /*const*/ SymExpr /*P*/ rhs, 
               QualType t) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    IntSymExpr.Profile(ID, lhs, op, rhs, /*NO_COPY*/t);
    final type$ref<type$ptr<SymExpr /*P*/>/*void P*/ > InsertPos = create_type$ref();
    SymExpr /*P*/ data = DataSet.FindNodeOrInsertPos(ID, InsertPos);
    if (!(data != null)) {
      data = (IntSymExpr /*P*/ )BPAlloc.<IntSymExpr>Allocate$T(IntSymExpr.class);
      /*NEW_EXPR [System]*/data = /*new (data)*/ $new_uint_voidPtr(data, (type$ptr<?> New$Mem)->{
          return new IntSymExpr(lhs, op, rhs, new QualType(t));
       });
      DataSet.InsertNode(data, InsertPos.$deref());
    }
    
    return cast_IntSymExpr(data);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::getSymSymExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 289,
   FQN="clang::ento::SymbolManager::getSymSymExpr", NM="_ZN5clang4ento13SymbolManager13getSymSymExprEPKNS0_7SymExprENS_18BinaryOperatorKindES4_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager13getSymSymExprEPKNS0_7SymExprENS_18BinaryOperatorKindES4_NS_8QualTypeE")
  //</editor-fold>
  public /*const*/ SymSymExpr /*P*/ getSymSymExpr(/*const*/ SymExpr /*P*/ lhs, 
               BinaryOperatorKind op, 
               /*const*/ SymExpr /*P*/ rhs, 
               QualType t) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    SymSymExpr.Profile(ID, lhs, op, rhs, /*NO_COPY*/t);
    final type$ref<type$ptr<SymExpr /*P*/>/*void P*/ > InsertPos = create_type$ref();
    SymExpr /*P*/ data = DataSet.FindNodeOrInsertPos(ID, InsertPos);
    if (!(data != null)) {
      data = (SymSymExpr /*P*/ )BPAlloc.<SymSymExpr>Allocate$T(SymSymExpr.class);
      /*NEW_EXPR [System]*/data = /*new (data)*/ $new_uint_voidPtr(data, (type$ptr<?> New$Mem)->{
          return new SymSymExpr(lhs, op, rhs, new QualType(t));
       });
      DataSet.InsertNode(data, InsertPos.$deref());
    }
    
    return cast_SymSymExpr(data);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 459,
   FQN="clang::ento::SymbolManager::getType", NM="_ZNK5clang4ento13SymbolManager7getTypeEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento13SymbolManager7getTypeEPKNS0_7SymExprE")
  //</editor-fold>
  public QualType getType(/*const*/ SymExpr /*P*/ SE) /*const*/ {
    return SE.getType();
  }

  
  /// \brief Add artificial symbol dependency.
  ///
  /// The dependent symbol should stay alive as long as the primary is alive.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::addSymbolDependency">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 347,
   FQN="clang::ento::SymbolManager::addSymbolDependency", NM="_ZN5clang4ento13SymbolManager19addSymbolDependencyEPKNS0_7SymExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager19addSymbolDependencyEPKNS0_7SymExprES4_")
  //</editor-fold>
  public void addSymbolDependency(/*const*/ SymExpr /*P*/ /*const*/ Primary, 
                     /*const*/ SymExpr /*P*/ /*const*/ Dependent) {
    DenseMapIterator</*const*/ SymExpr /*P*/ , SmallVector</*const*/ SymExpr /*P*/ > /*P*/> I = SymbolDependencies.find(Primary);
    SmallVector</*const*/ SymExpr /*P*/ > /*P*/ dependencies = null;
    if (I.$eq(/*NO_ITER_COPY*/SymbolDependencies.end())) {
      dependencies = new SmallVector</*const*/ SymExpr /*P*/ >(2, (/*const*/ SymExpr /*P*/ )null);
      SymbolDependencies.$set(Primary, dependencies);
    } else {
      dependencies = I.$arrow().second;
    }
    dependencies.push_back(Dependent);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::getDependentSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 360,
   FQN="clang::ento::SymbolManager::getDependentSymbols", NM="_ZN5clang4ento13SymbolManager19getDependentSymbolsEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager19getDependentSymbolsEPKNS0_7SymExprE")
  //</editor-fold>
  public /*const*/SmallVector</*const*/ SymExpr /*P*/ > /*P*/ getDependentSymbols(/*const*/ SymExpr /*P*/ /*const*/ Primary) {
    DenseMapIterator</*const*/ SymExpr /*P*/ , SmallVector</*const*/ SymExpr /*P*/ > /*P*/> I = new DenseMapIterator</*const*/ SymExpr /*P*/ , SmallVector</*const*/ SymExpr /*P*/ > /*P*/>(SymbolDependencies.find(Primary));
    if (I.$eq(/*NO_ITER_COPY*/SymbolDependencies.end())) {
      return null;
    }
    return I.$arrow().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 470,
   FQN="clang::ento::SymbolManager::getContext", NM="_ZN5clang4ento13SymbolManager10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager10getContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getContext() {
    return Ctx;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolManager::getBasicVals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 471,
   FQN="clang::ento::SymbolManager::getBasicVals", NM="_ZN5clang4ento13SymbolManager12getBasicValsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento13SymbolManager12getBasicValsEv")
  //</editor-fold>
  public BasicValueFactory /*&*/ getBasicVals() {
    return BV;
  }

  
  @Override public String toString() {
    return "" + "DataSet=" + DataSet // NOI18N
              + ", SymbolDependencies=" + SymbolDependencies // NOI18N
              + ", SymbolCounter=" + SymbolCounter // NOI18N
              + ", BPAlloc=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", BV=" + "[BasicValueFactory]" // NOI18N
              + ", Ctx=" + "[ASTContext]"; // NOI18N
  }
}
