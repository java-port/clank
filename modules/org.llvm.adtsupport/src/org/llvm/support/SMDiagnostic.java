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

package org.llvm.support;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.impl.*;
import static org.llvm.support.impl.SourceMgrStatics.*;


/// Instances of this class encapsulate one diagnostic report, allowing
/// printing to a raw_ostream as a caret diagnostic.
//<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 233,
 FQN="llvm::SMDiagnostic", NM="_ZN4llvm12SMDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZN4llvm12SMDiagnosticE")
//</editor-fold>
public class SMDiagnostic implements Destructors.ClassWithDestructor {
  private /*const*/ SourceMgr /*P*/ SM;
  private SMLoc Loc;
  private std.string Filename;
  private int LineNo;
  private int ColumnNo;
  private SourceMgr.DiagKind Kind;
  private std.string Message;
  private std.string LineContents;
  private std.vector<std.pairUIntUInt> Ranges;
  private SmallVector<SMFixIt> FixIts;
/*public:*/
  // Null diagnostic.
  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::SMDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 245,
   FQN="llvm::SMDiagnostic::SMDiagnostic", NM="_ZN4llvm12SMDiagnosticC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZN4llvm12SMDiagnosticC1Ev")
  //</editor-fold>
  public SMDiagnostic() {
    // : SM(null), Loc(), Filename(), LineNo(0), ColumnNo(0), Kind(SourceMgr::DK_Error), Message(), LineContents(), Ranges(), FixIts() 
    //START JInit
    this.SM = null;
    this.Loc = new SMLoc();
    this.Filename = new std.string();
    this.LineNo = 0;
    this.ColumnNo = 0;
    this.Kind = SourceMgr.DiagKind.DK_Error;
    this.Message = new std.string();
    this.LineContents = new std.string();
    this.Ranges = new std.vector<std.pairUIntUInt>(new std.pairUIntUInt());
    this.FixIts = new SmallVector<SMFixIt>(4, new SMFixIt());
    //END JInit
  }

  // Diagnostic with no location (e.g. file not found, command line arg error).
  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::SMDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 248,
   FQN="llvm::SMDiagnostic::SMDiagnostic", NM="_ZN4llvm12SMDiagnosticC1ENS_9StringRefENS_9SourceMgr8DiagKindES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZN4llvm12SMDiagnosticC1ENS_9StringRefENS_9SourceMgr8DiagKindES1_")
  //</editor-fold>
  public SMDiagnostic(StringRef filename, SourceMgr.DiagKind Knd, StringRef Msg) {
    // : SM(null), Loc(), Filename(filename.operator basic_string()), LineNo(-1), ColumnNo(-1), Kind(Knd), Message(Msg.operator basic_string()), LineContents(), Ranges(), FixIts() 
    //START JInit
    this.SM = null;
    this.Loc = new SMLoc();
    this.Filename = filename.$string();
    this.LineNo = -1;
    this.ColumnNo = -1;
    this.Kind = Knd;
    this.Message = Msg.$string();
    this.LineContents = new std.string();
    this.Ranges = new std.vector<std.pairUIntUInt>(new std.pairUIntUInt());
    this.FixIts = new SmallVector<SMFixIt>(4, new SMFixIt());
    //END JInit
  }

  
  // Diagnostic with a location.
  
  // Diagnostic with a location.
  
  //===----------------------------------------------------------------------===//
  // SMDiagnostic Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::SMDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 232,
   FQN="llvm::SMDiagnostic::SMDiagnostic", NM="_ZN4llvm12SMDiagnosticC1ERKNS_9SourceMgrENS_5SMLocENS_9StringRefEiiNS1_8DiagKindES5_S5_NS_8ArrayRefISt4pairIjjEEENS7_INS_7SMFixItEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm12SMDiagnosticC1ERKNS_9SourceMgrENS_5SMLocENS_9StringRefEiiNS1_8DiagKindES5_S5_NS_8ArrayRefISt4pairIjjEEENS7_INS_7SMFixItEEE")
  //</editor-fold>
  public SMDiagnostic(final /*const*/ SourceMgr /*&*/ sm, SMLoc L, StringRef FN, 
      int Line, int Col, SourceMgr.DiagKind Kind, 
      StringRef Msg, StringRef LineStr, 
      ArrayRef<std.pairUIntUInt> Ranges) {
    this(sm, L, FN, 
      Line, Col, Kind, 
      Msg, LineStr, 
      Ranges, 
      new ArrayRef<SMFixIt>(None, false));
  }
  public SMDiagnostic(final /*const*/ SourceMgr /*&*/ sm, SMLoc L, StringRef FN, 
      int Line, int Col, SourceMgr.DiagKind Kind, 
      StringRef Msg, StringRef LineStr, 
      ArrayRef<std.pairUIntUInt> Ranges, 
      ArrayRef<SMFixIt> Hints/*= None*/) {
    // : SM(&sm), Loc(L), Filename(FN.operator basic_string()), LineNo(Line), ColumnNo(Col), Kind(Kind), Message(Msg.operator basic_string()), LineContents(LineStr.operator basic_string()), Ranges($c$.track(Ranges.vec())), FixIts(Hints.begin(), Hints.end()) 
    //START JInit
    this.SM = $AddrOf(sm);
    this.Loc = new SMLoc(L);
    this.Filename = FN.$string();
    this.LineNo = Line;
    this.ColumnNo = Col;
    this.Kind = Kind;
    this.Message = Msg.$string();
    this.LineContents = LineStr.$string();
    this.Ranges = Ranges.vec();
    this.FixIts = new SmallVector<SMFixIt>(JD$T.INSTANCE, 4, Hints.begin(), Hints.end(), new SMFixIt());
    //END JInit
    std.sort(FixIts.begin(), FixIts.end());
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::getSourceMgr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 259,
   FQN="llvm::SMDiagnostic::getSourceMgr", NM="_ZNK4llvm12SMDiagnostic12getSourceMgrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZNK4llvm12SMDiagnostic12getSourceMgrEv")
  //</editor-fold>
  public /*const*/ SourceMgr /*P*/ getSourceMgr() /*const*/ {
    return SM;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::getLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 260,
   FQN="llvm::SMDiagnostic::getLoc", NM="_ZNK4llvm12SMDiagnostic6getLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZNK4llvm12SMDiagnostic6getLocEv")
  //</editor-fold>
  public SMLoc getLoc() /*const*/ {
    return new SMLoc(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::getFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 261,
   FQN="llvm::SMDiagnostic::getFilename", NM="_ZNK4llvm12SMDiagnostic11getFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZNK4llvm12SMDiagnostic11getFilenameEv")
  //</editor-fold>
  public StringRef getFilename() /*const*/ {
    return new StringRef(Filename);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::getLineNo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 262,
   FQN="llvm::SMDiagnostic::getLineNo", NM="_ZNK4llvm12SMDiagnostic9getLineNoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZNK4llvm12SMDiagnostic9getLineNoEv")
  //</editor-fold>
  public int getLineNo() /*const*/ {
    return LineNo;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::getColumnNo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 263,
   FQN="llvm::SMDiagnostic::getColumnNo", NM="_ZNK4llvm12SMDiagnostic11getColumnNoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZNK4llvm12SMDiagnostic11getColumnNoEv")
  //</editor-fold>
  public int getColumnNo() /*const*/ {
    return ColumnNo;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 264,
   FQN="llvm::SMDiagnostic::getKind", NM="_ZNK4llvm12SMDiagnostic7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZNK4llvm12SMDiagnostic7getKindEv")
  //</editor-fold>
  public SourceMgr.DiagKind getKind() /*const*/ {
    return Kind;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::getMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 265,
   FQN="llvm::SMDiagnostic::getMessage", NM="_ZNK4llvm12SMDiagnostic10getMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZNK4llvm12SMDiagnostic10getMessageEv")
  //</editor-fold>
  public StringRef getMessage() /*const*/ {
    return new StringRef(Message);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::getLineContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 266,
   FQN="llvm::SMDiagnostic::getLineContents", NM="_ZNK4llvm12SMDiagnostic15getLineContentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZNK4llvm12SMDiagnostic15getLineContentsEv")
  //</editor-fold>
  public StringRef getLineContents() /*const*/ {
    return new StringRef(LineContents);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::getRanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 267,
   FQN="llvm::SMDiagnostic::getRanges", NM="_ZNK4llvm12SMDiagnostic9getRangesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZNK4llvm12SMDiagnostic9getRangesEv")
  //</editor-fold>
  public ArrayRef<std.pairUIntUInt> getRanges() /*const*/ {
    return new ArrayRef<std.pairUIntUInt>(Ranges, false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::addFixIt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 271,
   FQN="llvm::SMDiagnostic::addFixIt", NM="_ZN4llvm12SMDiagnostic8addFixItERKNS_7SMFixItE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZN4llvm12SMDiagnostic8addFixItERKNS_7SMFixItE")
  //</editor-fold>
  public void addFixIt(final /*const*/ SMFixIt /*&*/ Hint) {
    FixIts.push_back_T$C$R(Hint);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::getFixIts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 275,
   FQN="llvm::SMDiagnostic::getFixIts", NM="_ZNK4llvm12SMDiagnostic9getFixItsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZNK4llvm12SMDiagnostic9getFixItsEv")
  //</editor-fold>
  public ArrayRef<SMFixIt> getFixIts() /*const*/ {
    return new ArrayRef<SMFixIt>(FixIts, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp", line = 335,
   FQN="llvm::SMDiagnostic::print", NM="_ZNK4llvm12SMDiagnostic5printEPKcRNS_11raw_ostreamEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZNK4llvm12SMDiagnostic5printEPKcRNS_11raw_ostreamEbb")
  //</editor-fold>
  public void print(/*const*/char$ptr/*char P*/ ProgName, final raw_ostream /*&*/ S) /*const*/ {
    print(ProgName, S, true, 
       true);
  }
  public void print(/*const*/char$ptr/*char P*/ ProgName, final raw_ostream /*&*/ S, boolean ShowColors/*= true*/) /*const*/ {
    print(ProgName, S, ShowColors, 
       true);
  }
  public void print(/*const*/char$ptr/*char P*/ ProgName, final raw_ostream /*&*/ S, boolean ShowColors/*= true*/, 
       boolean ShowKindLabel/*= true*/) /*const*/ {
    // Display colors only if OS supports colors.
    ShowColors &= S.has_colors();
    if (ShowColors) {
      S.changeColor(raw_ostream.Colors.SAVEDCOLOR, true);
    }
    if (Native.$bool(ProgName) && (ProgName.$at(0) != 0)) {
      S.$out(ProgName).$out(/*KEEP_STR*/": ");
    }
    if (!Filename.empty()) {
      if ($eq_string$C_T$C$P(Filename, /*KEEP_STR*/"-")) {
        S.$out(/*KEEP_STR*/"<stdin>");
      } else {
        S.$out(Filename);
      }
      if (LineNo != -1) {
        S.$out_char($$COLON).$out_int(LineNo);
        if (ColumnNo != -1) {
          S.$out_char($$COLON).$out_int((ColumnNo + 1));
        }
      }
      S.$out(/*KEEP_STR*/": ");
    }
    if (ShowKindLabel) {
      switch (Kind) {
       case DK_Error:
        if (ShowColors) {
          S.changeColor(raw_ostream.Colors.RED, true);
        }
        S.$out(/*KEEP_STR*/"error: ");
        break;
       case DK_Warning:
        if (ShowColors) {
          S.changeColor(raw_ostream.Colors.MAGENTA, true);
        }
        S.$out(/*KEEP_STR*/"warning: ");
        break;
       case DK_Note:
        if (ShowColors) {
          S.changeColor(raw_ostream.Colors.BLACK, true);
        }
        S.$out(/*KEEP_STR*/"note: ");
        break;
      }
      if (ShowColors) {
        S.resetColor();
        S.changeColor(raw_ostream.Colors.SAVEDCOLOR, true);
      }
    }
    
    S.$out(Message).$out_char($$LF);
    if (ShowColors) {
      S.resetColor();
    }
    if (LineNo == -1 || ColumnNo == -1) {
      return;
    }
    
    // FIXME: If there are multibyte or multi-column characters in the source, all
    // our ranges will be wrong. To do this properly, we'll need a byte-to-column
    // map like Clang's TextDiagnostic. For now, we'll just handle tabs by
    // expanding them later, and bail out rather than show incorrect ranges and
    // misaligned fixits for any other odd characters.
    if ($noteq___normal_iterator$C(std.find_if(LineContents.begin$Const(), LineContents.end$Const(), /*FuncRef*/SourceMgrStatics::isNonASCII), 
        LineContents.end$Const())) {
      printSourceLine(S, new StringRef(LineContents));
      return;
    }
    /*size_t*/int NumColumns = LineContents.size();
    
    // Build the line with the caret and ranges.
    std.string CaretLine/*J*/= new std.string(NumColumns + 1, $$SPACE);
    
    // Expand any ranges.
    for (/*uint*/int r = 0, e = Ranges.size(); r != e; ++r) {
      std.pairUIntUInt R = new std.pairUIntUInt(Ranges.$at$Const(r));
      std.fill($AddrOf(CaretLine.ptr$at(R.first)), 
          $AddrOf(CaretLine.ptr$at(std.min_uint((/*size_t*/int)R.second, CaretLine.size()))), 
          $$TILDE);
    }
    
    // Add any fix-its.
    // FIXME: Find the beginning of the line properly for multibyte characters.
    std.string FixItInsertionLine/*J*/= new std.string();
    buildFixItLine(CaretLine, FixItInsertionLine, new ArrayRef<SMFixIt>(FixIts, false), 
        makeArrayRef(Loc.getPointer().$sub(ColumnNo), 
            LineContents.size()));
    
    // Finally, plop on the caret.
    if ($lesseq_uint(((/*uint*/int)(ColumnNo)), NumColumns)) {
      CaretLine.$set(ColumnNo, $$CARET);
    } else {
      CaretLine.$set(NumColumns, $$CARET);
    }
    
    // ... and remove trailing whitespace so the output doesn't wrap for it.  We
    // know that the line isn't completely empty because it has the caret in it at
    // least.
    CaretLine.erase(CaretLine.find_last_not_of_T_size_type$_CharT($$SPACE) + 1);
    
    printSourceLine(S, new StringRef(LineContents));
    if (ShowColors) {
      S.changeColor(raw_ostream.Colors.GREEN, true);
    }
    
    // Print out the caret line, matching tabs in the source line.
    for (/*uint*/int i = 0, e = CaretLine.size(), OutCol = 0; i != e; ++i) {
      if ($greatereq_uint(i, LineContents.size()) || LineContents.$at$Const(i) != $$TAB) {
        S.$out_char(CaretLine.$at(i));
        ++OutCol;
        continue;
      }
      
      // Okay, we have a tab.  Insert the appropriate number of characters.
      do {
        S.$out_char(CaretLine.$at(i));
        ++OutCol;
      } while (($rem_uint(OutCol, TabStop)) != 0);
    }
    S.$out_char($$LF);
    if (ShowColors) {
      S.resetColor();
    }
    
    // Print out the replacement line, matching tabs in the source line.
    if (FixItInsertionLine.empty()) {
      return;
    }
    
    for (/*size_t*/int i = 0, e = FixItInsertionLine.size(), OutCol = 0; $less_uint(i, e); ++i) {
      if ($greatereq_uint(i, LineContents.size()) || LineContents.$at$Const(i) != $$TAB) {
        S.$out_char(FixItInsertionLine.$at(i));
        ++OutCol;
        continue;
      }
      
      // Okay, we have a tab.  Insert the appropriate number of characters.
      do {
        S.$out_char(FixItInsertionLine.$at(i));
        // FIXME: This is trying not to break up replacements, but then to re-sync
        // with the tabs between replacements. This will fail, though, if two
        // fix-it replacements are exactly adjacent, or if a fix-it contains a
        // space. Really we should be precomputing column widths, which we'll
        // need anyway for multibyte chars.
        if (FixItInsertionLine.$at(i) != $$SPACE) {
          ++i;
        }
        ++OutCol;
      } while ((($rem_uint(OutCol, TabStop)) != 0) && i != e);
    }
    S.$out_char($$LF);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 233,
   FQN="llvm::SMDiagnostic::operator=", NM="_ZN4llvm12SMDiagnosticaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZN4llvm12SMDiagnosticaSEOS0_")
  //</editor-fold>
  public /*inline*/ SMDiagnostic /*&*/ $assignMove(final SMDiagnostic /*&&*/$Prm0) {
    this.SM = $Prm0.SM;
    this.Loc.$assignMove($Prm0.Loc);
    this.Filename.$assignMove($Prm0.Filename);
    this.LineNo = $Prm0.LineNo;
    this.ColumnNo = $Prm0.ColumnNo;
    this.Kind = $Prm0.Kind;
    this.Message.$assignMove($Prm0.Message);
    this.LineContents.$assignMove($Prm0.LineContents);
    this.Ranges.$assignMove($Prm0.Ranges);
    this.FixIts.$assignMove($Prm0.FixIts);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::~SMDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 233,
   FQN="llvm::SMDiagnostic::~SMDiagnostic", NM="_ZN4llvm12SMDiagnosticD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/AsmParser/Parser.cpp -nm=_ZN4llvm12SMDiagnosticD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FixIts.$destroy();
    Ranges.$destroy();
    LineContents.$destroy();
    Message.$destroy();
    Filename.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::SMDiagnostic::SMDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SourceMgr.h", line = 233,
   FQN="llvm::SMDiagnostic::SMDiagnostic", NM="_ZN4llvm12SMDiagnosticC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SourceMgr.cpp -nm=_ZN4llvm12SMDiagnosticC1EOS0_")
  //</editor-fold>
  public /*inline*/ SMDiagnostic(JD$Move _dparam, final SMDiagnostic /*&&*/$Prm0) {
    // : SM(static_cast<SMDiagnostic &&>().SM), Loc(static_cast<SMDiagnostic &&>().Loc), Filename(static_cast<SMDiagnostic &&>().Filename), LineNo(static_cast<SMDiagnostic &&>().LineNo), ColumnNo(static_cast<SMDiagnostic &&>().ColumnNo), Kind(static_cast<SMDiagnostic &&>().Kind), Message(static_cast<SMDiagnostic &&>().Message), LineContents(static_cast<SMDiagnostic &&>().LineContents), Ranges(static_cast<SMDiagnostic &&>().Ranges), FixIts(static_cast<SMDiagnostic &&>().FixIts) 
    //START JInit
    this.SM = $Prm0.SM;
    this.Loc = new SMLoc(JD$Move.INSTANCE, $Prm0.Loc);
    this.Filename = new std.string(JD$Move.INSTANCE, $Prm0.Filename);
    this.LineNo = $Prm0.LineNo;
    this.ColumnNo = $Prm0.ColumnNo;
    this.Kind = $Prm0.Kind;
    this.Message = new std.string(JD$Move.INSTANCE, $Prm0.Message);
    this.LineContents = new std.string(JD$Move.INSTANCE, $Prm0.LineContents);
    this.Ranges = new std.vector<std.pairUIntUInt>(JD$Move.INSTANCE, $Prm0.Ranges);
    this.FixIts = new SmallVector<SMFixIt>(JD$Move.INSTANCE, $Prm0.FixIts);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "SM=" + SM // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", Filename=" + Filename // NOI18N
              + ", LineNo=" + LineNo // NOI18N
              + ", ColumnNo=" + ColumnNo // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", Message=" + Message // NOI18N
              + ", LineContents=" + LineContents // NOI18N
              + ", Ranges=" + Ranges // NOI18N
              + ", FixIts=" + FixIts; // NOI18N
  }
}
