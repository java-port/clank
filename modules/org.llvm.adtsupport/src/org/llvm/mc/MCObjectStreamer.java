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

package org.llvm.mc;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.ADTAliases.OptionalUInt;
import org.llvm.adt.aliases.*;
import static org.llvm.adt.java.ADTRTTI.*;
import org.llvm.mc.impl.MCObjectStreamerStatics;
import static org.llvm.mc.impl.MCObjectStreamerStatics.*;


/// \brief Streaming object file generation interface.
///
/// This class provides an implementation of the MCStreamer interface which is
/// suitable for use with the assembler backend. Specific object file formats
/// are expected to subclass this interface to implement directives specific
/// to that file format or custom semantics expected by the object writer
/// implementation.
//<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectStreamer.h", line = 36,
 FQN="llvm::MCObjectStreamer", NM="_ZN4llvm16MCObjectStreamerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamerE")
//</editor-fold>
public abstract class MCObjectStreamer extends /*public*/ MCStreamer implements Destructors.ClassWithDestructor {
  private MCAssembler /*P*/ Assembler;
  private ilist_iterator<MCFragment> CurInsertionPoint;
  private boolean EmitEHFrame;
  private boolean EmitDebugFrame;
  private SmallVector<MCSymbol /*P*/ > PendingLabels;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitInstToData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectStreamer.h", line = 43,
   FQN="llvm::MCObjectStreamer::EmitInstToData", NM="_ZN4llvm16MCObjectStreamer14EmitInstToDataERKNS_6MCInstERKNS_15MCSubtargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer14EmitInstToDataERKNS_6MCInstERKNS_15MCSubtargetInfoE")
  //</editor-fold>
  protected/*private*/ abstract /*virtual*/ void EmitInstToData(final /*const*/ MCInst /*&*/ Inst, final /*const*/ MCSubtargetInfo /*&*/ $Prm1)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitCFIStartProcImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 144,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 142,
   FQN="llvm::MCObjectStreamer::EmitCFIStartProcImpl", NM="_ZN4llvm16MCObjectStreamer20EmitCFIStartProcImplERNS_16MCDwarfFrameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer20EmitCFIStartProcImplERNS_16MCDwarfFrameInfoE")
  //</editor-fold>
  @Override protected/*private*/ void EmitCFIStartProcImpl(final MCDwarfFrameInfo /*&*/ Frame)/* override*/ {
    // We need to create a local symbol to avoid relocations.
    Frame.Begin = getContext().createTempSymbol();
    EmitLabel(Frame.Begin);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitCFIEndProcImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 150,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 148,
   FQN="llvm::MCObjectStreamer::EmitCFIEndProcImpl", NM="_ZN4llvm16MCObjectStreamer18EmitCFIEndProcImplERNS_16MCDwarfFrameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer18EmitCFIEndProcImplERNS_16MCDwarfFrameInfoE")
  //</editor-fold>
  @Override protected/*private*/ void EmitCFIEndProcImpl(final MCDwarfFrameInfo /*&*/ Frame)/* override*/ {
    Frame.End = getContext().createTempSymbol();
    EmitLabel(Frame.End);
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::MCObjectStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 27,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 26,
   FQN="llvm::MCObjectStreamer::MCObjectStreamer", NM="_ZN4llvm16MCObjectStreamerC1ERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamerC1ERNS_9MCContextERNS_12MCAsmBackendERNS_17raw_pwrite_streamEPNS_13MCCodeEmitterE")
  //</editor-fold>
  protected MCObjectStreamer(final MCContext /*&*/ Context, final MCAsmBackend /*&*/ TAB, 
      final raw_pwrite_stream /*&*/ OS, 
      MCCodeEmitter /*P*/ Emitter_) {
    // : MCStreamer(Context), Assembler(new MCAssembler(Context, TAB, *Emitter_, *TAB.createObjectWriter(OS))), CurInsertionPoint(), EmitEHFrame(true), EmitDebugFrame(false), PendingLabels() 
    //START JInit
    super(Context);
    this.Assembler = new MCAssembler(Context, TAB, $Deref(Emitter_), 
        $Deref(TAB.createObjectWriter(OS)));
    this.CurInsertionPoint = new ilist_iterator<MCFragment>(ilist_traitsMCFragment.$instance());
    this.EmitEHFrame = true;
    this.EmitDebugFrame = false;
    this.PendingLabels = new SmallVector<MCSymbol /*P*/ >(2, (MCSymbol /*P*/ )null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::~MCObjectStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 35,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 34,
   FQN="llvm::MCObjectStreamer::~MCObjectStreamer", NM="_ZN4llvm16MCObjectStreamerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamerD0Ev")
  //</editor-fold>
  @Override public/*protected*/ void $destroy()/* override*/ {
    if ($AddrOf(Assembler.getBackend()) != null) { $AddrOf(Assembler.getBackend()).$destroy();};
    if ($AddrOf(Assembler.getEmitter()) != null) { $AddrOf(Assembler.getEmitter()).$destroy();};
    if ($AddrOf(Assembler.getWriter()) != null) { $AddrOf(Assembler.getWriter()).$destroy();};
    if (Assembler != null) { Assembler.$destroy();};
    //START JDestroy
    PendingLabels.$destroy();
    super.$destroy();
    //END JDestroy
  }

/*public:*/
  /// state management
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 71,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 70,
   FQN="llvm::MCObjectStreamer::reset", NM="_ZN4llvm16MCObjectStreamer5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer5resetEv")
  //</editor-fold>
  @Override public void reset()/* override*/ {
    if ((Assembler != null)) {
      Assembler.reset();
    }
    CurInsertionPoint.$assignMove(new ilist_iterator<MCFragment>(ilist_traitsMCFragment.$instance()));
    EmitEHFrame = true;
    EmitDebugFrame = false;
    PendingLabels.clear();
    super.reset();
  }

  
  /// Object streamers require the integrated assembler.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::isIntegratedAssemblerRequired">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectStreamer.h", line = 57,
   FQN="llvm::MCObjectStreamer::isIntegratedAssemblerRequired", NM="_ZNK4llvm16MCObjectStreamer29isIntegratedAssemblerRequiredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZNK4llvm16MCObjectStreamer29isIntegratedAssemblerRequiredEv")
  //</editor-fold>
  @Override public boolean isIntegratedAssemblerRequired() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitFrames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 81,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 80,
   FQN="llvm::MCObjectStreamer::EmitFrames", NM="_ZN4llvm16MCObjectStreamer10EmitFramesEPNS_12MCAsmBackendE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer10EmitFramesEPNS_12MCAsmBackendE")
  //</editor-fold>
  public void EmitFrames(MCAsmBackend /*P*/ MAB) {
    if (!(getNumFrameInfos() != 0)) {
      return;
    }
    if (EmitEHFrame) {
      MCDwarfFrameEmitter.Emit(/*Deref*/this, MAB, true);
    }
    if (EmitDebugFrame) {
      MCDwarfFrameEmitter.Emit(/*Deref*/this, MAB, false);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitCFISections">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 117,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 116,
   FQN="llvm::MCObjectStreamer::EmitCFISections", NM="_ZN4llvm16MCObjectStreamer15EmitCFISectionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer15EmitCFISectionsEbb")
  //</editor-fold>
  @Override public void EmitCFISections(boolean EH, boolean Debug)/* override*/ {
    super.EmitCFISections(EH, Debug);
    EmitEHFrame = EH;
    EmitDebugFrame = Debug;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::getCurrentFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 92,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 91,
   FQN="llvm::MCObjectStreamer::getCurrentFragment", NM="_ZNK4llvm16MCObjectStreamer18getCurrentFragmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZNK4llvm16MCObjectStreamer18getCurrentFragmentEv")
  //</editor-fold>
  public MCFragment /*P*/ getCurrentFragment() /*const*/ {
    assert ((getCurrentSectionOnly() != null)) : "No current section!";
    if (CurInsertionPoint.$noteq(getCurrentSectionOnly().getFragmentList().begin())) {
      return $AddrOf(std.prev(new ilist_iterator<MCFragment>(CurInsertionPoint)).$star());
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectStreamer.h", line = 64,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectStreamer.h", old_line = 65,
   FQN="llvm::MCObjectStreamer::insert", NM="_ZN4llvm16MCObjectStreamer6insertEPNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer6insertEPNS_10MCFragmentE")
  //</editor-fold>
  public void insert(MCFragment /*P*/ F) {
    flushPendingLabels(F);
    MCSection /*P*/ CurSection = getCurrentSectionOnly();
    CurSection.getFragmentList().insert_ilist_iterator$NodeTy_T$P(new ilist_iterator<MCFragment>(CurInsertionPoint), F);
    F.setParent(CurSection);
  }

  
  /// Get a data fragment to write into, creating a new one if the current
  /// fragment is not a data fragment.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::getOrCreateDataFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 101,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 100,
   FQN="llvm::MCObjectStreamer::getOrCreateDataFragment", NM="_ZN4llvm16MCObjectStreamer23getOrCreateDataFragmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer23getOrCreateDataFragmentEv")
  //</editor-fold>
  public MCDataFragment /*P*/ getOrCreateDataFragment() {
    MCDataFragment /*P*/ F = dyn_cast_or_null_MCDataFragment(getCurrentFragment());
    // When bundling is enabled, we don't want to add data to a fragment that
    // already has instructions (see MCELFStreamer::EmitInstToData for details)
    if (!(F != null) || (Assembler.isBundlingEnabled() && !Assembler.getRelaxAll()
       && F.hasInstructions())) {
      F = new MCDataFragment();
      insert(F);
    }
    return F;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::changeSectionImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 201,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 199,
   FQN="llvm::MCObjectStreamer::changeSectionImpl", NM="_ZN4llvm16MCObjectStreamer17changeSectionImplEPNS_9MCSectionEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer17changeSectionImplEPNS_9MCSectionEPKNS_6MCExprE")
  //</editor-fold>
  protected boolean changeSectionImpl(MCSection /*P*/ Section, 
                   /*const*/ MCExpr /*P*/ Subsection) {
    assert ((Section != null)) : "Cannot switch to a null section!";
    flushPendingLabels((MCFragment /*P*/ )null);
    
    boolean Created = getAssembler().registerSection($Deref(Section));
    
    long$ref IntSubsection = create_long$ref(0);
    if ((Subsection != null)
       && !Subsection.evaluateAsAbsolute(IntSubsection, getAssembler())) {
      report_fatal_error($("Cannot evaluate subsection number"));
    }
    if (IntSubsection.$deref() < 0 || IntSubsection.$deref() > 8192) {
      report_fatal_error($("Subsection number out of range"));
    }
    CurInsertionPoint.$assignMove(
        Section.getSubsectionInsertionPoint(((/*uint*/int)($long2uint(IntSubsection.$deref()))))
    );
    return Created;
  }

  
  /// If any labels have been emitted but not assigned fragments, ensure that
  /// they get assigned, either to F if possible or to a new data fragment.
  /// Optionally, it is also possible to provide an offset \p FOffset, which
  /// will be used as a symbol offset within the fragment.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::flushPendingLabels">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 42,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 41,
   FQN="llvm::MCObjectStreamer::flushPendingLabels", NM="_ZN4llvm16MCObjectStreamer18flushPendingLabelsEPNS_10MCFragmentEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer18flushPendingLabelsEPNS_10MCFragmentEy")
  //</editor-fold>
  protected void flushPendingLabels(MCFragment /*P*/ F) {
    flushPendingLabels(F, $int2ulong(0));
  }
  protected void flushPendingLabels(MCFragment /*P*/ F, long/*uint64_t*/ FOffset/*= 0*/) {
    if (PendingLabels.empty()) {
      return;
    }
    if (!(F != null)) {
      F = new MCDataFragment();
      MCSection /*P*/ CurSection = getCurrentSectionOnly();
      CurSection.getFragmentList().insert_ilist_iterator$NodeTy_T$P(new ilist_iterator<MCFragment>(CurInsertionPoint), F);
      F.setParent(CurSection);
    }
    for (MCSymbol /*P*/ Sym : PendingLabels) {
      Sym.setFragment(F);
      Sym.setOffset(FOffset);
    }
    PendingLabels.clear();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::visitUsedSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 113,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 112,
   FQN="llvm::MCObjectStreamer::visitUsedSymbol", NM="_ZN4llvm16MCObjectStreamer15visitUsedSymbolERKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer15visitUsedSymbolERKNS_8MCSymbolE")
  //</editor-fold>
  @Override public void visitUsedSymbol(final /*const*/ MCSymbol /*&*/ Sym)/* override*/ {
    Assembler.registerSymbol(Sym);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::getAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectStreamer.h", line = 87,
   FQN="llvm::MCObjectStreamer::getAssembler", NM="_ZN4llvm16MCObjectStreamer12getAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer12getAssemblerEv")
  //</editor-fold>
  public MCAssembler /*&*/ getAssembler() {
    return $Deref(Assembler);
  }

  
  /// \name MCStreamer Interface
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 155,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 153,
   FQN="llvm::MCObjectStreamer::EmitLabel", NM="_ZN4llvm16MCObjectStreamer9EmitLabelEPNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer9EmitLabelEPNS_8MCSymbolE")
  //</editor-fold>
  @Override public void EmitLabel(MCSymbol /*P*/ Symbol)/* override*/ {
    super.EmitLabel(Symbol);
    
    getAssembler().registerSymbol($Deref(Symbol));
    
    // If there is a current fragment, mark the symbol as pointing into it.
    // Otherwise queue the label and set its fragment pointer when we emit the
    // next fragment.
    MCDataFragment /*P*/ F = dyn_cast_or_null_MCDataFragment(getCurrentFragment());
    if ((F != null) && !(getAssembler().isBundlingEnabled()
       && getAssembler().getRelaxAll())) {
      Symbol.setFragment(F);
      Symbol.setOffset($uint2ulong(F.getContents().size()));
    } else {
      PendingLabels.push_back(Symbol);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 219,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 217,
   FQN="llvm::MCObjectStreamer::EmitAssignment", NM="_ZN4llvm16MCObjectStreamer14EmitAssignmentEPNS_8MCSymbolEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer14EmitAssignmentEPNS_8MCSymbolEPKNS_6MCExprE")
  //</editor-fold>
  @Override public void EmitAssignment(MCSymbol /*P*/ Symbol, /*const*/ MCExpr /*P*/ Value)/* override*/ {
    getAssembler().registerSymbol($Deref(Symbol));
    super.EmitAssignment(Symbol, Value);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitValueImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 123,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 122,
   FQN="llvm::MCObjectStreamer::EmitValueImpl", NM="_ZN4llvm16MCObjectStreamer13EmitValueImplEPKNS_6MCExprEjNS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer13EmitValueImplEPKNS_6MCExprEjNS_5SMLocE")
  //</editor-fold>
  @Override public void EmitValueImpl(/*const*/ MCExpr /*P*/ Value, /*uint*/int Size)/* override*/ {
    EmitValueImpl(Value, Size, 
               new SMLoc());
  }
  @Override public void EmitValueImpl(/*const*/ MCExpr /*P*/ Value, /*uint*/int Size, 
               SMLoc Loc/*= SMLoc()*/)/* override*/ {
    super.EmitValueImpl(Value, Size, new SMLoc(Loc));
    MCDataFragment /*P*/ DF = getOrCreateDataFragment();
    flushPendingLabels(DF, $uint2ulong(DF.getContents().size()));
    
    MCCVLineEntry.Make(this);
    MCDwarfLineEntry.Make(this, getCurrentSection().first);
    
    // Avoid fixups when possible.
    long$ref AbsValue = create_long$ref();
    if (Value.evaluateAsAbsolute(AbsValue, getAssembler())) {
      EmitIntValue(AbsValue.$deref(), Size);
      return;
    }
    DF.getFixups().push_back(MCFixup.create(DF.getContents().size(), Value, 
            MCFixup.getKindForSize(Size, false), new SMLoc(Loc)));
    DF.getContents().resize(DF.getContents().size() + Size, (byte)0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitULEB128Value">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 173,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 171,
   FQN="llvm::MCObjectStreamer::EmitULEB128Value", NM="_ZN4llvm16MCObjectStreamer16EmitULEB128ValueEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer16EmitULEB128ValueEPKNS_6MCExprE")
  //</editor-fold>
  @Override public void EmitULEB128Value(/*const*/ MCExpr /*P*/ Value)/* override*/ {
    long$ref IntValue = create_long$ref();
    if (Value.evaluateAsAbsolute(IntValue, getAssembler())) {
      EmitULEB128IntValue(IntValue.$deref());
      return;
    }
    insert(new MCLEBFragment($Deref(Value), false));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitSLEB128Value">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 182,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 180,
   FQN="llvm::MCObjectStreamer::EmitSLEB128Value", NM="_ZN4llvm16MCObjectStreamer16EmitSLEB128ValueEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer16EmitSLEB128ValueEPKNS_6MCExprE")
  //</editor-fold>
  @Override public void EmitSLEB128Value(/*const*/ MCExpr /*P*/ Value)/* override*/ {
    long$ref IntValue = create_long$ref();
    if (Value.evaluateAsAbsolute(IntValue, getAssembler())) {
      EmitSLEB128IntValue(IntValue.$deref());
      return;
    }
    insert(new MCLEBFragment($Deref(Value), true));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitWeakReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 191,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 189,
   FQN="llvm::MCObjectStreamer::EmitWeakReference", NM="_ZN4llvm16MCObjectStreamer17EmitWeakReferenceEPNS_8MCSymbolEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer17EmitWeakReferenceEPNS_8MCSymbolEPKS1_")
  //</editor-fold>
  @Override public void EmitWeakReference(MCSymbol /*P*/ Alias, 
                   /*const*/ MCSymbol /*P*/ Symbol)/* override*/ {
    report_fatal_error($("This file format doesn't support weak aliases."));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::ChangeSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 196,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 194,
   FQN="llvm::MCObjectStreamer::ChangeSection", NM="_ZN4llvm16MCObjectStreamer13ChangeSectionEPNS_9MCSectionEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer13ChangeSectionEPNS_9MCSectionEPKNS_6MCExprE")
  //</editor-fold>
  @Override public void ChangeSection(MCSection /*P*/ Section, 
               /*const*/ MCExpr /*P*/ Subsection)/* override*/ {
    changeSectionImpl(Section, Subsection);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 228,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 226,
   FQN="llvm::MCObjectStreamer::EmitInstruction", NM="_ZN4llvm16MCObjectStreamer15EmitInstructionERKNS_6MCInstERKNS_15MCSubtargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer15EmitInstructionERKNS_6MCInstERKNS_15MCSubtargetInfoE")
  //</editor-fold>
  @Override public void EmitInstruction(final /*const*/ MCInst /*&*/ Inst, 
                 final /*const*/ MCSubtargetInfo /*&*/ STI)/* override*/ {
    super.EmitInstruction(Inst, STI);
    
    MCSection /*P*/ Sec = getCurrentSectionOnly();
    Sec.setHasInstructions(true);
    
    // Now that a machine instruction has been assembled into this section, make
    // a line entry for any .loc directive that has been seen.
    MCCVLineEntry.Make(this);
    MCDwarfLineEntry.Make(this, getCurrentSection().first);
    
    // If this instruction doesn't need relaxation, just emit it as data.
    final MCAssembler /*&*/ Assembler = getAssembler();
    if (!Assembler.getBackend().mayNeedRelaxation(Inst)) {
      EmitInstToData(Inst, STI);
      return;
    }
    
    // Otherwise, relax and emit it as data if either:
    // - The RelaxAll flag was passed
    // - Bundling is enabled and this instruction is inside a bundle-locked
    //   group. We want to emit all such instructions into the same data
    //   fragment.
    if (Assembler.getRelaxAll()
       || (Assembler.isBundlingEnabled() && Sec.isBundleLocked())) {
      MCInst Relaxed = null;
      try {
        Relaxed/*J*/= new MCInst();
        getAssembler().getBackend().relaxInstruction(Inst, STI, Relaxed);
        while (getAssembler().getBackend().mayNeedRelaxation(Relaxed)) {
          getAssembler().getBackend().relaxInstruction(Relaxed, STI, Relaxed);
        }
        EmitInstToData(Relaxed, STI);
        return;
      } finally {
        if (Relaxed != null) { Relaxed.$destroy(); }
      }
    }
    
    // Otherwise emit to a separate fragment.
    EmitInstToFragment(Inst, STI);
  }

  
  /// \brief Emit an instruction to a special fragment, because this instruction
  /// can change its size during relaxation.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitInstToFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 266,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 263,
   FQN="llvm::MCObjectStreamer::EmitInstToFragment", NM="_ZN4llvm16MCObjectStreamer18EmitInstToFragmentERKNS_6MCInstERKNS_15MCSubtargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer18EmitInstToFragmentERKNS_6MCInstERKNS_15MCSubtargetInfoE")
  //</editor-fold>
  public void EmitInstToFragment(final /*const*/ MCInst /*&*/ Inst, 
                    final /*const*/ MCSubtargetInfo /*&*/ STI) {
    raw_svector_ostream VecOS = null;
    try {
      if (getAssembler().getRelaxAll() && getAssembler().isBundlingEnabled()) {
        throw new llvm_unreachable("All instructions should have already been relaxed");
      }
      
      // Always create a new, separate fragment here, because its size can change
      // during relaxation.
      MCRelaxableFragment /*P*/ IF = new MCRelaxableFragment(Inst, STI);
      insert(IF);
      
      SmallString/*128*/ Code/*J*/= new SmallString/*128*/(128);
      VecOS/*J*/= new raw_svector_ostream(Code);
      getAssembler().getEmitter().encodeInstruction(Inst, VecOS, IF.getFixups(), 
          STI);
      IF.getContents().append_T(Code.begin(), Code.end());
    } finally {
      if (VecOS != null) { VecOS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitBundleAlignMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 288,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 285,
   FQN="llvm::MCObjectStreamer::EmitBundleAlignMode", NM="_ZN4llvm16MCObjectStreamer19EmitBundleAlignModeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer19EmitBundleAlignModeEj")
  //</editor-fold>
  @Override public void EmitBundleAlignMode(/*uint*/int AlignPow2)/* override*/ {
    throw new llvm_unreachable(Native.$toString(BundlingNotImplementedMsg));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitBundleLock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 292,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 289,
   FQN="llvm::MCObjectStreamer::EmitBundleLock", NM="_ZN4llvm16MCObjectStreamer14EmitBundleLockEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer14EmitBundleLockEb")
  //</editor-fold>
  @Override public void EmitBundleLock(boolean AlignToEnd)/* override*/ {
    throw new llvm_unreachable(Native.$toString(BundlingNotImplementedMsg));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitBundleUnlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 296,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 293,
   FQN="llvm::MCObjectStreamer::EmitBundleUnlock", NM="_ZN4llvm16MCObjectStreamer16EmitBundleUnlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer16EmitBundleUnlockEv")
  //</editor-fold>
  @Override public void EmitBundleUnlock()/* override*/ {
    throw new llvm_unreachable(Native.$toString(BundlingNotImplementedMsg));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 415,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 365,
   FQN="llvm::MCObjectStreamer::EmitBytes", NM="_ZN4llvm16MCObjectStreamer9EmitBytesENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer9EmitBytesENS_9StringRefE")
  //</editor-fold>
  @Override public void EmitBytes(StringRef Data)/* override*/ {
    MCCVLineEntry.Make(this);
    MCDwarfLineEntry.Make(this, getCurrentSection().first);
    MCDataFragment /*P*/ DF = getOrCreateDataFragment();
    flushPendingLabels(DF, $uint2ulong(DF.getContents().size()));
    DF.getContents().append_T(Data.begin(), Data.end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitValueToAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 423,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 372,
   FQN="llvm::MCObjectStreamer::EmitValueToAlignment", NM="_ZN4llvm16MCObjectStreamer20EmitValueToAlignmentEjxjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer20EmitValueToAlignmentEjxjj")
  //</editor-fold>
  @Override public void EmitValueToAlignment(/*uint*/int ByteAlignment)/* override*/ {
    EmitValueToAlignment(ByteAlignment, 
                      0, 
                      1, 
                      0);
  }
  @Override public void EmitValueToAlignment(/*uint*/int ByteAlignment, 
                      long/*int64_t*/ Value/*= 0*/)/* override*/ {
    EmitValueToAlignment(ByteAlignment, 
                      Value, 
                      1, 
                      0);
  }
  @Override public void EmitValueToAlignment(/*uint*/int ByteAlignment, 
                      long/*int64_t*/ Value/*= 0*/, 
                      /*uint*/int ValueSize/*= 1*/)/* override*/ {
    EmitValueToAlignment(ByteAlignment, 
                      Value, 
                      ValueSize, 
                      0);
  }
  @Override public void EmitValueToAlignment(/*uint*/int ByteAlignment, 
                      long/*int64_t*/ Value/*= 0*/, 
                      /*uint*/int ValueSize/*= 1*/, 
                      /*uint*/int MaxBytesToEmit/*= 0*/)/* override*/ {
    if (MaxBytesToEmit == 0) {
      MaxBytesToEmit = ByteAlignment;
    }
    insert(new MCAlignFragment(ByteAlignment, Value, ValueSize, MaxBytesToEmit));
    
    // Update the maximum alignment on the current section if necessary.
    MCSection /*P*/ CurSec = getCurrentSection().first;
    if ($greater_uint(ByteAlignment, CurSec.getAlignment())) {
      CurSec.setAlignment(ByteAlignment);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitCodeAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 437,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 386,
   FQN="llvm::MCObjectStreamer::EmitCodeAlignment", NM="_ZN4llvm16MCObjectStreamer17EmitCodeAlignmentEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer17EmitCodeAlignmentEjj")
  //</editor-fold>
  @Override public void EmitCodeAlignment(/*uint*/int ByteAlignment)/* override*/ {
    EmitCodeAlignment(ByteAlignment, 
                   0);
  }
  @Override public void EmitCodeAlignment(/*uint*/int ByteAlignment, 
                   /*uint*/int MaxBytesToEmit/*= 0*/)/* override*/ {
    EmitValueToAlignment(ByteAlignment, 0, 1, MaxBytesToEmit);
    cast_MCAlignFragment(getCurrentFragment()).setEmitNops(true);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::emitValueToOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 443,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 392,
   FQN="llvm::MCObjectStreamer::emitValueToOffset", NM="_ZN4llvm16MCObjectStreamer17emitValueToOffsetEPKNS_6MCExprEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer17emitValueToOffsetEPKNS_6MCExprEh")
  //</editor-fold>
  @Override public void emitValueToOffset(/*const*/ MCExpr /*P*/ Offset, 
                   /*uchar*/byte Value)/* override*/ {
    insert(new MCOrgFragment($Deref(Offset), Value));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitDwarfLocDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 300,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 297,
   FQN="llvm::MCObjectStreamer::EmitDwarfLocDirective", NM="_ZN4llvm16MCObjectStreamer21EmitDwarfLocDirectiveEjjjjjjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer21EmitDwarfLocDirectiveEjjjjjjNS_9StringRefE")
  //</editor-fold>
  @Override public void EmitDwarfLocDirective(/*uint*/int FileNo, /*uint*/int Line, 
                       /*uint*/int Column, /*uint*/int Flags, 
                       /*uint*/int Isa, 
                       /*uint*/int Discriminator, 
                       StringRef FileName)/* override*/ {
    // In case we see two .loc directives in a row, make sure the
    // first one gets a line entry.
    MCDwarfLineEntry.Make(this, getCurrentSection().first);
    
    /*J:ToBase*/super.EmitDwarfLocDirective(FileNo, Line, Column, Flags, 
        Isa, Discriminator, new StringRef(FileName));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitDwarfAdvanceLineAddr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 338,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 335,
   FQN="llvm::MCObjectStreamer::EmitDwarfAdvanceLineAddr", NM="_ZN4llvm16MCObjectStreamer24EmitDwarfAdvanceLineAddrExPKNS_8MCSymbolES3_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer24EmitDwarfAdvanceLineAddrExPKNS_8MCSymbolES3_j")
  //</editor-fold>
  public void EmitDwarfAdvanceLineAddr(long/*int64_t*/ LineDelta, 
                          /*const*/ MCSymbol /*P*/ LastLabel, 
                          /*const*/ MCSymbol /*P*/ Label, 
                          /*uint*/int PointerSize) {
    if (!(LastLabel != null)) {
      MCObjectStreamerStatics.emitDwarfSetLineAddr(/*Deref*/this, Assembler.getDWARFLinetableParams(), LineDelta, 
          Label, PointerSize);
      return;
    }
    /*const*/ MCExpr /*P*/ AddrDelta = MCObjectStreamerStatics.buildSymbolDiff(/*Deref*/this, Label, LastLabel);
    long$ref Res = create_long$ref();
    if (AddrDelta.evaluateAsAbsolute(Res, getAssembler())) {
      MCDwarfLineAddr.Emit(this, Assembler.getDWARFLinetableParams(), LineDelta, 
          Res.$deref());
      return;
    }
    insert(new MCDwarfLineAddrFragment(LineDelta, $Deref(AddrDelta)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitDwarfAdvanceFrameAddr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 357,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 354,
   FQN="llvm::MCObjectStreamer::EmitDwarfAdvanceFrameAddr", NM="_ZN4llvm16MCObjectStreamer25EmitDwarfAdvanceFrameAddrEPKNS_8MCSymbolES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer25EmitDwarfAdvanceFrameAddrEPKNS_8MCSymbolES3_")
  //</editor-fold>
  public void EmitDwarfAdvanceFrameAddr(/*const*/ MCSymbol /*P*/ LastLabel, 
                           /*const*/ MCSymbol /*P*/ Label) {
    /*const*/ MCExpr /*P*/ AddrDelta = MCObjectStreamerStatics.buildSymbolDiff(/*Deref*/this, Label, LastLabel);
    long$ref Res = create_long$ref();
    if (AddrDelta.evaluateAsAbsolute(Res, getAssembler())) {
      MCDwarfFrameEmitter.EmitAdvanceLoc(/*Deref*/this, Res.$deref());
      return;
    }
    insert(new MCDwarfCallFrameFragment($Deref(AddrDelta)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitCVLocDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 368,
   FQN="llvm::MCObjectStreamer::EmitCVLocDirective", NM="_ZN4llvm16MCObjectStreamer18EmitCVLocDirectiveEjjjjbbNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer18EmitCVLocDirectiveEjjjjbbNS_9StringRefE")
  //</editor-fold>
  @Override public void EmitCVLocDirective(/*uint*/int FunctionId, /*uint*/int FileNo, 
                    /*uint*/int Line, /*uint*/int Column, 
                    boolean PrologueEnd, boolean IsStmt, 
                    StringRef FileName)/* override*/ {
    // In case we see two .cv_loc directives in a row, make sure the
    // first one gets a line entry.
    MCCVLineEntry.Make(this);
    
    /*J:ToBase*/super.EmitCVLocDirective(FunctionId, FileNo, Line, Column, 
        PrologueEnd, IsStmt, new StringRef(FileName));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitCVLinetableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 380,
   FQN="llvm::MCObjectStreamer::EmitCVLinetableDirective", NM="_ZN4llvm16MCObjectStreamer24EmitCVLinetableDirectiveEjPKNS_8MCSymbolES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer24EmitCVLinetableDirectiveEjPKNS_8MCSymbolES3_")
  //</editor-fold>
  @Override public void EmitCVLinetableDirective(/*uint*/int FunctionId, 
                          /*const*/ MCSymbol /*P*/ Begin, 
                          /*const*/ MCSymbol /*P*/ End)/* override*/ {
    getContext().getCVContext().emitLineTableForFunction(/*Deref*/this, FunctionId, Begin, 
        End);
    /*J:ToBase*/super.EmitCVLinetableDirective(FunctionId, Begin, End);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitCVInlineLinetableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 388,
   FQN="llvm::MCObjectStreamer::EmitCVInlineLinetableDirective", NM="_ZN4llvm16MCObjectStreamer30EmitCVInlineLinetableDirectiveEjjjPKNS_8MCSymbolES3_NS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer30EmitCVInlineLinetableDirectiveEjjjPKNS_8MCSymbolES3_NS_8ArrayRefIjEE")
  //</editor-fold>
  @Override public void EmitCVInlineLinetableDirective(/*uint*/int PrimaryFunctionId, /*uint*/int SourceFileId, /*uint*/int SourceLineNum, 
                                /*const*/ MCSymbol /*P*/ FnStartSym, /*const*/ MCSymbol /*P*/ FnEndSym, 
                                ArrayRefUInt SecondaryFunctionIds)/* override*/ {
    getContext().getCVContext().emitInlineLineTableForFunction(/*Deref*/this, PrimaryFunctionId, SourceFileId, SourceLineNum, FnStartSym, 
        FnEndSym, new ArrayRefUInt(SecondaryFunctionIds));
    /*J:ToBase*/super.EmitCVInlineLinetableDirective(PrimaryFunctionId, SourceFileId, SourceLineNum, FnStartSym, FnEndSym, 
        new ArrayRefUInt(SecondaryFunctionIds));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitCVDefRangeDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 400,
   FQN="llvm::MCObjectStreamer::EmitCVDefRangeDirective", NM="_ZN4llvm16MCObjectStreamer23EmitCVDefRangeDirectiveENS_8ArrayRefISt4pairIPKNS_8MCSymbolES5_EEENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer23EmitCVDefRangeDirectiveENS_8ArrayRefISt4pairIPKNS_8MCSymbolES5_EEENS_9StringRefE")
  //</editor-fold>
  @Override public void EmitCVDefRangeDirective(ArrayRef<std.pairPtrPtr</*const*/ MCSymbol /*P*/ , /*const*/ MCSymbol /*P*/ >> Ranges, 
                         StringRef FixedSizePortion)/* override*/ {
    getContext().getCVContext().emitDefRange(/*Deref*/this, new ArrayRef<std.pairPtrPtr</*const*/ MCSymbol /*P*/ , /*const*/ MCSymbol /*P*/ >>(Ranges), new StringRef(FixedSizePortion));
    /*J:ToBase*/super.EmitCVDefRangeDirective(new ArrayRef<std.pairPtrPtr</*const*/ MCSymbol /*P*/ , /*const*/ MCSymbol /*P*/ >>(Ranges), new StringRef(FixedSizePortion));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitCVStringTableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 407,
   FQN="llvm::MCObjectStreamer::EmitCVStringTableDirective", NM="_ZN4llvm16MCObjectStreamer26EmitCVStringTableDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer26EmitCVStringTableDirectiveEv")
  //</editor-fold>
  @Override public void EmitCVStringTableDirective()/* override*/ {
    getContext().getCVContext().emitStringTable(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitCVFileChecksumsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 410,
   FQN="llvm::MCObjectStreamer::EmitCVFileChecksumsDirective", NM="_ZN4llvm16MCObjectStreamer28EmitCVFileChecksumsDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer28EmitCVFileChecksumsDirectiveEv")
  //</editor-fold>
  @Override public void EmitCVFileChecksumsDirective()/* override*/ {
    getContext().getCVContext().emitFileChecksums(/*Deref*/this);
  }

  
  // Associate GPRel32 fixup with data and resize data area
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitGPRel32Value">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 449,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 398,
   FQN="llvm::MCObjectStreamer::EmitGPRel32Value", NM="_ZN4llvm16MCObjectStreamer16EmitGPRel32ValueEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer16EmitGPRel32ValueEPKNS_6MCExprE")
  //</editor-fold>
  @Override public void EmitGPRel32Value(/*const*/ MCExpr /*P*/ Value)/* override*/ {
    MCDataFragment /*P*/ DF = getOrCreateDataFragment();
    flushPendingLabels(DF, $uint2ulong(DF.getContents().size()));
    
    DF.getFixups().push_back(MCFixup.create(DF.getContents().size(), 
            Value, MCFixupKind.FK_GPRel_4));
    DF.getContents().resize(DF.getContents().size() + 4, (byte)0);
  }

  
  // Associate GPRel32 fixup with data and resize data area
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitGPRel64Value">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 459,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 408,
   FQN="llvm::MCObjectStreamer::EmitGPRel64Value", NM="_ZN4llvm16MCObjectStreamer16EmitGPRel64ValueEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer16EmitGPRel64ValueEPKNS_6MCExprE")
  //</editor-fold>
  @Override public void EmitGPRel64Value(/*const*/ MCExpr /*P*/ Value)/* override*/ {
    MCDataFragment /*P*/ DF = getOrCreateDataFragment();
    flushPendingLabels(DF, $uint2ulong(DF.getContents().size()));
    
    DF.getFixups().push_back(MCFixup.create(DF.getContents().size(), 
            Value, MCFixupKind.FK_GPRel_4));
    DF.getContents().resize(DF.getContents().size() + 8, (byte)0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::EmitRelocDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 468,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 417,
   FQN="llvm::MCObjectStreamer::EmitRelocDirective", NM="_ZN4llvm16MCObjectStreamer18EmitRelocDirectiveERKNS_6MCExprENS_9StringRefEPS2_NS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer18EmitRelocDirectiveERKNS_6MCExprENS_9StringRefEPS2_NS_5SMLocE")
  //</editor-fold>
  @Override public boolean EmitRelocDirective(final /*const*/ MCExpr /*&*/ Offset, StringRef Name, 
                    /*const*/ MCExpr /*P*/ Expr, SMLoc Loc)/* override*/ {
    long$ref OffsetValue = create_long$ref();
    if (!Offset.evaluateAsAbsolute(OffsetValue)) {
      throw new llvm_unreachable("Offset is not absolute");
    }
    if (OffsetValue.$deref() < 0) {
      throw new llvm_unreachable("Offset is negative");
    }
    
    MCDataFragment /*P*/ DF = getOrCreateDataFragment();
    flushPendingLabels(DF, $uint2ulong(DF.getContents().size()));
    
    OptionalUInt MaybeKind = Assembler.getBackend().getFixupKind(new StringRef(Name));
    if (!MaybeKind.hasValue()) {
      return true;
    }
    
    /*MCFixupKind*//*uint*/int Kind = MaybeKind.$star();
    if (Expr == null) {
      Expr
         = MCSymbolRefExpr.create(getContext().createTempSymbol(), getContext());
    }
    DF.getFixups().push_back(MCFixup.create($long2uint(OffsetValue.$deref()), Expr, Kind, new SMLoc(Loc)));
    return false;
  }

  //JAVA: using MCStreamer::emitFill;
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::emitFill">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 493,
   FQN="llvm::MCObjectStreamer::emitFill", NM="_ZN4llvm16MCObjectStreamer8emitFillEyh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer8emitFillEyh")
  //</editor-fold>
  @Override public void emitFill(long/*uint64_t*/ NumBytes, byte/*uint8_t*/ FillValue)/* override*/ {
    /*const*/ MCSection /*P*/ Sec = getCurrentSection().first;
    ///*J:(void)*/Sec;
    assert ((Sec != null)) : "need a section";
    insert(new MCFillFragment(FillValue, NumBytes));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::emitFill">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 500,
   FQN="llvm::MCObjectStreamer::emitFill", NM="_ZN4llvm16MCObjectStreamer8emitFillERKNS_6MCExprEyNS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer8emitFillERKNS_6MCExprEyNS_5SMLocE")
  //</editor-fold>
  @Override public void emitFill(final /*const*/ MCExpr /*&*/ NumBytes, long/*uint64_t*/ FillValue)/* override*/ {
    emitFill(NumBytes, FillValue, 
          new SMLoc());
  }
  @Override public void emitFill(final /*const*/ MCExpr /*&*/ NumBytes, long/*uint64_t*/ FillValue, 
          SMLoc Loc/*= SMLoc()*/)/* override*/ {
    MCDataFragment /*P*/ DF = getOrCreateDataFragment();
    flushPendingLabels(DF, $uint2ulong(DF.getContents().size()));
    
    long$ref IntNumBytes = create_long$ref();
    if (!NumBytes.evaluateAsAbsolute(IntNumBytes, getAssembler())) {
      getContext().reportError(new SMLoc(Loc), new Twine(/*KEEP_STR*/"expected absolute expression"));
      return;
    }
    if (IntNumBytes.$deref() <= 0) {
      getContext().reportError(new SMLoc(Loc), new Twine(/*KEEP_STR*/"invalid number of bytes"));
      return;
    }
    
    emitFill(IntNumBytes.$deref(), $ulong2uchar(FillValue));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::emitFill">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 519,
   FQN="llvm::MCObjectStreamer::emitFill", NM="_ZN4llvm16MCObjectStreamer8emitFillERKNS_6MCExprExxNS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer8emitFillERKNS_6MCExprExxNS_5SMLocE")
  //</editor-fold>
  @Override public void emitFill(final /*const*/ MCExpr /*&*/ NumValues, long/*int64_t*/ Size, 
          long/*int64_t*/ Expr)/* override*/ {
    emitFill(NumValues, Size, 
          Expr, new SMLoc());
  }
  @Override public void emitFill(final /*const*/ MCExpr /*&*/ NumValues, long/*int64_t*/ Size, 
          long/*int64_t*/ Expr, SMLoc Loc/*= SMLoc()*/)/* override*/ {
    long$ref IntNumValues = create_long$ref();
    if (!NumValues.evaluateAsAbsolute(IntNumValues, getAssembler())) {
      getContext().reportError(new SMLoc(Loc), new Twine(/*KEEP_STR*/"expected absolute expression"));
      return;
    }
    if (IntNumValues.$deref() < 0) {
      getContext().getSourceManager().PrintMessage(new SMLoc(Loc), SourceMgr.DiagKind.DK_Warning, 
          new Twine(/*KEEP_STR*/"'.fill' directive with negative repeat count has no effect"));
      return;
    }
    
    super.emitFill(IntNumValues.$deref(), Size, Expr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::FinishImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 537,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 444,
   FQN="llvm::MCObjectStreamer::FinishImpl", NM="_ZN4llvm16MCObjectStreamer10FinishImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer10FinishImplEv")
  //</editor-fold>
  @Override public void FinishImpl()/* override*/ {
    // If we are generating dwarf for assembly source files dump out the sections.
    if (getContext().getGenDwarfForAssembly()) {
      MCGenDwarfInfo.Emit(this);
    }
    
    // Dump out the dwarf file & directory tables and line tables.
    MCDwarfLineTable.Emit(this, getAssembler().getDWARFLinetableParams());
    
    flushPendingLabels((MCFragment /*P*/ )null);
    getAssembler().Finish();
  }

  
  /// Emit the absolute difference between two symbols if possible.
  ///
  /// Emit the absolute difference between \c Hi and \c Lo, as long as we can
  /// compute it.  Currently, that requires that both symbols are in the same
  /// data fragment.  Otherwise, do nothing and return \c false.
  ///
  /// \pre Offset of \c Hi is greater than the offset \c Lo.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::emitAbsoluteSymbolDiff">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 58,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 57,
   FQN="llvm::MCObjectStreamer::emitAbsoluteSymbolDiff", NM="_ZN4llvm16MCObjectStreamer22emitAbsoluteSymbolDiffEPKNS_8MCSymbolES3_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZN4llvm16MCObjectStreamer22emitAbsoluteSymbolDiffEPKNS_8MCSymbolES3_j")
  //</editor-fold>
  @Override public void emitAbsoluteSymbolDiff(/*const*/ MCSymbol /*P*/ Hi, 
                        /*const*/ MCSymbol /*P*/ Lo, 
                        /*uint*/int Size)/* override*/ {
    // If not assigned to the same (valid) fragment, fallback.
    if (!(Hi.getFragment() != null) || Hi.getFragment() != Lo.getFragment()
       || Hi.isVariable() || Lo.isVariable()) {
      super.emitAbsoluteSymbolDiff(Hi, Lo, Size);
      return;
    }
    
    EmitIntValue(Hi.getOffset() - Lo.getOffset(), Size);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectStreamer::mayHaveInstructions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", line = 224,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp", old_line = 222,
   FQN="llvm::MCObjectStreamer::mayHaveInstructions", NM="_ZNK4llvm16MCObjectStreamer19mayHaveInstructionsERNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectStreamer.cpp -nm=_ZNK4llvm16MCObjectStreamer19mayHaveInstructionsERNS_9MCSectionE")
  //</editor-fold>
  @Override public boolean mayHaveInstructions(final MCSection /*&*/ Sec) /*const*//* override*/ {
    return Sec.hasInstructions();
  }

  
  @Override public String toString() {
    return "" + "Assembler=" + Assembler // NOI18N
              + ", CurInsertionPoint=" + CurInsertionPoint // NOI18N
              + ", EmitEHFrame=" + EmitEHFrame // NOI18N
              + ", EmitDebugFrame=" + EmitDebugFrame // NOI18N
              + ", PendingLabels=" + PendingLabels // NOI18N
              + super.toString(); // NOI18N
  }
}
