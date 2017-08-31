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
import static org.clang.staticanalyzer.core.impl.MemRegionStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//===----------------------------------------------------------------------===//
// MemRegionManager - Factory object for creating regions.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1117,
 FQN="clang::ento::MemRegionManager", NM="_ZN5clang4ento16MemRegionManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManagerE")
//</editor-fold>
public class MemRegionManager implements Destructors.ClassWithDestructor {
  private final ASTContext /*&*/ C;
  private final BumpPtrAllocatorImpl /*&*/ A;
  private FoldingSet<MemRegion> Regions;
  
  private type$ref<GlobalInternalSpaceRegion /*P*/> InternalGlobals;
  private type$ref<GlobalSystemSpaceRegion /*P*/> SystemGlobals;
  private type$ref<GlobalImmutableSpaceRegion /*P*/> ImmutableGlobals;
  
  private DenseMap</*const*/ StackFrameContext /*P*/ , StackLocalsSpaceRegion /*P*/ > StackLocalsSpaceRegions;
  private DenseMap</*const*/ StackFrameContext /*P*/ , StackArgumentsSpaceRegion /*P*/ > StackArgumentsSpaceRegions;
  private DenseMap</*const*/ CodeTextRegion /*P*/ , StaticGlobalSpaceRegion /*P*/ > StaticsGlobalSpaceRegions;
  
  private type$ref<HeapSpaceRegion /*P*/> heap;
  private type$ref<UnknownSpaceRegion /*P*/> unknown;
  private type$ref<CodeSpaceRegion /*P*/> code;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::MemRegionManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1139,
   FQN="clang::ento::MemRegionManager::MemRegionManager", NM="_ZN5clang4ento16MemRegionManagerC1ERNS_10ASTContextERN4llvm20BumpPtrAllocatorImplINS4_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManagerC1ERNS_10ASTContextERN4llvm20BumpPtrAllocatorImplINS4_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public MemRegionManager(final ASTContext /*&*/ c, final BumpPtrAllocatorImpl /*&*/ a) {
    // : C(c), A(a), Regions(), InternalGlobals(null), SystemGlobals(null), ImmutableGlobals(null), StackLocalsSpaceRegions(), StackArgumentsSpaceRegions(), StaticsGlobalSpaceRegions(), heap(null), unknown(null), code(null) 
    //START JInit
    this./*&*/C=/*&*/c;
    this./*&*/A=/*&*/a;
    this.Regions = new FoldingSet<MemRegion>(MemRegion.$Trait());
    this.InternalGlobals = create_type$null$ref();
    this.SystemGlobals = create_type$null$ref();
    this.ImmutableGlobals = create_type$null$ref();
    this.StackLocalsSpaceRegions = new DenseMap</*const*/ StackFrameContext /*P*/ , StackLocalsSpaceRegion /*P*/ >(DenseMapInfo$LikePtr.$Info(), (StackLocalsSpaceRegion /*P*/ )null);
    this.StackArgumentsSpaceRegions = new DenseMap</*const*/ StackFrameContext /*P*/ , StackArgumentsSpaceRegion /*P*/ >(DenseMapInfo$LikePtr.$Info(), (StackArgumentsSpaceRegion /*P*/ )null);
    this.StaticsGlobalSpaceRegions = new DenseMap</*const*/ CodeTextRegion /*P*/ , StaticGlobalSpaceRegion /*P*/ >(DenseMapInfo$LikePtr.$Info(), (StaticGlobalSpaceRegion /*P*/ )null);
    this.heap = create_type$null$ref();
    this.unknown = create_type$null$ref();
    this.code = create_type$null$ref();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::~MemRegionManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 136,
   FQN="clang::ento::MemRegionManager::~MemRegionManager", NM="_ZN5clang4ento16MemRegionManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManagerD0Ev")
  //</editor-fold>
  public void $destroy() {
    // All regions and their data are BumpPtrAllocated.  No need to call
    // their destructors.
    //START JDestroy
    StaticsGlobalSpaceRegions.$destroy();
    StackArgumentsSpaceRegions.$destroy();
    StackLocalsSpaceRegions.$destroy();
    Regions.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1146,
   FQN="clang::ento::MemRegionManager::getContext", NM="_ZN5clang4ento16MemRegionManager10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager10getContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getContext() {
    return C;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1148,
   FQN="clang::ento::MemRegionManager::getAllocator", NM="_ZN5clang4ento16MemRegionManager12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getAllocatorEv")
  //</editor-fold>
  public BumpPtrAllocatorImpl /*&*/ getAllocator() {
    return A;
  }

  
  /// getStackLocalsRegion - Retrieve the memory region associated with the
  ///  specified stack frame.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getStackLocalsRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 718,
   FQN="clang::ento::MemRegionManager::getStackLocalsRegion", NM="_ZN5clang4ento16MemRegionManager20getStackLocalsRegionEPKNS_17StackFrameContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager20getStackLocalsRegionEPKNS_17StackFrameContextE")
  //</editor-fold>
  public /*const*/ StackLocalsSpaceRegion /*P*/ getStackLocalsRegion(/*const*/ StackFrameContext /*P*/ STC) {
    assert Native.$bool(STC);
    final type$ref<StackLocalsSpaceRegion /*P*/ /*&*/> R = StackLocalsSpaceRegions.ref$at(STC);
    if ((R.$deref() != null)) {
      return R.$deref();
    }
    
    R.$set(A.<StackLocalsSpaceRegion>Allocate$T(StackLocalsSpaceRegion.class));
    /*NEW_EXPR [System]*/R.$set(/*new (R)*/ $new_uint_voidPtr(R.$deref(), (type$ptr<?> New$Mem)->{
        return new StackLocalsSpaceRegion(this, STC);
     }));
    return R.$deref();
  }

  
  /// getStackArgumentsRegion - Retrieve the memory region associated with
  ///  function/method arguments of the specified stack frame.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getStackArgumentsRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 731,
   FQN="clang::ento::MemRegionManager::getStackArgumentsRegion", NM="_ZN5clang4ento16MemRegionManager23getStackArgumentsRegionEPKNS_17StackFrameContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager23getStackArgumentsRegionEPKNS_17StackFrameContextE")
  //</editor-fold>
  public /*const*/ StackArgumentsSpaceRegion /*P*/ getStackArgumentsRegion(/*const*/ StackFrameContext /*P*/ STC) {
    assert Native.$bool(STC);
    final type$ref<StackArgumentsSpaceRegion /*P*/ /*&*/> R = StackArgumentsSpaceRegions.ref$at(STC);
    if ((R.$deref() != null)) {
      return R.$deref();
    }
    
    R.$set(A.<StackArgumentsSpaceRegion>Allocate$T(StackArgumentsSpaceRegion.class));
    /*NEW_EXPR [System]*/R.$set( /*new (R)*/ $new_uint_voidPtr(R.$deref(), (type$ptr<?> New$Mem)->{
        return new StackArgumentsSpaceRegion(this, STC);
     }));
    return R.$deref();
  }

  
  /// getGlobalsRegion - Retrieve the memory region associated with
  ///  global variables.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getGlobalsRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 744,
   FQN="clang::ento::MemRegionManager::getGlobalsRegion", NM="_ZN5clang4ento16MemRegionManager16getGlobalsRegionENS0_9MemRegion4KindEPKNS0_14CodeTextRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager16getGlobalsRegionENS0_9MemRegion4KindEPKNS0_14CodeTextRegionE")
  //</editor-fold>
  public /*const*/ GlobalsSpaceRegion /*P*/ getGlobalsRegion() {
    return getGlobalsRegion(MemRegion.Kind.GlobalInternalSpaceRegionKind, 
                  (/*const*/ CodeTextRegion /*P*/ )null);
  }
  public /*const*/ GlobalsSpaceRegion /*P*/ getGlobalsRegion(MemRegion.Kind K/*= MemRegion::GlobalInternalSpaceRegionKind*/) {
    return getGlobalsRegion(K, 
                  (/*const*/ CodeTextRegion /*P*/ )null);
  }
  public /*const*/ GlobalsSpaceRegion /*P*/ getGlobalsRegion(MemRegion.Kind K/*= MemRegion::GlobalInternalSpaceRegionKind*/, 
                  /*const*/ CodeTextRegion /*P*/ CR/*= null*/) {
    if (!(CR != null)) {
      if (K == MemRegion.Kind.GlobalSystemSpaceRegionKind) {
        return LazyAllocate$GlobalSystemSpaceRegion(SystemGlobals);
      }
      if (K == MemRegion.Kind.GlobalImmutableSpaceRegionKind) {
        return LazyAllocate$GlobalImmutableSpaceRegion(ImmutableGlobals);
      }
      assert (K == MemRegion.Kind.GlobalInternalSpaceRegionKind);
      return LazyAllocate$GlobalInternalSpaceRegion(InternalGlobals);
    }
    assert (K == MemRegion.Kind.StaticGlobalSpaceRegionKind);
    final type$ref<StaticGlobalSpaceRegion /*P*/ /*&*/> R = StaticsGlobalSpaceRegions.ref$at(CR);
    if ((R.$deref() != null)) {
      return R.$deref();
    }
    
    R.$set(A.<StaticGlobalSpaceRegion>Allocate$T(StaticGlobalSpaceRegion.class));
    /*NEW_EXPR [System]*/R.$set( /*new (R)*/ $new_uint_voidPtr(R.$deref(), (type$ptr<?> New$Mem)->{
        return new StaticGlobalSpaceRegion(this, CR);
     }));
    return R.$deref();
  }

  
  /// getHeapRegion - Retrieve the memory region associated with the
  ///  generic "heap".
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getHeapRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 766,
   FQN="clang::ento::MemRegionManager::getHeapRegion", NM="_ZN5clang4ento16MemRegionManager13getHeapRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager13getHeapRegionEv")
  //</editor-fold>
  public /*const*/ HeapSpaceRegion /*P*/ getHeapRegion() {
    return LazyAllocate$HeapSpaceRegion(heap);
  }

  
  /// getUnknownRegion - Retrieve the memory region associated with unknown
  /// memory space.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getUnknownRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 770,
   FQN="clang::ento::MemRegionManager::getUnknownRegion", NM="_ZN5clang4ento16MemRegionManager16getUnknownRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager16getUnknownRegionEv")
  //</editor-fold>
  public /*const*/ UnknownSpaceRegion /*P*/ getUnknownRegion() {
    return LazyAllocate$UnknownSpaceRegion(unknown);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getCodeRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 774,
   FQN="clang::ento::MemRegionManager::getCodeRegion", NM="_ZN5clang4ento16MemRegionManager13getCodeRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager13getCodeRegionEv")
  //</editor-fold>
  public /*const*/ CodeSpaceRegion /*P*/ getCodeRegion() {
    return LazyAllocate$CodeSpaceRegion(code);
  }

  
  /// getAllocaRegion - Retrieve a region associated with a call to alloca().
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getAllocaRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1089,
   FQN="clang::ento::MemRegionManager::getAllocaRegion", NM="_ZN5clang4ento16MemRegionManager15getAllocaRegionEPKNS_4ExprEjPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager15getAllocaRegionEPKNS_4ExprEjPKNS_15LocationContextE")
  //</editor-fold>
  public /*const*/ AllocaRegion /*P*/ getAllocaRegion(/*const*/ Expr /*P*/ E, /*uint*/int cnt, 
                 /*const*/ LocationContext /*P*/ LC) {
    /*const*/ StackFrameContext /*P*/ STC = LC.getCurrentStackFrame();
    assert Native.$bool(STC);
    return this.getSubRegion(E, cnt, getStackLocalsRegion(STC));
  }

  
  /// getCompoundLiteralRegion - Retrieve the region associated with a
  ///  given CompoundLiteral.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getCompoundLiteralRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 944,
   FQN="clang::ento::MemRegionManager::getCompoundLiteralRegion", NM="_ZN5clang4ento16MemRegionManager24getCompoundLiteralRegionEPKNS_19CompoundLiteralExprEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager24getCompoundLiteralRegionEPKNS_19CompoundLiteralExprEPKNS_15LocationContextE")
  //</editor-fold>
  public /*const*/ CompoundLiteralRegion /*P*/ getCompoundLiteralRegion(/*const*/ CompoundLiteralExpr /*P*/ CL, 
                          /*const*/ LocationContext /*P*/ LC) {
    /*const*/ MemRegion /*P*/ sReg = null;
    if (CL.isFileScope()) {
      sReg = getGlobalsRegion();
    } else {
      /*const*/ StackFrameContext /*P*/ STC = LC.getCurrentStackFrame();
      assert Native.$bool(STC);
      sReg = getStackLocalsRegion(STC);
    }
    
    return this.getSubRegion$CompoundLiteralRegion(CL, sReg);
  }

  
  /// getCXXThisRegion - Retrieve the [artificial] region associated with the
  ///  parameter 'this'.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getCXXThisRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1067,
   FQN="clang::ento::MemRegionManager::getCXXThisRegion", NM="_ZN5clang4ento16MemRegionManager16getCXXThisRegionENS_8QualTypeEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager16getCXXThisRegionENS_8QualTypeEPKNS_15LocationContextE")
  //</editor-fold>
  public /*const*/ CXXThisRegion /*P*/ getCXXThisRegion(QualType thisPointerTy, 
                  /*const*/ LocationContext /*P*/ LC) {
    /*const*/ PointerType /*P*/ PT = thisPointerTy.$arrow().getAs(PointerType.class);
    assert Native.$bool(PT);
    // Inside the body of the operator() of a lambda a this expr might refer to an
    // object in one of the parent location contexts.
    /*const*/ CXXMethodDecl /*P*/ D = dyn_cast_CXXMethodDecl(LC.getDecl());
    // FIXME: when operator() of lambda is analyzed as a top level function and
    // 'this' refers to a this to the enclosing scope, there is no right region to
    // return.
    while (!LC.inTopFrame()
       && (!(D != null) || D.isStatic()
       || PT != D.getThisType(getContext()).$arrow().getAs(PointerType.class))) {
      LC = LC.getParent();
      D = dyn_cast_CXXMethodDecl(LC.getDecl());
    }
    /*const*/ StackFrameContext /*P*/ STC = LC.getCurrentStackFrame();
    assert Native.$bool(STC);
    return this.getSubRegion$CXXThisRegion(PT, getStackArgumentsRegion(STC));
  }

  
  /// \brief Retrieve or create a "symbolic" memory region.
  
  /// getSymbolicRegion - Retrieve or create a "symbolic" memory region.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getSymbolicRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 995,
   FQN="clang::ento::MemRegionManager::getSymbolicRegion", NM="_ZN5clang4ento16MemRegionManager17getSymbolicRegionEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager17getSymbolicRegionEPKNS0_7SymExprE")
  //</editor-fold>
  public /*const*/ SymbolicRegion /*P*/ getSymbolicRegion(/*const*/ SymExpr /*P*/ sym) {
    return this.getSubRegion$SymbolicRegion(sym, getUnknownRegion());
  }

  
  /// \brief Return a unique symbolic region belonging to heap memory space.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getSymbolicHeapRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 999,
   FQN="clang::ento::MemRegionManager::getSymbolicHeapRegion", NM="_ZN5clang4ento16MemRegionManager21getSymbolicHeapRegionEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager21getSymbolicHeapRegionEPKNS0_7SymExprE")
  //</editor-fold>
  public /*const*/ SymbolicRegion /*P*/ getSymbolicHeapRegion(/*const*/ SymExpr /*P*/ Sym) {
    return this.getSubRegion$SymbolicRegion(Sym, getHeapRegion());
  }

  
  
  //===----------------------------------------------------------------------===//
  // Constructing regions.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getStringRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 781,
   FQN="clang::ento::MemRegionManager::getStringRegion", NM="_ZN5clang4ento16MemRegionManager15getStringRegionEPKNS_13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager15getStringRegionEPKNS_13StringLiteralE")
  //</editor-fold>
  public /*const*/ StringRegion /*P*/ getStringRegion(/*const*/ StringLiteral /*P*/ Str) {
    return this.getSubRegion$StringRegion(Str, getGlobalsRegion());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getObjCStringRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 785,
   FQN="clang::ento::MemRegionManager::getObjCStringRegion", NM="_ZN5clang4ento16MemRegionManager19getObjCStringRegionEPKNS_17ObjCStringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager19getObjCStringRegionEPKNS_17ObjCStringLiteralE")
  //</editor-fold>
  public /*const*/ ObjCStringRegion /*P*/ getObjCStringRegion(/*const*/ ObjCStringLiteral /*P*/ Str) {
    return this.getSubRegion$ObjCStringRegion(Str, getGlobalsRegion());
  }

  
  /// getVarRegion - Retrieve or create the memory region associated with
  ///  a specified VarDecl and LocationContext.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getVarRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 821,
   FQN="clang::ento::MemRegionManager::getVarRegion", NM="_ZN5clang4ento16MemRegionManager12getVarRegionEPKNS_7VarDeclEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getVarRegionEPKNS_7VarDeclEPKNS_15LocationContextE")
  //</editor-fold>
  public /*const*/ VarRegion /*P*/ getVarRegion(/*const*/ VarDecl /*P*/ D, 
              /*const*/ LocationContext /*P*/ LC) {
    /*const*/ MemRegion /*P*/ sReg = null;
    if (D.hasGlobalStorage() && !D.isStaticLocal()) {
      
      // First handle the globals defined in system headers.
      if (C.getSourceManager().isInSystemHeader(D.getLocation())) {
        // Whitelist the system globals which often DO GET modified, assume the
        // rest are immutable.
        if (D.getName().find(/*STRINGREF_STR*/"errno") != StringRef.npos) {
          sReg = getGlobalsRegion(MemRegion.Kind.GlobalSystemSpaceRegionKind);
        } else {
          sReg = getGlobalsRegion(MemRegion.Kind.GlobalImmutableSpaceRegionKind);
        }
        // Treat other globals as GlobalInternal unless they are constants.
      } else {
        QualType GQT = D.getType();
        /*const*/ Type /*P*/ GT = GQT.getTypePtrOrNull();
        // TODO: We could walk the complex types here and see if everything is
        // constified.
        if ((GT != null) && GQT.isConstQualified() && GT.isArithmeticType()) {
          sReg = getGlobalsRegion(MemRegion.Kind.GlobalImmutableSpaceRegionKind);
        } else {
          sReg = getGlobalsRegion();
        }
      }
      // Finally handle static locals.
    } else {
      // FIXME: Once we implement scope handling, we will need to properly lookup
      // 'D' to the proper LocationContext.
      /*const*/ DeclContext /*P*/ DC = D.getDeclContext$Const();
      PointerUnion</*const*/ StackFrameContext /*P*/ , /*const*/ VarRegion /*P*/ > V = getStackOrCaptureRegionForDeclContext(LC, DC, D);
      if ((V.is(/*const*/ VarRegion /*P*/.class) != 0)) {
        return V.get(/*const*/ VarRegion /*P*/.class);
      }
      
      /*const*/ StackFrameContext /*P*/ STC = V.get(/*const*/ StackFrameContext /*P*/.class);
      if (!(STC != null)) {
        sReg = getUnknownRegion();
      } else {
        if (D.hasLocalStorage()) {
          sReg = isa_ParmVarDecl(D) || isa_ImplicitParamDecl(D) ? ((/*static_cast*//*const*/ MemRegion /*P*/ )(getStackArgumentsRegion(STC))) : ((/*static_cast*//*const*/ MemRegion /*P*/ )(getStackLocalsRegion(STC)));
        } else {
          assert (D.isStaticLocal());
          /*const*/ Decl /*P*/ STCD = STC.getDecl();
          if (isa_FunctionDecl(STCD) || isa_ObjCMethodDecl(STCD)) {
            sReg = getGlobalsRegion(MemRegion.Kind.StaticGlobalSpaceRegionKind, 
                getFunctionCodeRegion(cast_NamedDecl(STCD)));
          } else {
            /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(STCD);
            if ((BD != null)) {
              // FIXME: The fallback type here is totally bogus -- though it should
              // never be queried, it will prevent uniquing with the real
              // BlockCodeRegion. Ideally we'd fix the AST so that we always had a
              // signature.
              QualType T/*J*/= new QualType();
              {
                /*const*/ TypeSourceInfo /*P*/ TSI = BD.getSignatureAsWritten();
                if ((TSI != null)) {
                  T.$assignMove(TSI.getType());
                }
              }
              if (T.isNull()) {
                T.$assignMove(getContext().VoidTy.$QualType());
              }
              if (!(T.$arrow().getAs(FunctionType.class) != null)) {
                T.$assignMove(getContext().getFunctionNoProtoType(new QualType(T)));
              }
              T.$assignMove(getContext().getBlockPointerType(new QualType(T)));
              
              /*const*/ BlockCodeRegion /*P*/ BTR = getBlockCodeRegion(BD, C.getCanonicalType(/*NO_COPY*/T), 
                  STC.getAnalysisDeclContext());
              sReg = getGlobalsRegion(MemRegion.Kind.StaticGlobalSpaceRegionKind, 
                  BTR);
            } else {
              sReg = getGlobalsRegion();
            }
          }
        }
      }
    }
    
    return this.getSubRegion$VarRegion(D, sReg);
  }

  
  /// getVarRegion - Retrieve or create the memory region associated with
  ///  a specified VarDecl and super region.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getVarRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 905,
   FQN="clang::ento::MemRegionManager::getVarRegion", NM="_ZN5clang4ento16MemRegionManager12getVarRegionEPKNS_7VarDeclEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getVarRegionEPKNS_7VarDeclEPKNS0_9MemRegionE")
  //</editor-fold>
  public /*const*/ VarRegion /*P*/ getVarRegion(/*const*/ VarDecl /*P*/ D, 
              /*const*/ MemRegion /*P*/ superR) {
    return this.getSubRegion$VarRegion(D, superR);
  }

  
  /// getElementRegion - Retrieve the memory region associated with the
  ///  associated element type, index, and super region.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getElementRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 960,
   FQN="clang::ento::MemRegionManager::getElementRegion", NM="_ZN5clang4ento16MemRegionManager16getElementRegionENS_8QualTypeENS0_6NonLocEPKNS0_9MemRegionERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager16getElementRegionENS_8QualTypeENS0_6NonLocEPKNS0_9MemRegionERNS_10ASTContextE")
  //</editor-fold>
  public /*const*/ ElementRegion /*P*/ getElementRegion(QualType elementType, NonLoc Idx, 
                  /*const*/ MemRegion /*P*/ superRegion, 
                  final ASTContext /*&*/ Ctx) {
    QualType T = Ctx.getCanonicalType(/*NO_COPY*/elementType).getUnqualifiedType().$QualType();
    
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ElementRegion.ProfileRegion(ID, new QualType(T), new SVal(Idx), superRegion);
    
    final type$ref<type$ptr<MemRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    MemRegion /*P*/ data = Regions.FindNodeOrInsertPos(ID, InsertPos);
    ElementRegion /*P*/ R = cast_or_null_ElementRegion(data);
    if (!(R != null)) {
      R = A.<ElementRegion>Allocate$T(ElementRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new ElementRegion(new QualType(T), new NonLoc(Idx), superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }
    
    return R;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getElementRegionWithSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1215,
   FQN="clang::ento::MemRegionManager::getElementRegionWithSuper", NM="_ZN5clang4ento16MemRegionManager25getElementRegionWithSuperEPKNS0_13ElementRegionEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager25getElementRegionWithSuperEPKNS0_13ElementRegionEPKNS0_9MemRegionE")
  //</editor-fold>
  public /*const*/ ElementRegion /*P*/ getElementRegionWithSuper(/*const*/ ElementRegion /*P*/ ER, 
                           /*const*/ MemRegion /*P*/ superRegion) {
    return getElementRegion(ER.getElementType(), ER.getIndex(), 
        superRegion, ER.getContext());
  }

  
  /// getFieldRegion - Retrieve or create the memory region associated with
  ///  a specified FieldDecl.  'superRegion' corresponds to the containing
  ///  memory region (which typically represents the memory representing
  ///  a structure or class).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getFieldRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1003,
   FQN="clang::ento::MemRegionManager::getFieldRegion", NM="_ZN5clang4ento16MemRegionManager14getFieldRegionEPKNS_9FieldDeclEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager14getFieldRegionEPKNS_9FieldDeclEPKNS0_9MemRegionE")
  //</editor-fold>
  public /*const*/ FieldRegion /*P*/ getFieldRegion(/*const*/ FieldDecl /*P*/ d, 
                /*const*/ MemRegion /*P*/ superRegion) {
    return this.getSubRegion$FieldRegion(d, superRegion);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getFieldRegionWithSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1228,
   FQN="clang::ento::MemRegionManager::getFieldRegionWithSuper", NM="_ZN5clang4ento16MemRegionManager23getFieldRegionWithSuperEPKNS0_11FieldRegionEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager23getFieldRegionWithSuperEPKNS0_11FieldRegionEPKNS0_9MemRegionE")
  //</editor-fold>
  public /*const*/ FieldRegion /*P*/ getFieldRegionWithSuper(/*const*/ FieldRegion /*P*/ FR, 
                         /*const*/ MemRegion /*P*/ superRegion) {
    return getFieldRegion(FR.getDecl(), superRegion);
  }

  
  /// getObjCIvarRegion - Retrieve or create the memory region associated with
  ///   a specified Objective-c instance variable.  'superRegion' corresponds
  ///   to the containing region (which typically represents the Objective-C
  ///   object).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getObjCIvarRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1009,
   FQN="clang::ento::MemRegionManager::getObjCIvarRegion", NM="_ZN5clang4ento16MemRegionManager17getObjCIvarRegionEPKNS_12ObjCIvarDeclEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager17getObjCIvarRegionEPKNS_12ObjCIvarDeclEPKNS0_9MemRegionE")
  //</editor-fold>
  public /*const*/ ObjCIvarRegion /*P*/ getObjCIvarRegion(/*const*/ ObjCIvarDecl /*P*/ d, 
                   /*const*/ MemRegion /*P*/ superRegion) {
    return this.getSubRegion$ObjCIvarRegion(d, superRegion);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getCXXTempObjectRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1015,
   FQN="clang::ento::MemRegionManager::getCXXTempObjectRegion", NM="_ZN5clang4ento16MemRegionManager22getCXXTempObjectRegionEPKNS_4ExprEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager22getCXXTempObjectRegionEPKNS_4ExprEPKNS_15LocationContextE")
  //</editor-fold>
  public /*const*/ CXXTempObjectRegion /*P*/ getCXXTempObjectRegion(/*const*/ Expr /*P*/ E, 
                        /*const*/ LocationContext /*P*/ LC) {
    /*const*/ StackFrameContext /*P*/ SFC = LC.getCurrentStackFrame();
    assert Native.$bool(SFC);
    return this.getSubRegion$CXXTempObjectRegion(E, getStackLocalsRegion(SFC));
  }

  
  /// Create a CXXBaseObjectRegion with the given base class for region
  /// \p Super.
  ///
  /// The type of \p Super is assumed be a class deriving from \p BaseClass.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getCXXBaseObjectRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1045,
   FQN="clang::ento::MemRegionManager::getCXXBaseObjectRegion", NM="_ZN5clang4ento16MemRegionManager22getCXXBaseObjectRegionEPKNS_13CXXRecordDeclEPKNS0_9MemRegionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager22getCXXBaseObjectRegionEPKNS_13CXXRecordDeclEPKNS0_9MemRegionEb")
  //</editor-fold>
  public /*const*/ CXXBaseObjectRegion /*P*/ getCXXBaseObjectRegion(/*const*/ CXXRecordDecl /*P*/ RD, 
                        /*const*/ MemRegion /*P*/ Super, 
                        boolean IsVirtual) {
    if (isa_TypedValueRegion(Super)) {
      assert (isValidBaseClass(RD, dyn_cast_TypedValueRegion(Super), IsVirtual));
      ///*J:(void)*//*AddrOf*//*FPtr*/isValidBaseClass;
      if (IsVirtual) {
        {
          // Virtual base regions should not be layered, since the layout rules
          // are different.
          /*const*/ CXXBaseObjectRegion /*P*/ Base;
          while (((/*P*/ Base = dyn_cast_CXXBaseObjectRegion(Super)) != null)) {
            Super = Base.getSuperRegion();
          }
        }
        assert ((Super != null) && !isa_MemSpaceRegion(Super));
      }
    }
    
    return this.getSubRegion(RD, IsVirtual, Super);
  }

  
  /// Create a CXXBaseObjectRegion with the same CXXRecordDecl but a different
  /// super region.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getCXXBaseObjectRegionWithSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1253,
   FQN="clang::ento::MemRegionManager::getCXXBaseObjectRegionWithSuper", NM="_ZN5clang4ento16MemRegionManager31getCXXBaseObjectRegionWithSuperEPKNS0_19CXXBaseObjectRegionEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager31getCXXBaseObjectRegionWithSuperEPKNS0_19CXXBaseObjectRegionEPKNS0_9MemRegionE")
  //</editor-fold>
  public /*const*/ CXXBaseObjectRegion /*P*/ getCXXBaseObjectRegionWithSuper(/*const*/ CXXBaseObjectRegion /*P*/ baseReg, 
                                 /*const*/ MemRegion /*P*/ superRegion) {
    return getCXXBaseObjectRegion(baseReg.getDecl(), superRegion, 
        baseReg.isVirtual());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getFunctionCodeRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 982,
   FQN="clang::ento::MemRegionManager::getFunctionCodeRegion", NM="_ZN5clang4ento16MemRegionManager21getFunctionCodeRegionEPKNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager21getFunctionCodeRegionEPKNS_9NamedDeclE")
  //</editor-fold>
  public /*const*/ FunctionCodeRegion /*P*/ getFunctionCodeRegion(/*const*/ NamedDecl /*P*/ FD) {
    return this.getSubRegion$FunctionCodeRegion(FD, getCodeRegion());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getBlockCodeRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 987,
   FQN="clang::ento::MemRegionManager::getBlockCodeRegion", NM="_ZN5clang4ento16MemRegionManager18getBlockCodeRegionEPKNS_9BlockDeclENS_7CanQualINS_4TypeEEEPNS_19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager18getBlockCodeRegionEPKNS_9BlockDeclENS_7CanQualINS_4TypeEEEPNS_19AnalysisDeclContextE")
  //</editor-fold>
  public /*const*/ BlockCodeRegion /*P*/ getBlockCodeRegion(/*const*/ BlockDecl /*P*/ BD, CanQual<Type> locTy, 
                    AnalysisDeclContext /*P*/ AC) {
    return this.getSubRegion(BD, new CanQual<Type>(locTy), AC, getCodeRegion());
  }

  
  /// getBlockDataRegion - Get the memory region associated with an instance
  ///  of a block.  Unlike many other MemRegions, the LocationContext*
  ///  argument is allowed to be NULL for cases where we have no known
  ///  context.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getBlockDataRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 910,
   FQN="clang::ento::MemRegionManager::getBlockDataRegion", NM="_ZN5clang4ento16MemRegionManager18getBlockDataRegionEPKNS0_15BlockCodeRegionEPKNS_15LocationContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager18getBlockDataRegionEPKNS0_15BlockCodeRegionEPKNS_15LocationContextEj")
  //</editor-fold>
  public /*const*/ BlockDataRegion /*P*/ getBlockDataRegion(/*const*/ BlockCodeRegion /*P*/ BC, 
                    /*const*/ LocationContext /*P*/ LC, 
                    /*uint*/int blockCount) {
    /*const*/ MemRegion /*P*/ sReg = null;
    /*const*/ BlockDecl /*P*/ BD = BC.getDecl();
    if (!BD.hasCaptures()) {
      // This handles 'static' blocks.
      sReg = getGlobalsRegion(MemRegion.Kind.GlobalImmutableSpaceRegionKind);
    } else {
      if ((LC != null)) {
        // FIXME: Once we implement scope handling, we want the parent region
        // to be the scope.
        /*const*/ StackFrameContext /*P*/ STC = LC.getCurrentStackFrame();
        assert Native.$bool(STC);
        sReg = getStackLocalsRegion(STC);
      } else {
        // We allow 'LC' to be NULL for cases where want BlockDataRegions
        // without context-sensitivity.
        sReg = getUnknownRegion();
      }
    }
    
    return this.getSubRegion(BC, LC, blockCount, sReg);
  }

  
  /// Create a CXXTempObjectRegion for temporaries which are lifetime-extended
  /// by static references. This differs from getCXXTempObjectRegion in the
  /// super-region used.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getCXXStaticTempObjectRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 938,
   FQN="clang::ento::MemRegionManager::getCXXStaticTempObjectRegion", NM="_ZN5clang4ento16MemRegionManager28getCXXStaticTempObjectRegionEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager28getCXXStaticTempObjectRegionEPKNS_4ExprE")
  //</editor-fold>
  public /*const*/ CXXTempObjectRegion /*P*/ getCXXStaticTempObjectRegion(/*const*/ Expr /*P*/ Ex) {
    return this.getSubRegion$CXXTempObjectRegion(Ex, getGlobalsRegion(MemRegion.Kind.GlobalInternalSpaceRegionKind, (/*const*/ CodeTextRegion /*P*/ )null));
  }

/*private:*/
//  /*template <typename RegionTy, typename A1> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getRegion">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 37,
//   FQN="clang::ento::MemRegionManager::getRegion", NM="Tpl__ZN5clang4ento16MemRegionManager9getRegionET0_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=Tpl__ZN5clang4ento16MemRegionManager9getRegionET0_")
//  //</editor-fold>
//  private </*typename*/ RegionTy, /*typename*/ A1> RegionTy /*P*/ getRegion(/*const*/ A1 a1) {
//    /*const*/  MemRegionManagerTrait.SuperRegionTy<RegionTy> /*P*/ superRegion = MemRegionManagerTrait.<RegionTy>getSuperRegion(/*Deref*/this, a1);
//
//    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
//    RegionTy.ProfileRegion(ID, a1, superRegion);
//    final type$ref<type$ptr<Object>/*void P*/ > InsertPos;
//    RegionTy /*P*/ R = cast_or_null<RegionTy>(Regions.FindNodeOrInsertPos(ID, 
//            InsertPos));
//    if (Native.$not(R)) {
//      R = A.<RegionTy>Allocate();
//      /*FIXME: NEW_EXPR [NoNewFun]*/R = /*new (R)*/ new RegionTy(( a1, superRegion ));
//      Regions.InsertNode(R, InsertPos);
//    }
//
//    return R;
//  }

  
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 57,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_12StringRegionEPKNS_13StringLiteralEEEPT_T0_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_12StringRegionEPKNS_13StringLiteralEEEPT_T0_PKNS0_9MemRegionE")
  //</editor-fold>
  private StringRegion /*P*/ getSubRegion$StringRegion(/*const*/ StringLiteral /*P*/ /*const*/ a1, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    StringRegion.ProfileRegion(ID, a1, superRegion);
    final type$ref<type$ptr<StringRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    StringRegion /*P*/ R = cast_or_null_StringRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<StringRegion>Allocate$T(StringRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new StringRegion(a1, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 57,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_16ObjCStringRegionEPKNS_17ObjCStringLiteralEEEPT_T0_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_16ObjCStringRegionEPKNS_17ObjCStringLiteralEEEPT_T0_PKNS0_9MemRegionE")
  //</editor-fold>
  private ObjCStringRegion /*P*/ getSubRegion$ObjCStringRegion(/*const*/ ObjCStringLiteral /*P*/ /*const*/ a1, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ObjCStringRegion.ProfileRegion(ID, a1, superRegion);
    final type$ref<type$ptr<ObjCStringRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    ObjCStringRegion /*P*/ R = cast_or_null_ObjCStringRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<ObjCStringRegion>Allocate$T(ObjCStringRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new ObjCStringRegion(a1, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 57,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_9VarRegionEPKNS_7VarDeclEEEPT_T0_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_9VarRegionEPKNS_7VarDeclEEEPT_T0_PKNS0_9MemRegionE")
  //</editor-fold>
  private VarRegion /*P*/ getSubRegion$VarRegion(/*const*/ VarDecl /*P*/ /*const*/ a1, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    VarRegion.ProfileRegion(ID, a1, superRegion);
    final type$ref<type$ptr<VarRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    VarRegion /*P*/ R = cast_or_null_VarRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<VarRegion>Allocate$T(VarRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new VarRegion(a1, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 57,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_19CXXTempObjectRegionEPKNS_4ExprEEEPT_T0_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_19CXXTempObjectRegionEPKNS_4ExprEEEPT_T0_PKNS0_9MemRegionE")
  //</editor-fold>
  private CXXTempObjectRegion /*P*/ getSubRegion$CXXTempObjectRegion(/*const*/ Expr /*P*/ /*const*/ a1, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    CXXTempObjectRegion.ProfileRegion(ID, a1, superRegion);
    final type$ref<type$ptr<CXXTempObjectRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    CXXTempObjectRegion /*P*/ R = cast_or_null_CXXTempObjectRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<CXXTempObjectRegion>Allocate$T(CXXTempObjectRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new CXXTempObjectRegion(a1, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 57,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_21CompoundLiteralRegionEPKNS_19CompoundLiteralExprEEEPT_T0_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_21CompoundLiteralRegionEPKNS_19CompoundLiteralExprEEEPT_T0_PKNS0_9MemRegionE")
  //</editor-fold>
  private CompoundLiteralRegion /*P*/ getSubRegion$CompoundLiteralRegion(/*const*/ CompoundLiteralExpr /*P*/ /*const*/ a1, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    CompoundLiteralRegion.ProfileRegion(ID, a1, superRegion);
    final type$ref<type$ptr<CompoundLiteralRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    CompoundLiteralRegion /*P*/ R = cast_or_null_CompoundLiteralRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<CompoundLiteralRegion>Allocate$T(CompoundLiteralRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new CompoundLiteralRegion(a1, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 57,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_18FunctionCodeRegionEPKNS_9NamedDeclEEEPT_T0_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_18FunctionCodeRegionEPKNS_9NamedDeclEEEPT_T0_PKNS0_9MemRegionE")
  //</editor-fold>
  private FunctionCodeRegion /*P*/ getSubRegion$FunctionCodeRegion(/*const*/ NamedDecl /*P*/ /*const*/ a1, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    FunctionCodeRegion.ProfileRegion(ID, a1, superRegion);
    final type$ref<type$ptr<FunctionCodeRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    FunctionCodeRegion /*P*/ R = cast_or_null_FunctionCodeRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<FunctionCodeRegion>Allocate$T(FunctionCodeRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new FunctionCodeRegion(a1, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 57,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_14SymbolicRegionEPKNS0_7SymExprEEEPT_T0_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_14SymbolicRegionEPKNS0_7SymExprEEEPT_T0_PKNS0_9MemRegionE")
  //</editor-fold>
  private SymbolicRegion /*P*/ getSubRegion$SymbolicRegion(/*const*/ SymExpr /*P*/ /*const*/ a1, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    SymbolicRegion.ProfileRegion(ID, a1, superRegion);
    final type$ref<type$ptr<SymbolicRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    SymbolicRegion /*P*/ R = cast_or_null_SymbolicRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<SymbolicRegion>Allocate$T(SymbolicRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new SymbolicRegion(a1, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 57,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_11FieldRegionEPKNS_9FieldDeclEEEPT_T0_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_11FieldRegionEPKNS_9FieldDeclEEEPT_T0_PKNS0_9MemRegionE")
  //</editor-fold>
  private FieldRegion /*P*/ getSubRegion$FieldRegion(/*const*/ FieldDecl /*P*/ /*const*/ a1, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    FieldRegion.ProfileRegion(ID, a1, superRegion);
    final type$ref<type$ptr<FieldRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    FieldRegion /*P*/ R = cast_or_null_FieldRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<FieldRegion>Allocate$T(FieldRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new FieldRegion(a1, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 57,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_14ObjCIvarRegionEPKNS_12ObjCIvarDeclEEEPT_T0_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_14ObjCIvarRegionEPKNS_12ObjCIvarDeclEEEPT_T0_PKNS0_9MemRegionE")
  //</editor-fold>
  private ObjCIvarRegion /*P*/ getSubRegion$ObjCIvarRegion(/*const*/ ObjCIvarDecl /*P*/ /*const*/ a1, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ObjCIvarRegion.ProfileRegion(ID, a1, superRegion);
    final type$ref<type$ptr<ObjCIvarRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    ObjCIvarRegion /*P*/ R = cast_or_null_ObjCIvarRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<ObjCIvarRegion>Allocate$T(ObjCIvarRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new ObjCIvarRegion(a1, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 57,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_13CXXThisRegionEPKNS_11PointerTypeEEEPT_T0_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_13CXXThisRegionEPKNS_11PointerTypeEEEPT_T0_PKNS0_9MemRegionE")
  //</editor-fold>
  private CXXThisRegion /*P*/ getSubRegion$CXXThisRegion(/*const*/ PointerType /*P*/ /*const*/ a1, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    CXXThisRegion.ProfileRegion(ID, a1, superRegion);
    final type$ref<type$ptr<CXXThisRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    CXXThisRegion /*P*/ R = cast_or_null_CXXThisRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<CXXThisRegion>Allocate$T(CXXThisRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new CXXThisRegion(a1, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }

  
//  /*template <typename RegionTy, typename A1, typename A2> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::getRegion">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 75,
//   FQN="clang::ento::MemRegionManager::getRegion", NM="Tpl__ZN5clang4ento16MemRegionManager9getRegionET0_T1_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=Tpl__ZN5clang4ento16MemRegionManager9getRegionET0_T1_")
//  //</editor-fold>
//  private </*typename*/ RegionTy, /*typename*/ A1, /*typename*/ A2> RegionTy /*P*/ getRegion(/*const*/ A1 a1, /*const*/ A2 a2) {
//    /*const*/  MemRegionManagerTrait.SuperRegionTy<RegionTy> /*P*/ superRegion = MemRegionManagerTrait.<RegionTy>getSuperRegion(/*Deref*/this, a1, a2);
//    
//    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
//    RegionTy.ProfileRegion(ID, a1, a2, superRegion);
//    final type$ref<type$ptr<Object>/*void P*/ > InsertPos = create_type$ref();
//    RegionTy /*P*/ R = cast_or_null<RegionTy>(Regions.FindNodeOrInsertPos(ID, 
//            InsertPos));
//    if (Native.$not(R)) {
//      R = A.<RegionTy>Allocate();
//      /*FIXME: NEW_EXPR [NoNewFun]*/R = /*new (R)*/ new RegionTy(( a1, a2, superRegion ));
//      Regions.InsertNode(R, InsertPos);
//    }
//    
//    return R;
//  }

  
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 95,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_19CXXBaseObjectRegionEPKNS_13CXXRecordDeclEbEEPT_T0_T1_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_19CXXBaseObjectRegionEPKNS_13CXXRecordDeclEbEEPT_T0_T1_PKNS0_9MemRegionE")
  //</editor-fold>
  private CXXBaseObjectRegion /*P*/ getSubRegion(/*const*/ CXXRecordDecl /*P*/ /*const*/ a1, /*const*/boolean a2, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    CXXBaseObjectRegion.ProfileRegion(ID, a1, a2, superRegion);
    final type$ref<type$ptr<CXXBaseObjectRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    CXXBaseObjectRegion /*P*/ R = cast_or_null_CXXBaseObjectRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<CXXBaseObjectRegion>Allocate$T(CXXBaseObjectRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new CXXBaseObjectRegion(a1, a2, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 95,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_12AllocaRegionEPKNS_4ExprEjEEPT_T0_T1_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_12AllocaRegionEPKNS_4ExprEjEEPT_T0_T1_PKNS0_9MemRegionE")
  //</editor-fold>
  private AllocaRegion /*P*/ getSubRegion(/*const*/ Expr /*P*/ /*const*/ a1, /*const*//*uint*/int a2, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    AllocaRegion.ProfileRegion(ID, a1, a2, superRegion);
    final type$ref<type$ptr<AllocaRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    AllocaRegion /*P*/ R = cast_or_null_AllocaRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<AllocaRegion>Allocate$T(AllocaRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new AllocaRegion(a1, a2, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 113,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_15BlockDataRegionEPKNS0_15BlockCodeRegionEPKNS_15LocationContextEjEEPT_T0_T1_T2_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_15BlockDataRegionEPKNS0_15BlockCodeRegionEPKNS_15LocationContextEjEEPT_T0_T1_T2_PKNS0_9MemRegionE")
  //</editor-fold>
  private BlockDataRegion /*P*/ getSubRegion(/*const*/ BlockCodeRegion /*P*/ /*const*/ a1, /*const*/ LocationContext /*P*/ /*const*/ a2, /*const*//*uint*/int a3, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    BlockDataRegion.ProfileRegion(ID, a1, a2, a3, superRegion);
    final type$ref<type$ptr<BlockDataRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    BlockDataRegion /*P*/ R = cast_or_null_BlockDataRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<BlockDataRegion>Allocate$T(BlockDataRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new BlockDataRegion(a1, a2, a3, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 113,
   FQN="clang::ento::MemRegionManager::getSubRegion", NM="_ZN5clang4ento16MemRegionManager12getSubRegionINS0_15BlockCodeRegionEPKNS_9BlockDeclENS_7CanQualINS_4TypeEEEPNS_19AnalysisDeclContextEEEPT_T0_T1_T2_PKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12getSubRegionINS0_15BlockCodeRegionEPKNS_9BlockDeclENS_7CanQualINS_4TypeEEEPNS_19AnalysisDeclContextEEEPT_T0_T1_T2_PKNS0_9MemRegionE")
  //</editor-fold>
  private BlockCodeRegion /*P*/ getSubRegion(/*const*/ BlockDecl /*P*/ /*const*/ a1, /*const*/ CanQual<Type> a2, AnalysisDeclContext /*P*/ /*const*/ a3, 
              /*const*/ MemRegion /*P*/ superRegion) {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    BlockCodeRegion.ProfileRegion(ID, a1, new CanQual<Type>(a2), a3, superRegion);
    final type$ref<type$ptr<BlockCodeRegion /*P*/>/*void P*/ > InsertPos = create_type$ref();
    BlockCodeRegion /*P*/ R = cast_or_null_BlockCodeRegion(Regions.FindNodeOrInsertPos(ID, 
      InsertPos));
    if (!(R != null)) {
      R = A.<BlockCodeRegion>Allocate$T(BlockCodeRegion.class);
      /*NEW_EXPR [System]*/R = /*new (R)*/ $new_uint_voidPtr(R, (type$ptr<?> New$Mem)->{
          return new BlockCodeRegion(a1, new CanQual<Type>(a2), a3, superRegion);
       });
      Regions.InsertNode(R, InsertPos.$deref());
    }

    return R;
  }

  /*template <typename REG> TEMPLATE*/
  
  //===----------------------------------------------------------------------===//
  // MemRegionManager methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::LazyAllocate">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 699,
   FQN="clang::ento::MemRegionManager::LazyAllocate", NM="_ZN5clang4ento16MemRegionManager12LazyAllocateINS0_23GlobalSystemSpaceRegionEEEPKT_RPS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12LazyAllocateINS0_23GlobalSystemSpaceRegionEEEPKT_RPS4_")
  //</editor-fold>
  private /*const*/ GlobalSystemSpaceRegion /*P*/ LazyAllocate$GlobalSystemSpaceRegion(final type$ref<GlobalSystemSpaceRegion /*P*/ /*&*/> region) {
    if (!(region.$deref() != null)) {
      region.$set(A.<GlobalSystemSpaceRegion>Allocate$T(GlobalSystemSpaceRegion.class));
      /*NEW_EXPR [System]*/region.$set(/*new (region)*/ $new_uint_voidPtr(region.$deref(), (type$ptr<?> New$Mem)->{
          return new GlobalSystemSpaceRegion(this);
       }));
    }

    return region.$deref();
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 699,
   FQN="clang::ento::MemRegionManager::LazyAllocate", NM="_ZN5clang4ento16MemRegionManager12LazyAllocateINS0_26GlobalImmutableSpaceRegionEEEPKT_RPS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12LazyAllocateINS0_26GlobalImmutableSpaceRegionEEEPKT_RPS4_")
  //</editor-fold>
  private /*const*/ GlobalImmutableSpaceRegion /*P*/ LazyAllocate$GlobalImmutableSpaceRegion(final type$ref<GlobalImmutableSpaceRegion /*P*/ /*&*/> region) {
    if (!(region.$deref() != null)) {
      region.$set(A.<GlobalImmutableSpaceRegion>Allocate$T(GlobalImmutableSpaceRegion.class));
      /*NEW_EXPR [System]*/region.$set(/*new (region)*/ $new_uint_voidPtr(region.$deref(), (type$ptr<?> New$Mem)->{
          return new GlobalImmutableSpaceRegion(this);
       }));
    }

    return region.$deref();
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 699,
   FQN="clang::ento::MemRegionManager::LazyAllocate", NM="_ZN5clang4ento16MemRegionManager12LazyAllocateINS0_25GlobalInternalSpaceRegionEEEPKT_RPS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12LazyAllocateINS0_25GlobalInternalSpaceRegionEEEPKT_RPS4_")
  //</editor-fold>
  private /*const*/ GlobalInternalSpaceRegion /*P*/ LazyAllocate$GlobalInternalSpaceRegion(final type$ref<GlobalInternalSpaceRegion /*P*/ /*&*/> region) {
    if (!(region.$deref() != null)) {
      region.$set(A.<GlobalInternalSpaceRegion>Allocate$T(GlobalInternalSpaceRegion.class));
      /*NEW_EXPR [System]*/region.$set(/*new (region)*/ $new_uint_voidPtr(region.$deref(), (type$ptr<?> New$Mem)->{
          return new GlobalInternalSpaceRegion(this);
       }));
    }

    return region.$deref();
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 699,
   FQN="clang::ento::MemRegionManager::LazyAllocate", NM="_ZN5clang4ento16MemRegionManager12LazyAllocateINS0_15HeapSpaceRegionEEEPKT_RPS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12LazyAllocateINS0_15HeapSpaceRegionEEEPKT_RPS4_")
  //</editor-fold>
  private /*const*/ HeapSpaceRegion /*P*/ LazyAllocate$HeapSpaceRegion(final type$ref<HeapSpaceRegion /*P*/ /*&*/> region) {
    if (!(region.$deref() != null)) {
      region.$set(A.<HeapSpaceRegion>Allocate$T(HeapSpaceRegion.class));
      /*NEW_EXPR [System]*/region.$set(/*new (region)*/ $new_uint_voidPtr(region.$deref(), (type$ptr<?> New$Mem)->{
          return new HeapSpaceRegion(this);
       }));
    }

    return region.$deref();
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 699,
   FQN="clang::ento::MemRegionManager::LazyAllocate", NM="_ZN5clang4ento16MemRegionManager12LazyAllocateINS0_18UnknownSpaceRegionEEEPKT_RPS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12LazyAllocateINS0_18UnknownSpaceRegionEEEPKT_RPS4_")
  //</editor-fold>
  private /*const*/ UnknownSpaceRegion /*P*/ LazyAllocate$UnknownSpaceRegion(final type$ref<UnknownSpaceRegion /*P*/ /*&*/> region) {
    if (!(region.$deref() != null)) {
      region.$set(A.<UnknownSpaceRegion>Allocate$T(UnknownSpaceRegion.class));
      /*NEW_EXPR [System]*/region.$set(/*new (region)*/ $new_uint_voidPtr(region.$deref(), (type$ptr<?> New$Mem)->{
          return new UnknownSpaceRegion(this);
       }));
    }

    return region.$deref();
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 699,
   FQN="clang::ento::MemRegionManager::LazyAllocate", NM="_ZN5clang4ento16MemRegionManager12LazyAllocateINS0_15CodeSpaceRegionEEEPKT_RPS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16MemRegionManager12LazyAllocateINS0_15CodeSpaceRegionEEEPKT_RPS4_")
  //</editor-fold>
  private /*const*/ CodeSpaceRegion /*P*/ LazyAllocate$CodeSpaceRegion(final type$ref<CodeSpaceRegion /*P*/ /*&*/> region) {
    if (!(region.$deref() != null)) {
      region.$set(A.<CodeSpaceRegion>Allocate$T(CodeSpaceRegion.class));
      /*NEW_EXPR [System]*/region.$set(/*new (region)*/ $new_uint_voidPtr(region.$deref(), (type$ptr<?> New$Mem)->{
          return new CodeSpaceRegion(this);
       }));
    }

    return region.$deref();
  }

  
//  /*template <typename REG, typename ARG> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionManager::LazyAllocate">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 709,
//   FQN="clang::ento::MemRegionManager::LazyAllocate", NM="Tpl__ZN5clang4ento16MemRegionManager12LazyAllocateERPT_T0_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=Tpl__ZN5clang4ento16MemRegionManager12LazyAllocateERPT_T0_")
//  //</editor-fold>
//  private </*typename*/ REG, /*typename*/ ARG> /*const*/ REG /*P*/ LazyAllocate(final REG /*P*/ /*&*/ region, ARG a) {
//    if (Native.$not(region)) {
//      region.$assign(A.<REG>Allocate());
//      /*FIXME: NEW_EXPR [NoNewFun]*/region = /*new (region)*/ new REG(( this, a ));
//    }
//    
//    return region;
//  }

  
  @Override public String toString() {
    return "" + "C=" + "[ASTContext]" // NOI18N
              + ", A=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", Regions=" + Regions // NOI18N
              + ", InternalGlobals=" + InternalGlobals // NOI18N
              + ", SystemGlobals=" + SystemGlobals // NOI18N
              + ", ImmutableGlobals=" + ImmutableGlobals // NOI18N
              + ", StackLocalsSpaceRegions=" + StackLocalsSpaceRegions // NOI18N
              + ", StackArgumentsSpaceRegions=" + StackArgumentsSpaceRegions // NOI18N
              + ", StaticsGlobalSpaceRegions=" + StaticsGlobalSpaceRegions // NOI18N
              + ", heap=" + heap // NOI18N
              + ", unknown=" + unknown // NOI18N
              + ", code=" + code; // NOI18N
  }
}
