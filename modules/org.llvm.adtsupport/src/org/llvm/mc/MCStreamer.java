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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.adt.java.ADTRTTI.*;
import org.llvm.mc.impl.MCStreamerStatics;
import static org.llvm.support.AdtsupportLlvmGlobals.encodeSLEB128;
import static org.llvm.support.AdtsupportLlvmGlobals.encodeULEB128;
import org.llvm.support.target.Win64EH;


/// \brief Streaming machine code generation interface.
///
/// This interface is intended to provide a programatic interface that is very
/// similar to the level that an assembler .s file provides.  It has callbacks
/// to emit bytes, handle directives, etc.  The implementation of this interface
/// retains state to know what the current section is etc.
///
/// There are multiple implementations of this interface: one for writing out
/// a .s file, and implementations that write out .o files of various formats.
///
//<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 161,
 FQN="llvm::MCStreamer", NM="_ZN4llvm10MCStreamerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamerE")
//</editor-fold>
public abstract class MCStreamer implements Destructors.ClassWithDestructor {
  private final MCContext /*&*/ Context;
  private std.unique_ptr<MCTargetStreamer> TargetStreamer;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::MCStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 165,
   FQN="llvm::MCStreamer::MCStreamer", NM="_ZN4llvm10MCStreamerC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamerC1ERKS0_")
  //</editor-fold>
  protected/*private*/ MCStreamer(final /*const*/ MCStreamer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 166,
   FQN="llvm::MCStreamer::operator=", NM="_ZN4llvm10MCStreameraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreameraSERKS0_")
  //</editor-fold>
  protected/*private*/ MCStreamer /*&*/ $assign(final /*const*/ MCStreamer /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  private std.vector<MCDwarfFrameInfo> DwarfFrameInfos;
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getCurrentDwarfFrameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 185,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 171,
   FQN="llvm::MCStreamer::getCurrentDwarfFrameInfo", NM="_ZN4llvm10MCStreamer24getCurrentDwarfFrameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer24getCurrentDwarfFrameInfoEv")
  //</editor-fold>
  private MCDwarfFrameInfo /*P*/ getCurrentDwarfFrameInfo() {
    if (DwarfFrameInfos.empty()) {
      return null;
    }
    return $AddrOf(DwarfFrameInfos.back());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EnsureValidDwarfFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 196,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 177,
   FQN="llvm::MCStreamer::EnsureValidDwarfFrame", NM="_ZN4llvm10MCStreamer21EnsureValidDwarfFrameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer21EnsureValidDwarfFrameEv")
  //</editor-fold>
  private void EnsureValidDwarfFrame() {
    MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
    if (!(CurFrame != null) || (CurFrame.End != null)) {
      report_fatal_error($("No open frame"));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFICommon">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 295,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 252,
   FQN="llvm::MCStreamer::EmitCFICommon", NM="_ZN4llvm10MCStreamer13EmitCFICommonEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer13EmitCFICommonEv")
  //</editor-fold>
  private MCSymbol /*P*/ EmitCFICommon() {
    EnsureValidDwarfFrame();
    MCSymbol /*P*/ Label = getContext().createTempSymbol();
    EmitLabel(Label);
    return Label;
  }

  
  private std.vector<WinEH.FrameInfo /*P*/ > WinFrameInfos;
  private WinEH.FrameInfo /*P*/ CurrentWinFrameInfo;
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EnsureValidWinFrameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 443,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 400,
   FQN="llvm::MCStreamer::EnsureValidWinFrameInfo", NM="_ZN4llvm10MCStreamer23EnsureValidWinFrameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer23EnsureValidWinFrameInfoEv")
  //</editor-fold>
  private void EnsureValidWinFrameInfo() {
    /*const*/ MCAsmInfo /*P*/ MAI = Context.getAsmInfo();
    if (!MAI.usesWindowsCFI()) {
      report_fatal_error($(".seh_* directives are not supported on this target"));
    }
    if (!(CurrentWinFrameInfo != null) || (CurrentWinFrameInfo.End != null)) {
      report_fatal_error($("No open Win64 EH frame function!"));
    }
  }

  
  /// \brief Tracks an index to represent the order a symbol was emitted in.
  /// Zero means we did not emit that symbol.
  private DenseMapTypeUInt</*const*/ MCSymbol /*P*/> SymbolOrdering;
  
  /// \brief This is stack of current and previous section values saved by
  /// PushSection.
  private SmallVector<std.pairTypeType<std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>, std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>>> SectionStack;
  
  /// The next unique ID to use when creating a WinCFI-related section (.pdata
  /// or .xdata). This ID ensures that we have a one-to-one mapping from
  /// code section to unwind info section, which MSVC's incremental linker
  /// requires.
  private /*uint*/int NextWinCFIID/* = 0*/;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::MCStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 45,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 43,
   FQN="llvm::MCStreamer::MCStreamer", NM="_ZN4llvm10MCStreamerC1ERNS_9MCContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamerC1ERNS_9MCContextE")
  //</editor-fold>
  protected MCStreamer(final MCContext /*&*/ Ctx) {
    // : Context(Ctx), TargetStreamer(), DwarfFrameInfos(), WinFrameInfos(), CurrentWinFrameInfo(null), SymbolOrdering(), SectionStack(), NextWinCFIID(0) 
    //START JInit
    this./*&*/Context=/*&*/Ctx;
    this.TargetStreamer = new std.unique_ptr<MCTargetStreamer>();
    this.DwarfFrameInfos = new std.vector<MCDwarfFrameInfo>(new MCDwarfFrameInfo());
    this.WinFrameInfos = new std.vector<WinEH.FrameInfo /*P*/ >((WinEH.FrameInfo /*P*/ )null);
    this.CurrentWinFrameInfo = null;
    this.SymbolOrdering = new DenseMapTypeUInt</*const*/ MCSymbol /*P*/>(DenseMapInfo$LikePtr.$Info(), 0);
    this.SectionStack = new SmallVector<std.pairTypeType<std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>, std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>>>(4, new std.pairTypeType<std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>, std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>>());
    /*InClass*/this.NextWinCFIID = 0;
    //END JInit
    SectionStack.push_back(new std.pairTypeType<std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>, std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>>());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIStartProcImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 280,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 237,
   FQN="llvm::MCStreamer::EmitCFIStartProcImpl", NM="_ZN4llvm10MCStreamer20EmitCFIStartProcImplERNS_16MCDwarfFrameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer20EmitCFIStartProcImplERNS_16MCDwarfFrameInfoE")
  //</editor-fold>
  protected void EmitCFIStartProcImpl(final MCDwarfFrameInfo /*&*/ Frame) {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIEndProcImpl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 289,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 246,
   FQN="llvm::MCStreamer::EmitCFIEndProcImpl", NM="_ZN4llvm10MCStreamer18EmitCFIEndProcImplERNS_16MCDwarfFrameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer18EmitCFIEndProcImplERNS_16MCDwarfFrameInfoE")
  //</editor-fold>
  protected void EmitCFIEndProcImpl(final MCDwarfFrameInfo /*&*/ Frame) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getCurrentWinFrameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 198,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 192,
   FQN="llvm::MCStreamer::getCurrentWinFrameInfo", NM="_ZN4llvm10MCStreamer22getCurrentWinFrameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer22getCurrentWinFrameInfoEv")
  //</editor-fold>
  protected WinEH.FrameInfo /*P*/ getCurrentWinFrameInfo() {
    return CurrentWinFrameInfo;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWindowsUnwindTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 667,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 590,
   FQN="llvm::MCStreamer::EmitWindowsUnwindTables", NM="_ZN4llvm10MCStreamer23EmitWindowsUnwindTablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer23EmitWindowsUnwindTablesEv")
  //</editor-fold>
  protected void EmitWindowsUnwindTables() {
  }

  
  
  /// EmitRawText - If this file is backed by an assembly streamer, this dumps
  /// the specified string in the output .s file.  This capability is
  /// indicated by the hasRawTextSupport() predicate.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitRawTextImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 656,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 579,
   FQN="llvm::MCStreamer::EmitRawTextImpl", NM="_ZN4llvm10MCStreamer15EmitRawTextImplENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer15EmitRawTextImplENS_9StringRefE")
  //</editor-fold>
  protected void EmitRawTextImpl(StringRef String) {
    errs().$out(/*KEEP_STR*/"EmitRawText called on an MCStreamer that doesn't support it,  something must not be fully mc'ized\n");
    abort();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::~MCStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 50,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 48,
   FQN="llvm::MCStreamer::~MCStreamer", NM="_ZN4llvm10MCStreamerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamerD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (/*uint*/int i = 0; $less_uint(i, getNumWinFrameInfos()); ++i)  {
      if (WinFrameInfos.$at(i) != null) { WinFrameInfos.$at(i).$destroy();};
    }
    //START JDestroy
    SectionStack.$destroy();
    SymbolOrdering.$destroy();
    WinFrameInfos.$destroy();
    DwarfFrameInfos.$destroy();
    TargetStreamer.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::visitUsedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 698,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 621,
   FQN="llvm::MCStreamer::visitUsedExpr", NM="_ZN4llvm10MCStreamer13visitUsedExprERKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer13visitUsedExprERKNS_6MCExprE")
  //</editor-fold>
  public void visitUsedExpr(final /*const*/ MCExpr /*&*/ Expr) {
    switch ((MCExpr.ExprKind)Expr.getKind()) {
     case Target:
      cast_MCTargetExpr(Expr).visitUsedExpr(/*Deref*/this);
      break;
     case Constant:
      break;
     case Binary:
      {
        final /*const*/ MCBinaryExpr /*&*/ BE = cast_MCBinaryExpr(Expr);
        visitUsedExpr($Deref(BE.getLHS()));
        visitUsedExpr($Deref(BE.getRHS()));
        break;
      }
     case SymbolRef:
      visitUsedSymbol(cast_MCSymbolRefExpr(Expr).getSymbol());
      break;
     case Unary:
      visitUsedExpr($Deref(cast_MCUnaryExpr(Expr).getSubExpr()));
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::visitUsedSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 695,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 618,
   FQN="llvm::MCStreamer::visitUsedSymbol", NM="_ZN4llvm10MCStreamer15visitUsedSymbolERKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer15visitUsedSymbolERKNS_8MCSymbolE")
  //</editor-fold>
  public void visitUsedSymbol(final /*const*/ MCSymbol /*&*/ Sym) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::setTargetStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 212,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 206,
   FQN="llvm::MCStreamer::setTargetStreamer", NM="_ZN4llvm10MCStreamer17setTargetStreamerEPNS_16MCTargetStreamerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer17setTargetStreamerEPNS_16MCTargetStreamerE")
  //</editor-fold>
  public void setTargetStreamer(MCTargetStreamer /*P*/ TS) {
    TargetStreamer.reset(TS);
  }

  
  /// State management
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 55,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 53,
   FQN="llvm::MCStreamer::reset", NM="_ZN4llvm10MCStreamer5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer5resetEv")
  //</editor-fold>
  public void reset() {
    DwarfFrameInfos.clear();
    for (/*uint*/int i = 0; $less_uint(i, getNumWinFrameInfos()); ++i)  {
      if (WinFrameInfos.$at(i) != null) { WinFrameInfos.$at(i).$destroy();};
    }
    WinFrameInfos.clear();
    CurrentWinFrameInfo = null;
    SymbolOrdering.clear();
    SectionStack.clear();
    SectionStack.push_back(new std.pairTypeType<std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>, std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>>());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 220,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 214,
   FQN="llvm::MCStreamer::getContext", NM="_ZNK4llvm10MCStreamer10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZNK4llvm10MCStreamer10getContextEv")
  //</editor-fold>
  public MCContext /*&*/ getContext() /*const*/ {
    return Context;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getTargetStreamer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 222,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 216,
   FQN="llvm::MCStreamer::getTargetStreamer", NM="_ZN4llvm10MCStreamer17getTargetStreamerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer17getTargetStreamerEv")
  //</editor-fold>
  public MCTargetStreamer /*P*/ getTargetStreamer() {
    return TargetStreamer.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getNumFrameInfos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 226,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 220,
   FQN="llvm::MCStreamer::getNumFrameInfos", NM="_ZN4llvm10MCStreamer16getNumFrameInfosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16getNumFrameInfosEv")
  //</editor-fold>
  public /*uint*/int getNumFrameInfos() {
    return DwarfFrameInfos.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getDwarfFrameInfos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 227,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 221,
   FQN="llvm::MCStreamer::getDwarfFrameInfos", NM="_ZNK4llvm10MCStreamer18getDwarfFrameInfosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZNK4llvm10MCStreamer18getDwarfFrameInfosEv")
  //</editor-fold>
  public ArrayRef<MCDwarfFrameInfo> getDwarfFrameInfos() /*const*/ {
    return new ArrayRef<MCDwarfFrameInfo>(DwarfFrameInfos, false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::hasUnfinishedDwarfFrameInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 191,
   FQN="llvm::MCStreamer::hasUnfinishedDwarfFrameInfo", NM="_ZN4llvm10MCStreamer27hasUnfinishedDwarfFrameInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer27hasUnfinishedDwarfFrameInfoEv")
  //</editor-fold>
  public boolean hasUnfinishedDwarfFrameInfo() {
    MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
    return (CurFrame != null) && !(CurFrame.End != null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getNumWinFrameInfos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 233,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 225,
   FQN="llvm::MCStreamer::getNumWinFrameInfos", NM="_ZN4llvm10MCStreamer19getNumWinFrameInfosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer19getNumWinFrameInfosEv")
  //</editor-fold>
  public /*uint*/int getNumWinFrameInfos() {
    return WinFrameInfos.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getWinFrameInfos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 234,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 226,
   FQN="llvm::MCStreamer::getWinFrameInfos", NM="_ZNK4llvm10MCStreamer16getWinFrameInfosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZNK4llvm10MCStreamer16getWinFrameInfosEv")
  //</editor-fold>
  public ArrayRef<WinEH.FrameInfo /*P*/ > getWinFrameInfos() /*const*/ {
    return new ArrayRef<WinEH.FrameInfo /*P*/ >(WinFrameInfos, true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::generateCompactUnwindEncodings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 76,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 71,
   FQN="llvm::MCStreamer::generateCompactUnwindEncodings", NM="_ZN4llvm10MCStreamer30generateCompactUnwindEncodingsEPNS_12MCAsmBackendE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer30generateCompactUnwindEncodingsEPNS_12MCAsmBackendE")
  //</editor-fold>
  public void generateCompactUnwindEncodings(MCAsmBackend /*P*/ MAB) {
    for (final MCDwarfFrameInfo /*&*/ FI : DwarfFrameInfos)  {
      FI.CompactUnwindEncoding
         = ((MAB != null) ? MAB.generateCompactUnwindEncoding(new ArrayRef<MCCFIInstruction>(FI.Instructions, false)) : 0);
    }
  }

  
  /// \name Assembly File Formatting.
  /// @{
  
  /// \brief Return true if this streamer supports verbose assembly and if it is
  /// enabled.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::isVerboseAsm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 245,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 237,
   FQN="llvm::MCStreamer::isVerboseAsm", NM="_ZNK4llvm10MCStreamer12isVerboseAsmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZNK4llvm10MCStreamer12isVerboseAsmEv")
  //</editor-fold>
  public /*virtual*/ boolean isVerboseAsm() /*const*/ {
    return false;
  }

  
  /// \brief Return true if this asm streamer supports emitting unformatted text
  /// to the .s file with EmitRawText.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::hasRawTextSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 249,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 241,
   FQN="llvm::MCStreamer::hasRawTextSupport", NM="_ZNK4llvm10MCStreamer17hasRawTextSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZNK4llvm10MCStreamer17hasRawTextSupportEv")
  //</editor-fold>
  public /*virtual*/ boolean hasRawTextSupport() /*const*/ {
    return false;
  }

  
  /// \brief Is the integrated assembler required for this streamer to function
  /// correctly?
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::isIntegratedAssemblerRequired">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 253,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 245,
   FQN="llvm::MCStreamer::isIntegratedAssemblerRequired", NM="_ZNK4llvm10MCStreamer29isIntegratedAssemblerRequiredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZNK4llvm10MCStreamer29isIntegratedAssemblerRequiredEv")
  //</editor-fold>
  public /*virtual*/ boolean isIntegratedAssemblerRequired() /*const*/ {
    return false;
  }

  
  /// \brief Add a textual comment.
  ///
  /// Typically for comments that can be emitted to the generated .s
  /// file if applicable as a QoI issue to make the output of the compiler
  /// more readable.  This only affects the MCAsmStreamer, and only when
  /// verbose assembly output is enabled.
  ///
  /// If the comment includes embedded \n's, they will each get the comment
  /// prefix as appropriate.  The added comment should not end with a \n.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::AddComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 264,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 256,
   FQN="llvm::MCStreamer::AddComment", NM="_ZN4llvm10MCStreamer10AddCommentERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer10AddCommentERKNS_5TwineE")
  //</editor-fold>
  public /*virtual*/ void AddComment(final /*const*/ Twine /*&*/ T) {
  }

  
  /// \brief Return a raw_ostream that comments can be written to. Unlike
  /// AddComment, you are required to terminate comments with \n if you use this
  /// method.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::GetCommentOS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 66,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 64,
   FQN="llvm::MCStreamer::GetCommentOS", NM="_ZN4llvm10MCStreamer12GetCommentOSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer12GetCommentOSEv")
  //</editor-fold>
  public raw_ostream /*&*/ GetCommentOS() {
    // By default, discard comments.
    return nulls();
  }

  
  /// \brief Print T and prefix it with the comment string (normally #) and
  /// optionally a tab. This prints the comment immediately, not at the end of
  /// the current line. It is basically a safe version of EmitRawText: since it
  /// only prints comments, the object streamer ignores it instead of asserting.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::emitRawComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 71,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 69,
   FQN="llvm::MCStreamer::emitRawComment", NM="_ZN4llvm10MCStreamer14emitRawCommentERKNS_5TwineEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer14emitRawCommentERKNS_5TwineEb")
  //</editor-fold>
  public void emitRawComment(final /*const*/ Twine /*&*/ T) {
    emitRawComment(T, true);
  }
  public void emitRawComment(final /*const*/ Twine /*&*/ T, boolean TabPrefix/*= true*/) {
  }

  
  /// \brief Add explicit comment T. T is required to be a valid
  /// comment in the output and does not need to be escaped.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::addExplicitComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 73,
   FQN="llvm::MCStreamer::addExplicitComment", NM="_ZN4llvm10MCStreamer18addExplicitCommentERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer18addExplicitCommentERKNS_5TwineE")
  //</editor-fold>
  public void addExplicitComment(final /*const*/ Twine /*&*/ T) {
  }

  /// \brief Emit added explicit comments.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::emitExplicitComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 74,
   FQN="llvm::MCStreamer::emitExplicitComments", NM="_ZN4llvm10MCStreamer20emitExplicitCommentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer20emitExplicitCommentsEv")
  //</editor-fold>
  public void emitExplicitComments() {
  }

  
  /// AddBlankLine - Emit a blank line to a .s file to pretty it up.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::AddBlankLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 284,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 270,
   FQN="llvm::MCStreamer::AddBlankLine", NM="_ZN4llvm10MCStreamer12AddBlankLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer12AddBlankLineEv")
  //</editor-fold>
  public /*virtual*/ void AddBlankLine() {
  }

  
  /// @}
  
  /// \name Symbol & Section Management
  /// @{
  
  /// \brief Return the current section that the streamer is emitting code to.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getCurrentSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 292,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 278,
   FQN="llvm::MCStreamer::getCurrentSection", NM="_ZNK4llvm10MCStreamer17getCurrentSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZNK4llvm10MCStreamer17getCurrentSectionEv")
  //</editor-fold>
  public std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/> getCurrentSection() /*const*/ {
    if (!SectionStack.empty()) {
      return new std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>(SectionStack.back$Const().first);
    }
    return new std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getCurrentSectionOnly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 297,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 283,
   FQN="llvm::MCStreamer::getCurrentSectionOnly", NM="_ZNK4llvm10MCStreamer21getCurrentSectionOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZNK4llvm10MCStreamer21getCurrentSectionOnlyEv")
  //</editor-fold>
  public MCSection /*P*/ getCurrentSectionOnly() /*const*/ {
    return getCurrentSection().first;
  }

  
  /// \brief Return the previous section that the streamer is emitting code to.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getPreviousSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 300,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 286,
   FQN="llvm::MCStreamer::getPreviousSection", NM="_ZNK4llvm10MCStreamer18getPreviousSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZNK4llvm10MCStreamer18getPreviousSectionEv")
  //</editor-fold>
  public std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/> getPreviousSection() /*const*/ {
    if (!SectionStack.empty()) {
      return new std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>(SectionStack.back$Const().second);
    }
    return new std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>();
  }

  
  /// \brief Returns an index to represent the order a symbol was emitted in.
  /// (zero if we did not emit that symbol)
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::GetSymbolOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 308,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 294,
   FQN="llvm::MCStreamer::GetSymbolOrder", NM="_ZNK4llvm10MCStreamer14GetSymbolOrderEPKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZNK4llvm10MCStreamer14GetSymbolOrderEPKNS_8MCSymbolE")
  //</editor-fold>
  public /*uint*/int GetSymbolOrder(/*const*/ MCSymbol /*P*/ Sym) /*const*/ {
    return SymbolOrdering.lookup(Sym);
  }

  
  /// \brief Update streamer for a new active section.
  ///
  /// This is called by PopSection and SwitchSection, if the current
  /// section changes.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::ChangeSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 764,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 687,
   FQN="llvm::MCStreamer::ChangeSection", NM="_ZN4llvm10MCStreamer13ChangeSectionEPNS_9MCSectionEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer13ChangeSectionEPNS_9MCSectionEPKNS_6MCExprE")
  //</editor-fold>
  public void ChangeSection(MCSection /*P*/ $Prm0, /*const*/ MCExpr /*P*/ $Prm1) {
  }

  
  /// \brief Save the current and previous section on the section stack.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::PushSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 319,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 305,
   FQN="llvm::MCStreamer::PushSection", NM="_ZN4llvm10MCStreamer11PushSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer11PushSectionEv")
  //</editor-fold>
  public void PushSection() {
    SectionStack.push_back(std.make_pair($Move(getCurrentSection()), $Move(getPreviousSection())));
  }

  
  /// \brief Restore the current and previous section from the section stack.
  /// Calls ChangeSection as needed.
  ///
  /// Returns false if the stack was empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::PopSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 328,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 314,
   FQN="llvm::MCStreamer::PopSection", NM="_ZN4llvm10MCStreamer10PopSectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer10PopSectionEv")
  //</editor-fold>
  public boolean PopSection() {
    if ($lesseq_uint(SectionStack.size(), 1)) {
      return false;
    }
    type$ptr<pairTypeType<pair<MCSection, MCExpr>, pair<MCSection, MCExpr>>> I = $tryClone(SectionStack.end());
    I.$preDec();
    std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/> OldSection = new std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>(I./*->*/$star().first);
    I.$preDec();
    std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/> NewSection = new std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>(I./*->*/$star().first);
    if ($noteq_pair$_T1$_T2$C(OldSection, NewSection)) {
      ChangeSection(NewSection.first, NewSection.second);
    }
    SectionStack.pop_back();
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::SubSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 343,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 329,
   FQN="llvm::MCStreamer::SubSection", NM="_ZN4llvm10MCStreamer10SubSectionEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer10SubSectionEPKNS_6MCExprE")
  //</editor-fold>
  public boolean SubSection(/*const*/ MCExpr /*P*/ Subsection) {
    if (SectionStack.empty()) {
      return false;
    }
    
    SwitchSection(SectionStack.back().first.first, Subsection);
    return true;
  }

  
  /// Set the current section where code is being emitted to \p Section.  This
  /// is required to update CurSection.
  ///
  /// This corresponds to assembler directives like .section, .text, etc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::SwitchSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 787,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 706,
   FQN="llvm::MCStreamer::SwitchSection", NM="_ZN4llvm10MCStreamer13SwitchSectionEPNS_9MCSectionEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer13SwitchSectionEPNS_9MCSectionEPKNS_6MCExprE")
  //</editor-fold>
  public void SwitchSection(MCSection /*P*/ Section) {
    SwitchSection(Section, (/*const*/ MCExpr /*P*/ )null);
  }
  public void SwitchSection(MCSection /*P*/ Section, /*const*/ MCExpr /*P*/ Subsection/*= null*/) {
    assert ((Section != null)) : "Cannot switch to a null section!";
    std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/> curSection = new std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>(SectionStack.back().first);
    SectionStack.back().second.$assign(curSection);
    if ($noteq_pair$_T1$_T2$C(new std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>(JD$T$RR_T1$RR.INSTANCE, Section, Subsection), curSection)) {
      ChangeSection(Section, Subsection);
      SectionStack.back().first.$assignMove(new std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>(JD$T$RR_T1$RR.INSTANCE, Section, Subsection));
      assert (!Section.hasEnded()) : "Section already ended";
      MCSymbol /*P*/ Sym = Section.getBeginSymbol();
      if ((Sym != null) && !Sym.isInSection()) {
        EmitLabel(Sym);
      }
    }
  }

  
  /// \brief Set the current section where code is being emitted to \p Section.
  /// This is required to update CurSection. This version does not call
  /// ChangeSection.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::SwitchSectionNoChange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 361,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 347,
   FQN="llvm::MCStreamer::SwitchSectionNoChange", NM="_ZN4llvm10MCStreamer21SwitchSectionNoChangeEPNS_9MCSectionEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer21SwitchSectionNoChangeEPNS_9MCSectionEPKNS_6MCExprE")
  //</editor-fold>
  public void SwitchSectionNoChange(MCSection /*P*/ Section) {
    SwitchSectionNoChange(Section, 
                       (/*const*/ MCExpr /*P*/ )null);
  }
  public void SwitchSectionNoChange(MCSection /*P*/ Section, 
                       /*const*/ MCExpr /*P*/ Subsection/*= null*/) {
    assert ((Section != null)) : "Cannot switch to a null section!";
    std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/> curSection = new std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>(SectionStack.back().first);
    SectionStack.back().second.$assign(curSection);
    if ($noteq_pair$_T1$_T2$C(new std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>(JD$T$RR_T1$RR.INSTANCE, Section, Subsection), curSection)) {
      SectionStack.back().first.$assignMove(new std.pair</*const*/ MCSection /*P*/, /*const*/ MCExpr /*P*/>(JD$T$RR_T1$RR.INSTANCE, Section, Subsection));
    }
  }

  
  /// \brief Create the default sections and set the initial one.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::InitSections">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 231,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 187,
   FQN="llvm::MCStreamer::InitSections", NM="_ZN4llvm10MCStreamer12InitSectionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer12InitSectionsEb")
  //</editor-fold>
  public void InitSections(boolean NoExecStack) {
    SwitchSection(getContext().getObjectFileInfo().getTextSection());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::endSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 801,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 720,
   FQN="llvm::MCStreamer::endSection", NM="_ZN4llvm10MCStreamer10endSectionEPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer10endSectionEPNS_9MCSectionE")
  //</editor-fold>
  public MCSymbol /*P*/ endSection(MCSection /*P*/ Section) {
    // TODO: keep track of the last subsection so that this symbol appears in the
    // correct place.
    MCSymbol /*P*/ Sym = Section.getEndSymbol(Context);
    if (Sym.isInSection()) {
      return Sym;
    }
    
    SwitchSection(Section);
    EmitLabel(Sym);
    return Sym;
  }

  
  /// \brief Sets the symbol's section.
  ///
  /// Each emitted symbol will be tracked in the ordering table,
  /// so we can sort on them later.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::AssignFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 235,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 191,
   FQN="llvm::MCStreamer::AssignFragment", NM="_ZN4llvm10MCStreamer14AssignFragmentEPNS_8MCSymbolEPNS_10MCFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer14AssignFragmentEPNS_8MCSymbolEPNS_10MCFragmentE")
  //</editor-fold>
  public void AssignFragment(MCSymbol /*P*/ Symbol, MCFragment /*P*/ Fragment) {
    assert Native.$bool(Fragment);
    Symbol.setFragment(Fragment);
    
    // As we emit symbols into a section, track the order so that they can
    // be sorted upon later. Zero is reserved to mean 'unemitted'.
    SymbolOrdering.$set(Symbol, 1 + SymbolOrdering.size());
  }

  
  /// \brief Emit a label for \p Symbol into the current section.
  ///
  /// This corresponds to an assembler statement such as:
  ///   foo:
  ///
  /// \param Symbol - The symbol to emit. A given symbol should only be
  /// emitted as a label once, and symbols emitted as a label should never be
  /// used in an assignment.
  // FIXME: These emission are non-const because we mutate the symbol to
  // add the section we're emitting it to later.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 244,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 200,
   FQN="llvm::MCStreamer::EmitLabel", NM="_ZN4llvm10MCStreamer9EmitLabelEPNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer9EmitLabelEPNS_8MCSymbolE")
  //</editor-fold>
  public void EmitLabel(MCSymbol /*P*/ Symbol) {
    assert (!Symbol.isVariable()) : "Cannot emit a variable symbol!";
    assert (((getCurrentSection().first) != null)) : "Cannot emit before setting section!";
    assert (!(Symbol.getFragment() != null)) : "Unexpected fragment on symbol data!";
    Symbol.setFragment($AddrOf(getCurrentSectionOnly().getDummyFragment()));
    
    MCTargetStreamer /*P*/ TS = getTargetStreamer();
    if ((TS != null)) {
      TS.emitLabel(Symbol);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitEHSymAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 227,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 183,
   FQN="llvm::MCStreamer::EmitEHSymAttributes", NM="_ZN4llvm10MCStreamer19EmitEHSymAttributesEPKNS_8MCSymbolEPS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer19EmitEHSymAttributesEPKNS_8MCSymbolEPS1_")
  //</editor-fold>
  public void EmitEHSymAttributes(/*const*/ MCSymbol /*P*/ Symbol, 
                     MCSymbol /*P*/ EHSymbol) {
  }

  
  /// \brief Note in the output the specified \p Flag.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitAssemblerFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 751,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 674,
   FQN="llvm::MCStreamer::EmitAssemblerFlag", NM="_ZN4llvm10MCStreamer17EmitAssemblerFlagENS_15MCAssemblerFlagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer17EmitAssemblerFlagENS_15MCAssemblerFlagE")
  //</editor-fold>
  public void EmitAssemblerFlag(MCAssemblerFlag Flag) {
  }

  
  /// \brief Emit the given list \p Options of strings as linker
  /// options into the output.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitLinkerOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 400,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 386,
   FQN="llvm::MCStreamer::EmitLinkerOptions", NM="_ZN4llvm10MCStreamer17EmitLinkerOptionsENS_8ArrayRefISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer17EmitLinkerOptionsENS_8ArrayRefISsEE")
  //</editor-fold>
  public /*virtual*/ void EmitLinkerOptions(ArrayRef<std.string> Kind) {
  }

  
  /// \brief Note in the output the specified region \p Kind.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitDataRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 403,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 389,
   FQN="llvm::MCStreamer::EmitDataRegion", NM="_ZN4llvm10MCStreamer14EmitDataRegionENS_16MCDataRegionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer14EmitDataRegionENS_16MCDataRegionTypeE")
  //</editor-fold>
  public /*virtual*/ void EmitDataRegion(MCDataRegionType Kind) {
  }

  
  /// \brief Specify the MachO minimum deployment target version.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitVersionMin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 406,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 392,
   FQN="llvm::MCStreamer::EmitVersionMin", NM="_ZN4llvm10MCStreamer14EmitVersionMinENS_16MCVersionMinTypeEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer14EmitVersionMinENS_16MCVersionMinTypeEjjj")
  //</editor-fold>
  public /*virtual*/ void EmitVersionMin(MCVersionMinType $Prm0, /*uint*/int Major, /*uint*/int Minor, 
                /*uint*/int Update) {
  }

  
  /// \brief Note in the output that the specified \p Func is a Thumb mode
  /// function (ARM target only).
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitThumbFunc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 752,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 675,
   FQN="llvm::MCStreamer::EmitThumbFunc", NM="_ZN4llvm10MCStreamer13EmitThumbFuncEPNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer13EmitThumbFuncEPNS_8MCSymbolE")
  //</editor-fold>
  public void EmitThumbFunc(MCSymbol /*P*/ Func) {
  }

  
  /// \brief Emit an assignment of \p Value to \p Symbol.
  ///
  /// This corresponds to an assembler statement such as:
  ///  symbol = value
  ///
  /// The assignment generates no code, but has the side effect of binding the
  /// value in the current context. For the assembly streamer, this prints the
  /// binding into the .s file.
  ///
  /// \param Symbol - The symbol being assigned to.
  /// \param Value - The value for the symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 681,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 604,
   FQN="llvm::MCStreamer::EmitAssignment", NM="_ZN4llvm10MCStreamer14EmitAssignmentEPNS_8MCSymbolEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer14EmitAssignmentEPNS_8MCSymbolEPKNS_6MCExprE")
  //</editor-fold>
  public void EmitAssignment(MCSymbol /*P*/ Symbol, /*const*/ MCExpr /*P*/ Value) {
    visitUsedExpr($Deref(Value));
    Symbol.setVariableValue(Value);
    
    MCTargetStreamer /*P*/ TS = getTargetStreamer();
    if ((TS != null)) {
      TS.emitAssignment(Symbol, Value);
    }
  }

  
  /// \brief Emit an weak reference from \p Alias to \p Symbol.
  ///
  /// This corresponds to an assembler statement such as:
  ///  .weakref alias, symbol
  ///
  /// \param Alias - The alias that is being created.
  /// \param Symbol - The symbol being aliased.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWeakReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 765,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 688,
   FQN="llvm::MCStreamer::EmitWeakReference", NM="_ZN4llvm10MCStreamer17EmitWeakReferenceEPNS_8MCSymbolEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer17EmitWeakReferenceEPNS_8MCSymbolEPKS1_")
  //</editor-fold>
  public void EmitWeakReference(MCSymbol /*P*/ Alias, /*const*/ MCSymbol /*P*/ Symbol) {
  }

  
  /// \brief Add the given \p Attribute to \p Symbol.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitSymbolAttribute">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 436,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 422,
   FQN="llvm::MCStreamer::EmitSymbolAttribute", NM="_ZN4llvm10MCStreamer19EmitSymbolAttributeEPNS_8MCSymbolENS_12MCSymbolAttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer19EmitSymbolAttributeEPNS_8MCSymbolENS_12MCSymbolAttrE")
  //</editor-fold>
  public abstract /*virtual*/ boolean EmitSymbolAttribute(MCSymbol /*P*/ Symbol, 
                     MCSymbolAttr Attribute)/* = 0*/;

  
  /// \brief Set the \p DescValue for the \p Symbol.
  ///
  /// \param Symbol - The symbol to have its n_desc field set.
  /// \param DescValue - The value to set into the n_desc field.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitSymbolDesc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 753,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 676,
   FQN="llvm::MCStreamer::EmitSymbolDesc", NM="_ZN4llvm10MCStreamer14EmitSymbolDescEPNS_8MCSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer14EmitSymbolDescEPNS_8MCSymbolEj")
  //</editor-fold>
  public void EmitSymbolDesc(MCSymbol /*P*/ Symbol, /*uint*/int DescValue) {
  }

  
  /// \brief Start emitting COFF symbol definition
  ///
  /// \param Symbol - The symbol to have its External & Type fields set.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::BeginCOFFSymbolDef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 754,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 677,
   FQN="llvm::MCStreamer::BeginCOFFSymbolDef", NM="_ZN4llvm10MCStreamer18BeginCOFFSymbolDefEPKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer18BeginCOFFSymbolDefEPKNS_8MCSymbolE")
  //</editor-fold>
  public void BeginCOFFSymbolDef(/*const*/ MCSymbol /*P*/ Symbol) {
  }

  
  /// \brief Emit the storage class of the symbol.
  ///
  /// \param StorageClass - The storage class the symbol should have.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCOFFSymbolStorageClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 757,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 680,
   FQN="llvm::MCStreamer::EmitCOFFSymbolStorageClass", NM="_ZN4llvm10MCStreamer26EmitCOFFSymbolStorageClassEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer26EmitCOFFSymbolStorageClassEi")
  //</editor-fold>
  public void EmitCOFFSymbolStorageClass(int StorageClass) {
  }

  
  /// \brief Emit the type of the symbol.
  ///
  /// \param Type - A COFF type identifier (see COFF::SymbolType in X86COFF.h)
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCOFFSymbolType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 758,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 681,
   FQN="llvm::MCStreamer::EmitCOFFSymbolType", NM="_ZN4llvm10MCStreamer18EmitCOFFSymbolTypeEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer18EmitCOFFSymbolTypeEi")
  //</editor-fold>
  public void EmitCOFFSymbolType(int Type) {
  }

  
  /// \brief Marks the end of the symbol definition.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EndCOFFSymbolDef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 755,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 678,
   FQN="llvm::MCStreamer::EndCOFFSymbolDef", NM="_ZN4llvm10MCStreamer16EndCOFFSymbolDefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EndCOFFSymbolDefEv")
  //</editor-fold>
  public void EndCOFFSymbolDef() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCOFFSafeSEH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 644,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 567,
   FQN="llvm::MCStreamer::EmitCOFFSafeSEH", NM="_ZN4llvm10MCStreamer15EmitCOFFSafeSEHEPKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer15EmitCOFFSafeSEHEPKNS_8MCSymbolE")
  //</editor-fold>
  public void EmitCOFFSafeSEH(/*const*/ MCSymbol /*P*/ Symbol) {
  }

  
  /// \brief Emits a COFF section index.
  ///
  /// \param Symbol - Symbol the section number relocation should point to.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCOFFSectionIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 647,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 570,
   FQN="llvm::MCStreamer::EmitCOFFSectionIndex", NM="_ZN4llvm10MCStreamer20EmitCOFFSectionIndexEPKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer20EmitCOFFSectionIndexEPKNS_8MCSymbolE")
  //</editor-fold>
  public void EmitCOFFSectionIndex(/*const*/ MCSymbol /*P*/ Symbol) {
  }

  
  /// \brief Emits a COFF section relative relocation.
  ///
  /// \param Symbol - Symbol the section relative relocation should point to.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCOFFSecRel32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 650,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 573,
   FQN="llvm::MCStreamer::EmitCOFFSecRel32", NM="_ZN4llvm10MCStreamer16EmitCOFFSecRel32EPKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EmitCOFFSecRel32EPKNS_8MCSymbolE")
  //</editor-fold>
  public void EmitCOFFSecRel32(/*const*/ MCSymbol /*P*/ Symbol) {
  }

  
  /// \brief Emit an ELF .size directive.
  ///
  /// This corresponds to an assembler statement such as:
  ///  .size symbol, expression
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::emitELFSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 759,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 682,
   FQN="llvm::MCStreamer::emitELFSize", NM="_ZN4llvm10MCStreamer11emitELFSizeEPNS_11MCSymbolELFEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer11emitELFSizeEPNS_11MCSymbolELFEPKNS_6MCExprE")
  //</editor-fold>
  public void emitELFSize(MCSymbolELF /*P*/ Symbol, /*const*/ MCExpr /*P*/ Value) {
  }

  
  /// \brief Emit a Linker Optimization Hint (LOH) directive.
  /// \param Args - Arguments of the LOH.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitLOHDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 483,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 469,
   FQN="llvm::MCStreamer::EmitLOHDirective", NM="_ZN4llvm10MCStreamer16EmitLOHDirectiveENS_9MCLOHTypeERKNS_15SmallVectorImplIPNS_8MCSymbolEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EmitLOHDirectiveENS_9MCLOHTypeERKNS_15SmallVectorImplIPNS_8MCSymbolEEE")
  //</editor-fold>
  public /*virtual*/ void EmitLOHDirective(/*MCLOHType*//*uint*/int Kind, final /*const*/ SmallVectorImpl<MCSymbol /*P*/ > /*&*/ Args) {
  }

  
  /// \brief Emit a common symbol.
  ///
  /// \param Symbol - The common symbol to emit.
  /// \param Size - The size of the common symbol.
  /// \param ByteAlignment - The alignment of the symbol if
  /// non-zero. This must be a power of 2.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCommonSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 491,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 477,
   FQN="llvm::MCStreamer::EmitCommonSymbol", NM="_ZN4llvm10MCStreamer16EmitCommonSymbolEPNS_8MCSymbolEyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EmitCommonSymbolEPNS_8MCSymbolEyj")
  //</editor-fold>
  public abstract /*virtual*/ void EmitCommonSymbol(MCSymbol /*P*/ Symbol, long/*uint64_t*/ Size, 
                  /*uint*/int ByteAlignment)/* = 0*/;

  
  /// \brief Emit a local common (.lcomm) symbol.
  ///
  /// \param Symbol - The common symbol to emit.
  /// \param Size - The size of the common symbol.
  /// \param ByteAlignment - The alignment of the common symbol in bytes.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitLocalCommonSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 760,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 683,
   FQN="llvm::MCStreamer::EmitLocalCommonSymbol", NM="_ZN4llvm10MCStreamer21EmitLocalCommonSymbolEPNS_8MCSymbolEyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer21EmitLocalCommonSymbolEPNS_8MCSymbolEyj")
  //</editor-fold>
  public void EmitLocalCommonSymbol(MCSymbol /*P*/ Symbol, long/*uint64_t*/ Size, 
                       /*uint*/int ByteAlignment) {
  }

  
  /// \brief Emit the zerofill section and an optional symbol.
  ///
  /// \param Section - The zerofill section to create and or to put the symbol
  /// \param Symbol - The zerofill symbol to emit, if non-NULL.
  /// \param Size - The size of the zerofill symbol.
  /// \param ByteAlignment - The alignment of the zerofill symbol if
  /// non-zero. This must be a power of 2 on some targets.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitZerofill">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 509,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 495,
   FQN="llvm::MCStreamer::EmitZerofill", NM="_ZN4llvm10MCStreamer12EmitZerofillEPNS_9MCSectionEPNS_8MCSymbolEyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer12EmitZerofillEPNS_9MCSectionEPNS_8MCSymbolEyj")
  //</editor-fold>
  public abstract /*virtual*/ void EmitZerofill(MCSection /*P*/ Section, MCSymbol /*P*/ Symbol/*= null*/, 
              long/*uint64_t*/ Size/*= 0*/, /*uint*/int ByteAlignment/*= 0*/)/* = 0*/;

  
  /// \brief Emit a thread local bss (.tbss) symbol.
  ///
  /// \param Section - The thread local common section.
  /// \param Symbol - The thread local common symbol to emit.
  /// \param Size - The size of the symbol.
  /// \param ByteAlignment - The alignment of the thread local common symbol
  /// if non-zero.  This must be a power of 2 on some targets.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitTBSSSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 762,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 685,
   FQN="llvm::MCStreamer::EmitTBSSSymbol", NM="_ZN4llvm10MCStreamer14EmitTBSSSymbolEPNS_9MCSectionEPNS_8MCSymbolEyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer14EmitTBSSSymbolEPNS_9MCSectionEPNS_8MCSymbolEyj")
  //</editor-fold>
  public void EmitTBSSSymbol(MCSection /*P*/ Section, MCSymbol /*P*/ Symbol, 
                long/*uint64_t*/ Size) {
    EmitTBSSSymbol(Section, Symbol, 
                Size, 0);
  }
  public void EmitTBSSSymbol(MCSection /*P*/ Section, MCSymbol /*P*/ Symbol, 
                long/*uint64_t*/ Size, /*uint*/int ByteAlignment/*= 0*/) {
  }

  
  /// @}
  /// \name Generating Data
  /// @{
  
  /// \brief Emit the bytes in \p Data into the output.
  ///
  /// This is used to implement assembler directives such as .byte, .ascii,
  /// etc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 766,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 689,
   FQN="llvm::MCStreamer::EmitBytes", NM="_ZN4llvm10MCStreamer9EmitBytesENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer9EmitBytesENS_9StringRefE")
  //</editor-fold>
  public void EmitBytes(StringRef Data) {
  }

  
  /// Functionally identical to EmitBytes. When emitting textual assembly, this
  /// method uses .byte directives instead of .ascii or .asciz for readability.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitBinaryData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 767,
   FQN="llvm::MCStreamer::EmitBinaryData", NM="_ZN4llvm10MCStreamer14EmitBinaryDataENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer14EmitBinaryDataENS_9StringRefE")
  //</editor-fold>
  public void EmitBinaryData(StringRef Data) {
    EmitBytes(new StringRef(Data));
  }

  
  /// \brief Emit the expression \p Value into the output as a native
  /// integer of the given \p Size bytes.
  ///
  /// This is used to implement assembler directives such as .word, .quad,
  /// etc.
  ///
  /// \param Value - The value to emit.
  /// \param Size - The size of the integer (in bytes) to emit. This must
  /// match a native machine width.
  /// \param Loc - The location of the expression for error reporting.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitValueImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 768,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 690,
   FQN="llvm::MCStreamer::EmitValueImpl", NM="_ZN4llvm10MCStreamer13EmitValueImplEPKNS_6MCExprEjNS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer13EmitValueImplEPKNS_6MCExprEjNS_5SMLocE")
  //</editor-fold>
  public void EmitValueImpl(/*const*/ MCExpr /*P*/ Value, /*uint*/int Size) {
    EmitValueImpl(Value, Size, new SMLoc());
  }
  public void EmitValueImpl(/*const*/ MCExpr /*P*/ Value, /*uint*/int Size, SMLoc Loc/*= SMLoc()*/) {
    visitUsedExpr($Deref(Value));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 115,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 110,
   FQN="llvm::MCStreamer::EmitValue", NM="_ZN4llvm10MCStreamer9EmitValueEPKNS_6MCExprEjNS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer9EmitValueEPKNS_6MCExprEjNS_5SMLocE")
  //</editor-fold>
  public void EmitValue(/*const*/ MCExpr /*P*/ Value, /*uint*/int Size) {
    EmitValue(Value, Size, new SMLoc());
  }
  public void EmitValue(/*const*/ MCExpr /*P*/ Value, /*uint*/int Size, SMLoc Loc/*= SMLoc()*/) {
    EmitValueImpl(Value, Size, new SMLoc(Loc));
  }

  
  /// \brief Special case of EmitValue that avoids the client having
  /// to pass in a MCExpr for constant integers.
  
  /// EmitIntValue - Special case of EmitValue that avoids the client having to
  /// pass in a MCExpr for constant integers.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitIntValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 84,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 79,
   FQN="llvm::MCStreamer::EmitIntValue", NM="_ZN4llvm10MCStreamer12EmitIntValueEyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer12EmitIntValueEyj")
  //</editor-fold>
  public void EmitIntValue(long/*uint64_t*/ Value, /*uint*/int Size) {
    assert ($lesseq_uint(1, Size) && $lesseq_uint(Size, 8)) : "Invalid size";
    assert ((isUIntN(8 * Size, Value) || isIntN(8 * Size, Value))) : "Invalid size";
    /*char*/byte buf[/*8*/] = new$char(8);
    /*const*/boolean isLittleEndian = Context.getAsmInfo().isLittleEndian();
    for (/*uint*/int i = 0; i != Size; ++i) {
      /*uint*/int index = isLittleEndian ? i : (Size - i - 1);
      buf[i] = ((byte/*uint8_t*/)($ulong2uchar(Value >>> (index * 8))));
    }
    EmitBytes(new StringRef(buf, Size));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitULEB128Value">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 771,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 693,
   FQN="llvm::MCStreamer::EmitULEB128Value", NM="_ZN4llvm10MCStreamer16EmitULEB128ValueEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EmitULEB128ValueEPKNS_6MCExprE")
  //</editor-fold>
  public void EmitULEB128Value(/*const*/ MCExpr /*P*/ Value) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitSLEB128Value">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 772,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 694,
   FQN="llvm::MCStreamer::EmitSLEB128Value", NM="_ZN4llvm10MCStreamer16EmitSLEB128ValueEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EmitSLEB128ValueEPKNS_6MCExprE")
  //</editor-fold>
  public void EmitSLEB128Value(/*const*/ MCExpr /*P*/ Value) {
  }

  
  /// \brief Special case of EmitULEB128Value that avoids the client having to
  /// pass in a MCExpr for constant integers.
  
  /// EmitULEB128Value - Special case of EmitULEB128Value that avoids the
  /// client having to pass in a MCExpr for constant integers.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitULEB128IntValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 99,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 94,
   FQN="llvm::MCStreamer::EmitULEB128IntValue", NM="_ZN4llvm10MCStreamer19EmitULEB128IntValueEyj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer19EmitULEB128IntValueEyj")
  //</editor-fold>
  public void EmitULEB128IntValue(long/*uint64_t*/ Value) {
    EmitULEB128IntValue(Value, 0);
  }
  public void EmitULEB128IntValue(long/*uint64_t*/ Value, /*uint*/int Padding/*= 0*/) {
    raw_svector_ostream OSE = null;
    try {
      SmallString/*128*/ Tmp/*J*/= new SmallString/*128*/(128);
      OSE/*J*/= new raw_svector_ostream(Tmp);
      encodeULEB128(Value, OSE, Padding);
      EmitBytes(OSE.str());
    } finally {
      if (OSE != null) { OSE.$destroy(); }
    }
  }

  
  /// \brief Special case of EmitSLEB128Value that avoids the client having to
  /// pass in a MCExpr for constant integers.
  
  /// EmitSLEB128Value - Special case of EmitSLEB128Value that avoids the
  /// client having to pass in a MCExpr for constant integers.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitSLEB128IntValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 108,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 103,
   FQN="llvm::MCStreamer::EmitSLEB128IntValue", NM="_ZN4llvm10MCStreamer19EmitSLEB128IntValueEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer19EmitSLEB128IntValueEx")
  //</editor-fold>
  public void EmitSLEB128IntValue(long/*int64_t*/ Value) {
    raw_svector_ostream OSE = null;
    try {
      SmallString/*128*/ Tmp/*J*/= new SmallString/*128*/(128);
      OSE/*J*/= new raw_svector_ostream(Tmp);
      encodeSLEB128(Value, OSE);
      EmitBytes(OSE.str());
    } finally {
      if (OSE != null) { OSE.$destroy(); }
    }
  }

  
  /// \brief Special case of EmitValue that avoids the client having to pass in
  /// a MCExpr for MCSymbols.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitSymbolValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 119,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 114,
   FQN="llvm::MCStreamer::EmitSymbolValue", NM="_ZN4llvm10MCStreamer15EmitSymbolValueEPKNS_8MCSymbolEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer15EmitSymbolValueEPKNS_8MCSymbolEjb")
  //</editor-fold>
  public void EmitSymbolValue(/*const*/ MCSymbol /*P*/ Sym, /*uint*/int Size) {
    EmitSymbolValue(Sym, Size, 
                 false);
  }
  public void EmitSymbolValue(/*const*/ MCSymbol /*P*/ Sym, /*uint*/int Size, 
                 boolean IsSectionRelative/*= false*/) {
    assert ((!IsSectionRelative || Size == 4)) : "SectionRelative value requires 4-bytes";
    if (!IsSectionRelative) {
      EmitValueImpl(MCSymbolRefExpr.create(Sym, getContext()), Size);
    } else {
      EmitCOFFSecRel32(Sym);
    }
  }

  
  /// \brief Emit the expression \p Value into the output as a gprel64 (64-bit
  /// GP relative) value.
  ///
  /// This is used to implement assembler directives such as .gpdword on
  /// targets that support them.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitGPRel64Value">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 130,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 125,
   FQN="llvm::MCStreamer::EmitGPRel64Value", NM="_ZN4llvm10MCStreamer16EmitGPRel64ValueEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EmitGPRel64ValueEPKNS_6MCExprE")
  //</editor-fold>
  public void EmitGPRel64Value(/*const*/ MCExpr /*P*/ Value) {
    report_fatal_error($("unsupported directive in streamer"));
  }

  
  /// \brief Emit the expression \p Value into the output as a gprel32 (32-bit
  /// GP relative) value.
  ///
  /// This is used to implement assembler directives such as .gprel32 on
  /// targets that support them.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitGPRel32Value">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 134,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 129,
   FQN="llvm::MCStreamer::EmitGPRel32Value", NM="_ZN4llvm10MCStreamer16EmitGPRel32ValueEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EmitGPRel32ValueEPKNS_6MCExprE")
  //</editor-fold>
  public void EmitGPRel32Value(/*const*/ MCExpr /*P*/ Value) {
    report_fatal_error($("unsupported directive in streamer"));
  }

  
  /// \brief Emit NumBytes bytes worth of the value specified by FillValue.
  /// This implements directives such as '.space'.
  
  /// Emit NumBytes bytes worth of the value specified by FillValue.
  /// This implements directives such as '.space'.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::emitFill">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 140,
   FQN="llvm::MCStreamer::emitFill", NM="_ZN4llvm10MCStreamer8emitFillEyh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer8emitFillEyh")
  //</editor-fold>
  public void emitFill(long/*uint64_t*/ NumBytes, byte/*uint8_t*/ FillValue) {
    for (long/*uint64_t*/ i = $int2ulong(0), e = NumBytes; i != e; ++i)  {
      EmitIntValue($uchar2ulong(FillValue), 1);
    }
  }

  
  /// \brief Emit \p Size bytes worth of the value specified by \p FillValue.
  ///
  /// This is used to implement assembler directives such as .space or .skip.
  ///
  /// \param NumBytes - The number of bytes to emit.
  /// \param FillValue - The value to use when filling bytes.
  /// \param Loc - The location of the expression for error reporting.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::emitFill">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 773,
   FQN="llvm::MCStreamer::emitFill", NM="_ZN4llvm10MCStreamer8emitFillERKNS_6MCExprEyNS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer8emitFillERKNS_6MCExprEyNS_5SMLocE")
  //</editor-fold>
  public void emitFill(final /*const*/ MCExpr /*&*/ NumBytes, long/*uint64_t*/ Value) {
    emitFill(NumBytes, Value, new SMLoc());
  }
  public void emitFill(final /*const*/ MCExpr /*&*/ NumBytes, long/*uint64_t*/ Value, SMLoc Loc/*= SMLoc()*/) {
  }

  
  /// \brief Emit \p NumValues copies of \p Size bytes. Each \p Size bytes is
  /// taken from the lowest order 4 bytes of \p Expr expression.
  ///
  /// This is used to implement assembler directives such as .fill.
  ///
  /// \param NumValues - The number of copies of \p Size bytes to emit.
  /// \param Size - The size (in bytes) of each repeated value.
  /// \param Expr - The expression from which \p Size bytes are used.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::emitFill">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 145,
   FQN="llvm::MCStreamer::emitFill", NM="_ZN4llvm10MCStreamer8emitFillEyxx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer8emitFillEyxx")
  //</editor-fold>
  public void emitFill(long/*uint64_t*/ NumValues, long/*int64_t*/ Size, long/*int64_t*/ Expr) {
    long/*int64_t*/ NonZeroSize = Size > 4 ? 4 : Size;
    Expr &= ~0L/*ULL*/ >>> (64 - NonZeroSize * 8);
    for (long/*uint64_t*/ i = $int2ulong(0), e = NumValues; i != e; ++i) {
      EmitIntValue(Expr, $long2uint(NonZeroSize));
      if (NonZeroSize < Size) {
        EmitIntValue($int2ulong(0), $llong2uint(Size - NonZeroSize));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::emitFill">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 774,
   FQN="llvm::MCStreamer::emitFill", NM="_ZN4llvm10MCStreamer8emitFillERKNS_6MCExprExxNS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer8emitFillERKNS_6MCExprExxNS_5SMLocE")
  //</editor-fold>
  public void emitFill(final /*const*/ MCExpr /*&*/ NumValues, long/*int64_t*/ Size, long/*int64_t*/ Expr) {
    emitFill(NumValues, Size, Expr, 
          new SMLoc());
  }
  public void emitFill(final /*const*/ MCExpr /*&*/ NumValues, long/*int64_t*/ Size, long/*int64_t*/ Expr, 
          SMLoc Loc/*= SMLoc()*/) {
  }

  
  /// \brief Emit NumBytes worth of zeros.
  /// This function properly handles data in virtual sections.
  
  /// The implementation in this class just redirects to emitFill.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitZeros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 156,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 142,
   FQN="llvm::MCStreamer::EmitZeros", NM="_ZN4llvm10MCStreamer9EmitZerosEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer9EmitZerosEy")
  //</editor-fold>
  public void EmitZeros(long/*uint64_t*/ NumBytes) {
    emitFill(NumBytes, $int2uchar(0));
  }

  
  /// \brief Emit some number of copies of \p Value until the byte alignment \p
  /// ByteAlignment is reached.
  ///
  /// If the number of bytes need to emit for the alignment is not a multiple
  /// of \p ValueSize, then the contents of the emitted fill bytes is
  /// undefined.
  ///
  /// This used to implement the .align assembler directive.
  ///
  /// \param ByteAlignment - The alignment to reach. This must be a power of
  /// two on some targets.
  /// \param Value - The value to use when filling bytes.
  /// \param ValueSize - The size of the integer (in bytes) to emit for
  /// \p Value. This must match a native machine width.
  /// \param MaxBytesToEmit - The maximum numbers of bytes to emit, or 0. If
  /// the alignment cannot be reached in this many bytes, no bytes are
  /// emitted.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitValueToAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 776,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 695,
   FQN="llvm::MCStreamer::EmitValueToAlignment", NM="_ZN4llvm10MCStreamer20EmitValueToAlignmentEjxjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer20EmitValueToAlignmentEjxjj")
  //</editor-fold>
  public void EmitValueToAlignment(/*uint*/int ByteAlignment) {
    EmitValueToAlignment(ByteAlignment, 0, 
                      1, 
                      0);
  }
  public void EmitValueToAlignment(/*uint*/int ByteAlignment, long/*int64_t*/ Value/*= 0*/) {
    EmitValueToAlignment(ByteAlignment, Value, 
                      1, 
                      0);
  }
  public void EmitValueToAlignment(/*uint*/int ByteAlignment, long/*int64_t*/ Value/*= 0*/, 
                      /*uint*/int ValueSize/*= 1*/) {
    EmitValueToAlignment(ByteAlignment, Value, 
                      ValueSize, 
                      0);
  }
  public void EmitValueToAlignment(/*uint*/int ByteAlignment, long/*int64_t*/ Value/*= 0*/, 
                      /*uint*/int ValueSize/*= 1*/, 
                      /*uint*/int MaxBytesToEmit/*= 0*/) {
  }

  
  /// \brief Emit nops until the byte alignment \p ByteAlignment is reached.
  ///
  /// This used to align code where the alignment bytes may be executed.  This
  /// can emit different bytes for different sizes to optimize execution.
  ///
  /// \param ByteAlignment - The alignment to reach. This must be a power of
  /// two on some targets.
  /// \param MaxBytesToEmit - The maximum numbers of bytes to emit, or 0. If
  /// the alignment cannot be reached in this many bytes, no bytes are
  /// emitted.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCodeAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 779,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 698,
   FQN="llvm::MCStreamer::EmitCodeAlignment", NM="_ZN4llvm10MCStreamer17EmitCodeAlignmentEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer17EmitCodeAlignmentEjj")
  //</editor-fold>
  public void EmitCodeAlignment(/*uint*/int ByteAlignment) {
    EmitCodeAlignment(ByteAlignment, 
                   0);
  }
  public void EmitCodeAlignment(/*uint*/int ByteAlignment, 
                   /*uint*/int MaxBytesToEmit/*= 0*/) {
  }

  
  /// \brief Emit some number of copies of \p Value until the byte offset \p
  /// Offset is reached.
  ///
  /// This is used to implement assembler directives such as .org.
  ///
  /// \param Offset - The offset to reach. This may be an expression, but the
  /// expression must be associated with the current section.
  /// \param Value - The value to use when filling bytes.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::emitValueToOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 781,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 700,
   FQN="llvm::MCStreamer::emitValueToOffset", NM="_ZN4llvm10MCStreamer17emitValueToOffsetEPKNS_6MCExprEh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer17emitValueToOffsetEPKNS_6MCExprEh")
  //</editor-fold>
  public void emitValueToOffset(/*const*/ MCExpr /*P*/ Offset) {
    emitValueToOffset(Offset, $int2uchar(0));
  }
  public void emitValueToOffset(/*const*/ MCExpr /*P*/ Offset, /*uchar*/byte Value/*= 0*/) {
  }

  
  /// @}
  
  /// \brief Switch to a new logical file.  This is used to implement the '.file
  /// "foo.c"' assembler directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitFileDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 756,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 679,
   FQN="llvm::MCStreamer::EmitFileDirective", NM="_ZN4llvm10MCStreamer17EmitFileDirectiveENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer17EmitFileDirectiveENS_9StringRefE")
  //</editor-fold>
  public void EmitFileDirective(StringRef Filename) {
  }

  
  /// \brief Emit the "identifiers" directive.  This implements the
  /// '.ident "version foo"' assembler directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitIdent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 668,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 628,
   FQN="llvm::MCStreamer::EmitIdent", NM="_ZN4llvm10MCStreamer9EmitIdentENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer9EmitIdentENS_9StringRefE")
  //</editor-fold>
  public /*virtual*/ void EmitIdent(StringRef IdentString) {
  }

  
  /// \brief Associate a filename with a specified logical file number.  This
  /// implements the DWARF2 '.file 4 "foo.c"' assembler directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitDwarfFileDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 160,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 146,
   FQN="llvm::MCStreamer::EmitDwarfFileDirective", NM="_ZN4llvm10MCStreamer22EmitDwarfFileDirectiveEjNS_9StringRefES1_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer22EmitDwarfFileDirectiveEjNS_9StringRefES1_j")
  //</editor-fold>
  public /*uint*/int EmitDwarfFileDirective(/*uint*/int FileNo, 
                        StringRef Directory, 
                        StringRef Filename) {
    return EmitDwarfFileDirective(FileNo, 
                        Directory, 
                        Filename, 0);
  }
  public /*uint*/int EmitDwarfFileDirective(/*uint*/int FileNo, 
                        StringRef Directory, 
                        StringRef Filename, /*uint*/int CUID/*= 0*/) {
    return getContext().getDwarfFile(new StringRef(Directory), new StringRef(Filename), FileNo, CUID);
  }

  
  /// \brief This implements the DWARF2 '.loc fileno lineno ...' assembler
  /// directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitDwarfLocDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 166,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 152,
   FQN="llvm::MCStreamer::EmitDwarfLocDirective", NM="_ZN4llvm10MCStreamer21EmitDwarfLocDirectiveEjjjjjjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer21EmitDwarfLocDirectiveEjjjjjjNS_9StringRefE")
  //</editor-fold>
  public void EmitDwarfLocDirective(/*uint*/int FileNo, /*uint*/int Line, 
                       /*uint*/int Column, /*uint*/int Flags, 
                       /*uint*/int Isa, 
                       /*uint*/int Discriminator, 
                       StringRef FileName) {
    getContext().setCurrentDwarfLoc(FileNo, Line, Column, Flags, Isa, 
        Discriminator);
  }

  
  /// \brief Associate a filename with a specified logical file number.  This
  /// implements the '.cv_file 4 "foo.c"' assembler directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCVFileDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 202,
   FQN="llvm::MCStreamer::EmitCVFileDirective", NM="_ZN4llvm10MCStreamer19EmitCVFileDirectiveEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer19EmitCVFileDirectiveEjNS_9StringRefE")
  //</editor-fold>
  public /*uint*/int EmitCVFileDirective(/*uint*/int FileNo, StringRef Filename) {
    return getContext().getCVFile(new StringRef(Filename), FileNo);
  }

  
  /// \brief This implements the CodeView '.cv_loc' assembler directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCVLocDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 206,
   FQN="llvm::MCStreamer::EmitCVLocDirective", NM="_ZN4llvm10MCStreamer18EmitCVLocDirectiveEjjjjbbNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer18EmitCVLocDirectiveEjjjjbbNS_9StringRefE")
  //</editor-fold>
  public void EmitCVLocDirective(/*uint*/int FunctionId, /*uint*/int FileNo, 
                    /*uint*/int Line, /*uint*/int Column, 
                    boolean PrologueEnd, boolean IsStmt, 
                    StringRef FileName) {
    getContext().setCurrentCVLoc(FunctionId, FileNo, Line, Column, PrologueEnd, 
        IsStmt);
  }

  
  /// \brief This implements the CodeView '.cv_linetable' assembler directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCVLinetableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 214,
   FQN="llvm::MCStreamer::EmitCVLinetableDirective", NM="_ZN4llvm10MCStreamer24EmitCVLinetableDirectiveEjPKNS_8MCSymbolES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer24EmitCVLinetableDirectiveEjPKNS_8MCSymbolES3_")
  //</editor-fold>
  public void EmitCVLinetableDirective(/*uint*/int FunctionId, 
                          /*const*/ MCSymbol /*P*/ Begin, 
                          /*const*/ MCSymbol /*P*/ End) {
  }

  
  /// \brief This implements the CodeView '.cv_inline_linetable' assembler
  /// directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCVInlineLinetableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 218,
   FQN="llvm::MCStreamer::EmitCVInlineLinetableDirective", NM="_ZN4llvm10MCStreamer30EmitCVInlineLinetableDirectiveEjjjPKNS_8MCSymbolES3_NS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer30EmitCVInlineLinetableDirectiveEjjjPKNS_8MCSymbolES3_NS_8ArrayRefIjEE")
  //</editor-fold>
  public void EmitCVInlineLinetableDirective(/*uint*/int PrimaryFunctionId, /*uint*/int SourceFileId, /*uint*/int SourceLineNum, 
                                /*const*/ MCSymbol /*P*/ FnStartSym, /*const*/ MCSymbol /*P*/ FnEndSym, 
                                ArrayRefUInt SecondaryFunctionIds) {
  }

  
  /// \brief This implements the CodeView '.cv_def_range' assembler
  /// directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCVDefRangeDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 223,
   FQN="llvm::MCStreamer::EmitCVDefRangeDirective", NM="_ZN4llvm10MCStreamer23EmitCVDefRangeDirectiveENS_8ArrayRefISt4pairIPKNS_8MCSymbolES5_EEENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer23EmitCVDefRangeDirectiveENS_8ArrayRefISt4pairIPKNS_8MCSymbolES5_EEENS_9StringRefE")
  //</editor-fold>
  public void EmitCVDefRangeDirective(ArrayRef<std.pairPtrPtr</*const*/ MCSymbol /*P*/ , /*const*/ MCSymbol /*P*/ >> Ranges, 
                         StringRef FixedSizePortion) {
  }

  
  /// \brief This implements the CodeView '.cv_stringtable' assembler directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCVStringTableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 712,
   FQN="llvm::MCStreamer::EmitCVStringTableDirective", NM="_ZN4llvm10MCStreamer26EmitCVStringTableDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer26EmitCVStringTableDirectiveEv")
  //</editor-fold>
  public /*virtual*/ void EmitCVStringTableDirective() {
  }

  
  /// \brief This implements the CodeView '.cv_filechecksums' assembler directive.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCVFileChecksumsDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 715,
   FQN="llvm::MCStreamer::EmitCVFileChecksumsDirective", NM="_ZN4llvm10MCStreamer28EmitCVFileChecksumsDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer28EmitCVFileChecksumsDirectiveEv")
  //</editor-fold>
  public /*virtual*/ void EmitCVFileChecksumsDirective() {
  }

  
  /// Emit the absolute difference between two symbols.
  ///
  /// \pre Offset of \c Hi is greater than the offset \c Lo.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::emitAbsoluteSymbolDiff">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 732,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 655,
   FQN="llvm::MCStreamer::emitAbsoluteSymbolDiff", NM="_ZN4llvm10MCStreamer22emitAbsoluteSymbolDiffEPKNS_8MCSymbolES3_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer22emitAbsoluteSymbolDiffEPKNS_8MCSymbolES3_j")
  //</editor-fold>
  public void emitAbsoluteSymbolDiff(/*const*/ MCSymbol /*P*/ Hi, /*const*/ MCSymbol /*P*/ Lo, 
                        /*uint*/int Size) {
    // Get the Hi-Lo expression.
    /*const*/ MCExpr /*P*/ Diff = MCBinaryExpr.createSub(MCSymbolRefExpr.create(Hi, Context), 
        MCSymbolRefExpr.create(Lo, Context), Context);
    
    /*const*/ MCAsmInfo /*P*/ MAI = Context.getAsmInfo();
    if (!MAI.doesSetDirectiveSuppressReloc()) {
      EmitValue(Diff, Size);
      return;
    }
    
    // Otherwise, emit with .set (aka assignment).
    MCSymbol /*P*/ SetLabel = Context.createTempSymbol(new Twine(/*KEEP_STR*/"set"), true);
    EmitAssignment(SetLabel, Diff);
    EmitSymbolValue(SetLabel, Size);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getDwarfLineTableSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 175,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 161,
   FQN="llvm::MCStreamer::getDwarfLineTableSymbol", NM="_ZN4llvm10MCStreamer23getDwarfLineTableSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer23getDwarfLineTableSymbolEj")
  //</editor-fold>
  public MCSymbol /*P*/ getDwarfLineTableSymbol(/*uint*/int CUID) {
    final MCDwarfLineTable /*&*/ Table = getContext().getMCDwarfLineTable(CUID);
    if (!(Table.getLabel() != null)) {
      StringRef Prefix = new StringRef(Context.getAsmInfo().getPrivateGlobalPrefix());
      Table.setLabel(Context.getOrCreateSymbol($add_Twine$C($add_StringRef$C_char$ptr$C(Prefix, /*KEEP_STR*/"line_table_start"), new Twine(JD$UInt.INSTANCE, CUID))));
    }
    return Table.getLabel();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFISections">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 255,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 211,
   FQN="llvm::MCStreamer::EmitCFISections", NM="_ZN4llvm10MCStreamer15EmitCFISectionsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer15EmitCFISectionsEbb")
  //</editor-fold>
  public void EmitCFISections(boolean EH, boolean Debug) {
    assert (EH || Debug);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIStartProc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 259,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 215,
   FQN="llvm::MCStreamer::EmitCFIStartProc", NM="_ZN4llvm10MCStreamer16EmitCFIStartProcEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EmitCFIStartProcEb")
  //</editor-fold>
  public void EmitCFIStartProc(boolean IsSimple) {
    MCDwarfFrameInfo Frame = null;
    try {
      if (hasUnfinishedDwarfFrameInfo()) {
        report_fatal_error($("Starting a frame before finishing the previous one!"));
      }
      
      Frame/*J*/= new MCDwarfFrameInfo();
      Frame.IsSimple = IsSimple;
      EmitCFIStartProcImpl(Frame);
      
      /*const*/ MCAsmInfo /*P*/ MAI = Context.getAsmInfo();
      if ((MAI != null)) {
        for (final /*const*/ MCCFIInstruction /*&*/ Inst : MAI.getInitialFrameState()) {
          if (Inst.getOperation() == MCCFIInstruction.OpType.OpDefCfa
             || Inst.getOperation() == MCCFIInstruction.OpType.OpDefCfaRegister) {
            Frame.CurrentCfaRegister = Inst.getRegister();
          }
        }
      }
      
      DwarfFrameInfos.push_back_T$C$R(Frame);
    } finally {
      if (Frame != null) { Frame.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIEndProc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 283,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 240,
   FQN="llvm::MCStreamer::EmitCFIEndProc", NM="_ZN4llvm10MCStreamer14EmitCFIEndProcEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer14EmitCFIEndProcEv")
  //</editor-fold>
  public void EmitCFIEndProc() {
    EnsureValidDwarfFrame();
    MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
    EmitCFIEndProcImpl($Deref(CurFrame));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIDefCfa">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 302,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 259,
   FQN="llvm::MCStreamer::EmitCFIDefCfa", NM="_ZN4llvm10MCStreamer13EmitCFIDefCfaExx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer13EmitCFIDefCfaExx")
  //</editor-fold>
  public void EmitCFIDefCfa(long/*int64_t*/ Register, long/*int64_t*/ Offset) {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createDefCfa(Label, $long2uint(Register), (int)Offset);
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
      CurFrame.CurrentCfaRegister = ((/*static_cast*//*uint*/int)($long2uint(Register)));
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIDefCfaOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 311,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 268,
   FQN="llvm::MCStreamer::EmitCFIDefCfaOffset", NM="_ZN4llvm10MCStreamer19EmitCFIDefCfaOffsetEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer19EmitCFIDefCfaOffsetEx")
  //</editor-fold>
  public void EmitCFIDefCfaOffset(long/*int64_t*/ Offset) {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createDefCfaOffset(Label, (int)Offset);
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIDefCfaRegister">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 327,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 284,
   FQN="llvm::MCStreamer::EmitCFIDefCfaRegister", NM="_ZN4llvm10MCStreamer21EmitCFIDefCfaRegisterEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer21EmitCFIDefCfaRegisterEx")
  //</editor-fold>
  public void EmitCFIDefCfaRegister(long/*int64_t*/ Register) {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createDefCfaRegister(Label, $long2uint(Register));
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
      CurFrame.CurrentCfaRegister = ((/*static_cast*//*uint*/int)($long2uint(Register)));
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 336,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 293,
   FQN="llvm::MCStreamer::EmitCFIOffset", NM="_ZN4llvm10MCStreamer13EmitCFIOffsetExx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer13EmitCFIOffsetExx")
  //</editor-fold>
  public void EmitCFIOffset(long/*int64_t*/ Register, long/*int64_t*/ Offset) {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createOffset(Label, $long2uint(Register), (int)Offset);
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIPersonality">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 352,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 309,
   FQN="llvm::MCStreamer::EmitCFIPersonality", NM="_ZN4llvm10MCStreamer18EmitCFIPersonalityEPKNS_8MCSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer18EmitCFIPersonalityEPKNS_8MCSymbolEj")
  //</editor-fold>
  public void EmitCFIPersonality(/*const*/ MCSymbol /*P*/ Sym, 
                    /*uint*/int Encoding) {
    EnsureValidDwarfFrame();
    MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
    CurFrame.Personality = Sym;
    CurFrame.PersonalityEncoding = Encoding;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFILsda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 360,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 317,
   FQN="llvm::MCStreamer::EmitCFILsda", NM="_ZN4llvm10MCStreamer11EmitCFILsdaEPKNS_8MCSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer11EmitCFILsdaEPKNS_8MCSymbolEj")
  //</editor-fold>
  public void EmitCFILsda(/*const*/ MCSymbol /*P*/ Sym, /*uint*/int Encoding) {
    EnsureValidDwarfFrame();
    MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
    CurFrame.Lsda = Sym;
    CurFrame.LsdaEncoding = Encoding;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIRememberState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 367,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 324,
   FQN="llvm::MCStreamer::EmitCFIRememberState", NM="_ZN4llvm10MCStreamer20EmitCFIRememberStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer20EmitCFIRememberStateEv")
  //</editor-fold>
  public void EmitCFIRememberState() {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createRememberState(Label);
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIRestoreState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 374,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 331,
   FQN="llvm::MCStreamer::EmitCFIRestoreState", NM="_ZN4llvm10MCStreamer19EmitCFIRestoreStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer19EmitCFIRestoreStateEv")
  //</editor-fold>
  public void EmitCFIRestoreState() {
    MCCFIInstruction Instruction = null;
    try {
      // FIXME: Error if there is no matching cfi_remember_state.
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createRestoreState(Label);
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFISameValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 382,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 339,
   FQN="llvm::MCStreamer::EmitCFISameValue", NM="_ZN4llvm10MCStreamer16EmitCFISameValueEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EmitCFISameValueEx")
  //</editor-fold>
  public void EmitCFISameValue(long/*int64_t*/ Register) {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createSameValue(Label, $long2uint(Register));
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIRestore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 390,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 347,
   FQN="llvm::MCStreamer::EmitCFIRestore", NM="_ZN4llvm10MCStreamer14EmitCFIRestoreEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer14EmitCFIRestoreEx")
  //</editor-fold>
  public void EmitCFIRestore(long/*int64_t*/ Register) {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createRestore(Label, $long2uint(Register));
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIRelOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 344,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 301,
   FQN="llvm::MCStreamer::EmitCFIRelOffset", NM="_ZN4llvm10MCStreamer16EmitCFIRelOffsetExx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EmitCFIRelOffsetExx")
  //</editor-fold>
  public void EmitCFIRelOffset(long/*int64_t*/ Register, long/*int64_t*/ Offset) {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createRelOffset(Label, $long2uint(Register), (int)Offset);
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIAdjustCfaOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 319,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 276,
   FQN="llvm::MCStreamer::EmitCFIAdjustCfaOffset", NM="_ZN4llvm10MCStreamer22EmitCFIAdjustCfaOffsetEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer22EmitCFIAdjustCfaOffsetEx")
  //</editor-fold>
  public void EmitCFIAdjustCfaOffset(long/*int64_t*/ Adjustment) {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createAdjustCfaOffset(Label, (int)Adjustment);
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 398,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 355,
   FQN="llvm::MCStreamer::EmitCFIEscape", NM="_ZN4llvm10MCStreamer13EmitCFIEscapeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer13EmitCFIEscapeENS_9StringRefE")
  //</editor-fold>
  public void EmitCFIEscape(StringRef Values) {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createEscape(Label, new StringRef(Values));
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIGnuArgsSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 405,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 362,
   FQN="llvm::MCStreamer::EmitCFIGnuArgsSize", NM="_ZN4llvm10MCStreamer18EmitCFIGnuArgsSizeEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer18EmitCFIGnuArgsSizeEx")
  //</editor-fold>
  public void EmitCFIGnuArgsSize(long/*int64_t*/ Size) {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createGnuArgsSize(Label, (int)Size);
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFISignalFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 413,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 370,
   FQN="llvm::MCStreamer::EmitCFISignalFrame", NM="_ZN4llvm10MCStreamer18EmitCFISignalFrameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer18EmitCFISignalFrameEv")
  //</editor-fold>
  public void EmitCFISignalFrame() {
    EnsureValidDwarfFrame();
    MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
    CurFrame.IsSignalFrame = true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIUndefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 419,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 376,
   FQN="llvm::MCStreamer::EmitCFIUndefined", NM="_ZN4llvm10MCStreamer16EmitCFIUndefinedEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EmitCFIUndefinedEx")
  //</editor-fold>
  public void EmitCFIUndefined(long/*int64_t*/ Register) {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createUndefined(Label, $long2uint(Register));
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIRegister">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 427,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 384,
   FQN="llvm::MCStreamer::EmitCFIRegister", NM="_ZN4llvm10MCStreamer15EmitCFIRegisterExx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer15EmitCFIRegisterExx")
  //</editor-fold>
  public void EmitCFIRegister(long/*int64_t*/ Register1, long/*int64_t*/ Register2) {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createRegister(Label, $long2uint(Register1), $long2uint(Register2));
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitCFIWindowSave">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 435,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 392,
   FQN="llvm::MCStreamer::EmitCFIWindowSave", NM="_ZN4llvm10MCStreamer17EmitCFIWindowSaveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer17EmitCFIWindowSaveEv")
  //</editor-fold>
  public void EmitCFIWindowSave() {
    MCCFIInstruction Instruction = null;
    try {
      MCSymbol /*P*/ Label = EmitCFICommon();
      Instruction = MCCFIInstruction.createWindowSave(Label);
      MCDwarfFrameInfo /*P*/ CurFrame = getCurrentDwarfFrameInfo();
      CurFrame.Instructions.push_back_T$C$R(Instruction);
    } finally {
      if (Instruction != null) { Instruction.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWinCFIStartProc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 451,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 408,
   FQN="llvm::MCStreamer::EmitWinCFIStartProc", NM="_ZN4llvm10MCStreamer19EmitWinCFIStartProcEPKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer19EmitWinCFIStartProcEPKNS_8MCSymbolE")
  //</editor-fold>
  public void EmitWinCFIStartProc(/*const*/ MCSymbol /*P*/ Symbol) {
    /*const*/ MCAsmInfo /*P*/ MAI = Context.getAsmInfo();
    if (!MAI.usesWindowsCFI()) {
      report_fatal_error($(".seh_* directives are not supported on this target"));
    }
    if ((CurrentWinFrameInfo != null) && !(CurrentWinFrameInfo.End != null)) {
      report_fatal_error($("Starting a function before ending the previous one!"));
    }
    
    MCSymbol /*P*/ StartProc = getContext().createTempSymbol();
    EmitLabel(StartProc);
    
    WinFrameInfos.push_back_T$RR(new WinEH.FrameInfo(Symbol, StartProc));
    CurrentWinFrameInfo = WinFrameInfos.back();
    CurrentWinFrameInfo.TextSection = getCurrentSectionOnly();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWinCFIEndProc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 466,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 422,
   FQN="llvm::MCStreamer::EmitWinCFIEndProc", NM="_ZN4llvm10MCStreamer17EmitWinCFIEndProcEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer17EmitWinCFIEndProcEv")
  //</editor-fold>
  public void EmitWinCFIEndProc() {
    EnsureValidWinFrameInfo();
    if ((CurrentWinFrameInfo.ChainedParent != null)) {
      report_fatal_error($("Not all chained regions terminated!"));
    }
    
    MCSymbol /*P*/ Label = getContext().createTempSymbol();
    EmitLabel(Label);
    CurrentWinFrameInfo.End = Label;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWinCFIStartChained">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 476,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 432,
   FQN="llvm::MCStreamer::EmitWinCFIStartChained", NM="_ZN4llvm10MCStreamer22EmitWinCFIStartChainedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer22EmitWinCFIStartChainedEv")
  //</editor-fold>
  public void EmitWinCFIStartChained() {
    EnsureValidWinFrameInfo();
    
    MCSymbol /*P*/ StartProc = getContext().createTempSymbol();
    EmitLabel(StartProc);
    
    WinFrameInfos.push_back_T$RR(new WinEH.FrameInfo(CurrentWinFrameInfo.Function, 
            StartProc, CurrentWinFrameInfo));
    CurrentWinFrameInfo = WinFrameInfos.back();
    CurrentWinFrameInfo.TextSection = getCurrentSectionOnly();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWinCFIEndChained">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 488,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 443,
   FQN="llvm::MCStreamer::EmitWinCFIEndChained", NM="_ZN4llvm10MCStreamer20EmitWinCFIEndChainedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer20EmitWinCFIEndChainedEv")
  //</editor-fold>
  public void EmitWinCFIEndChained() {
    EnsureValidWinFrameInfo();
    if (!(CurrentWinFrameInfo.ChainedParent != null)) {
      report_fatal_error($("End of a chained region outside a chained region!"));
    }
    
    MCSymbol /*P*/ Label = getContext().createTempSymbol();
    EmitLabel(Label);
    
    CurrentWinFrameInfo.End = Label;
    CurrentWinFrameInfo
       = ((/*const_cast*/WinEH.FrameInfo /*P*/ )(CurrentWinFrameInfo.ChainedParent));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWinCFIPushReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 555,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 478,
   FQN="llvm::MCStreamer::EmitWinCFIPushReg", NM="_ZN4llvm10MCStreamer17EmitWinCFIPushRegEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer17EmitWinCFIPushRegEj")
  //</editor-fold>
  public void EmitWinCFIPushReg(/*uint*/int Register) {
    EnsureValidWinFrameInfo();
    
    MCSymbol /*P*/ Label = getContext().createTempSymbol();
    EmitLabel(Label);
    
    WinEH.Instruction Inst = Win64EH.Instruction.PushNonVol(Label, Register);
    CurrentWinFrameInfo.Instructions.push_back_T$C$R(Inst);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWinCFISetFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 565,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 488,
   FQN="llvm::MCStreamer::EmitWinCFISetFrame", NM="_ZN4llvm10MCStreamer18EmitWinCFISetFrameEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer18EmitWinCFISetFrameEjj")
  //</editor-fold>
  public void EmitWinCFISetFrame(/*uint*/int Register, /*uint*/int Offset) {
    EnsureValidWinFrameInfo();
    if (CurrentWinFrameInfo.LastFrameInst >= 0) {
      report_fatal_error($("Frame register and offset already specified!"));
    }
    if (((Offset & 0x0F) != 0)) {
      report_fatal_error($("Misaligned frame pointer offset!"));
    }
    if ($greater_uint(Offset, 240)) {
      report_fatal_error($("Frame offset must be less than or equal to 240!"));
    }
    
    MCSymbol /*P*/ Label = getContext().createTempSymbol();
    EmitLabel(Label);
    
    WinEH.Instruction Inst = Win64EH.Instruction.SetFPReg(Label, Register, Offset);
    CurrentWinFrameInfo.LastFrameInst = CurrentWinFrameInfo.Instructions.size();
    CurrentWinFrameInfo.Instructions.push_back_T$C$R(Inst);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWinCFIAllocStack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 583,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 506,
   FQN="llvm::MCStreamer::EmitWinCFIAllocStack", NM="_ZN4llvm10MCStreamer20EmitWinCFIAllocStackEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer20EmitWinCFIAllocStackEj")
  //</editor-fold>
  public void EmitWinCFIAllocStack(/*uint*/int Size) {
    EnsureValidWinFrameInfo();
    if (Size == 0) {
      report_fatal_error($("Allocation size must be non-zero!"));
    }
    if (((Size & 7) != 0)) {
      report_fatal_error($("Misaligned stack allocation!"));
    }
    
    MCSymbol /*P*/ Label = getContext().createTempSymbol();
    EmitLabel(Label);
    
    WinEH.Instruction Inst = Win64EH.Instruction.Alloc(Label, Size);
    CurrentWinFrameInfo.Instructions.push_back_T$C$R(Inst);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWinCFISaveReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 597,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 520,
   FQN="llvm::MCStreamer::EmitWinCFISaveReg", NM="_ZN4llvm10MCStreamer17EmitWinCFISaveRegEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer17EmitWinCFISaveRegEjj")
  //</editor-fold>
  public void EmitWinCFISaveReg(/*uint*/int Register, /*uint*/int Offset) {
    EnsureValidWinFrameInfo();
    if (((Offset & 7) != 0)) {
      report_fatal_error($("Misaligned saved register offset!"));
    }
    
    MCSymbol /*P*/ Label = getContext().createTempSymbol();
    EmitLabel(Label);
    
    WinEH.Instruction Inst = Win64EH.Instruction.SaveNonVol(Label, Register, Offset);
    CurrentWinFrameInfo.Instructions.push_back_T$C$R(Inst);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWinCFISaveXMM">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 610,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 533,
   FQN="llvm::MCStreamer::EmitWinCFISaveXMM", NM="_ZN4llvm10MCStreamer17EmitWinCFISaveXMMEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer17EmitWinCFISaveXMMEjj")
  //</editor-fold>
  public void EmitWinCFISaveXMM(/*uint*/int Register, /*uint*/int Offset) {
    EnsureValidWinFrameInfo();
    if (((Offset & 0x0F) != 0)) {
      report_fatal_error($("Misaligned saved vector register offset!"));
    }
    
    MCSymbol /*P*/ Label = getContext().createTempSymbol();
    EmitLabel(Label);
    
    WinEH.Instruction Inst = Win64EH.Instruction.SaveXMM(Label, Register, Offset);
    CurrentWinFrameInfo.Instructions.push_back_T$C$R(Inst);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWinCFIPushFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 623,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 546,
   FQN="llvm::MCStreamer::EmitWinCFIPushFrame", NM="_ZN4llvm10MCStreamer19EmitWinCFIPushFrameEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer19EmitWinCFIPushFrameEb")
  //</editor-fold>
  public void EmitWinCFIPushFrame(boolean Code) {
    EnsureValidWinFrameInfo();
    if ($greater_uint(CurrentWinFrameInfo.Instructions.size(), 0)) {
      report_fatal_error($("If present, PushMachFrame must be the first UOP"));
    }
    
    MCSymbol /*P*/ Label = getContext().createTempSymbol();
    EmitLabel(Label);
    
    WinEH.Instruction Inst = Win64EH.Instruction.PushMachFrame(Label, Code);
    CurrentWinFrameInfo.Instructions.push_back_T$C$R(Inst);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWinCFIEndProlog">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 635,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 558,
   FQN="llvm::MCStreamer::EmitWinCFIEndProlog", NM="_ZN4llvm10MCStreamer19EmitWinCFIEndPrologEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer19EmitWinCFIEndPrologEv")
  //</editor-fold>
  public void EmitWinCFIEndProlog() {
    EnsureValidWinFrameInfo();
    
    MCSymbol /*P*/ Label = getContext().createTempSymbol();
    EmitLabel(Label);
    
    CurrentWinFrameInfo.PrologEnd = Label;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWinEHHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 501,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 456,
   FQN="llvm::MCStreamer::EmitWinEHHandler", NM="_ZN4llvm10MCStreamer16EmitWinEHHandlerEPKNS_8MCSymbolEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EmitWinEHHandlerEPKNS_8MCSymbolEbb")
  //</editor-fold>
  public void EmitWinEHHandler(/*const*/ MCSymbol /*P*/ Sym, boolean Unwind, 
                  boolean Except) {
    EnsureValidWinFrameInfo();
    if ((CurrentWinFrameInfo.ChainedParent != null)) {
      report_fatal_error($("Chained unwind areas can't have handlers!"));
    }
    CurrentWinFrameInfo.ExceptionHandler = Sym;
    if (!Except && !Unwind) {
      report_fatal_error($("Don't know what kind of handler this is!"));
    }
    if (Unwind) {
      CurrentWinFrameInfo.HandlesUnwind = true;
    }
    if (Except) {
      CurrentWinFrameInfo.HandlesExceptions = true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitWinEHHandlerData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 515,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 470,
   FQN="llvm::MCStreamer::EmitWinEHHandlerData", NM="_ZN4llvm10MCStreamer20EmitWinEHHandlerDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer20EmitWinEHHandlerDataEv")
  //</editor-fold>
  public void EmitWinEHHandlerData() {
    EnsureValidWinFrameInfo();
    if ((CurrentWinFrameInfo.ChainedParent != null)) {
      report_fatal_error($("Chained unwind areas can't have handlers!"));
    }
  }

  
  /// Get the .pdata section used for the given section. Typically the given
  /// section is either the main .text section or some other COMDAT .text
  /// section, but it may be any section containing code.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getAssociatedPDataSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 541,
   FQN="llvm::MCStreamer::getAssociatedPDataSection", NM="_ZN4llvm10MCStreamer25getAssociatedPDataSectionEPKNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer25getAssociatedPDataSectionEPKNS_9MCSectionE")
  //</editor-fold>
  public MCSection /*P*/ getAssociatedPDataSection(/*const*/ MCSection /*P*/ TextSec) {
    return MCStreamerStatics.getWinCFISection(getContext(), $AddrOf(NativePointer.create_uint$ptr2ConstT(NextWinCFIID)), 
        getContext().getObjectFileInfo().getPDataSection(), 
        TextSec);
  }

  
  /// Get the .xdata section used for the given section.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::getAssociatedXDataSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 547,
   FQN="llvm::MCStreamer::getAssociatedXDataSection", NM="_ZN4llvm10MCStreamer25getAssociatedXDataSectionEPKNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer25getAssociatedXDataSectionEPKNS_9MCSectionE")
  //</editor-fold>
  public MCSection /*P*/ getAssociatedXDataSection(/*const*/ MCSection /*P*/ TextSec) {
    return MCStreamerStatics.getWinCFISection(getContext(), $AddrOf(NativePointer.create_uint$ptr2ConstT(NextWinCFIID)), 
        getContext().getObjectFileInfo().getXDataSection(), 
        TextSec);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitSyntaxDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 553,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 476,
   FQN="llvm::MCStreamer::EmitSyntaxDirective", NM="_ZN4llvm10MCStreamer19EmitSyntaxDirectiveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer19EmitSyntaxDirectiveEv")
  //</editor-fold>
  public void EmitSyntaxDirective() {
  }

  
  /// \brief Emit a .reloc directive.
  /// Returns true if the relocation could not be emitted because Name is not
  /// known.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitRelocDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 774,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 692,
   FQN="llvm::MCStreamer::EmitRelocDirective", NM="_ZN4llvm10MCStreamer18EmitRelocDirectiveERKNS_6MCExprENS_9StringRefEPS2_NS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer18EmitRelocDirectiveERKNS_6MCExprENS_9StringRefEPS2_NS_5SMLocE")
  //</editor-fold>
  public /*virtual*/ boolean EmitRelocDirective(final /*const*/ MCExpr /*&*/ Offset, StringRef Name, 
                    /*const*/ MCExpr /*P*/ Expr, SMLoc Loc) {
    return true;
  }

  
  /// \brief Emit the given \p Instruction into the current section.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 724,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 647,
   FQN="llvm::MCStreamer::EmitInstruction", NM="_ZN4llvm10MCStreamer15EmitInstructionERKNS_6MCInstERKNS_15MCSubtargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer15EmitInstructionERKNS_6MCInstERKNS_15MCSubtargetInfoE")
  //</editor-fold>
  public void EmitInstruction(final /*const*/ MCInst /*&*/ Inst, 
                 final /*const*/ MCSubtargetInfo /*&*/ STI) {
    // Scan for values.
    for (/*uint*/int i = Inst.getNumOperands(); ((i--) != 0);)  {
      if (Inst.getOperand$Const(i).isExpr()) {
        visitUsedExpr($Deref(Inst.getOperand$Const(i).getExpr()));
      }
    }
  }

  
  /// \brief Set the bundle alignment mode from now on in the section.
  /// The argument is the power of 2 to which the alignment is set. The
  /// value 0 means turn the bundle alignment off.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitBundleAlignMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 782,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 701,
   FQN="llvm::MCStreamer::EmitBundleAlignMode", NM="_ZN4llvm10MCStreamer19EmitBundleAlignModeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer19EmitBundleAlignModeEj")
  //</editor-fold>
  public void EmitBundleAlignMode(/*uint*/int AlignPow2) {
  }

  
  /// \brief The following instructions are a bundle-locked group.
  ///
  /// \param AlignToEnd - If true, the bundle-locked group will be aligned to
  ///                     the end of a bundle.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitBundleLock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 783,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 702,
   FQN="llvm::MCStreamer::EmitBundleLock", NM="_ZN4llvm10MCStreamer14EmitBundleLockEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer14EmitBundleLockEb")
  //</editor-fold>
  public void EmitBundleLock(boolean AlignToEnd) {
  }

  
  /// \brief Ends a bundle-locked group.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitBundleUnlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 785,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 704,
   FQN="llvm::MCStreamer::EmitBundleUnlock", NM="_ZN4llvm10MCStreamer16EmitBundleUnlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer16EmitBundleUnlockEv")
  //</editor-fold>
  public void EmitBundleUnlock() {
  }

  
  /// \brief If this file is backed by a assembly streamer, this dumps the
  /// specified string in the output .s file.  This capability is indicated by
  /// the hasRawTextSupport() predicate.  By default this aborts.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::EmitRawText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 662,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 585,
   FQN="llvm::MCStreamer::EmitRawText", NM="_ZN4llvm10MCStreamer11EmitRawTextERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer11EmitRawTextERKNS_5TwineE")
  //</editor-fold>
  public void EmitRawText(final /*const*/ Twine /*&*/ T) {
    SmallString/*128*/ Str/*J*/= new SmallString/*128*/(128);
    EmitRawTextImpl(T.toStringRef(Str));
  }

  
  /// \brief Streamer specific finalization.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::FinishImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 784,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 703,
   FQN="llvm::MCStreamer::FinishImpl", NM="_ZN4llvm10MCStreamer10FinishImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer10FinishImplEv")
  //</editor-fold>
  public void FinishImpl() {
  }

  /// \brief Finish emission of machine code.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::Finish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", line = 670,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp", old_line = 593,
   FQN="llvm::MCStreamer::Finish", NM="_ZN4llvm10MCStreamer6FinishEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm10MCStreamer6FinishEv")
  //</editor-fold>
  public void Finish() {
    if (!DwarfFrameInfos.empty() && !(DwarfFrameInfos.back().End != null)) {
      report_fatal_error($("Unfinished frame!"));
    }
    
    MCTargetStreamer /*P*/ TS = getTargetStreamer();
    if ((TS != null)) {
      TS.finish();
    }
    
    FinishImpl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCStreamer::mayHaveInstructions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", line = 806,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCStreamer.h", old_line = 724,
   FQN="llvm::MCStreamer::mayHaveInstructions", NM="_ZNK4llvm10MCStreamer19mayHaveInstructionsERNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZNK4llvm10MCStreamer19mayHaveInstructionsERNS_9MCSectionE")
  //</editor-fold>
  public /*virtual*/ boolean mayHaveInstructions(final MCSection /*&*/ Sec) /*const*/ {
    return true;
  }

  
  @Override public String toString() {
    return "" + "Context=" + "[MCContext]" // NOI18N
              + ", TargetStreamer=" + TargetStreamer // NOI18N
              + ", DwarfFrameInfos=" + DwarfFrameInfos // NOI18N
              + ", WinFrameInfos=" + WinFrameInfos // NOI18N
              + ", CurrentWinFrameInfo=" + CurrentWinFrameInfo // NOI18N
              + ", SymbolOrdering=" + SymbolOrdering // NOI18N
              + ", SectionStack=" + SectionStack // NOI18N
              + ", NextWinCFIID=" + NextWinCFIID; // NOI18N
  }
}
