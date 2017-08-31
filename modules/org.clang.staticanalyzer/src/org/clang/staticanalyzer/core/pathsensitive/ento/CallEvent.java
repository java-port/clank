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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.impl.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.staticanalyzer.core.impl.CallEventStatics.*;

/// \brief Represents an abstract call to a function or method along a
/// particular path.
///
/// CallEvents are created through the factory methods of CallEventManager.
///
/// CallEvents should always be cheap to create and destroy. In order for
/// CallEventManager to be able to re-use CallEvent-sized memory blocks,
/// subclasses of CallEvent may not add any data members to the base class.
/// Use the "Data" and "Location" fields instead.
//<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 138,
 FQN="clang::ento::CallEvent", NM="_ZN5clang4ento9CallEventE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9CallEventE")
//</editor-fold>
public abstract class CallEvent implements RefCountedBaseImplementation, Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef CallEventKind Kind
//  public final class Kind extends CallEventKind{ };
/*private:*/
  /*package*//*friend*//*private*/ IntrusiveRefCntPtr</*const*/ ProgramState> State;
  private /*const*/ LocationContext /*P*/ LCtx;
  private PointerUnion</*const*/ Expr /*P*/ , /*const*/ Decl /*P*/ > Origin;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 147,
   FQN="clang::ento::CallEvent::operator=", NM="_ZN5clang4ento9CallEventaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9CallEventaSERKS1_")
  //</editor-fold>
  private void $assign(final /*const*/ CallEvent /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  // This is user data for subclasses.
  protected /*const*/Object/*void P*/ Data;
  
  // This is user data for subclasses.
  // This should come right before RefCount, so that the two fields can be
  // packed together on LP64 platforms.
  protected SourceLocation Location;
/*private:*/
  private /*mutable *//*uint*/int RefCount;
  
  /*friend template <typename T> struct IntrusiveRefCntPtrInfo*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::Retain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 162,
   FQN="clang::ento::CallEvent::Retain", NM="_ZNK5clang4ento9CallEvent6RetainEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent6RetainEv")
  //</editor-fold>
  /*RefCount*/public/*private*/ void Retain() /*const*/ {
    ++RefCount;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::Release">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1100,
   FQN="clang::ento::CallEvent::Release", NM="_ZNK5clang4ento9CallEvent7ReleaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent7ReleaseEv")
  //</editor-fold>
  /*RefCount*/public/*private*/ /*inline*/ void Release() /*const*/ {
    assert ($greater_uint(RefCount, 0)) : "Reference count is already zero.";
    --RefCount;
    if ($greater_uint(RefCount, 0)) {
      return;
    }
    
    final CallEventManager /*&*/ Mgr = State.$arrow().getStateManager().getCallEventManager();
    Mgr.reclaim(this);
    
    this.$destroy();
  }

/*protected:*/
  /*friend  class CallEventManager*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::CallEvent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 168,
   FQN="clang::ento::CallEvent::CallEvent", NM="_ZN5clang4ento9CallEventC1EPKNS_4ExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9CallEventC1EPKNS_4ExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  /*use ctr with cleaner*/private/*protected*/ CallEvent(/*const*/ Expr /*P*/ E, IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ LocationContext /*P*/ lctx) {
    // : State(std::move(state)), LCtx(lctx), Origin(E), Location(), RefCount(0) 
    //START JInit
    this.State = new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, std.move(state));
    this.LCtx = lctx;
    this.Origin = new PointerUnion</*const*/ Expr /*P*/ , /*const*/ Decl /*P*/ >(JD$T.INSTANCE, /*const*/ Expr /*P*/.class, E);
    this.Location = new SourceLocation();
    this.RefCount = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::CallEvent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 171,
   FQN="clang::ento::CallEvent::CallEvent", NM="_ZN5clang4ento9CallEventC1EPKNS_4DeclEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9CallEventC1EPKNS_4DeclEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  /*use ctr with cleaner*/private/*protected*/ CallEvent(/*const*/ Decl /*P*/ D, IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ LocationContext /*P*/ lctx) {
    // : State(std::move(state)), LCtx(lctx), Origin(D), Location(), RefCount(0) 
    //START JInit
    this.State = new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, std.move(state));
    this.LCtx = lctx;
    this.Origin = new PointerUnion</*const*/ Expr /*P*/ , /*const*/ Decl /*P*/ >(JD$T1.INSTANCE, /*const*/ Decl /*P*/.class, D);
    this.Location = new SourceLocation();
    this.RefCount = 0;
    //END JInit
  }

  
  // DO NOT MAKE PUBLIC
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::CallEvent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 175,
   FQN="clang::ento::CallEvent::CallEvent", NM="_ZN5clang4ento9CallEventC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9CallEventC1ERKS1_")
  //</editor-fold>
  protected CallEvent(final /*const*/ CallEvent /*&*/ Original) {
    // : State(Original.State), LCtx(Original.LCtx), Origin(Original.Origin), Data(Original.Data), Location(Original.Location), RefCount(0) 
    //START JInit
    this.State = new IntrusiveRefCntPtr</*const*/ ProgramState>(Original.State);
    this.LCtx = Original.LCtx;
    this.Origin = new PointerUnion</*const*/ Expr /*P*/ , /*const*/ Decl /*P*/ >(Original.Origin);
    this.Data = Original.Data;
    this.Location = new SourceLocation(Original.Location);
    this.RefCount = 0;
    //END JInit
  }

  
  /// Copies this CallEvent, with vtable intact, into a new block of memory.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::cloneTo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 180,
   FQN="clang::ento::CallEvent::cloneTo", NM="_ZNK5clang4ento9CallEvent7cloneToEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent7cloneToEPv")
  //</editor-fold>
  protected abstract /*virtual*/ void cloneTo(Object/*void P*/ Dest) /*const*//* = 0*/;

  
  /// \brief Get the value of arbitrary expressions at this point in the path.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 183,
   FQN="clang::ento::CallEvent::getSVal", NM="_ZNK5clang4ento9CallEvent7getSValEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent7getSValEPKNS_4StmtE")
  //</editor-fold>
  protected SVal getSVal(/*const*/ Stmt /*P*/ S) /*const*/ {
    return getState().$arrow().getSVal(S, getLocationContext());
  }

  
  // JAVA: typedef SmallVectorImpl<SVal> ValueList
//  public final class ValueList extends SmallVectorImpl<SVal>{ };
  
  /// \brief Used to specify non-argument regions that will be invalidated as a
  /// result of this call.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getExtraInvalidatedValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 192,
   FQN="clang::ento::CallEvent::getExtraInvalidatedValues", NM="_ZNK5clang4ento9CallEvent25getExtraInvalidatedValuesERN4llvm15SmallVectorImplINS0_4SValEEEPNS0_33RegionAndSymbolInvalidationTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent25getExtraInvalidatedValuesERN4llvm15SmallVectorImplINS0_4SValEEEPNS0_33RegionAndSymbolInvalidationTraitsE")
  //</editor-fold>
  protected /*virtual*/ void getExtraInvalidatedValues(final SmallVectorImpl<SVal> /*&*/ Values, 
                           RegionAndSymbolInvalidationTraits /*P*/ ETraits) /*const*/ {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::~CallEvent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 196,
   FQN="clang::ento::CallEvent::~CallEvent", NM="_ZN5clang4ento9CallEventD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9CallEventD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    //START JDestroy
    State.$destroy();
    //END JDestroy
  }

  
  /// \brief Returns the kind of call this is.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 199,
   FQN="clang::ento::CallEvent::getKind", NM="_ZNK5clang4ento9CallEvent7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent7getKindEv")
  //</editor-fold>
  public abstract /*virtual*/ CallEventKind getKind() /*const*//* = 0*/;

  
  /// \brief Returns the declaration of the function or method that will be
  /// called. May be null.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 203,
   FQN="clang::ento::CallEvent::getDecl", NM="_ZNK5clang4ento9CallEvent7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent7getDeclEv")
  //</editor-fold>
  public /*virtual*/ /*const*/ Decl /*P*/ getDecl() /*const*/ {
    return Origin.dyn_cast(/*const*/ Decl /*P*/.class);
  }

  
  /// \brief The state in which the call is being evaluated.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 208,
   FQN="clang::ento::CallEvent::getState", NM="_ZNK5clang4ento9CallEvent8getStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent8getStateEv")
  //</editor-fold>
  public /*const*/ IntrusiveRefCntPtr</*const*/ ProgramState> /*&*/ getState() /*const*/ {
    return State;
  }

  
  /// \brief The context in which the call is being evaluated.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getLocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 213,
   FQN="clang::ento::CallEvent::getLocationContext", NM="_ZNK5clang4ento9CallEvent18getLocationContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent18getLocationContextEv")
  //</editor-fold>
  public /*const*/ LocationContext /*P*/ getLocationContext() /*const*/ {
    return LCtx;
  }

  
  /// \brief Returns the definition of the function or method that will be
  /// called.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getRuntimeDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 219,
   FQN="clang::ento::CallEvent::getRuntimeDefinition", NM="_ZNK5clang4ento9CallEvent20getRuntimeDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent20getRuntimeDefinitionEv")
  //</editor-fold>
  public abstract /*virtual*/ RuntimeDefinition getRuntimeDefinition() /*const*//* = 0*/;

  
  /// \brief Returns the expression whose value will be the result of this call.
  /// May be null.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getOriginExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 223,
   FQN="clang::ento::CallEvent::getOriginExpr", NM="_ZNK5clang4ento9CallEvent13getOriginExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent13getOriginExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getOriginExpr() /*const*/ {
    return Origin.dyn_cast(/*const*/ Expr /*P*/.class);
  }

  
  /// \brief Returns the number of arguments (explicit and implicit).
  ///
  /// Note that this may be greater than the number of parameters in the
  /// callee's declaration, and that it may include arguments not written in
  /// the source.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 232,
   FQN="clang::ento::CallEvent::getNumArgs", NM="_ZNK5clang4ento9CallEvent10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent10getNumArgsEv")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int getNumArgs() /*const*//* = 0*/;

  
  /// \brief Returns true if the callee is known to be from a system header.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::isInSystemHeader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 235,
   FQN="clang::ento::CallEvent::isInSystemHeader", NM="_ZNK5clang4ento9CallEvent16isInSystemHeaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent16isInSystemHeaderEv")
  //</editor-fold>
  public boolean isInSystemHeader() /*const*/ {
    /*const*/ Decl /*P*/ D = getDecl();
    if (!(D != null)) {
      return false;
    }
    
    SourceLocation Loc = D.getLocation();
    if (Loc.isValid()) {
      final /*const*/ SourceManager /*&*/ SM = getState().$arrow().getStateManager().getContext().getSourceManager();
      return SM.isInSystemHeader(D.getLocation());
    }
    {
      
      // Special case for implicitly-declared global operator new/delete.
      // These should be considered system functions.
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        return FD.isOverloadedOperator() && FD.isImplicit() && FD.isGlobal();
      }
    }
    
    return false;
  }

  
  /// \brief Returns true if the CallEvent is a call to a function that matches
  /// the CallDescription.
  ///
  /// Note that this function is not intended to be used to match Obj-C method
  /// calls.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::isCalled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 213,
   FQN="clang::ento::CallEvent::isCalled", NM="_ZNK5clang4ento9CallEvent8isCalledERKNS0_15CallDescriptionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent8isCalledERKNS0_15CallDescriptionE")
  //</editor-fold>
  public boolean isCalled(final /*const*/ CallDescription /*&*/ CD) /*const*/ {
    assert (getKind() != CallEventKind.CE_ObjCMessage) : "Obj-C methods are not supported";
    if (!(CD.II != null)) {
      CD.II = $AddrOf(getState().$arrow().getStateManager().getContext().Idents.get(/*NO_COPY*/CD.FuncName));
    }
    if (getCalleeIdentifier() != CD.II) {
      return false;
    }
    return (CD.RequiredArgs == CallDescription.NoArgRequirement
       || CD.RequiredArgs == getNumArgs());
  }

  
  /// \brief Returns a source range for the entire call, suitable for
  /// outputting in diagnostics.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 264,
   FQN="clang::ento::CallEvent::getSourceRange", NM="_ZNK5clang4ento9CallEvent14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent14getSourceRangeEv")
  //</editor-fold>
  public /*virtual*/ SourceRange getSourceRange() /*const*/ {
    return getOriginExpr().getSourceRange();
  }

  
  /// \brief Returns the value of a given argument at the time of the call.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getArgSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 223,
   FQN="clang::ento::CallEvent::getArgSVal", NM="_ZNK5clang4ento9CallEvent10getArgSValEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent10getArgSValEj")
  //</editor-fold>
  public SVal getArgSVal(/*uint*/int Index) /*const*/ {
    /*const*/ Expr /*P*/ ArgE = getArgExpr(Index);
    if (!(ArgE != null)) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    return getSVal(ArgE);
  }

  
  /// \brief Returns the expression associated with a given argument.
  /// May be null if this expression does not appear in the source.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 273,
   FQN="clang::ento::CallEvent::getArgExpr", NM="_ZNK5clang4ento9CallEvent10getArgExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent10getArgExprEj")
  //</editor-fold>
  public /*virtual*/ /*const*/ Expr /*P*/ getArgExpr(/*uint*/int Index) /*const*/ {
    return null;
  }

  
  /// \brief Returns the source range for errors associated with this argument.
  ///
  /// May be invalid if the argument is not written in the source.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getArgSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 230,
   FQN="clang::ento::CallEvent::getArgSourceRange", NM="_ZNK5clang4ento9CallEvent17getArgSourceRangeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent17getArgSourceRangeEj")
  //</editor-fold>
  public SourceRange getArgSourceRange(/*uint*/int Index) /*const*/ {
    /*const*/ Expr /*P*/ ArgE = getArgExpr(Index);
    if (!(ArgE != null)) {
      return new SourceRange();
    }
    return ArgE.getSourceRange();
  }

  
  /// \brief Returns the result type, adjusted for references.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 28,
   FQN="clang::ento::CallEvent::getResultType", NM="_ZNK5clang4ento9CallEvent13getResultTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent13getResultTypeEv")
  //</editor-fold>
  public QualType getResultType() /*const*/ {
    /*const*/ Expr /*P*/ E = getOriginExpr();
    assert ((E != null)) : "Calls without origin expressions do not have results";
    QualType ResultTy = E.getType();
    
    final ASTContext /*&*/ Ctx = getState().$arrow().getStateManager().getContext();
    
    // A function that returns a reference to 'int' will have a result type
    // of simply 'int'. Check the origin expr's value kind to recover the
    // proper type.
    switch (E.getValueKind()) {
     case VK_LValue:
      ResultTy.$assignMove(Ctx.getLValueReferenceType(new QualType(ResultTy)));
      break;
     case VK_XValue:
      ResultTy.$assignMove(Ctx.getRValueReferenceType(new QualType(ResultTy)));
      break;
     case VK_RValue:
      // No adjustment is necessary.
      break;
    }
    
    return ResultTy;
  }

  
  /// \brief Returns the return value of the call.
  ///
  /// This should only be called if the CallEvent was created using a state in
  /// which the return value has already been bound to the origin expression.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getReturnValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 237,
   FQN="clang::ento::CallEvent::getReturnValue", NM="_ZNK5clang4ento9CallEvent14getReturnValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent14getReturnValueEv")
  //</editor-fold>
  public SVal getReturnValue() /*const*/ {
    /*const*/ Expr /*P*/ E = getOriginExpr();
    if (!(E != null)) {
      return new SVal(JD$Move.INSTANCE, new UndefinedVal());
    }
    return getSVal(E);
  }

  
  /// \brief Returns true if the type of any of the non-null arguments satisfies
  /// the condition.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::hasNonNullArgumentsWithType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 87,
   FQN="clang::ento::CallEvent::hasNonNullArgumentsWithType", NM="_ZNK5clang4ento9CallEvent27hasNonNullArgumentsWithTypeEPFbNS_8QualTypeEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent27hasNonNullArgumentsWithTypeEPFbNS_8QualTypeEE")
  //</editor-fold>
  public boolean hasNonNullArgumentsWithType(BoolPredicate<QualType> Condition) /*const*/ {
    /*uint*/int NumOfArgs = getNumArgs();
    
    // If calling using a function pointer, assume the function does not
    // satisfy the callback.
    // TODO: We could check the types of the arguments here.
    if (!(getDecl() != null)) {
      return false;
    }
    
    /*uint*/int Idx = 0;
    for (mapped_iterator<ParmVarDecl/*P*/, QualType> I = param_type_begin(), 
        E = param_type_end();
         I.$noteq(E) && $less_uint(Idx, NumOfArgs); I.$preInc() , ++Idx) {
      if ($lesseq_uint(NumOfArgs, Idx)) {
        break;
      }
      
      // If the parameter is 0, it's harmless.
      if (getArgSVal(Idx).isZeroConstant()) {
        continue;
      }
      if (Condition.$call(I.$star())) {
        return true;
      }
    }
    return false;
  }

  
  /// \brief Returns true if any of the arguments appear to represent callbacks.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::hasNonZeroCallbackArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 113,
   FQN="clang::ento::CallEvent::hasNonZeroCallbackArg", NM="_ZNK5clang4ento9CallEvent21hasNonZeroCallbackArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent21hasNonZeroCallbackArgEv")
  //</editor-fold>
  public boolean hasNonZeroCallbackArg() /*const*/ {
    return hasNonNullArgumentsWithType(/*FuncRef*/CallEventStatics::isCallback);
  }

  
  /// \brief Returns true if any of the arguments is void*.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::hasVoidPointerToNonConstArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 117,
   FQN="clang::ento::CallEvent::hasVoidPointerToNonConstArg", NM="_ZNK5clang4ento9CallEvent27hasVoidPointerToNonConstArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent27hasVoidPointerToNonConstArgEv")
  //</editor-fold>
  public boolean hasVoidPointerToNonConstArg() /*const*/ {
    return hasNonNullArgumentsWithType(/*FuncRef*/CallEventStatics::isVoidPointerToNonConst);
  }

  
  /// \brief Returns true if any of the arguments are known to escape to long-
  /// term storage, even if this method will not modify them.
  // NOTE: The exact semantics of this are still being defined!
  // We don't really want a list of hardcoded exceptions in the long run,
  // but we don't want duplicated lists of known APIs in the short term either.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::argumentsMayEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 304,
   FQN="clang::ento::CallEvent::argumentsMayEscape", NM="_ZNK5clang4ento9CallEvent18argumentsMayEscapeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent18argumentsMayEscapeEv")
  //</editor-fold>
  public /*virtual*/ boolean argumentsMayEscape() /*const*/ {
    return hasNonZeroCallbackArg();
  }

  
  /// \brief Returns true if the callee is an externally-visible function in the
  /// top-level namespace, such as \c malloc.
  ///
  /// You can use this call to determine that a particular function really is
  /// a library function and not, say, a C++ member function with the same name.
  ///
  /// If a name is provided, the function must additionally match the given
  /// name.
  ///
  /// Note that this deliberately excludes C++ library functions in the \c std
  /// namespace, but will include C library functions accessed through the
  /// \c std namespace. This also does not check if the function is declared
  /// as 'extern "C"', or if it uses C++ name mangling.
  // FIXME: Add a helper for checking namespaces.
  // FIXME: Move this down to AnyFunctionCall once checkers have more
  // precise callbacks.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::isGlobalCFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 121,
   FQN="clang::ento::CallEvent::isGlobalCFunction", NM="_ZNK5clang4ento9CallEvent17isGlobalCFunctionEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent17isGlobalCFunctionEN4llvm9StringRefE")
  //</editor-fold>
  public boolean isGlobalCFunction() /*const*/ {
    return isGlobalCFunction(new StringRef());
  }
  public boolean isGlobalCFunction(StringRef FunctionName/*= StringRef()*/) /*const*/ {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(getDecl());
    if (!(FD != null)) {
      return false;
    }
    
    return CheckerContext.isCLibraryFunction(FD, new StringRef(FunctionName));
  }

  
  /// \brief Returns the name of the callee, if its name is a simple identifier.
  ///
  /// Note that this will fail for Objective-C methods, blocks, and C++
  /// overloaded operators. The former is named by a Selector rather than a
  /// simple identifier, and the latter two do not have names.
  // FIXME: Move this down to AnyFunctionCall once checkers have more
  // precise callbacks.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getCalleeIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 333,
   FQN="clang::ento::CallEvent::getCalleeIdentifier", NM="_ZNK5clang4ento9CallEvent19getCalleeIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent19getCalleeIdentifierEv")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*P*/ getCalleeIdentifier() /*const*/ {
    /*const*/ NamedDecl /*P*/ ND = dyn_cast_or_null_NamedDecl(getDecl());
    if (!(ND != null)) {
      return null;
    }
    return ND.getIdentifier();
  }

  
  /// \brief Returns an appropriate ProgramPoint for this call.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getProgramPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 196,
   FQN="clang::ento::CallEvent::getProgramPoint", NM="_ZNK5clang4ento9CallEvent15getProgramPointEbPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent15getProgramPointEbPKNS_15ProgramPointTagE")
  //</editor-fold>
  public ProgramPoint getProgramPoint() /*const*/ {
    return getProgramPoint(false, 
                 (/*const*/ ProgramPointTag /*P*/ )null);
  }
  public ProgramPoint getProgramPoint(boolean IsPreVisit/*= false*/) /*const*/ {
    return getProgramPoint(IsPreVisit, 
                 (/*const*/ ProgramPointTag /*P*/ )null);
  }
  public ProgramPoint getProgramPoint(boolean IsPreVisit/*= false*/, 
                 /*const*/ ProgramPointTag /*P*/ Tag/*= null*/) /*const*/ {
    {
      /*const*/ Expr /*P*/ E = getOriginExpr();
      if ((E != null)) {
        if (IsPreVisit) {
          return new ProgramPoint(JD$Move.INSTANCE, new org.clang.analysis.PreStmt(E, getLocationContext(), Tag));
        }
        return new ProgramPoint(JD$Move.INSTANCE, new org.clang.analysis.PostStmt(E, getLocationContext(), Tag));
      }
    }
    
    /*const*/ Decl /*P*/ D = getDecl();
    assert ((D != null)) : "Cannot get a program point without a statement or decl";
    
    SourceLocation Loc = getSourceRange().getBegin();
    if (IsPreVisit) {
      return new ProgramPoint(JD$Move.INSTANCE, new PreImplicitCall(D, new SourceLocation(Loc), getLocationContext(), Tag));
    }
    return new ProgramPoint(JD$Move.INSTANCE, new PostImplicitCall(D, new SourceLocation(Loc), getLocationContext(), Tag));
  }

  
  /// \brief Returns a new state with all argument regions invalidated.
  ///
  /// This accepts an alternate state in case some processing has already
  /// occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::invalidateRegions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 156,
   FQN="clang::ento::CallEvent::invalidateRegions", NM="_ZNK5clang4ento9CallEvent17invalidateRegionsEjN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent17invalidateRegionsEjN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> invalidateRegions(/*uint*/int BlockCount) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(invalidateRegions(BlockCount, 
                   $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null))));
    } finally {
      $c$.$destroy();
    }
  }
  public IntrusiveRefCntPtr</*const*/ ProgramState> invalidateRegions(/*uint*/int BlockCount, 
                   IntrusiveRefCntPtr</*const*/ ProgramState> Orig/*= $c$.track(null)*/) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> Result = null;
    RegionAndSymbolInvalidationTraits ETraits = null;
    SmallSetUInt PreserveArgs = null;
    try {
      Result = new IntrusiveRefCntPtr</*const*/ ProgramState>((Orig.$bool() ? Orig : getState()));
      {
        
        // Don't invalidate anything if the callee is marked pure/const.
        /*const*/ Decl /*P*/ callee = getDecl();
        if ((callee != null)) {
          if (callee.hasAttr(PureAttr.class) || callee.hasAttr(ConstAttr.class)) {
            return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, Result);
          }
        }
      }
      
      SmallVector<SVal> ValuesToInvalidate/*J*/= new SmallVector<SVal>(8, new SVal());
      ETraits/*J*/= new RegionAndSymbolInvalidationTraits();
      
      getExtraInvalidatedValues(ValuesToInvalidate, $AddrOf(ETraits));
      
      // Indexes of arguments whose values will be preserved by the call.
      PreserveArgs/*J*/= new SmallSetUInt(4);
      if (!argumentsMayEscape()) {
        CallEventStatics.findPtrToConstParams(PreserveArgs, /*Deref*/this);
      }
      
      for (/*uint*/int Idx = 0, Count = getNumArgs(); Idx != Count; ++Idx) {
        // Mark this region for invalidation.  We batch invalidate regions
        // below for efficiency.
        if ((PreserveArgs.count(Idx) != 0)) {
          {
            /*const*/ MemRegion /*P*/ MR = getArgSVal(Idx).getAsRegion();
            if ((MR != null)) {
              ETraits.setTrait(MR.getBaseRegion(), 
                  RegionAndSymbolInvalidationTraits.InvalidationKinds.TK_PreserveContents);
            }
          }
        }
        // TODO: Factor this out + handle the lower level const pointers.
        ValuesToInvalidate.push_back(getArgSVal(Idx));
      }
      
      // Invalidate designated regions using the batch invalidation API.
      // NOTE: Even if RegionsToInvalidate is empty, we may still invalidate
      //  global variables.
      return Result.$arrow().invalidateRegions_ArrayRef2(new ArrayRef<SVal>(ValuesToInvalidate, false), getOriginExpr(), 
          BlockCount, getLocationContext(), 
          /*CausedByPointerEscape*/ true, 
          /*Symbols=*/ (DenseSet</*const*/ SymExpr /*P*/ > /*P*/)null, this, $AddrOf(ETraits));
    } finally {
      if (PreserveArgs != null) { PreserveArgs.$destroy(); }
      if (ETraits != null) { ETraits.$destroy(); }
      if (Result != null) { Result.$destroy(); }
    }
  }

  
  // JAVA: typedef std::pair<Loc, SVal> FrameBindingTy
//  public final class FrameBindingTy extends std.pairTypeType<Loc, SVal>{ };
  // JAVA: typedef SmallVectorImpl<FrameBindingTy> BindingsTy
//  public final class BindingsTy extends SmallVectorImpl<std.pairTypeType<Loc, SVal> >{ };
  
  /// Populates the given SmallVector with the bindings in the callee's stack
  /// frame at the start of this call.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getInitialStackFrameContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 356,
   FQN="clang::ento::CallEvent::getInitialStackFrameContents", NM="_ZNK5clang4ento9CallEvent28getInitialStackFrameContentsEPKNS_17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS0_3LocENS0_4SValEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent28getInitialStackFrameContentsEPKNS_17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS0_3LocENS0_4SValEEEE")
  //</editor-fold>
  public abstract /*virtual*/ void getInitialStackFrameContents(/*const*/ StackFrameContext /*P*/ CalleeCtx, 
                              final SmallVectorImpl<std.pairTypeType<Loc, SVal> > /*&*/ Bindings) /*const*//* = 0*/;

  
  /// Returns a copy of this CallEvent, but using the given state.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::cloneWithState">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1083,
   FQN="clang::ento::CallEvent::cloneWithState", NM="Tpl__ZNK5clang4ento9CallEvent14cloneWithStateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZNK5clang4ento9CallEvent14cloneWithStateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public </*typename*/ T extends CallEvent> CallEventRef<T> cloneWithState$T(Class<T> clazz, IntrusiveRefCntPtr</*const*/ ProgramState> NewState) /*const*/ {
    assert Native.$bool(isa(clazz, /*Deref*/this)) : "Cloning to unrelated type";
    // JAVA: I don't know how to implement the bwloe; and I think we don't need it
    // static_assert($sizeof_T() == $sizeof_CallEvent(), $("Subclasses may not add fields"));
    if ($eq_IntrusiveRefCntPtr(NewState, State)) {
      return new CallEventRef(cast(clazz, this));
    }
    
    final CallEventManager /*&*/ Mgr = State.$arrow().getStateManager().getCallEventManager();
    // JAVA: MEMORY
    T /*P*/ Copy;
    if (false) {
      Copy = ((/*static_cast*/T /*P*/ )(Mgr.allocate(clazz)));
      cloneTo(Copy);
    } else {
      assert this.getClass() == clazz || clazz == CallEvent.class: "" + clazz + " vs. " + this.getClass();
      Copy = (T)this.clone();
    }
    assert Native.$bool(Native.$eq(Copy.getKind(), this.getKind())) : "Bad copy";
    IntrusiveRefCntPtr</*const*/ ProgramState> $NewState = null;
    try {
      $NewState = new IntrusiveRefCntPtr</*const*/ ProgramState>(NewState);
      Copy.State.$assign($NewState);
    } finally {
      if ($NewState != null) { $NewState.$destroy(); }
    }
    return new CallEventRef<T>(Copy);
  }

  
  /// Returns a copy of this CallEvent, but using the given state.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::cloneWithState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 364,
   FQN="clang::ento::CallEvent::cloneWithState", NM="_ZNK5clang4ento9CallEvent14cloneWithStateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent14cloneWithStateEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public CallEventRef<CallEvent> cloneWithState(IntrusiveRefCntPtr</*const*/ ProgramState> NewState) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(this.<CallEvent>cloneWithState$T(CallEvent.class, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(NewState))));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Returns true if this is a statement is a function or method call
  /// of some kind.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::isCallStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 265,
   FQN="clang::ento::CallEvent::isCallStmt", NM="_ZN5clang4ento9CallEvent10isCallStmtEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9CallEvent10isCallStmtEPKNS_4StmtE")
  //</editor-fold>
  public static boolean isCallStmt(/*const*/ Stmt /*P*/ S) {
    return isa_CallExpr(S) || isa_ObjCMessageExpr(S)
       || isa_CXXConstructExpr(S)
       || isa_CXXNewExpr(S);
  }

  
  /// \brief Returns the result type of a function or method declaration.
  ///
  /// This will return a null QualType if the result type cannot be determined.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::getDeclaredResultType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 271,
   FQN="clang::ento::CallEvent::getDeclaredResultType", NM="_ZN5clang4ento9CallEvent21getDeclaredResultTypeEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9CallEvent21getDeclaredResultTypeEPKNS_4DeclE")
  //</editor-fold>
  public static QualType getDeclaredResultType(/*const*/ Decl /*P*/ D) {
    assert Native.$bool(D);
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        return FD.getReturnType();
      }
    }
    {
      /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
      if ((MD != null)) {
        return MD.getReturnType();
      }
    }
    {
      /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
      if ((BD != null)) {
        {
          // Blocks are difficult because the return type may not be stored in the
          // BlockDecl itself. The AST should probably be enhanced, but for now we
          // just do what we can.
          // If the block is declared without an explicit argument list, the
          // signature-as-written just includes the return type, not the entire
          // function type.
          // FIXME: All blocks should have signatures-as-written, even if the return
          // type is inferred. (That's signified with a dependent result type.)
          /*const*/ TypeSourceInfo /*P*/ TSI = BD.getSignatureAsWritten();
          if ((TSI != null)) {
            QualType Ty = TSI.getType();
            {
              /*const*/ FunctionType /*P*/ FT = Ty.$arrow().getAs(FunctionType.class);
              if ((FT != null)) {
                Ty.$assignMove(FT.getReturnType());
              }
            }
            if (!Ty.$arrow().isDependentType()) {
              return Ty;
            }
          }
        }
        
        return new QualType();
      }
    }
    throw new llvm_unreachable("unknown callable kind");
  }

  
  /// \brief Returns true if the given decl is known to be variadic.
  ///
  /// \p D must not be null.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::isVariadic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 300,
   FQN="clang::ento::CallEvent::isVariadic", NM="_ZN5clang4ento9CallEvent10isVariadicEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9CallEvent10isVariadicEPKNS_4DeclE")
  //</editor-fold>
  public static boolean isVariadic(/*const*/ Decl /*P*/ D) {
    assert Native.$bool(D);
    {
      
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        return FD.isVariadic();
      }
    }
    {
      /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
      if ((MD != null)) {
        return MD.isVariadic();
      }
    }
    {
      /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
      if ((BD != null)) {
        return BD.isVariadic();
      }
    }
    throw new llvm_unreachable("unknown callable kind");
  }


  // Iterator access to formal parameters and their types.
  /*private:*/
  // JAVA: typedef std::const_mem_fun_t<QualType, ParmVarDecl> get_type_fun
//  public final class get_type_fun extends std.const_mem_fun_t<QualType, ParmVarDecl>{ };
/*public:*/
  /// Return call's formal parameters.
  ///
  /// Remember that the number of formal parameters may not match the number
  /// of arguments for all calls. However, the first parameter will always
  /// correspond with the argument value returned by \c getArgSVal(0).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::parameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 392,
   FQN="clang::ento::CallEvent::parameters", NM="_ZNK5clang4ento9CallEvent10parametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent10parametersEv")
  //</editor-fold>
  public abstract /*virtual*/ ArrayRef<ParmVarDecl /*P*/ > parameters() /*const*//* = 0*/;

  
  // JAVA: typedef llvm::mapped_iterator<ArrayRef<ParmVarDecl *>::iterator, get_type_fun> param_type_iterator
//  public final class param_type_iterator extends mapped_iterator<ParmVarDecl/*P*/, QualType>{ };
  
  /// Returns an iterator over the types of the call's formal parameters.
  ///
  /// This uses the callee decl found by default name lookup rather than the
  /// definition because it represents a public interface, and probably has
  /// more annotations.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::param_type_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 402,
   FQN="clang::ento::CallEvent::param_type_begin", NM="_ZNK5clang4ento9CallEvent16param_type_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent16param_type_beginEv")
  //</editor-fold>
  public mapped_iterator<ParmVarDecl/*P*/, QualType> param_type_begin() /*const*/ {
    return llvm.map_iterator(parameters().begin(), 
        /*FuncArg*//*AddrOf*//*FPtr*/ParmVarDecl::getType);
  }

  /// \sa param_type_begin()
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::param_type_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 407,
   FQN="clang::ento::CallEvent::param_type_end", NM="_ZNK5clang4ento9CallEvent14param_type_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent14param_type_endEv")
  //</editor-fold>
  public mapped_iterator<ParmVarDecl/*P*/, QualType> param_type_end() /*const*/ {
    return llvm.map_iterator(parameters().end(), 
        /*FuncArg*//*AddrOf*//*FPtr*/ParmVarDecl::getType);
  }

  
  // For debugging purposes only
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 246,
   FQN="clang::ento::CallEvent::dump", NM="_ZNK5clang4ento9CallEvent4dumpERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent4dumpERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ Out) /*const*/ {
    final ASTContext /*&*/ Ctx = getState().$arrow().getStateManager().getContext();
    {
      /*const*/ Expr /*P*/ E = getOriginExpr();
      if ((E != null)) {
        E.printPretty(Out, (PrinterHelper /*P*/ )null, Ctx.getPrintingPolicy());
        Out.$out(/*KEEP_STR*/$LF);
        return;
      }
    }
    {
      
      /*const*/ Decl /*P*/ D = getDecl();
      if ((D != null)) {
        Out.$out(/*KEEP_STR*/"Call to ");
        D.print(Out, Ctx.getPrintingPolicy());
        return;
      }
    }
    
    // FIXME: a string representation of the kind would be nice.
    Out.$out(/*KEEP_STR*/"Unknown call (type ").$out_int(getKind().getValue()).$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEvent::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 244,
   FQN="clang::ento::CallEvent::dump", NM="_ZNK5clang4ento9CallEvent4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9CallEvent4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dump(llvm.errs());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public abstract CallEvent clone();
  
  protected CallEvent(/*const*/ Decl /*P*/ D, IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ LocationContext /*P*/ lctx, JD$Clean _dparm) {
    this(D, state, lctx);
    // do cleanup
    if (_dparm != null) state.$destroy();
  }
  
  protected CallEvent(/*const*/ Expr /*P*/ E, IntrusiveRefCntPtr</*const*/ ProgramState> state, /*const*/ LocationContext /*P*/ lctx, JD$Clean _dparm) { 
    this(E, state, lctx);
    // do cleanup
    if (_dparm != null) state.$destroy();
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    if (true) {
      std.string Buf = new std.string();
      raw_string_ostream OS = new raw_string_ostream(Buf);    
      dump(OS);
      OS.flush();      
      return Buf.toJavaString();
    }
    return "" + "State=" + State // NOI18N
              + ", LCtx=" + "[LocationContext]" // NOI18N
              + ", Origin=" + "[PointerUnion$Expr$Decl]" // NOI18N
              + ", Data=" + NativeTrace.getIdentityStr(Data) // NOI18N
              + ", Location=" + Location // NOI18N
              + ", RefCount=" + RefCount; // NOI18N
  }
}
