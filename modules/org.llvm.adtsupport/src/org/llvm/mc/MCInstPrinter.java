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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.mc.impl.MCInstPrinterStatics;


/// \brief This is an instance of a target assembly language printer that
/// converts an MCInst to valid target assembly syntax.
//<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstPrinter.h", line = 38,
 FQN="llvm::MCInstPrinter", NM="_ZN4llvm13MCInstPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm13MCInstPrinterE")
//</editor-fold>
public abstract class MCInstPrinter implements Destructors.ClassWithDestructor {
/*protected:*/
  /// \brief A stream that comments can be emitted to if desired.  Each comment
  /// must end with a newline.  This will be null if verbose assembly emission
  /// is disable.
  protected raw_ostream /*P*/ CommentStream;
  protected final /*const*/ MCAsmInfo /*&*/ MAI;
  protected final /*const*/ MCInstrInfo /*&*/ MII;
  protected final /*const*/ MCRegisterInfo /*&*/ MRI;
  
  /// True if we are printing marked up assembly.
  protected boolean UseMarkup;
  
  /// True if we are printing immediates as hex.
  protected boolean PrintImmHex;
  
  /// Which style to use for printing hexadecimal values.
  protected HexStyle.Style PrintHexStyle;
  
  /// Utility function for printing annotations.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::printAnnotation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp", line = 41,
   FQN="llvm::MCInstPrinter::printAnnotation", NM="_ZN4llvm13MCInstPrinter15printAnnotationERNS_11raw_ostreamENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm13MCInstPrinter15printAnnotationERNS_11raw_ostreamENS_9StringRefE")
  //</editor-fold>
  protected void printAnnotation(final raw_ostream /*&*/ OS, StringRef Annot) {
    if (!Annot.empty()) {
      if ((CommentStream != null)) {
        ($Deref(CommentStream)).$out(/*NO_COPY*/Annot);
        // By definition (see MCInstPrinter.h), CommentStream must end with
        // a newline after each comment.
        if (Annot.back() != $$LF) {
          ($Deref(CommentStream)).$out_char($$LF);
        }
      } else {
        OS.$out(/*KEEP_STR*/$SPACE).$out(MAI.getCommentString()).$out(/*KEEP_STR*/$SPACE).$out(/*NO_COPY*/Annot);
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::MCInstPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstPrinter.h", line = 61,
   FQN="llvm::MCInstPrinter::MCInstPrinter", NM="_ZN4llvm13MCInstPrinterC1ERKNS_9MCAsmInfoERKNS_11MCInstrInfoERKNS_14MCRegisterInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm13MCInstPrinterC1ERKNS_9MCAsmInfoERKNS_11MCInstrInfoERKNS_14MCRegisterInfoE")
  //</editor-fold>
  public MCInstPrinter(final /*const*/ MCAsmInfo /*&*/ mai, final /*const*/ MCInstrInfo /*&*/ mii, 
      final /*const*/ MCRegisterInfo /*&*/ mri) {
    // : CommentStream(null), MAI(mai), MII(mii), MRI(mri), UseMarkup(0), PrintImmHex(0), PrintHexStyle(HexStyle::C) 
    //START JInit
    this.CommentStream = null;
    this./*&*/MAI=/*&*/mai;
    this./*&*/MII=/*&*/mii;
    this./*&*/MRI=/*&*/mri;
    this.UseMarkup = false;
    this.PrintImmHex = false;
    this.PrintHexStyle = HexStyle.Style.C;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::~MCInstPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp", line = 28,
   FQN="llvm::MCInstPrinter::~MCInstPrinter", NM="_ZN4llvm13MCInstPrinterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm13MCInstPrinterD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// \brief Specify a stream to emit comments to.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::setCommentStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstPrinter.h", line = 69,
   FQN="llvm::MCInstPrinter::setCommentStream", NM="_ZN4llvm13MCInstPrinter16setCommentStreamERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm13MCInstPrinter16setCommentStreamERNS_11raw_ostreamE")
  //</editor-fold>
  public void setCommentStream(final raw_ostream /*&*/ OS) {
    CommentStream = $AddrOf(OS);
  }

  
  /// \brief Print the specified MCInst to the specified raw_ostream.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::printInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstPrinter.h", line = 72,
   FQN="llvm::MCInstPrinter::printInst", NM="_ZN4llvm13MCInstPrinter9printInstEPKNS_6MCInstERNS_11raw_ostreamENS_9StringRefERKNS_15MCSubtargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm13MCInstPrinter9printInstEPKNS_6MCInstERNS_11raw_ostreamENS_9StringRefERKNS_15MCSubtargetInfoE")
  //</editor-fold>
  public abstract /*virtual*/ void printInst(/*const*/ MCInst /*P*/ MI, final raw_ostream /*&*/ OS, StringRef Annot, 
           final /*const*/ MCSubtargetInfo /*&*/ STI)/* = 0*/;

  
  /// \brief Return the name of the specified opcode enum (e.g. "MOV32ri") or
  /// empty if we can't resolve it.
  
  /// getOpcodeName - Return the name of the specified opcode enum (e.g.
  /// "MOV32ri") or empty if we can't resolve it.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::getOpcodeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp", line = 33,
   FQN="llvm::MCInstPrinter::getOpcodeName", NM="_ZNK4llvm13MCInstPrinter13getOpcodeNameEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCInstPrinter13getOpcodeNameEj")
  //</editor-fold>
  public StringRef getOpcodeName(/*uint*/int Opcode) /*const*/ {
    return new StringRef(MII.getName(Opcode));
  }

  
  /// \brief Print the assembler register name.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::printRegName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp", line = 37,
   FQN="llvm::MCInstPrinter::printRegName", NM="_ZNK4llvm13MCInstPrinter12printRegNameERNS_11raw_ostreamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCInstPrinter12printRegNameERNS_11raw_ostreamEj")
  //</editor-fold>
  public void printRegName(final raw_ostream /*&*/ OS, /*uint*/int RegNo) /*const*/ {
    throw new llvm_unreachable("Target should implement this");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::getUseMarkup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstPrinter.h", line = 82,
   FQN="llvm::MCInstPrinter::getUseMarkup", NM="_ZNK4llvm13MCInstPrinter12getUseMarkupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCInstPrinter12getUseMarkupEv")
  //</editor-fold>
  public boolean getUseMarkup() /*const*/ {
    return UseMarkup;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::setUseMarkup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstPrinter.h", line = 83,
   FQN="llvm::MCInstPrinter::setUseMarkup", NM="_ZN4llvm13MCInstPrinter12setUseMarkupEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm13MCInstPrinter12setUseMarkupEb")
  //</editor-fold>
  public void setUseMarkup(boolean Value) {
    UseMarkup = Value;
  }

  
  /// Utility functions to make adding mark ups simpler.
  
  /// Utility functions to make adding mark ups simpler.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::markup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp", line = 55,
   FQN="llvm::MCInstPrinter::markup", NM="_ZNK4llvm13MCInstPrinter6markupENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCInstPrinter6markupENS_9StringRefE")
  //</editor-fold>
  public StringRef markup(StringRef s) /*const*/ {
    if (getUseMarkup()) {
      return new StringRef(JD$Move.INSTANCE, s);
    } else {
      return new StringRef(/*KEEP_STR*/$EMPTY);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::markup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp", line = 61,
   FQN="llvm::MCInstPrinter::markup", NM="_ZNK4llvm13MCInstPrinter6markupENS_9StringRefES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCInstPrinter6markupENS_9StringRefES1_")
  //</editor-fold>
  public StringRef markup(StringRef a, StringRef b) /*const*/ {
    if (getUseMarkup()) {
      return new StringRef(JD$Move.INSTANCE, a);
    } else {
      return new StringRef(JD$Move.INSTANCE, b);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::getPrintImmHex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstPrinter.h", line = 89,
   FQN="llvm::MCInstPrinter::getPrintImmHex", NM="_ZNK4llvm13MCInstPrinter14getPrintImmHexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCInstPrinter14getPrintImmHexEv")
  //</editor-fold>
  public boolean getPrintImmHex() /*const*/ {
    return PrintImmHex;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::setPrintImmHex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstPrinter.h", line = 90,
   FQN="llvm::MCInstPrinter::setPrintImmHex", NM="_ZN4llvm13MCInstPrinter14setPrintImmHexEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm13MCInstPrinter14setPrintImmHexEb")
  //</editor-fold>
  public void setPrintImmHex(boolean Value) {
    PrintImmHex = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::getPrintHexStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstPrinter.h", line = 92,
   FQN="llvm::MCInstPrinter::getPrintHexStyle", NM="_ZNK4llvm13MCInstPrinter16getPrintHexStyleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCInstPrinter16getPrintHexStyleEv")
  //</editor-fold>
  public HexStyle.Style getPrintHexStyle() /*const*/ {
    return PrintHexStyle;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::setPrintHexStyle">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstPrinter.h", line = 93,
   FQN="llvm::MCInstPrinter::setPrintHexStyle", NM="_ZN4llvm13MCInstPrinter16setPrintHexStyleENS_8HexStyle5StyleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm13MCInstPrinter16setPrintHexStyleENS_8HexStyle5StyleE")
  //</editor-fold>
  public void setPrintHexStyle(HexStyle.Style Value) {
    PrintHexStyle = Value;
  }

  
  /// Utility function to print immediates in decimal or hex.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::formatImm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstPrinter.h", line = 96,
   FQN="llvm::MCInstPrinter::formatImm", NM="_ZNK4llvm13MCInstPrinter9formatImmEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCInstPrinter9formatImmEx")
  //</editor-fold>
  public format_object formatImm(long/*int64_t*/ Value) /*const*/ {
    return PrintImmHex ? formatHex_long(Value) : formatDec(Value);
  }

  
  /// Utility functions to print decimal/hexadecimal values.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::formatDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp", line = 81,
   FQN="llvm::MCInstPrinter::formatDec", NM="_ZNK4llvm13MCInstPrinter9formatDecEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCInstPrinter9formatDecEx")
  //</editor-fold>
  public format_object formatDec(long/*int64_t*/ Value) /*const*/ {
    return AdtsupportLlvmGlobals.format(/*KEEP_STR*/$("%lld"), Value);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::formatHex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp", line = 85,
   FQN="llvm::MCInstPrinter::formatHex", NM="_ZNK4llvm13MCInstPrinter9formatHexEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCInstPrinter9formatHexEx")
  //</editor-fold>
  public format_object formatHex_long(long/*int64_t*/ Value) /*const*/ {
    switch (PrintHexStyle) {
     case C:
      if (Value < 0) {
        return AdtsupportLlvmGlobals.format(/*KEEP_STR*/$("-0x%llx"), -Value);
      } else {
        return AdtsupportLlvmGlobals.format(/*KEEP_STR*/$("0x%llx"), Value);
      }
     case Asm:
      if (Value < 0) {
        if (MCInstPrinterStatics.needsLeadingZero((long/*uint64_t*/)(-Value))) {
          return AdtsupportLlvmGlobals.format(/*KEEP_STR*/$("-0%llxh"), -Value);
        } else {
          return AdtsupportLlvmGlobals.format(/*KEEP_STR*/$("-%llxh"), -Value);
        }
      } else {
        if (MCInstPrinterStatics.needsLeadingZero((long/*uint64_t*/)(Value))) {
          return AdtsupportLlvmGlobals.format(/*KEEP_STR*/$("0%llxh"), Value);
        } else {
          return AdtsupportLlvmGlobals.format(/*KEEP_STR*/$("%llxh"), Value);
        }
      }
    }
    throw new llvm_unreachable("unsupported print style");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInstPrinter::formatHex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp", line = 108,
   FQN="llvm::MCInstPrinter::formatHex", NM="_ZNK4llvm13MCInstPrinter9formatHexEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCInstPrinter9formatHexEy")
  //</editor-fold>
  public format_object formatHex_ulong(long/*uint64_t*/ Value) /*const*/ {
    switch (PrintHexStyle) {
     case C:
      return AdtsupportLlvmGlobals.format(/*KEEP_STR*/$("0x%llx"), Value);
     case Asm:
      if (MCInstPrinterStatics.needsLeadingZero(Value)) {
        return AdtsupportLlvmGlobals.format(/*KEEP_STR*/$("0%llxh"), Value);
      } else {
        return AdtsupportLlvmGlobals.format(/*KEEP_STR*/$("%llxh"), Value);
      }
    }
    throw new llvm_unreachable("unsupported print style");
  }

  
  @Override public String toString() {
    return "" + "CommentStream=" + CommentStream // NOI18N
              + ", MAI=" + MAI // NOI18N
              + ", MII=" + MII // NOI18N
              + ", MRI=" + MRI // NOI18N
              + ", UseMarkup=" + UseMarkup // NOI18N
              + ", PrintImmHex=" + PrintImmHex // NOI18N
              + ", PrintHexStyle=" + PrintHexStyle; // NOI18N
  }
}
