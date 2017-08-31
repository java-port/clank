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


/// SValVisitor - this class implements a simple visitor for SVal
/// subclasses.
/*template <typename ImplClass, typename RetTy = void> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValVisitor.h", line = 28,
 FQN="clang::ento::SValVisitor", NM="_ZN5clang4ento11SValVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitorE")
//</editor-fold>
public interface/*class*/ SValVisitor< /*typename*/ ImplClass extends SValVisitor<ImplClass, RetTy>, /*typename*/ RetTy/* = void*/>  {
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::Visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValVisitor.h", line = 34,
   FQN="clang::ento::SValVisitor::Visit", NM="_ZN5clang4ento11SValVisitor5VisitENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor5VisitENS0_4SValE")
  //</editor-fold>
  public default/*interface*/ RetTy Visit(SVal V) {
    // Dispatch to VisitFooVal for each FooVal.
    // Take namespaces (loc:: and nonloc::) into account.
    switch (V.getBaseKind()) {
     case UndefinedValKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUndefinedVal(V.castAs(UndefinedVal.class));
     case UnknownValKind:
      return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitUnknownVal(V.castAs(UnknownVal.class));
     case LocKind:
      switch (NsLoc.Kind.valueOf(V.getSubKind())) {
       case ConcreteIntKind:
        return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLocConcreteInt(V.castAs(NsLoc.ConcreteInt.class));
       case GotoLabelKind:
        return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLocGotoLabel(V.castAs(NsLoc.GotoLabel.class));
       case MemRegionValKind:
        return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLocMemRegionVal(V.castAs(NsLoc.MemRegionVal.class));
      }
      throw new llvm_unreachable("Unknown Loc sub-kind!");
     case NonLocKind:
      switch (NsNonloc.Kind.valueOf(V.getSubKind())) {
       case CompoundValKind:
        return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonLocCompoundVal(V.castAs(NsNonloc.CompoundVal.class));
       case ConcreteIntKind:
        return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonLocConcreteInt(V.castAs(NsNonloc.ConcreteInt.class));
       case LazyCompoundValKind:
        return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonLocLazyCompoundVal(V.castAs(NsNonloc.LazyCompoundVal.class));
       case LocAsIntegerKind:
        return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonLocLocAsInteger(V.castAs(NsNonloc.LocAsInteger.class));
       case SymbolValKind:
        return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonLocSymbolVal(V.castAs(NsNonloc.SymbolVal.class));
      }
      throw new llvm_unreachable("Unknown NonLoc sub-kind!");
    }
    throw new llvm_unreachable("Unknown SVal kind!");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitUndefinedVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 55,
   FQN="clang::ento::SValVisitor::VisitUndefinedVal", NM="_ZN5clang4ento11SValVisitor17VisitUndefinedValENS0_12UndefinedValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor17VisitUndefinedValENS0_12UndefinedValE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUndefinedVal(UndefinedVal V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSVal(V.castAs(UndefinedVal.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitDefinedOrUnknownSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 56,
   FQN="clang::ento::SValVisitor::VisitDefinedOrUnknownSVal", NM="_ZN5clang4ento11SValVisitor25VisitDefinedOrUnknownSValENS0_20DefinedOrUnknownSValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor25VisitDefinedOrUnknownSValENS0_20DefinedOrUnknownSValE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitDefinedOrUnknownSVal(DefinedOrUnknownSVal V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitSVal(V.castAs(DefinedOrUnknownSVal.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitUnknownVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 57,
   FQN="clang::ento::SValVisitor::VisitUnknownVal", NM="_ZN5clang4ento11SValVisitor15VisitUnknownValENS0_10UnknownValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor15VisitUnknownValENS0_10UnknownValE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitUnknownVal(UnknownVal V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDefinedOrUnknownSVal(V.castAs(UnknownVal.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitDefinedSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 58,
   FQN="clang::ento::SValVisitor::VisitDefinedSVal", NM="_ZN5clang4ento11SValVisitor16VisitDefinedSValENS0_11DefinedSValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor16VisitDefinedSValENS0_11DefinedSValE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitDefinedSVal(DefinedSVal V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDefinedOrUnknownSVal(V.castAs(DefinedSVal.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 59,
   FQN="clang::ento::SValVisitor::VisitLoc", NM="_ZN5clang4ento11SValVisitor8VisitLocENS0_3LocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor8VisitLocENS0_3LocE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitLoc(Loc V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDefinedSVal(V.castAs(Loc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitLocConcreteInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 60,
   FQN="clang::ento::SValVisitor::VisitLocConcreteInt", NM="_ZN5clang4ento11SValVisitor19VisitLocConcreteIntENS0_3loc11ConcreteIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor19VisitLocConcreteIntENS0_3loc11ConcreteIntE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitLocConcreteInt(NsLoc.ConcreteInt V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLoc(V.castAs(Loc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitLocGotoLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 61,
   FQN="clang::ento::SValVisitor::VisitLocGotoLabel", NM="_ZN5clang4ento11SValVisitor17VisitLocGotoLabelENS0_3loc9GotoLabelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor17VisitLocGotoLabelENS0_3loc9GotoLabelE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitLocGotoLabel(NsLoc.GotoLabel V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLoc(V.castAs(Loc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitLocMemRegionVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 62,
   FQN="clang::ento::SValVisitor::VisitLocMemRegionVal", NM="_ZN5clang4ento11SValVisitor20VisitLocMemRegionValENS0_3loc12MemRegionValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor20VisitLocMemRegionValENS0_3loc12MemRegionValE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitLocMemRegionVal(NsLoc.MemRegionVal V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitLoc(V.castAs(Loc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitNonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 63,
   FQN="clang::ento::SValVisitor::VisitNonLoc", NM="_ZN5clang4ento11SValVisitor11VisitNonLocENS0_6NonLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor11VisitNonLocENS0_6NonLocE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitNonLoc(NonLoc V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitDefinedSVal(V.castAs(NonLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitNonLocCompoundVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 64,
   FQN="clang::ento::SValVisitor::VisitNonLocCompoundVal", NM="_ZN5clang4ento11SValVisitor22VisitNonLocCompoundValENS0_6nonloc11CompoundValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor22VisitNonLocCompoundValENS0_6nonloc11CompoundValE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitNonLocCompoundVal(NsNonloc.CompoundVal V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonLoc(V.castAs(NonLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitNonLocConcreteInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 65,
   FQN="clang::ento::SValVisitor::VisitNonLocConcreteInt", NM="_ZN5clang4ento11SValVisitor22VisitNonLocConcreteIntENS0_6nonloc11ConcreteIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor22VisitNonLocConcreteIntENS0_6nonloc11ConcreteIntE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitNonLocConcreteInt(NsNonloc.ConcreteInt V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonLoc(V.castAs(NonLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitNonLocLazyCompoundVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 66,
   FQN="clang::ento::SValVisitor::VisitNonLocLazyCompoundVal", NM="_ZN5clang4ento11SValVisitor26VisitNonLocLazyCompoundValENS0_6nonloc15LazyCompoundValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor26VisitNonLocLazyCompoundValENS0_6nonloc15LazyCompoundValE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitNonLocLazyCompoundVal(NsNonloc.LazyCompoundVal V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonLoc(V.castAs(NonLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitNonLocLocAsInteger">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 67,
   FQN="clang::ento::SValVisitor::VisitNonLocLocAsInteger", NM="_ZN5clang4ento11SValVisitor23VisitNonLocLocAsIntegerENS0_6nonloc12LocAsIntegerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor23VisitNonLocLocAsIntegerENS0_6nonloc12LocAsIntegerE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitNonLocLocAsInteger(NsNonloc.LocAsInteger V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonLoc(V.castAs(NonLoc.class));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitNonLocSymbolVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SVals.def", line = 68,
   FQN="clang::ento::SValVisitor::VisitNonLocSymbolVal", NM="_ZN5clang4ento11SValVisitor20VisitNonLocSymbolValENS0_6nonloc9SymbolValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor20VisitNonLocSymbolValENS0_6nonloc9SymbolValE")
  //</editor-fold>
  public default/*interface*/ RetTy VisitNonLocSymbolVal(NsNonloc.SymbolVal V) {
    return ((/*static_cast*/ImplClass /*P*/ )(this)).VisitNonLoc(V.castAs(NonLoc.class));
  }

  
  // Base case, ignore it. :)
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SValVisitor::VisitSVal">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SValVisitor.h", line = 69,
   FQN="clang::ento::SValVisitor::VisitSVal", NM="_ZN5clang4ento11SValVisitor9VisitSValENS0_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ExprInspectionChecker.cpp -nm=_ZN5clang4ento11SValVisitor9VisitSValENS0_4SValE")
  //</editor-fold>
  public /*interface*/ RetTy VisitSVal(SVal V);

}
