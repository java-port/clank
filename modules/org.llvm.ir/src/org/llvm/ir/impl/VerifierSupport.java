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

package org.llvm.ir.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.pass.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 86,
 FQN="(anonymous namespace)::VerifierSupport", NM="_ZN12_GLOBAL__N_115VerifierSupportE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_115VerifierSupportE")
//</editor-fold>
public class/*struct*/ VerifierSupport implements Destructors.ClassWithDestructor {
  public raw_ostream /*P*/ OS;
  public /*const*/ Module /*P*/ M/* = null*/;
  public Optional<ModuleSlotTracker> MST;
  
  /// Track the brokenness of the module while recursively visiting.
  public boolean Broken/* = false*/;
  /// Broken debug info can be "recovered" from by stripping the debug info.
  public boolean BrokenDebugInfo/* = false*/;
  /// Whether to treat broken debug info as an error.
  public boolean TreatBrokenDebugInfoAsError/* = true*/;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::VerifierSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 98,
   FQN="(anonymous namespace)::VerifierSupport::VerifierSupport", NM="_ZN12_GLOBAL__N_115VerifierSupportC1EPN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_115VerifierSupportC1EPN4llvm11raw_ostreamE")
  //</editor-fold>
  public /*explicit*/ VerifierSupport(raw_ostream /*P*/ OS) {
    // : OS(OS), M(null), MST(), Broken(false), BrokenDebugInfo(false), TreatBrokenDebugInfoAsError(true) 
    //START JInit
    this.OS = OS;
    /*InClass*/this.M = null;
    this.MST = new Optional<ModuleSlotTracker>();
    /*InClass*/this.Broken = false;
    /*InClass*/this.BrokenDebugInfo = false;
    /*InClass*/this.TreatBrokenDebugInfoAsError = true;
    //END JInit
  }

/*private:*/
  /*template <class NodeTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::Write">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 101,
   FQN="(anonymous namespace)::VerifierSupport::Write", NM="Tpl__ZN12_GLOBAL__N_115VerifierSupport5WriteERKN4llvm14ilist_iteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__ZN12_GLOBAL__N_115VerifierSupport5WriteERKN4llvm14ilist_iteratorIT_EE")
  //</editor-fold>
  private </*class*/ NodeTy extends ilist_node<NodeTy>> void Write$T(final /*const*/ ilist_iterator<NodeTy> /*&*/ I) {
    Write($AddrOf($Deref(I)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::Write">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 105,
   FQN="(anonymous namespace)::VerifierSupport::Write", NM="_ZN12_GLOBAL__N_115VerifierSupport5WriteEPKN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_115VerifierSupport5WriteEPKN4llvm6ModuleE")
  //</editor-fold>
  private void Write(/*const*/ Module /*P*/ M) {
    if (!(M != null)) {
      return;
    }
    $Deref(OS).$out(/*KEEP_STR*/"; ModuleID = '").$out(M.getModuleIdentifier()).$out(/*KEEP_STR*/"'\n");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::Write">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 111,
   FQN="(anonymous namespace)::VerifierSupport::Write", NM="_ZN12_GLOBAL__N_115VerifierSupport5WriteEPKN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_115VerifierSupport5WriteEPKN4llvm5ValueE")
  //</editor-fold>
  private void Write(/*const*/ Value /*P*/ V) {
    if (!(V != null)) {
      return;
    }
    if (isa_Instruction(V)) {
      V.print($Deref(OS), MST.$star());
      $Deref(OS).$out_char($$LF);
    } else {
      V.printAsOperand($Deref(OS), true, MST.$star());
      $Deref(OS).$out_char($$LF);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::Write">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 122,
   FQN="(anonymous namespace)::VerifierSupport::Write", NM="_ZN12_GLOBAL__N_115VerifierSupport5WriteEN4llvm17ImmutableCallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_115VerifierSupport5WriteEN4llvm17ImmutableCallSiteE")
  //</editor-fold>
  private void Write(ImmutableCallSite CS) {
    Write(CS.getInstruction());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::Write">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 126,
   FQN="(anonymous namespace)::VerifierSupport::Write", NM="_ZN12_GLOBAL__N_115VerifierSupport5WriteEPKN4llvm8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_115VerifierSupport5WriteEPKN4llvm8MetadataE")
  //</editor-fold>
  private void Write(/*const*/ Metadata /*P*/ MD) {
    if (!(MD != null)) {
      return;
    }
    MD.print($Deref(OS), MST.$star(), M);
    $Deref(OS).$out_char($$LF);
  }

  
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::Write">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 133,
   FQN="(anonymous namespace)::VerifierSupport::Write", NM="Tpl__ZN12_GLOBAL__N_115VerifierSupport5WriteERKN4llvm24MDTupleTypedArrayWrapperIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__ZN12_GLOBAL__N_115VerifierSupport5WriteERKN4llvm24MDTupleTypedArrayWrapperIT_EE")
  //</editor-fold>
  private </*class*/ T> void Write$T(final /*const*/ MDTupleTypedArrayWrapper<T> /*&*/ MD) {
    Write(MD.get());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::Write">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 137,
   FQN="(anonymous namespace)::VerifierSupport::Write", NM="_ZN12_GLOBAL__N_115VerifierSupport5WriteEPKN4llvm11NamedMDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_115VerifierSupport5WriteEPKN4llvm11NamedMDNodeE")
  //</editor-fold>
  private void Write(/*const*/ NamedMDNode /*P*/ NMD) {
    if (!(NMD != null)) {
      return;
    }
    NMD.print($Deref(OS), MST.$star());
    $Deref(OS).$out_char($$LF);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::Write">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 144,
   FQN="(anonymous namespace)::VerifierSupport::Write", NM="_ZN12_GLOBAL__N_115VerifierSupport5WriteEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_115VerifierSupport5WriteEPN4llvm4TypeE")
  //</editor-fold>
  private void Write(Type /*P*/ T) {
    if (!(T != null)) {
      return;
    }
    IrLlvmGlobals.$out_raw_ostream_Type($Deref(OS).$out_char($$SPACE), $Deref(T));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::Write">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 150,
   FQN="(anonymous namespace)::VerifierSupport::Write", NM="_ZN12_GLOBAL__N_115VerifierSupport5WriteEPKN4llvm6ComdatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_115VerifierSupport5WriteEPKN4llvm6ComdatE")
  //</editor-fold>
  private void Write(/*const*/ Comdat /*P*/ C) {
    if (!(C != null)) {
      return;
    }
    IrLlvmGlobals.$out_raw_ostream_Comdat$C($Deref(OS), $Deref(C));
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::Write">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 156,
   FQN="(anonymous namespace)::VerifierSupport::Write", NM="Tpl__ZN12_GLOBAL__N_115VerifierSupport5WriteEN4llvm8ArrayRefIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__ZN12_GLOBAL__N_115VerifierSupport5WriteEN4llvm8ArrayRefIT_EE")
  //</editor-fold>
  private </*typename*/ T> void Write$T(ArrayRef<T> Vs) {
    for (final /*const*/ T /*&*/ V : Vs)  {
      Write(V);
    }
  }

  
  /*template <typename T1, typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::WriteTs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 162,
   FQN="(anonymous namespace)::VerifierSupport::WriteTs", NM="Tpl__ZN12_GLOBAL__N_115VerifierSupport7WriteTsERKT_DpRKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__ZN12_GLOBAL__N_115VerifierSupport7WriteTsERKT_DpRKT0_")
  //</editor-fold>
  private </*typename*/ T1, /*typename*/ /*...*/ Ts> void WriteTs(final /*const*/ T1 /*&*/ V1, /*const*/ Ts /*&*/ ...Vs) {
    Write(V1);
    for (Ts V : Vs) {
      WriteTs(V);
    }
  }

  
  /*template <typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::WriteTs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 167,
   FQN="(anonymous namespace)::VerifierSupport::WriteTs", NM="Tpl__ZN12_GLOBAL__N_115VerifierSupport7WriteTsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__ZN12_GLOBAL__N_115VerifierSupport7WriteTsEv")
  //</editor-fold>
  private </*typename*/ /*...*/ Ts> void WriteTs() {
  }

/*public:*/
  /// \brief A check failed, so printout out the condition and the message.
  ///
  /// This provides a nice place to put a breakpoint if you want to see why
  /// something is not correct.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::CheckFailed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 174,
   FQN="(anonymous namespace)::VerifierSupport::CheckFailed", NM="_ZN12_GLOBAL__N_115VerifierSupport11CheckFailedERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_115VerifierSupport11CheckFailedERKN4llvm5TwineE")
  //</editor-fold>
  public void CheckFailed(final /*const*/ Twine /*&*/ Message) {
    if ((OS != null)) {
      $out_raw_ostream_Twine$C($Deref(OS), Message).$out_char($$LF);
    }
    Broken = true;
  }

  
  /// \brief A check failed (with values to print).
  ///
  /// This calls the Message-only version so that the above is easier to set a
  /// breakpoint on.
  /*template <typename T1, typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::CheckFailed">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 185,
   FQN="(anonymous namespace)::VerifierSupport::CheckFailed", NM="Tpl__ZN12_GLOBAL__N_115VerifierSupport11CheckFailedERKN4llvm5TwineERKT_DpRKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__ZN12_GLOBAL__N_115VerifierSupport11CheckFailedERKN4llvm5TwineERKT_DpRKT0_")
  //</editor-fold>
  public </*typename*/ T1, /*typename*/ /*...*/ Ts> void CheckFailed$T(final /*const*/ Twine /*&*/ Message, final /*const*/ T1 /*&*/ V1, /*const*/ Ts /*&*/ ...Vs) {
    CheckFailed(Message);
    if ((OS != null)) {
      WriteTs(V1, Vs);
    }
  }

  
  /// A debug info check failed.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::DebugInfoCheckFailed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 192,
   FQN="(anonymous namespace)::VerifierSupport::DebugInfoCheckFailed", NM="_ZN12_GLOBAL__N_115VerifierSupport20DebugInfoCheckFailedERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_115VerifierSupport20DebugInfoCheckFailedERKN4llvm5TwineE")
  //</editor-fold>
  public void DebugInfoCheckFailed(final /*const*/ Twine /*&*/ Message) {
    if ((OS != null)) {
      $out_raw_ostream_Twine$C($Deref(OS), Message).$out_char($$LF);
    }
    Broken |= TreatBrokenDebugInfoAsError;
    BrokenDebugInfo = true;
  }

  
  /// A debug info check failed (with values to print).
  /*template <typename T1, typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::DebugInfoCheckFailed">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 201,
   FQN="(anonymous namespace)::VerifierSupport::DebugInfoCheckFailed", NM="Tpl__ZN12_GLOBAL__N_115VerifierSupport20DebugInfoCheckFailedERKN4llvm5TwineERKT_DpRKT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__ZN12_GLOBAL__N_115VerifierSupport20DebugInfoCheckFailedERKN4llvm5TwineERKT_DpRKT0_")
  //</editor-fold>
  public </*typename*/ T1, /*typename*/ /*...*/ Ts> void DebugInfoCheckFailed$T(final /*const*/ Twine /*&*/ Message, final /*const*/ T1 /*&*/ V1, 
                        /*const*/ Ts /*&*/ ...Vs) {
    DebugInfoCheckFailed(Message);
    if ((OS != null)) {
      WriteTs(V1, Vs);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VerifierSupport::~VerifierSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 86,
   FQN="(anonymous namespace)::VerifierSupport::~VerifierSupport", NM="_ZN12_GLOBAL__N_115VerifierSupportD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN12_GLOBAL__N_115VerifierSupportD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    MST.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private <T> void Write(T t) {
    if (t instanceof Module) {
      Write((Module)t);
    } else if (t instanceof Value) {
      Write((Value)t);
    } else if (t instanceof ImmutableCallSite) {
      Write((ImmutableCallSite)t);
    } else if (t instanceof Metadata) {
      Write((Metadata)t);
    } else if (t instanceof NamedMDNode) {
      Write((NamedMDNode)t);
    } else if (t instanceof Type) {
      Write((Type)t);
    } else if (t instanceof Comdat) {
      Write((Comdat)t);
    }
    throw new UnsupportedOperationException("EmptyBody: Write(" + t.getClass().getName() + ")");
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + ", M=" + M // NOI18N
              + ", MST=" + MST // NOI18N
              + ", Broken=" + Broken // NOI18N
              + ", BrokenDebugInfo=" + BrokenDebugInfo // NOI18N
              + ", TreatBrokenDebugInfoAsError=" + TreatBrokenDebugInfoAsError; // NOI18N
  }
}
