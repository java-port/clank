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
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clank.support.JavaDifferentiators.JD$Clean;


/// \brief Represents a non-static C++ member function call.
///
/// Example: \c obj.fun()
//<editor-fold defaultstate="collapsed" desc="clang::ento::CXXMemberCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 648,
 FQN="clang::ento::CXXMemberCall", NM="_ZN5clang4ento13CXXMemberCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento13CXXMemberCallE")
//</editor-fold>
public class CXXMemberCall extends /*public*/ CXXInstanceCall implements Destructors.ClassWithDestructor {
  /*friend  class CallEventManager*/
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXMemberCall::CXXMemberCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*cleaner*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 652,
   FQN="clang::ento::CXXMemberCall::CXXMemberCall", NM="_ZN5clang4ento13CXXMemberCallC1EPKNS_17CXXMemberCallExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento13CXXMemberCallC1EPKNS_17CXXMemberCallExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  protected CXXMemberCall(/*const*/ CXXMemberCallExpr /*P*/ CE, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
      /*const*/ LocationContext /*P*/ LCtx) {
    // : CXXInstanceCall(CE, St, LCtx) 
    //START JInit
    /*ExprWithCleanups*/super(CE, /*$c$.track(*/new IntrusiveRefCntPtr</*const*/ ProgramState>(St)/*)*/, LCtx, JD$Clean.TRAILING);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXMemberCall::CXXMemberCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 656,
   FQN="clang::ento::CXXMemberCall::CXXMemberCall", NM="_ZN5clang4ento13CXXMemberCallC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento13CXXMemberCallC1ERKS1_")
  //</editor-fold>
  protected CXXMemberCall(final /*const*/ CXXMemberCall /*&*/ Other) {
    // : CXXInstanceCall(Other) 
    //START JInit
    super(Other);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXMemberCall::cloneTo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 657,
   FQN="clang::ento::CXXMemberCall::cloneTo", NM="_ZNK5clang4ento13CXXMemberCall7cloneToEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento13CXXMemberCall7cloneToEPv")
  //</editor-fold>
  @Override protected void cloneTo(Object/*void P*/ Dest) /*const*//* override*/ {
    assert false : "must use clone instead";
    /*NEW_EXPR [System]*/Dest = /*new (Dest)*/ $new_uint_voidPtr(Dest, (type$ptr<?> New$Mem)->{
        return new CXXMemberCall(/*Deref*/this);
     });
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXMemberCall::getOriginExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 660,
   FQN="clang::ento::CXXMemberCall::getOriginExpr", NM="_ZNK5clang4ento13CXXMemberCall13getOriginExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento13CXXMemberCall13getOriginExprEv")
  //</editor-fold>
  public /*virtual*/ /*const*/ CXXMemberCallExpr /*P*/ getOriginExpr() /*const*/ {
    return cast_CXXMemberCallExpr(super.getOriginExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXMemberCall::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 664,
   FQN="clang::ento::CXXMemberCall::getNumArgs", NM="_ZNK5clang4ento13CXXMemberCall10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento13CXXMemberCall10getNumArgsEv")
  //</editor-fold>
  @Override public /*uint*/int getNumArgs() /*const*//* override*/ {
    {
      /*const*/ CallExpr /*P*/ CE = getOriginExpr();
      if ((CE != null)) {
        return CE.getNumArgs();
      }
    }
    return 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXMemberCall::getArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 670,
   FQN="clang::ento::CXXMemberCall::getArgExpr", NM="_ZNK5clang4ento13CXXMemberCall10getArgExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento13CXXMemberCall10getArgExprEj")
  //</editor-fold>
  @Override public /*const*/ Expr /*P*/ getArgExpr(/*uint*/int Index) /*const*//* override*/ {
    return getOriginExpr().getArg$Const(Index);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXMemberCall::getCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 566,
   FQN="clang::ento::CXXMemberCall::getCXXThisExpr", NM="_ZNK5clang4ento13CXXMemberCall14getCXXThisExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento13CXXMemberCall14getCXXThisExprEv")
  //</editor-fold>
  @Override public /*const*/ Expr /*P*/ getCXXThisExpr() /*const*//* override*/ {
    return getOriginExpr().getImplicitObjectArgument();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXMemberCall::getRuntimeDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 570,
   FQN="clang::ento::CXXMemberCall::getRuntimeDefinition", NM="_ZNK5clang4ento13CXXMemberCall20getRuntimeDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento13CXXMemberCall20getRuntimeDefinitionEv")
  //</editor-fold>
  @Override public RuntimeDefinition getRuntimeDefinition() /*const*//* override*/ {
    {
      // C++11 [expr.call]p1: ...If the selected function is non-virtual, or if the
      // id-expression in the class member access expression is a qualified-id,
      // that function is called. Otherwise, its final overrider in the dynamic type
      // of the object expression is called.
      /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(getOriginExpr().getCallee$Const());
      if ((ME != null)) {
        if (ME.hasQualifier()) {
          return super.getRuntimeDefinition();
        }
      }
    }
    
    return super.getRuntimeDefinition();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXMemberCall::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 678,
   FQN="clang::ento::CXXMemberCall::getKind", NM="_ZNK5clang4ento13CXXMemberCall7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento13CXXMemberCall7getKindEv")
  //</editor-fold>
  @Override public CallEventKind getKind() /*const*//* override*/ {
    return CallEventKind.CE_CXXMember;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXMemberCall::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 680,
   FQN="clang::ento::CXXMemberCall::classof", NM="_ZN5clang4ento13CXXMemberCall7classofEPKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento13CXXMemberCall7classofEPKNS0_9CallEventE")
  //</editor-fold>
  public static boolean classof(/*const*/ CallEvent /*P*/ CA) {
    return CA.getKind() == CallEventKind.CE_CXXMember;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXMemberCall::~CXXMemberCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 648,
   FQN="clang::ento::CXXMemberCall::~CXXMemberCall", NM="_ZN5clang4ento13CXXMemberCallD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento13CXXMemberCallD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public CXXMemberCall clone() { return new CXXMemberCall(this); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
