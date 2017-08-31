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

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.core.impl.CallEventStatics;
import org.clank.support.JavaDifferentiators.JD$Clean;


/// \brief Represents a call to any sort of function that might have a
/// FunctionDecl.
//<editor-fold defaultstate="collapsed" desc="clang::ento::AnyFunctionCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 420,
 FQN="clang::ento::AnyFunctionCall", NM="_ZN5clang4ento15AnyFunctionCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15AnyFunctionCallE")
//</editor-fold>
public abstract class AnyFunctionCall extends /*public*/ CallEvent implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnyFunctionCall::AnyFunctionCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*cleaner*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 422,
   FQN="clang::ento::AnyFunctionCall::AnyFunctionCall", NM="_ZN5clang4ento15AnyFunctionCallC1EPKNS_4ExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15AnyFunctionCallC1EPKNS_4ExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  /*use ctr with cleaner*/private/*protected*/ AnyFunctionCall(/*const*/ Expr /*P*/ E, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
      /*const*/ LocationContext /*P*/ LCtx) {
    // : CallEvent(E, $c$.track(St), LCtx) 
    //START JInit
    /*ExprWithCleanups*/super(E, /*$c$.track(*/new IntrusiveRefCntPtr</*const*/ ProgramState>(St)/*)*/, LCtx, JD$Clean.TRAILING);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnyFunctionCall::AnyFunctionCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*cleaner*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 425,
   FQN="clang::ento::AnyFunctionCall::AnyFunctionCall", NM="_ZN5clang4ento15AnyFunctionCallC1EPKNS_4DeclEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15AnyFunctionCallC1EPKNS_4DeclEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  /*use ctr with cleaner*/private/*protected*/ AnyFunctionCall(/*const*/ Decl /*P*/ D, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
      /*const*/ LocationContext /*P*/ LCtx) {
    // : CallEvent(D, $c$.track(St), LCtx) 
    //START JInit
    /*ExprWithCleanups*/super(D, /*$c$.track(*/new IntrusiveRefCntPtr</*const*/ ProgramState>(St)/*)*/, LCtx, JD$Clean.TRAILING);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnyFunctionCall::AnyFunctionCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 428,
   FQN="clang::ento::AnyFunctionCall::AnyFunctionCall", NM="_ZN5clang4ento15AnyFunctionCallC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15AnyFunctionCallC1ERKS1_")
  //</editor-fold>
  protected AnyFunctionCall(final /*const*/ AnyFunctionCall /*&*/ Other) {
    // : CallEvent(Other) 
    //START JInit
    super(Other);
    //END JInit
  }

/*public:*/
  // This function is overridden by subclasses, but they must return
  // a FunctionDecl.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnyFunctionCall::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 433,
   FQN="clang::ento::AnyFunctionCall::getDecl", NM="_ZNK5clang4ento15AnyFunctionCall7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento15AnyFunctionCall7getDeclEv")
  //</editor-fold>
  @Override public /*const*/ FunctionDecl /*P*/ getDecl() /*const*//* override*/ {
    return cast_FunctionDecl(super.getDecl());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnyFunctionCall::getRuntimeDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 437,
   FQN="clang::ento::AnyFunctionCall::getRuntimeDefinition", NM="_ZNK5clang4ento15AnyFunctionCall20getRuntimeDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento15AnyFunctionCall20getRuntimeDefinitionEv")
  //</editor-fold>
  @Override public RuntimeDefinition getRuntimeDefinition() /*const*//* override*/ {
    /*const*/ FunctionDecl /*P*/ FD = getDecl();
    // Note that the AnalysisDeclContext will have the FunctionDecl with
    // the definition (if one exists).
    if ((FD != null)) {
      AnalysisDeclContext /*P*/ AD = getLocationContext().getAnalysisDeclContext().
          getManager().getContext(FD);
      if ((AD.getBody() != null)) {
        return new RuntimeDefinition(AD.getDecl());
      }
    }
    
    return new RuntimeDefinition();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnyFunctionCall::argumentsMayEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 355,
   FQN="clang::ento::AnyFunctionCall::argumentsMayEscape", NM="_ZNK5clang4ento15AnyFunctionCall18argumentsMayEscapeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento15AnyFunctionCall18argumentsMayEscapeEv")
  //</editor-fold>
  @Override public boolean argumentsMayEscape() /*const*//* override*/ {
    if (super.argumentsMayEscape() || hasVoidPointerToNonConstArg()) {
      return true;
    }
    
    /*const*/ FunctionDecl /*P*/ D = getDecl();
    if (!(D != null)) {
      return true;
    }
    
    /*const*/ IdentifierInfo /*P*/ II = D.getIdentifier();
    if (!(II != null)) {
      return false;
    }
    
    // This set of "escaping" APIs is
    
    // - 'int pthread_setspecific(ptheread_key k, const void *)' stores a
    //   value into thread local storage. The value can later be retrieved with
    //   'void *ptheread_getspecific(pthread_key)'. So even thought the
    //   parameter is 'const void *', the region escapes through the call.
    if (II.isStr(/*KEEP_STR*/"pthread_setspecific")) {
      return true;
    }
    
    // - xpc_connection_set_context stores a value which can be retrieved later
    //   with xpc_connection_get_context.
    if (II.isStr(/*KEEP_STR*/"xpc_connection_set_context")) {
      return true;
    }
    
    // - funopen - sets a buffer for future IO calls.
    if (II.isStr(/*KEEP_STR*/"funopen")) {
      return true;
    }
    
    StringRef FName = II.getName();
    
    // - CoreFoundation functions that end with "NoCopy" can free a passed-in
    //   buffer even if it is const.
    if (FName.endswith(/*STRINGREF_STR*/"NoCopy")) {
      return true;
    }
    
    // - NSXXInsertXX, for example NSMapInsertIfAbsent, since they can
    //   be deallocated by NSMapRemove.
    if (FName.startswith(/*STRINGREF_STR*/"NS") && (FName.find(/*STRINGREF_STR*/"Insert") != StringRef.npos)) {
      return true;
    }
    
    // - Many CF containers allow objects to escape through custom
    //   allocators/deallocators upon container construction. (PR12101)
    if (FName.startswith(/*STRINGREF_STR*/"CF") || FName.startswith(/*STRINGREF_STR*/"CG")) {
      return StrInStrNoCase(new StringRef(FName), new StringRef(/*KEEP_STR*/"InsertValue")) != StringRef.npos
         || StrInStrNoCase(new StringRef(FName), new StringRef(/*KEEP_STR*/"AddValue")) != StringRef.npos
         || StrInStrNoCase(new StringRef(FName), new StringRef(/*KEEP_STR*/"SetValue")) != StringRef.npos
         || StrInStrNoCase(new StringRef(FName), new StringRef(/*KEEP_STR*/"WithData")) != StringRef.npos
         || StrInStrNoCase(new StringRef(FName), new StringRef(/*KEEP_STR*/"AppendValue")) != StringRef.npos
         || StrInStrNoCase(new StringRef(FName), new StringRef(/*KEEP_STR*/"SetAttribute")) != StringRef.npos;
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnyFunctionCall::getInitialStackFrameContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 346,
   FQN="clang::ento::AnyFunctionCall::getInitialStackFrameContents", NM="_ZNK5clang4ento15AnyFunctionCall28getInitialStackFrameContentsEPKNS_17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS0_3LocENS0_4SValEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento15AnyFunctionCall28getInitialStackFrameContentsEPKNS_17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS0_3LocENS0_4SValEEEE")
  //</editor-fold>
  @Override public void getInitialStackFrameContents(/*const*/ StackFrameContext /*P*/ CalleeCtx, 
                              final SmallVectorImpl<std.pairTypeType<Loc, SVal> > /*&*/ Bindings) /*const*//* override*/ {
    /*const*/ FunctionDecl /*P*/ D = cast_FunctionDecl(CalleeCtx.getDecl());
    final SValBuilder /*&*/ SVB = getState().$arrow().getStateManager().getSValBuilder();
    CallEventStatics.addParameterValuesToBindings(CalleeCtx, Bindings, SVB, /*Deref*/this, 
        D.parameters$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnyFunctionCall::parameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 339,
   FQN="clang::ento::AnyFunctionCall::parameters", NM="_ZNK5clang4ento15AnyFunctionCall10parametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento15AnyFunctionCall10parametersEv")
  //</editor-fold>
  @Override public ArrayRef<ParmVarDecl /*P*/ > parameters() /*const*//* override*/ {
    /*const*/ FunctionDecl /*P*/ D = getDecl();
    if (!(D != null)) {
      return new ArrayRef<ParmVarDecl /*P*/ >(None, true);
    }
    return D.parameters$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnyFunctionCall::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 459,
   FQN="clang::ento::AnyFunctionCall::classof", NM="_ZN5clang4ento15AnyFunctionCall7classofEPKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15AnyFunctionCall7classofEPKNS0_9CallEventE")
  //</editor-fold>
  public static boolean classof(/*const*/ CallEvent /*P*/ CA) {
    return CA.getKind().getValue() >= CallEventKind.CE_BEG_FUNCTION_CALLS.getValue()
       && CA.getKind().getValue() <= CallEventKind.CE_END_FUNCTION_CALLS.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::AnyFunctionCall::~AnyFunctionCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 420,
   FQN="clang::ento::AnyFunctionCall::~AnyFunctionCall", NM="_ZN5clang4ento15AnyFunctionCallD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15AnyFunctionCallD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected AnyFunctionCall(/*const*/ Expr /*P*/ E, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
    /*const*/ LocationContext /*P*/ LCtx, JD$Clean _dparm) {
    this(E, St, LCtx);
    // do cleanup
    if (_dparm != null) St.$destroy();
  }

  protected AnyFunctionCall(/*const*/ Decl /*P*/ D, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
    /*const*/ LocationContext /*P*/ LCtx, JD$Clean _dparm) {
    this(D, St, LCtx);
    // do cleanup
    if (_dparm != null) St.$destroy();
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
