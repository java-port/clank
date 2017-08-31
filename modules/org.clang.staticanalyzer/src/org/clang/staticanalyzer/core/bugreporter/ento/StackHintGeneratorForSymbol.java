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

package org.clang.staticanalyzer.core.bugreporter.ento;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


/// \brief Constructs a Stack hint for the given symbol.
///
/// The class knows how to construct the stack hint message based on
/// traversing the CallExpr associated with the call and checking if the given
/// symbol is returned or is one of the arguments.
/// The hint can be customized by redefining 'getMessageForX()' methods.
//<editor-fold defaultstate="collapsed" desc="clang::ento::StackHintGeneratorForSymbol">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 477,
 FQN="clang::ento::StackHintGeneratorForSymbol", NM="_ZN5clang4ento27StackHintGeneratorForSymbolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento27StackHintGeneratorForSymbolE")
//</editor-fold>
public class StackHintGeneratorForSymbol extends /*public*/ StackHintGenerator implements Destructors.ClassWithDestructor {
/*private:*/
  private /*const*/ SymExpr /*P*/ Sym;
  private std.string Msg;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StackHintGeneratorForSymbol::StackHintGeneratorForSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 483,
   FQN="clang::ento::StackHintGeneratorForSymbol::StackHintGeneratorForSymbol", NM="_ZN5clang4ento27StackHintGeneratorForSymbolC1EPKNS0_7SymExprEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento27StackHintGeneratorForSymbolC1EPKNS0_7SymExprEN4llvm9StringRefE")
  //</editor-fold>
  public StackHintGeneratorForSymbol(/*const*/ SymExpr /*P*/ S, StringRef M) {
    // : StackHintGenerator(), Sym(S), Msg(M.operator basic_string()) 
    //START JInit
    super();
    this.Sym = S;
    this.Msg = M.$string();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::StackHintGeneratorForSymbol::~StackHintGeneratorForSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 484,
   FQN="clang::ento::StackHintGeneratorForSymbol::~StackHintGeneratorForSymbol", NM="_ZN5clang4ento27StackHintGeneratorForSymbolD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento27StackHintGeneratorForSymbolD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    Msg.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  /// \brief Search the call expression for the symbol Sym and dispatch the
  /// 'getMessageForX()' methods to construct a specific message.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StackHintGeneratorForSymbol::getMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 1118,
   FQN="clang::ento::StackHintGeneratorForSymbol::getMessage", NM="_ZN5clang4ento27StackHintGeneratorForSymbol10getMessageEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento27StackHintGeneratorForSymbol10getMessageEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  @Override public std.string getMessage(/*const*/ ExplodedNode /*P*/ N)/* override*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      ProgramPoint P = N.getLocation();
      CallExitEnd CExit = P.castAs(CallExitEnd.class);

      // FIXME: Use CallEvent to abstract this over all calls.
      /*const*/ Stmt /*P*/ CallSite = CExit.getCalleeContext().getCallSite();
      /*const*/ CallExpr /*P*/ CE = dyn_cast_or_null_CallExpr(CallSite);
      if (!(CE != null)) {
        return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
      }
      if (!(N != null)) {
        return getMessageForSymbolNotFound();
      }

      // Check if one of the parameters are set to the interesting symbol.
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
      /*const*/ LocationContext /*P*/ LCtx = N.getLocationContext();
      /*uint*/int ArgIndex = 0;
      for (Stmt.ConstExprIterator I = CE.arg_begin$Const(), 
          E = CE.arg_end$Const(); I.$noteq(E); I.$preInc() , ++ArgIndex) {
        SVal SV = State.$arrow().getSVal(I.$star(), LCtx);

        // Check if the variable corresponding to the symbol is passed by value.
        /*const*/ SymExpr /*P*/ AS = SV.getAsLocSymbol();
        if (AS == Sym) {
          return getMessageForArg(I.$star(), ArgIndex);
        }
        {

          // Check if the parameter is a pointer to the symbol.
          Optional<NsLoc.MemRegionVal> Reg = SV.getAs(NsLoc.MemRegionVal.class);
          if (Reg.$bool()) {
            SVal PSV = State.$arrow().getSVal(Reg.$arrow().getRegion());
            /*const*/ SymExpr /*P*/ AS$1 = PSV.getAsLocSymbol();
            if (AS$1 == Sym) {
              return getMessageForArg(I.$star(), ArgIndex);
            }
          }
        }
      }

      // Check if we are returning the interesting symbol.
      SVal SV = State.$arrow().getSVal(CE, LCtx);
      /*const*/ SymExpr /*P*/ RetSym = SV.getAsLocSymbol();
      if (RetSym == Sym) {
        return getMessageForReturn(CE);
      }

      return getMessageForSymbolNotFound();
    } finally {
     if (State != null) { State.$destroy(); }
    } 
  }

  
  /// Produces the message of the following form:
  ///   'Msg via Nth parameter'
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StackHintGeneratorForSymbol::getMessageForArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp", line = 1165,
   FQN="clang::ento::StackHintGeneratorForSymbol::getMessageForArg", NM="_ZN5clang4ento27StackHintGeneratorForSymbol16getMessageForArgEPKNS_4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento27StackHintGeneratorForSymbol16getMessageForArgEPKNS_4ExprEj")
  //</editor-fold>
  public std.string getMessageForArg(/*const*/ Expr /*P*/ ArgE, 
                  /*uint*/int ArgIndex) {
    raw_svector_ostream os = null;
    try {
      // Printed parameters start at 1, not 0.
      ++ArgIndex;
      
      SmallString/*<200>*/ buf/*J*/= new SmallString/*<200>*/(200);
      os/*J*/= new raw_svector_ostream(buf);
      
      os.$out(Msg).$out(/*KEEP_STR*/" via ").$out_uint(ArgIndex).$out(llvm.getOrdinalSuffix(ArgIndex)).$out(
          /*KEEP_STR*/" parameter"
      );
      
      return os.str().$string();
    } finally {
      if (os != null) { os.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::StackHintGeneratorForSymbol::getMessageForReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 493,
   FQN="clang::ento::StackHintGeneratorForSymbol::getMessageForReturn", NM="_ZN5clang4ento27StackHintGeneratorForSymbol19getMessageForReturnEPKNS_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento27StackHintGeneratorForSymbol19getMessageForReturnEPKNS_8CallExprE")
  //</editor-fold>
  public /*virtual*/ std.string getMessageForReturn(/*const*/ CallExpr /*P*/ $CallExpr) {
    return new std.string(Msg);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::StackHintGeneratorForSymbol::getMessageForSymbolNotFound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/BugReporter/PathDiagnostic.h", line = 496,
   FQN="clang::ento::StackHintGeneratorForSymbol::getMessageForSymbolNotFound", NM="_ZN5clang4ento27StackHintGeneratorForSymbol27getMessageForSymbolNotFoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang4ento27StackHintGeneratorForSymbol27getMessageForSymbolNotFoundEv")
  //</editor-fold>
  public /*virtual*/ std.string getMessageForSymbolNotFound() {
    return new std.string(Msg);
  }

  
  @Override public String toString() {
    return "" + "Sym=" + "[SymExpr]" // NOI18N
              + ", Msg=" + Msg // NOI18N
              + super.toString(); // NOI18N
  }
}
