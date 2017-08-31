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
import org.llvm.support.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;


/// MemRegionVisitor - this class implements a simple visitor for MemRegion
/// subclasses.
/*template <typename ImplClass, typename RetTy = void> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValVisitor.h", line = 106,
 FQN="clang::ento::MemRegionVisitor", NM="_ZN5clang4ento16MemRegionVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitorE")
//</editor-fold>
public interface/*class*/ MemRegionVisitor</*typename*/ ImplClass extends MemRegionVisitor<ImplClass, RetTy>, /*typename*/ RetTy/* = void*/>  {
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::Visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValVisitor.h", line = 112,
   FQN="clang::ento::MemRegionVisitor::Visit", NM="_ZN5clang4ento16MemRegionVisitor5VisitEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor5VisitEPKNS0_9MemRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy Visit(/*const*/ MemRegion /*P*/ R) {
    // Dispatch to VisitFooRegion for each FooRegion.
    switch (R.getKind()) {
     case CodeSpaceRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCodeSpaceRegion(cast_CodeSpaceRegion(R));
     case GlobalImmutableSpaceRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitGlobalImmutableSpaceRegion(cast_GlobalImmutableSpaceRegion(R));
     case GlobalInternalSpaceRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitGlobalInternalSpaceRegion(cast_GlobalInternalSpaceRegion(R));
     case GlobalSystemSpaceRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitGlobalSystemSpaceRegion(cast_GlobalSystemSpaceRegion(R));
     case StaticGlobalSpaceRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStaticGlobalSpaceRegion(cast_StaticGlobalSpaceRegion(R));
     case HeapSpaceRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitHeapSpaceRegion(cast_HeapSpaceRegion(R));
     case StackArgumentsSpaceRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStackArgumentsSpaceRegion(cast_StackArgumentsSpaceRegion(R));
     case StackLocalsSpaceRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStackLocalsSpaceRegion(cast_StackLocalsSpaceRegion(R));
     case UnknownSpaceRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnknownSpaceRegion(cast_UnknownSpaceRegion(R));
     case AllocaRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitAllocaRegion(cast_AllocaRegion(R));
     case SymbolicRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSymbolicRegion(cast_SymbolicRegion(R));
     case BlockDataRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBlockDataRegion(cast_BlockDataRegion(R));
     case BlockCodeRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitBlockCodeRegion(cast_BlockCodeRegion(R));
     case FunctionCodeRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFunctionCodeRegion(cast_FunctionCodeRegion(R));
     case CompoundLiteralRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCompoundLiteralRegion(cast_CompoundLiteralRegion(R));
     case CXXBaseObjectRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXBaseObjectRegion(cast_CXXBaseObjectRegion(R));
     case CXXTempObjectRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXTempObjectRegion(cast_CXXTempObjectRegion(R));
     case CXXThisRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCXXThisRegion(cast_CXXThisRegion(R));
     case FieldRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitFieldRegion(cast_FieldRegion(R));
     case ObjCIvarRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCIvarRegion(cast_ObjCIvarRegion(R));
     case VarRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitVarRegion(cast_VarRegion(R));
     case ElementRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitElementRegion(cast_ElementRegion(R));
     case ObjCStringRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitObjCStringRegion(cast_ObjCStringRegion(R));
     case StringRegionKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStringRegion(cast_StringRegion(R));
    }
    throw new llvm_unreachable("Unknown MemRegion kind!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitMemSpaceRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 37,
   FQN="clang::ento::MemRegionVisitor::VisitMemSpaceRegion", NM="_ZN5clang4ento16MemRegionVisitor19VisitMemSpaceRegionEPKNS0_14MemSpaceRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor19VisitMemSpaceRegionEPKNS0_14MemSpaceRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitMemSpaceRegion(/*const*/ MemSpaceRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemRegion(cast_MemRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitCodeSpaceRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 38,
   FQN="clang::ento::MemRegionVisitor::VisitCodeSpaceRegion", NM="_ZN5clang4ento16MemRegionVisitor20VisitCodeSpaceRegionEPKNS0_15CodeSpaceRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor20VisitCodeSpaceRegionEPKNS0_15CodeSpaceRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCodeSpaceRegion(/*const*/ CodeSpaceRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemSpaceRegion(cast_MemSpaceRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitGlobalsSpaceRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 39,
   FQN="clang::ento::MemRegionVisitor::VisitGlobalsSpaceRegion", NM="_ZN5clang4ento16MemRegionVisitor23VisitGlobalsSpaceRegionEPKNS0_18GlobalsSpaceRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor23VisitGlobalsSpaceRegionEPKNS0_18GlobalsSpaceRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitGlobalsSpaceRegion(/*const*/ GlobalsSpaceRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemSpaceRegion(cast_MemSpaceRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitNonStaticGlobalSpaceRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 40,
   FQN="clang::ento::MemRegionVisitor::VisitNonStaticGlobalSpaceRegion", NM="_ZN5clang4ento16MemRegionVisitor31VisitNonStaticGlobalSpaceRegionEPKNS0_26NonStaticGlobalSpaceRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor31VisitNonStaticGlobalSpaceRegionEPKNS0_26NonStaticGlobalSpaceRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitNonStaticGlobalSpaceRegion(/*const*/ NonStaticGlobalSpaceRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitGlobalsSpaceRegion(cast_GlobalsSpaceRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitGlobalImmutableSpaceRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 41,
   FQN="clang::ento::MemRegionVisitor::VisitGlobalImmutableSpaceRegion", NM="_ZN5clang4ento16MemRegionVisitor31VisitGlobalImmutableSpaceRegionEPKNS0_26GlobalImmutableSpaceRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor31VisitGlobalImmutableSpaceRegionEPKNS0_26GlobalImmutableSpaceRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitGlobalImmutableSpaceRegion(/*const*/ GlobalImmutableSpaceRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonStaticGlobalSpaceRegion(cast_NonStaticGlobalSpaceRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitGlobalInternalSpaceRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 42,
   FQN="clang::ento::MemRegionVisitor::VisitGlobalInternalSpaceRegion", NM="_ZN5clang4ento16MemRegionVisitor30VisitGlobalInternalSpaceRegionEPKNS0_25GlobalInternalSpaceRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor30VisitGlobalInternalSpaceRegionEPKNS0_25GlobalInternalSpaceRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitGlobalInternalSpaceRegion(/*const*/ GlobalInternalSpaceRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonStaticGlobalSpaceRegion(cast_NonStaticGlobalSpaceRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitGlobalSystemSpaceRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 43,
   FQN="clang::ento::MemRegionVisitor::VisitGlobalSystemSpaceRegion", NM="_ZN5clang4ento16MemRegionVisitor28VisitGlobalSystemSpaceRegionEPKNS0_23GlobalSystemSpaceRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor28VisitGlobalSystemSpaceRegionEPKNS0_23GlobalSystemSpaceRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitGlobalSystemSpaceRegion(/*const*/ GlobalSystemSpaceRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonStaticGlobalSpaceRegion(cast_NonStaticGlobalSpaceRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitStaticGlobalSpaceRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 46,
   FQN="clang::ento::MemRegionVisitor::VisitStaticGlobalSpaceRegion", NM="_ZN5clang4ento16MemRegionVisitor28VisitStaticGlobalSpaceRegionEPKNS0_23StaticGlobalSpaceRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor28VisitStaticGlobalSpaceRegionEPKNS0_23StaticGlobalSpaceRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitStaticGlobalSpaceRegion(/*const*/ StaticGlobalSpaceRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemSpaceRegion(cast_MemSpaceRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitHeapSpaceRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 49,
   FQN="clang::ento::MemRegionVisitor::VisitHeapSpaceRegion", NM="_ZN5clang4ento16MemRegionVisitor20VisitHeapSpaceRegionEPKNS0_15HeapSpaceRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor20VisitHeapSpaceRegionEPKNS0_15HeapSpaceRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitHeapSpaceRegion(/*const*/ HeapSpaceRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemSpaceRegion(cast_MemSpaceRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitStackSpaceRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 50,
   FQN="clang::ento::MemRegionVisitor::VisitStackSpaceRegion", NM="_ZN5clang4ento16MemRegionVisitor21VisitStackSpaceRegionEPKNS0_16StackSpaceRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor21VisitStackSpaceRegionEPKNS0_16StackSpaceRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitStackSpaceRegion(/*const*/ StackSpaceRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemSpaceRegion(cast_MemSpaceRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitStackArgumentsSpaceRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 51,
   FQN="clang::ento::MemRegionVisitor::VisitStackArgumentsSpaceRegion", NM="_ZN5clang4ento16MemRegionVisitor30VisitStackArgumentsSpaceRegionEPKNS0_25StackArgumentsSpaceRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor30VisitStackArgumentsSpaceRegionEPKNS0_25StackArgumentsSpaceRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitStackArgumentsSpaceRegion(/*const*/ StackArgumentsSpaceRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStackSpaceRegion(cast_StackSpaceRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitStackLocalsSpaceRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 52,
   FQN="clang::ento::MemRegionVisitor::VisitStackLocalsSpaceRegion", NM="_ZN5clang4ento16MemRegionVisitor27VisitStackLocalsSpaceRegionEPKNS0_22StackLocalsSpaceRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor27VisitStackLocalsSpaceRegionEPKNS0_22StackLocalsSpaceRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitStackLocalsSpaceRegion(/*const*/ StackLocalsSpaceRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitStackSpaceRegion(cast_StackSpaceRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitUnknownSpaceRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 55,
   FQN="clang::ento::MemRegionVisitor::VisitUnknownSpaceRegion", NM="_ZN5clang4ento16MemRegionVisitor23VisitUnknownSpaceRegionEPKNS0_18UnknownSpaceRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor23VisitUnknownSpaceRegionEPKNS0_18UnknownSpaceRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnknownSpaceRegion(/*const*/ UnknownSpaceRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemSpaceRegion(cast_MemSpaceRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitSubRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 58,
   FQN="clang::ento::MemRegionVisitor::VisitSubRegion", NM="_ZN5clang4ento16MemRegionVisitor14VisitSubRegionEPKNS0_9SubRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor14VisitSubRegionEPKNS0_9SubRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSubRegion(/*const*/ SubRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitMemRegion(cast_MemRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitAllocaRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 59,
   FQN="clang::ento::MemRegionVisitor::VisitAllocaRegion", NM="_ZN5clang4ento16MemRegionVisitor17VisitAllocaRegionEPKNS0_12AllocaRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor17VisitAllocaRegionEPKNS0_12AllocaRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitAllocaRegion(/*const*/ AllocaRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubRegion(cast_SubRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitSymbolicRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 60,
   FQN="clang::ento::MemRegionVisitor::VisitSymbolicRegion", NM="_ZN5clang4ento16MemRegionVisitor19VisitSymbolicRegionEPKNS0_14SymbolicRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor19VisitSymbolicRegionEPKNS0_14SymbolicRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitSymbolicRegion(/*const*/ SymbolicRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubRegion(cast_SubRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitTypedRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 61,
   FQN="clang::ento::MemRegionVisitor::VisitTypedRegion", NM="_ZN5clang4ento16MemRegionVisitor16VisitTypedRegionEPKNS0_11TypedRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor16VisitTypedRegionEPKNS0_11TypedRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTypedRegion(/*const*/ TypedRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSubRegion(cast_SubRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitBlockDataRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 62,
   FQN="clang::ento::MemRegionVisitor::VisitBlockDataRegion", NM="_ZN5clang4ento16MemRegionVisitor20VisitBlockDataRegionEPKNS0_15BlockDataRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor20VisitBlockDataRegionEPKNS0_15BlockDataRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBlockDataRegion(/*const*/ BlockDataRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedRegion(cast_TypedRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitCodeTextRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 63,
   FQN="clang::ento::MemRegionVisitor::VisitCodeTextRegion", NM="_ZN5clang4ento16MemRegionVisitor19VisitCodeTextRegionEPKNS0_14CodeTextRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor19VisitCodeTextRegionEPKNS0_14CodeTextRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCodeTextRegion(/*const*/ CodeTextRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedRegion(cast_TypedRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitBlockCodeRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 64,
   FQN="clang::ento::MemRegionVisitor::VisitBlockCodeRegion", NM="_ZN5clang4ento16MemRegionVisitor20VisitBlockCodeRegionEPKNS0_15BlockCodeRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor20VisitBlockCodeRegionEPKNS0_15BlockCodeRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitBlockCodeRegion(/*const*/ BlockCodeRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCodeTextRegion(cast_CodeTextRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitFunctionCodeRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 65,
   FQN="clang::ento::MemRegionVisitor::VisitFunctionCodeRegion", NM="_ZN5clang4ento16MemRegionVisitor23VisitFunctionCodeRegionEPKNS0_18FunctionCodeRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor23VisitFunctionCodeRegionEPKNS0_18FunctionCodeRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitFunctionCodeRegion(/*const*/ FunctionCodeRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitCodeTextRegion(cast_CodeTextRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitTypedValueRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 68,
   FQN="clang::ento::MemRegionVisitor::VisitTypedValueRegion", NM="_ZN5clang4ento16MemRegionVisitor21VisitTypedValueRegionEPKNS0_16TypedValueRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor21VisitTypedValueRegionEPKNS0_16TypedValueRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitTypedValueRegion(/*const*/ TypedValueRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedRegion(cast_TypedRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitCompoundLiteralRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 69,
   FQN="clang::ento::MemRegionVisitor::VisitCompoundLiteralRegion", NM="_ZN5clang4ento16MemRegionVisitor26VisitCompoundLiteralRegionEPKNS0_21CompoundLiteralRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor26VisitCompoundLiteralRegionEPKNS0_21CompoundLiteralRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCompoundLiteralRegion(/*const*/ CompoundLiteralRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedValueRegion(cast_TypedValueRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitCXXBaseObjectRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 70,
   FQN="clang::ento::MemRegionVisitor::VisitCXXBaseObjectRegion", NM="_ZN5clang4ento16MemRegionVisitor24VisitCXXBaseObjectRegionEPKNS0_19CXXBaseObjectRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor24VisitCXXBaseObjectRegionEPKNS0_19CXXBaseObjectRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXBaseObjectRegion(/*const*/ CXXBaseObjectRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedValueRegion(cast_TypedValueRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitCXXTempObjectRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 71,
   FQN="clang::ento::MemRegionVisitor::VisitCXXTempObjectRegion", NM="_ZN5clang4ento16MemRegionVisitor24VisitCXXTempObjectRegionEPKNS0_19CXXTempObjectRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor24VisitCXXTempObjectRegionEPKNS0_19CXXTempObjectRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXTempObjectRegion(/*const*/ CXXTempObjectRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedValueRegion(cast_TypedValueRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitCXXThisRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 72,
   FQN="clang::ento::MemRegionVisitor::VisitCXXThisRegion", NM="_ZN5clang4ento16MemRegionVisitor18VisitCXXThisRegionEPKNS0_13CXXThisRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor18VisitCXXThisRegionEPKNS0_13CXXThisRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitCXXThisRegion(/*const*/ CXXThisRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedValueRegion(cast_TypedValueRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitDeclRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 73,
   FQN="clang::ento::MemRegionVisitor::VisitDeclRegion", NM="_ZN5clang4ento16MemRegionVisitor15VisitDeclRegionEPKNS0_10DeclRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor15VisitDeclRegionEPKNS0_10DeclRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitDeclRegion(/*const*/ DeclRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedValueRegion(cast_TypedValueRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitFieldRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 74,
   FQN="clang::ento::MemRegionVisitor::VisitFieldRegion", NM="_ZN5clang4ento16MemRegionVisitor16VisitFieldRegionEPKNS0_11FieldRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor16VisitFieldRegionEPKNS0_11FieldRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitFieldRegion(/*const*/ FieldRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDeclRegion(cast_DeclRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitObjCIvarRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 75,
   FQN="clang::ento::MemRegionVisitor::VisitObjCIvarRegion", NM="_ZN5clang4ento16MemRegionVisitor19VisitObjCIvarRegionEPKNS0_14ObjCIvarRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor19VisitObjCIvarRegionEPKNS0_14ObjCIvarRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCIvarRegion(/*const*/ ObjCIvarRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDeclRegion(cast_DeclRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitVarRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 76,
   FQN="clang::ento::MemRegionVisitor::VisitVarRegion", NM="_ZN5clang4ento16MemRegionVisitor14VisitVarRegionEPKNS0_9VarRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor14VisitVarRegionEPKNS0_9VarRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitVarRegion(/*const*/ VarRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDeclRegion(cast_DeclRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitElementRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 79,
   FQN="clang::ento::MemRegionVisitor::VisitElementRegion", NM="_ZN5clang4ento16MemRegionVisitor18VisitElementRegionEPKNS0_13ElementRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor18VisitElementRegionEPKNS0_13ElementRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitElementRegion(/*const*/ ElementRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedValueRegion(cast_TypedValueRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitObjCStringRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 80,
   FQN="clang::ento::MemRegionVisitor::VisitObjCStringRegion", NM="_ZN5clang4ento16MemRegionVisitor21VisitObjCStringRegionEPKNS0_16ObjCStringRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor21VisitObjCStringRegionEPKNS0_16ObjCStringRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitObjCStringRegion(/*const*/ ObjCStringRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedValueRegion(cast_TypedValueRegion(R));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitStringRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Regions.def", line = 81,
   FQN="clang::ento::MemRegionVisitor::VisitStringRegion", NM="_ZN5clang4ento16MemRegionVisitor17VisitStringRegionEPKNS0_12StringRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor17VisitStringRegionEPKNS0_12StringRegionE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitStringRegion(/*const*/ StringRegion /*P*/ R) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitTypedValueRegion(cast_TypedValueRegion(R));
  }

  
  // Base case, ignore it. :)
  //<editor-fold defaultstate="collapsed" desc="clang::ento::MemRegionVisitor::VisitMemRegion">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValVisitor.h", line = 130,
   FQN="clang::ento::MemRegionVisitor::VisitMemRegion", NM="_ZN5clang4ento16MemRegionVisitor14VisitMemRegionEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento16MemRegionVisitor14VisitMemRegionEPKNS0_9MemRegionE")
  //</editor-fold>
  public /*interface*/ RetTy VisitMemRegion(/*const*/ MemRegion /*P*/ R);

}
