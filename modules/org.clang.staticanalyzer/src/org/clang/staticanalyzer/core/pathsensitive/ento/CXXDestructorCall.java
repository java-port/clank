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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;


/// \brief Represents an implicit call to a C++ destructor.
///
/// This can occur at the end of a scope (for automatic objects), at the end
/// of a full-expression (for temporaries), or as part of a delete.
//<editor-fold defaultstate="collapsed" desc="clang::ento::CXXDestructorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 728,
 FQN="clang::ento::CXXDestructorCall", NM="_ZN5clang4ento17CXXDestructorCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento17CXXDestructorCallE")
//</editor-fold>
public class CXXDestructorCall extends /*public*/ CXXInstanceCall implements Destructors.ClassWithDestructor {
  /*friend  class CallEventManager*/
/*protected:*/
  // JAVA: typedef llvm::PointerIntPair<const MemRegion *, 1, bool> DtorDataTy
//  public final class DtorDataTy extends PointerBoolPair</*const*/ MemRegion /*P*/ >{ };
  
  /// Creates an implicit destructor.
  ///
  /// \param DD The destructor that will be called.
  /// \param Trigger The statement whose completion causes this destructor call.
  /// \param Target The object region to be destructed.
  /// \param St The path-sensitive state at this point in the program.
  /// \param LCtx The location context at this point in the program.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXDestructorCall::CXXDestructorCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*cleaner*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 741,
   FQN="clang::ento::CXXDestructorCall::CXXDestructorCall", NM="_ZN5clang4ento17CXXDestructorCallC1EPKNS_17CXXDestructorDeclEPKNS_4StmtEPKNS0_9MemRegionEbN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento17CXXDestructorCallC1EPKNS_17CXXDestructorDeclEPKNS_4StmtEPKNS0_9MemRegionEbN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  protected CXXDestructorCall(/*const*/ CXXDestructorDecl /*P*/ DD, /*const*/ Stmt /*P*/ Trigger, 
      /*const*/ MemRegion /*P*/ Target, boolean IsBaseDestructor, 
      IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
    // : CXXInstanceCall(DD, St, LCtx) 
    //START JInit
    /*ExprWithCleanups*/super(DD, /*$c$.track(*/new IntrusiveRefCntPtr</*const*/ ProgramState>(St)/*)*/, LCtx, JD$Clean.TRAILING);
    //END JInit
    Data = new PointerBoolPair</*const*/ MemRegion /*P*/ >(1, Target, IsBaseDestructor).getOpaqueValue();
    Location.$assignMove(Trigger.getLocEnd());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXDestructorCall::CXXDestructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 749,
   FQN="clang::ento::CXXDestructorCall::CXXDestructorCall", NM="_ZN5clang4ento17CXXDestructorCallC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento17CXXDestructorCallC1ERKS1_")
  //</editor-fold>
  protected CXXDestructorCall(final /*const*/ CXXDestructorCall /*&*/ Other) {
    // : CXXInstanceCall(Other) 
    //START JInit
    super(Other);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXDestructorCall::cloneTo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 750,
   FQN="clang::ento::CXXDestructorCall::cloneTo", NM="_ZNK5clang4ento17CXXDestructorCall7cloneToEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento17CXXDestructorCall7cloneToEPv")
  //</editor-fold>
  @Override protected void cloneTo(Object/*void P*/ Dest) /*const*//* override*/ {
    assert false : "must use clone instead";
    /*NEW_EXPR [System]*/Dest = /*new (Dest)*/ $new_uint_voidPtr(Dest, (type$ptr<?> New$Mem)->{
        return new CXXDestructorCall(/*Deref*/this);
     });
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXDestructorCall::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 753,
   FQN="clang::ento::CXXDestructorCall::getSourceRange", NM="_ZNK5clang4ento17CXXDestructorCall14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento17CXXDestructorCall14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* override*/ {
    return new SourceRange(/*NO_COPY*/Location);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXDestructorCall::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 754,
   FQN="clang::ento::CXXDestructorCall::getNumArgs", NM="_ZNK5clang4ento17CXXDestructorCall10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento17CXXDestructorCall10getNumArgsEv")
  //</editor-fold>
  @Override public /*uint*/int getNumArgs() /*const*//* override*/ {
    return 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXDestructorCall::getRuntimeDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 665,
   FQN="clang::ento::CXXDestructorCall::getRuntimeDefinition", NM="_ZNK5clang4ento17CXXDestructorCall20getRuntimeDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento17CXXDestructorCall20getRuntimeDefinitionEv")
  //</editor-fold>
  @Override public RuntimeDefinition getRuntimeDefinition() /*const*//* override*/ {
    // Base destructors are always called non-virtually.
    // Skip CXXInstanceCall's devirtualization logic in this case.
    if (isBaseDestructor()) {
      return super.getRuntimeDefinition();
    }
    
    return super.getRuntimeDefinition();
  }

  
  /// \brief Returns the value of the implicit 'this' object.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXDestructorCall::getCXXThisVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 659,
   FQN="clang::ento::CXXDestructorCall::getCXXThisVal", NM="_ZNK5clang4ento17CXXDestructorCall13getCXXThisValEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento17CXXDestructorCall13getCXXThisValEv")
  //</editor-fold>
  @Override public SVal getCXXThisVal() /*const*//* override*/ {
    if ((Data != null)) {
      return new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(PointerBoolPair.</*const*/ MemRegion /*P*/ >getFromOpaqueValue_ConstVoidPtr(Data).getPointer()));
    }
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }

  
  /// Returns true if this is a call to a base class destructor.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXDestructorCall::isBaseDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 762,
   FQN="clang::ento::CXXDestructorCall::isBaseDestructor", NM="_ZNK5clang4ento17CXXDestructorCall16isBaseDestructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento17CXXDestructorCall16isBaseDestructorEv")
  //</editor-fold>
  public boolean isBaseDestructor() /*const*/ {
    return PointerBoolPair.</*const*/ MemRegion /*P*/ >getFromOpaqueValue_ConstVoidPtr(Data).getInt();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXDestructorCall::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 766,
   FQN="clang::ento::CXXDestructorCall::getKind", NM="_ZNK5clang4ento17CXXDestructorCall7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento17CXXDestructorCall7getKindEv")
  //</editor-fold>
  @Override public CallEventKind getKind() /*const*//* override*/ {
    return CallEventKind.CE_CXXDestructor;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXDestructorCall::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 768,
   FQN="clang::ento::CXXDestructorCall::classof", NM="_ZN5clang4ento17CXXDestructorCall7classofEPKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento17CXXDestructorCall7classofEPKNS0_9CallEventE")
  //</editor-fold>
  public static boolean classof(/*const*/ CallEvent /*P*/ CA) {
    return CA.getKind() == CallEventKind.CE_CXXDestructor;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXDestructorCall::~CXXDestructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 728,
   FQN="clang::ento::CXXDestructorCall::~CXXDestructorCall", NM="_ZN5clang4ento17CXXDestructorCallD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento17CXXDestructorCallD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public CXXDestructorCall clone() { return new CXXDestructorCall(this); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
