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

package org.clang.basic;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;



//===----------------------------------------------------------------------===//
// DiagnosticBuilder
//===----------------------------------------------------------------------===//

/// \brief A little helper class used to produce diagnostics.
///
/// This is constructed by the DiagnosticsEngine::Report method, and
/// allows insertion of extra information (arguments and source ranges) into
/// the currently "in flight" diagnostic.  When the temporary for the builder
/// is destroyed, the diagnostic is issued.
///
/// Note that many of these will be created as temporary objects (many call
/// sites), so we want them to be small and we never want their address taken.
/// This ensures that compilers with somewhat reasonable optimizers will promote
/// the common fields to registers, eliminating increments of the NumArgs field,
/// for example.
//<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 873,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 866,
 FQN="clang::DiagnosticBuilder", NM="_ZN5clang17DiagnosticBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticBuilderE")
//</editor-fold>
public class DiagnosticBuilder implements Destructors.ClassWithDestructor, Native.Native$Bool  {
  private /*mutable */DiagnosticsEngine /*P*/ DiagObj/* = null*/;
  private /*mutable *//*uint*/int NumArgs/* = 0*/;
  
  /// \brief Status variable indicating if this diagnostic is still active.
  ///
  // NOTE: This field is redundant with DiagObj (IsActive iff (DiagObj == 0)),
  // but LLVM is not currently smart enough to eliminate the null check that
  // Emit() would end up with if we used that as our status variable.
  private /*mutable */boolean IsActive/* = false*/;
  
  /// \brief Flag indicating that this diagnostic is being emitted via a
  /// call to ForceEmit.
  private /*mutable */boolean IsForceEmit/* = false*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 888,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 881,
   FQN="clang::DiagnosticBuilder::operator=", NM="_ZN5clang17DiagnosticBuilderaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticBuilderaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ DiagnosticBuilder /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  /*friend  class DiagnosticsEngine*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::DiagnosticBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 891,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 884,
   FQN="clang::DiagnosticBuilder::DiagnosticBuilder", NM="_ZN5clang17DiagnosticBuilderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticBuilderC1Ev")
  //</editor-fold>
  private DiagnosticBuilder() {
    /* : DiagObj(null), NumArgs(0), IsActive(false), IsForceEmit(false)*//* = default*/ 
    //START JInit
    /*InClass*/this.DiagObj = null;
    /*InClass*/this.NumArgs = 0;
    /*InClass*/this.IsActive = false;
    /*InClass*/this.IsForceEmit = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::DiagnosticBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 893,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 886,
   FQN="clang::DiagnosticBuilder::DiagnosticBuilder", NM="_ZN5clang17DiagnosticBuilderC1EPNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticBuilderC1EPNS_17DiagnosticsEngineE")
  //</editor-fold>
  /*explicit*/ DiagnosticBuilder(DiagnosticsEngine /*P*/ diagObj) {
    /* : DiagObj(diagObj), NumArgs(0), IsActive(true), IsForceEmit(false)*/ 
    //START JInit
    this.DiagObj = diagObj;
    /*InClass*/this.NumArgs = 0;
    this.IsActive = true;
    /*InClass*/this.IsForceEmit = false;
    //END JInit
    assert ((diagObj != null)) : "DiagnosticBuilder requires a valid DiagnosticsEngine!";
    diagObj.DiagRanges.clear();
    diagObj.DiagFixItHints.clear();
  }

  
  /*friend  class PartialDiagnostic*/
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::FlushCounts">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 903,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 896,
   FQN="clang::DiagnosticBuilder::FlushCounts", NM="_ZN5clang17DiagnosticBuilder11FlushCountsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticBuilder11FlushCountsEv")
  //</editor-fold>
  protected void FlushCounts() {
    DiagObj.NumDiagArgs = (byte) NumArgs;
  }

  
  /// \brief Clear out the current diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::Clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 908,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 901,
   FQN="clang::DiagnosticBuilder::Clear", NM="_ZNK5clang17DiagnosticBuilder5ClearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticBuilder5ClearEv")
  //</editor-fold>
  protected void Clear() /*const*/ {
    DiagObj = null;
    IsActive = false;
    IsForceEmit = false;
  }

  
  /// \brief Determine whether this diagnostic is still active.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::isActive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 915,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 908,
   FQN="clang::DiagnosticBuilder::isActive", NM="_ZNK5clang17DiagnosticBuilder8isActiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticBuilder8isActiveEv")
  //</editor-fold>
  protected boolean isActive() /*const*/ {
    return IsActive;
  }

  
  /// \brief Force the diagnostic builder to emit the diagnostic now.
  ///
  /// Once this function has been called, the DiagnosticBuilder object
  /// should not be used again before it is destroyed.
  ///
  /// \returns true if a diagnostic was emitted, false if the
  /// diagnostic was suppressed.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 924,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 917,
   FQN="clang::DiagnosticBuilder::Emit", NM="_ZN5clang17DiagnosticBuilder4EmitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticBuilder4EmitEv")
  //</editor-fold>
  protected boolean Emit() {
    // If this diagnostic is inactive, then its soul was stolen by the copy ctor
    // (or by a subclass, as in SemaDiagnosticBuilder).
    if (!isActive()) {
      return false;
    }
    
    // When emitting diagnostics, we set the final argument count into
    // the DiagnosticsEngine object.
    FlushCounts();
    
    // Process the diagnostic.
    boolean Result = DiagObj.EmitCurrentDiagnostic(IsForceEmit);
    
    // This diagnostic is dead.
    Clear();
    
    return Result;
  }

/*public:*/
  /// Copy constructor.  When copied, this "takes" the diagnostic info from the
  /// input and neuters it.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::DiagnosticBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 945,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 938,
   FQN="clang::DiagnosticBuilder::DiagnosticBuilder", NM="_ZN5clang17DiagnosticBuilderC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticBuilderC1ERKS0_")
  //</editor-fold>
  public DiagnosticBuilder(/*const*/ DiagnosticBuilder /*&*/ D) {
    /* : DiagObj(null), NumArgs(0), IsActive(false), IsForceEmit(false)*/ 
    //START JInit
    /*InClass*/this.DiagObj = null;
    /*InClass*/this.NumArgs = 0;
    /*InClass*/this.IsActive = false;
    /*InClass*/this.IsForceEmit = false;
    //END JInit
    DiagObj = D.DiagObj;
    IsActive = D.IsActive;
    IsForceEmit = D.IsForceEmit;
    D.Clear();
    NumArgs = D.NumArgs;
  }

  
  /// \brief Retrieve an empty diagnostic builder.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::getEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 954,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 947,
   FQN="clang::DiagnosticBuilder::getEmpty", NM="_ZN5clang17DiagnosticBuilder8getEmptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticBuilder8getEmptyEv")
  //</editor-fold>
  public static DiagnosticBuilder getEmpty() {
    return new DiagnosticBuilder();
  }

  
  /// \brief Emits the diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::~DiagnosticBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 959,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 952,
   FQN="clang::DiagnosticBuilder::~DiagnosticBuilder", NM="_ZN5clang17DiagnosticBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clang17DiagnosticBuilderD0Ev")
  //</editor-fold>
  public void $destroy() {
    Emit();
  }

  
  /// \brief Forces the diagnostic to be emitted.
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::setForceEmit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 964,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 957,
   FQN="clang::DiagnosticBuilder::setForceEmit", NM="_ZNK5clang17DiagnosticBuilder12setForceEmitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticBuilder12setForceEmitEv")
  //</editor-fold>
  public /*const*/ DiagnosticBuilder /*&*/ setForceEmit() /*const*/ {
    IsForceEmit = true;
    return /*Deref*/this;
  }

  
  /// \brief Conversion of DiagnosticBuilder to bool always returns \c true.
  ///
  /// This allows is to be used in boolean error contexts (where \c true is
  /// used to indicate that an error has occurred), like:
  /// \code
  /// return Diag(...);
  /// \endcode
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 976,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 969,
   FQN="clang::DiagnosticBuilder::operator bool", NM="_ZNK5clang17DiagnosticBuildercvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticBuildercvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::AddString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 978,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 971,
   FQN="clang::DiagnosticBuilder::AddString", NM="_ZNK5clang17DiagnosticBuilder9AddStringEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticBuilder9AddStringEN4llvm9StringRefE")
  //</editor-fold>
  public void AddString(StringRef S) /*const*/ {
    assert (isActive()) : "Clients must not add to cleared diagnostic!";
    assert ($less_uint_int(NumArgs, DiagnosticsEngine.MaxArguments)) : "Too many arguments to diagnostic!";
    DiagObj.DiagArgumentsKind[NumArgs] = DiagnosticsEngine.ArgumentKind.ak_std_string;
    DiagObj.DiagArgumentsStr[NumArgs++].$assignMove(S.$string());
  }
  public void AddString(std.string S) /*const*/ {
    assert (isActive()) : "Clients must not add to cleared diagnostic!";
    assert ($less_uint_int(NumArgs, DiagnosticsEngine.MaxArguments)) : "Too many arguments to diagnostic!";
    DiagObj.DiagArgumentsKind[NumArgs] = DiagnosticsEngine.ArgumentKind.ak_std_string;
    DiagObj.DiagArgumentsStr[NumArgs++].$assign(S);
  }
  public void AddString(String S) /*const*/ {
    assert (isActive()) : "Clients must not add to cleared diagnostic!";
    assert ($less_uint_int(NumArgs, DiagnosticsEngine.MaxArguments)) : "Too many arguments to diagnostic!";
    DiagObj.DiagArgumentsKind[NumArgs] = DiagnosticsEngine.ArgumentKind.ak_std_string;
    DiagObj.DiagArgumentsStr[NumArgs++].$assign(new std.string(S));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::AddTaggedVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 986,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 979,
   FQN="clang::DiagnosticBuilder::AddTaggedVal", NM="_ZNK5clang17DiagnosticBuilder12AddTaggedValEiNS_17DiagnosticsEngine12ArgumentKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticBuilder12AddTaggedValEiNS_17DiagnosticsEngine12ArgumentKindE")
  //</editor-fold>
  public void AddTaggedVal(Object/*intptr_t*/ V, DiagnosticsEngine.ArgumentKind Kind) /*const*/ {
    assert (isActive()) : "Clients must not add to cleared diagnostic!";
    assert ($less_uint_int(NumArgs, DiagnosticsEngine.MaxArguments)) : "Too many arguments to diagnostic!";
    DiagObj.DiagArgumentsKind[NumArgs] = Kind;
    DiagObj.DiagArgumentsVal[NumArgs++] = V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::AddSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 994,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 987,
   FQN="clang::DiagnosticBuilder::AddSourceRange", NM="_ZNK5clang17DiagnosticBuilder14AddSourceRangeERKNS_15CharSourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticBuilder14AddSourceRangeERKNS_15CharSourceRangeE")
  //</editor-fold>
  public void AddSourceRange(/*const*/ CharSourceRange /*&*/ R) /*const*/ {
    assert (isActive()) : "Clients must not add to cleared diagnostic!";
    DiagObj.DiagRanges.push_back(R);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::AddFixItHint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 999,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 992,
   FQN="clang::DiagnosticBuilder::AddFixItHint", NM="_ZNK5clang17DiagnosticBuilder12AddFixItHintERKNS_9FixItHintE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticBuilder12AddFixItHintERKNS_9FixItHintE")
  //</editor-fold>
  public void AddFixItHint(/*const*/ FixItHint /*&*/ Hint) /*const*/ {
    assert (isActive()) : "Clients must not add to cleared diagnostic!";
    if (!Hint.isNull()) {
      DiagObj.DiagFixItHints.push_back(Hint);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DiagnosticBuilder::addFlagValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1005,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 998,
   FQN="clang::DiagnosticBuilder::addFlagValue", NM="_ZNK5clang17DiagnosticBuilder12addFlagValueEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZNK5clang17DiagnosticBuilder12addFlagValueEN4llvm9StringRefE")
  //</editor-fold>
  public void addFlagValue(StringRef V) /*const*/ {
    DiagObj.FlagValue.$assignMove(V.$string());
  }

  
  public String toString() {
    return "" + "DiagObj=" + DiagObj // NOI18N
              + ", NumArgs=" + NumArgs // NOI18N
              + ", IsActive=" + IsActive // NOI18N
              + ", IsForceEmit=" + IsForceEmit; // NOI18N
  }
}
