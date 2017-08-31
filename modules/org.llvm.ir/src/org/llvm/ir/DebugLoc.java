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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.pass.*;


/// \brief A debug info location.
///
/// This class is a wrapper around a tracking reference to an \a DILocation
/// pointer.
///
/// To avoid extra includes, \a DebugLoc doubles the \a DILocation API with a
/// one based on relatively opaque \a MDNode pointers.
//<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 34,
 FQN="llvm::DebugLoc", NM="_ZN4llvm8DebugLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZN4llvm8DebugLocE")
//</editor-fold>
public class DebugLoc implements Destructors.ClassWithDestructor, Native.NativeComparable<DebugLoc>, Native.Native$Bool {
  private TypedTrackingMDRef<MDNode> Loc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::DebugLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 38,
   FQN="llvm::DebugLoc::DebugLoc", NM="_ZN4llvm8DebugLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZN4llvm8DebugLocC1Ev")
  //</editor-fold>
  public DebugLoc() {
    // : Loc()
    //START JInit
    this.Loc = new TypedTrackingMDRef<MDNode>();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::DebugLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 39,
   FQN="llvm::DebugLoc::DebugLoc", NM="_ZN4llvm8DebugLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZN4llvm8DebugLocC1EOS0_")
  //</editor-fold>
  public DebugLoc(JD$Move _dparam, final DebugLoc /*&&*/X) {
    // : Loc(std::move(X.Loc))
    //START JInit
    this.Loc = new TypedTrackingMDRef<MDNode>(JD$Move.INSTANCE, std.move(X.Loc));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::DebugLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 40,
   FQN="llvm::DebugLoc::DebugLoc", NM="_ZN4llvm8DebugLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZN4llvm8DebugLocC1ERKS0_")
  //</editor-fold>
  public DebugLoc(final /*const*/ DebugLoc /*&*/ X) {
    // : Loc(X.Loc)
    //START JInit
    this.Loc = new TypedTrackingMDRef<MDNode>(X.Loc);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 41,
   FQN="llvm::DebugLoc::operator=", NM="_ZN4llvm8DebugLocaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZN4llvm8DebugLocaSEOS0_")
  //</editor-fold>
  public DebugLoc /*&*/ $assignMove(final DebugLoc /*&&*/X) {
    Loc.$assignMove(std.move(X.Loc));
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 45,
   FQN="llvm::DebugLoc::operator=", NM="_ZN4llvm8DebugLocaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZN4llvm8DebugLocaSERKS0_")
  //</editor-fold>
  public DebugLoc /*&*/ $assign(final /*const*/ DebugLoc /*&*/ X) {
    Loc.$assign(X.Loc);
    return /*Deref*/this;
  }


  /// \brief Construct from an \a DILocation.

  //===----------------------------------------------------------------------===//
  // DebugLoc Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::DebugLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp", line = 18,
   FQN="llvm::DebugLoc::DebugLoc", NM="_ZN4llvm8DebugLocC1EPKNS_10DILocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZN4llvm8DebugLocC1EPKNS_10DILocationE")
  //</editor-fold>
  public DebugLoc(/*const*/ DILocation /*P*/ L) {
    // : Loc(const_cast<DILocation * >(L))
    //START JInit
    this.Loc = new TypedTrackingMDRef<MDNode>(((/*const_cast*/DILocation /*P*/ )(L)));
    //END JInit
  }


  /// \brief Construct from an \a MDNode.
  ///
  /// Note: if \c N is not an \a DILocation, a verifier check will fail, and
  /// accessors will crash.  However, construction from other nodes is
  /// supported in order to handle forward references when reading textual
  /// IR.
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::DebugLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp", line = 19,
   FQN="llvm::DebugLoc::DebugLoc", NM="_ZN4llvm8DebugLocC1EPKNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZN4llvm8DebugLocC1EPKNS_6MDNodeE")
  //</editor-fold>
  public DebugLoc(/*const*/ MDNode /*P*/ L) {
    // : Loc(const_cast<MDNode * >(L))
    //START JInit
    this.Loc = new TypedTrackingMDRef<MDNode>(((/*const_cast*/MDNode /*P*/ )(L)));
    //END JInit
  }


  /// \brief Get the underlying \a DILocation.
  ///
  /// \pre !*this or \c isa<DILocation>(getAsMDNode()).
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp", line = 21,
   FQN="llvm::DebugLoc::get", NM="_ZNK4llvm8DebugLoc3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoc3getEv")
  //</editor-fold>
  public DILocation /*P*/ get() /*const*/ {
    return cast_or_null_DILocation(Loc.get());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::operator DILocation * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 66,
   FQN="llvm::DebugLoc::operator DILocation * ", NM="_ZNK4llvm8DebugLoccvPNS_10DILocationEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoccvPNS_10DILocationEEv")
  //</editor-fold>
  public DILocation /*P*/ $DILocation$P() /*const*/ {
    return get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 67,
   FQN="llvm::DebugLoc::operator->", NM="_ZNK4llvm8DebugLocptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLocptEv")
  //</editor-fold>
  public DILocation /*P*/ $arrow() /*const*/ {
    return get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 68,
   FQN="llvm::DebugLoc::operator*", NM="_ZNK4llvm8DebugLocdeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLocdeEv")
  //</editor-fold>
  public DILocation /*&*/ $star() /*const*/ {
    return $Deref(get());
  }

  /// @}

  /// \brief Check for null.
  ///
  /// Check for null in a way that is safe with broken debug info.  Unlike
  /// the conversion to \c DILocation, this doesn't require that \c Loc is of
  /// the right type.  Important for cases like \a llvm::StripDebugInfo() and
  /// \a Instruction::hasMetadata().
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 77,
   FQN="llvm::DebugLoc::operator bool", NM="_ZNK4llvm8DebugLoccvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoccvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return ((Loc.$T$P()) != null);
  }


  /// \brief Check whether this has a trivial destructor.
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::hasTrivialDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 80,
   FQN="llvm::DebugLoc::hasTrivialDestructor", NM="_ZNK4llvm8DebugLoc20hasTrivialDestructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoc20hasTrivialDestructorEv")
  //</editor-fold>
  public boolean hasTrivialDestructor() /*const*/ {
    return Loc.hasTrivialDestructor();
  }


  /// \brief Create a new DebugLoc.
  ///
  /// Create a new DebugLoc at the specified line/col and scope/inline.  This
  /// forwards to \a DILocation::get().
  ///
  /// If \c !Scope, returns a default-constructed \a DebugLoc.
  ///
  /// FIXME: Remove this.  Users should use DILocation::get().
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp", line = 58,
   FQN="llvm::DebugLoc::get", NM="_ZN4llvm8DebugLoc3getEjjPKNS_6MDNodeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZN4llvm8DebugLoc3getEjjPKNS_6MDNodeES3_")
  //</editor-fold>
  public static DebugLoc get(/*uint*/int Line, /*uint*/int Col, /*const*/ MDNode /*P*/ Scope) {
    return get(Line, Col, Scope,
     (/*const*/ MDNode /*P*/ )null);
  }
  public static DebugLoc get(/*uint*/int Line, /*uint*/int Col, /*const*/ MDNode /*P*/ Scope,
     /*const*/ MDNode /*P*/ InlinedAt/*= null*/) {
    // If no scope is available, this is an unknown location.
    if (!(Scope != null)) {
      return new DebugLoc();
    }

    return new DebugLoc(DILocation.get(Scope.getContext(), Line, Col,
            ((/*const_cast*/MDNode /*P*/ )(Scope)),
            ((/*const_cast*/MDNode /*P*/ )(InlinedAt))));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp", line = 25,
   FQN="llvm::DebugLoc::getLine", NM="_ZNK4llvm8DebugLoc7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoc7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    assert ((get() != null)) : "Expected valid DebugLoc";
    return get().getLine();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::getCol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp", line = 30,
   FQN="llvm::DebugLoc::getCol", NM="_ZNK4llvm8DebugLoc6getColEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoc6getColEv")
  //</editor-fold>
  public /*uint*/int getCol() /*const*/ {
    assert ((get() != null)) : "Expected valid DebugLoc";
    return get().getColumn();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::getScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp", line = 35,
   FQN="llvm::DebugLoc::getScope", NM="_ZNK4llvm8DebugLoc8getScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoc8getScopeEv")
  //</editor-fold>
  public MDNode /*P*/ getScope() /*const*/ {
    assert ((get() != null)) : "Expected valid DebugLoc";
    return get().getScope();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::getInlinedAt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp", line = 40,
   FQN="llvm::DebugLoc::getInlinedAt", NM="_ZNK4llvm8DebugLoc12getInlinedAtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoc12getInlinedAtEv")
  //</editor-fold>
  public DILocation /*P*/ getInlinedAt() /*const*/ {
    assert ((get() != null)) : "Expected valid DebugLoc";
    return get().getInlinedAt();
  }


  /// \brief Get the fully inlined-at scope for a DebugLoc.
  ///
  /// Gets the inlined-at scope for a DebugLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::getInlinedAtScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp", line = 45,
   FQN="llvm::DebugLoc::getInlinedAtScope", NM="_ZNK4llvm8DebugLoc17getInlinedAtScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoc17getInlinedAtScopeEv")
  //</editor-fold>
  public MDNode /*P*/ getInlinedAtScope() /*const*/ {
    return cast_DILocation(Loc.$star()).getInlinedAtScope();
  }


  /// \brief Find the debug info location for the start of the function.
  ///
  /// Walk up the scope chain of given debug loc and find line number info
  /// for the function.
  ///
  /// FIXME: Remove this.  Users should use DILocation/DILocalScope API to
  /// find the subprogram, and then DILocation::get().
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::getFnDebugLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp", line = 49,
   FQN="llvm::DebugLoc::getFnDebugLoc", NM="_ZNK4llvm8DebugLoc13getFnDebugLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoc13getFnDebugLocEv")
  //</editor-fold>
  public DebugLoc getFnDebugLoc() /*const*/ {
    // FIXME: Add a method on \a DILocation that does this work.
    /*const*/ MDNode /*P*/ Scope = getInlinedAtScope();
    {
      DISubprogram /*P*/ SP = IrLlvmGlobals.getDISubprogram(Scope);
      if ((SP != null)) {
        return DebugLoc.get(SP.getScopeLine(), 0, SP);
      }
    }

    return new DebugLoc();
  }


  /// \brief Return \c this as a bar \a MDNode.
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::getAsMDNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 113,
   FQN="llvm::DebugLoc::getAsMDNode", NM="_ZNK4llvm8DebugLoc11getAsMDNodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoc11getAsMDNodeEv")
  //</editor-fold>
  public MDNode /*P*/ getAsMDNode() /*const*/ {
    return Loc.$T$P();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 115,
   FQN="llvm::DebugLoc::operator==", NM="_ZNK4llvm8DebugLoceqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoceqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ DebugLoc /*&*/ DL) /*const*/ {
    return Loc.$eq(DL.Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 116,
   FQN="llvm::DebugLoc::operator!=", NM="_ZNK4llvm8DebugLocneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLocneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ DebugLoc /*&*/ DL) /*const*/ {
    return Loc.$noteq(DL.Loc);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp", line = 69,
   FQN="llvm::DebugLoc::dump", NM="_ZNK4llvm8DebugLoc4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoc4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    if (!((Loc.$T$P()) != null)) {
      return;
    }

    dbgs().$out_uint(getLine());
    if (getCol() != 0) {
      dbgs().$out_char($$COMMA).$out_uint(getCol());
    }
    {
      DebugLoc InlinedAtDL = null;
      try {
        InlinedAtDL = new DebugLoc(getInlinedAt());
        if (InlinedAtDL.$bool()) {
          dbgs().$out(/*KEEP_STR*/" @ ");
          InlinedAtDL.dump();
        } else {
          dbgs().$out(/*KEEP_STR*/$LF);
        }
      } finally {
        if (InlinedAtDL != null) { InlinedAtDL.$destroy(); }
      }
    }
  }


  /// \brief prints source location /path/to/file.exe:line:col @[inlined at]
  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp", line = 85,
   FQN="llvm::DebugLoc::print", NM="_ZNK4llvm8DebugLoc5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZNK4llvm8DebugLoc5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    if (!((Loc.$T$P()) != null)) {
      return;
    }

    // Print source line info.
    DIScope /*P*/ Scope = cast_DIScope(getScope());
    OS.$out(Scope.getFilename());
    OS.$out_char($$COLON).$out_uint(getLine());
    if (getCol() != 0) {
      OS.$out_char($$COLON).$out_uint(getCol());
    }
    {
      DebugLoc InlinedAtDL = null;
      try {

        InlinedAtDL = new DebugLoc(getInlinedAt());
        if (InlinedAtDL.$bool()) {
          OS.$out(/*KEEP_STR*/" @[ ");
          InlinedAtDL.print(OS);
          OS.$out(/*KEEP_STR*/" ]");
        }
      } finally {
        if (InlinedAtDL != null) { InlinedAtDL.$destroy(); }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DebugLoc::~DebugLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugLoc.h", line = 34,
   FQN="llvm::DebugLoc::~DebugLoc", NM="_ZN4llvm8DebugLocD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugLoc.cpp -nm=_ZN4llvm8DebugLocD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Loc.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "Loc=" + Loc; // NOI18N
  }
}
