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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clank.java.stdimpl.aliases.*;


/// Holds state from .cv_file and .cv_loc directives for later emission.
//<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 108,
 FQN="llvm::CodeViewContext", NM="_ZN4llvm15CodeViewContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContextE")
//</editor-fold>
public class CodeViewContext implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::CodeViewContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 29,
   FQN="llvm::CodeViewContext::CodeViewContext", NM="_ZN4llvm15CodeViewContextC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContextC1Ev")
  //</editor-fold>
  public CodeViewContext() {
    // : StringTable(), StrTabFragment(null), InsertedStrTabFragment(false), Filenames(), MCCVLineStartStop(), MCCVLines() 
    //START JInit
    this.StringTable = new StringMapUInt((/*uint*/int)0);
    /*InClass*/this.StrTabFragment = null;
    /*InClass*/this.InsertedStrTabFragment = false;
    this.Filenames = new SmallVector<StringRef>(4, new StringRef());
    this.MCCVLineStartStop = new std.mapUIntType<std.pairUIntUInt>(new std.pairUIntUInt());
    this.MCCVLines = new std.vector<MCCVLineEntry>(new MCCVLineEntry());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::~CodeViewContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 31,
   FQN="llvm::CodeViewContext::~CodeViewContext", NM="_ZN4llvm15CodeViewContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContextD0Ev")
  //</editor-fold>
  public void $destroy() {
    // If someone inserted strings into the string table but never actually
    // emitted them somewhere, clean up the fragment.
    if (!InsertedStrTabFragment) {
      if (StrTabFragment != null) { StrTabFragment.$destroy();};
    }
    //START JDestroy
    MCCVLines.$destroy();
    MCCVLineStartStop.$destroy();
    Filenames.$destroy();
    StringTable.$destroy();
    //END JDestroy
  }

  
  
  /// This is a valid number for use with .cv_loc if we've already seen a .cv_file
  /// for it.
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::isValidFileNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 40,
   FQN="llvm::CodeViewContext::isValidFileNumber", NM="_ZNK4llvm15CodeViewContext17isValidFileNumberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm15CodeViewContext17isValidFileNumberEj")
  //</editor-fold>
  public boolean isValidFileNumber(/*uint*/int FileNumber) /*const*/ {
    /*uint*/int Idx = FileNumber - 1;
    if ($less_uint(Idx, Filenames.size())) {
      return !Filenames.$at$Const(Idx).empty();
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::addFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 47,
   FQN="llvm::CodeViewContext::addFile", NM="_ZN4llvm15CodeViewContext7addFileEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext7addFileEjNS_9StringRefE")
  //</editor-fold>
  public boolean addFile(/*uint*/int FileNumber, StringRef Filename) {
    assert ($greater_uint(FileNumber, 0));
    Filename.$assignMove(addToStringTable(new StringRef(Filename)));
    /*uint*/int Idx = FileNumber - 1;
    if ($greatereq_uint(Idx, Filenames.size())) {
      Filenames.resize(Idx + 1);
    }
    if (Filename.empty()) {
      Filename.$assignMove(/*STRINGREF_STR*/"<stdin>");
    }
    if (!Filenames.$at(Idx).empty()) {
      return false;
    }
    
    // FIXME: We should store the string table offset of the filename, rather than
    // the filename itself for efficiency.
    Filename.$assignMove(addToStringTable(new StringRef(Filename)));
    
    Filenames.$at(Idx).$assign(Filename);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::getFilenames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 115,
   FQN="llvm::CodeViewContext::getFilenames", NM="_ZN4llvm15CodeViewContext12getFilenamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext12getFilenamesEv")
  //</editor-fold>
  public ArrayRef<StringRef> getFilenames() {
    return new ArrayRef<StringRef>(Filenames, false);
  }

  
  /// \brief Add a line entry.
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::addLineEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 118,
   FQN="llvm::CodeViewContext::addLineEntry", NM="_ZN4llvm15CodeViewContext12addLineEntryERKNS_13MCCVLineEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext12addLineEntryERKNS_13MCCVLineEntryE")
  //</editor-fold>
  public void addLineEntry(final /*const*/ MCCVLineEntry /*&*/ LineEntry) {
    /*size_t*/int Offset = MCCVLines.size();
    pairTypeBool<StdMapUIntType.iterator<pairUIntUInt>> I = MCCVLineStartStop.insert(/*{ */new std.pairUIntType<std.pairUIntUInt>(JD$T$RR_T1$C$R.INSTANCE, LineEntry.getFunctionId(), /*{ */new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, Offset, Offset + 1)/* }*/)/* }*/);
    if (!I.second) {
      I.first.$arrow().second.second = Offset + 1;
    }
    MCCVLines.push_back_T$C$R(LineEntry);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::getFunctionLineEntries">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 127,
   FQN="llvm::CodeViewContext::getFunctionLineEntries", NM="_ZN4llvm15CodeViewContext22getFunctionLineEntriesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext22getFunctionLineEntriesEj")
  //</editor-fold>
  public std.vector<MCCVLineEntry> getFunctionLineEntries(/*uint*/int FuncId) {
    std.vector<MCCVLineEntry> FilteredLines = null;
    try {
      FilteredLines/*J*/= new std.vector<MCCVLineEntry>(new MCCVLineEntry());

      StdMapUIntType.iterator<pairUIntUInt> I = MCCVLineStartStop.find(FuncId);
      if (I.$noteq(MCCVLineStartStop.end())) {
        for (/*size_t*/int Idx = I.$arrow().second.first, End = I.$arrow().second.second; Idx != End;
             ++Idx)  {
          if (MCCVLines.$at(Idx).getFunctionId() == FuncId) {
            FilteredLines.push_back_T$C$R(MCCVLines.$at(Idx));
          }
        }
      }
      return new std.vector<MCCVLineEntry>(JD$Move.INSTANCE, FilteredLines);
    } finally {
      if (FilteredLines != null) { FilteredLines.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::getLineExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 139,
   FQN="llvm::CodeViewContext::getLineExtent", NM="_ZN4llvm15CodeViewContext13getLineExtentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext13getLineExtentEj")
  //</editor-fold>
  public std.pairUIntUInt getLineExtent(/*uint*/int FuncId) {
    StdMapUIntType.iterator<pairUIntUInt> I = MCCVLineStartStop.find(FuncId);
    // Return an empty extent if there are no cv_locs for this function id.
    if (I.$eq(MCCVLineStartStop.end())) {
      return /*{ */new std.pairUIntUInt(JD$T$RR_T1$RR.INSTANCE, ~0L/*ULL*/, 0)/* }*/;
    }
    return new std.pairUIntUInt(I.$arrow().second);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::getLinesForExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCCodeView.h", line = 147,
   FQN="llvm::CodeViewContext::getLinesForExtent", NM="_ZN4llvm15CodeViewContext17getLinesForExtentEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext17getLinesForExtentEjj")
  //</editor-fold>
  public ArrayRef<MCCVLineEntry> getLinesForExtent(/*size_t*/int L, /*size_t*/int R) {
    if ($lesseq_uint(R, L)) {
      return new ArrayRef<MCCVLineEntry>(None, false);
    }
    if ($greatereq_uint(L, MCCVLines.size())) {
      return new ArrayRef<MCCVLineEntry>(None, false);
    }
    return makeArrayRef($AddrOf(MCCVLines.$at(L)), R - L);
  }

  
  /// Emits a line table substream.
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::emitLineTableForFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 148,
   FQN="llvm::CodeViewContext::emitLineTableForFunction", NM="_ZN4llvm15CodeViewContext24emitLineTableForFunctionERNS_16MCObjectStreamerEjPKNS_8MCSymbolES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext24emitLineTableForFunctionERNS_16MCObjectStreamerEjPKNS_8MCSymbolES5_")
  //</editor-fold>
  public void emitLineTableForFunction(final MCObjectStreamer /*&*/ OS, 
                          /*uint*/int FuncId, 
                          /*const*/ MCSymbol /*P*/ FuncBegin, 
                          /*const*/ MCSymbol /*P*/ FuncEnd) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::emitInlineLineTableForFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 240,
   FQN="llvm::CodeViewContext::emitInlineLineTableForFunction", NM="_ZN4llvm15CodeViewContext30emitInlineLineTableForFunctionERNS_16MCObjectStreamerEjjjPKNS_8MCSymbolES5_NS_8ArrayRefIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext30emitInlineLineTableForFunctionERNS_16MCObjectStreamerEjjjPKNS_8MCSymbolES5_NS_8ArrayRefIjEE")
  //</editor-fold>
  public void emitInlineLineTableForFunction(final MCObjectStreamer /*&*/ OS, /*uint*/int PrimaryFunctionId, /*uint*/int SourceFileId, 
                                /*uint*/int SourceLineNum, /*const*/ MCSymbol /*P*/ FnStartSym, 
                                /*const*/ MCSymbol /*P*/ FnEndSym, ArrayRefUInt SecondaryFunctionIds) {
    // Create and insert a fragment into the current section that will be encoded
    // later.
    new MCCVInlineLineTableFragment(PrimaryFunctionId, SourceFileId, SourceLineNum, FnStartSym, FnEndSym, 
        new ArrayRefUInt(SecondaryFunctionIds), OS.getCurrentSectionOnly());
  }

  
  /// Encodes the binary annotations once we have a layout.
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::encodeInlineLineTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 278,
   FQN="llvm::CodeViewContext::encodeInlineLineTable", NM="_ZN4llvm15CodeViewContext21encodeInlineLineTableERNS_11MCAsmLayoutERNS_27MCCVInlineLineTableFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext21encodeInlineLineTableERNS_11MCAsmLayoutERNS_27MCCVInlineLineTableFragmentE")
  //</editor-fold>
  public void encodeInlineLineTable(final MCAsmLayout /*&*/ Layout, 
                       final MCCVInlineLineTableFragment /*&*/ Frag) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::emitDefRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 251,
   FQN="llvm::CodeViewContext::emitDefRange", NM="_ZN4llvm15CodeViewContext12emitDefRangeERNS_16MCObjectStreamerENS_8ArrayRefISt4pairIPKNS_8MCSymbolES7_EEENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext12emitDefRangeERNS_16MCObjectStreamerENS_8ArrayRefISt4pairIPKNS_8MCSymbolES7_EEENS_9StringRefE")
  //</editor-fold>
  public void emitDefRange(final MCObjectStreamer /*&*/ OS, 
              ArrayRef<std.pairPtrPtr</*const*/ MCSymbol /*P*/ , /*const*/ MCSymbol /*P*/ >> Ranges, 
              StringRef FixedSizePortion) {
    // Create and insert a fragment into the current section that will be encoded
    // later.
    new MCCVDefRangeFragment(new ArrayRef<std.pairPtrPtr</*const*/ MCSymbol /*P*/ , /*const*/ MCSymbol /*P*/ >>(Ranges), new StringRef(FixedSizePortion), 
        OS.getCurrentSectionOnly());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::encodeDefRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 387,
   FQN="llvm::CodeViewContext::encodeDefRange", NM="_ZN4llvm15CodeViewContext14encodeDefRangeERNS_11MCAsmLayoutERNS_20MCCVDefRangeFragmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext14encodeDefRangeERNS_11MCAsmLayoutERNS_20MCCVDefRangeFragmentE")
  //</editor-fold>
  public void encodeDefRange(final MCAsmLayout /*&*/ Layout, 
                final MCCVDefRangeFragment /*&*/ Frag) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Emits the string table substream.
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::emitStringTable">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 99,
   FQN="llvm::CodeViewContext::emitStringTable", NM="_ZN4llvm15CodeViewContext15emitStringTableERNS_16MCObjectStreamerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext15emitStringTableERNS_16MCObjectStreamerE")
  //</editor-fold>
  public void emitStringTable(final MCObjectStreamer /*&*/ OS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Emits the file checksum substream.
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::emitFileChecksums">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 121,
   FQN="llvm::CodeViewContext::emitFileChecksums", NM="_ZN4llvm15CodeViewContext17emitFileChecksumsERNS_16MCObjectStreamerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext17emitFileChecksumsERNS_16MCObjectStreamerE")
  //</editor-fold>
  public void emitFileChecksums(final MCObjectStreamer /*&*/ OS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  /// Map from string to string table offset.
  private StringMapUInt StringTable;
  
  /// The fragment that ultimately holds our strings.
  private MCDataFragment /*P*/ StrTabFragment/* = null*/;
  private boolean InsertedStrTabFragment/* = false*/;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::getStringTableFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 68,
   FQN="llvm::CodeViewContext::getStringTableFragment", NM="_ZN4llvm15CodeViewContext22getStringTableFragmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext22getStringTableFragmentEv")
  //</editor-fold>
  private MCDataFragment /*P*/ getStringTableFragment() {
    if (!(StrTabFragment != null)) {
      StrTabFragment = new MCDataFragment();
      // Start a new string table out with a null byte.
      StrTabFragment.getContents().push_back($$TERM);
    }
    return StrTabFragment;
  }

  
  /// Add something to the string table.
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::addToStringTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 77,
   FQN="llvm::CodeViewContext::addToStringTable", NM="_ZN4llvm15CodeViewContext16addToStringTableENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext16addToStringTableENS_9StringRefE")
  //</editor-fold>
  private StringRef addToStringTable(StringRef S) {
    final SmallString/*&*/ Contents = getStringTableFragment().getContents();
    std_pair.pairTypeBool<StringMapIteratorUInt> Insertion = StringTable.insert(std.make_pair_T_uint($Clone(S), ((/*uint*/int)(Contents.size()))));
    // Return the string from the table, since it is stable.
    S.$assignMove(Insertion.first.$arrow().first());
    if (Insertion.second) {
      // The string map key is always null terminated.
      Contents.append_T(S.begin(), S.end().$add(1));
    }
    return new StringRef(JD$Move.INSTANCE, S);
  }

  
  /// Get a string table offset.
  //<editor-fold defaultstate="collapsed" desc="llvm::CodeViewContext::getStringTableOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp", line = 90,
   FQN="llvm::CodeViewContext::getStringTableOffset", NM="_ZN4llvm15CodeViewContext20getStringTableOffsetENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm15CodeViewContext20getStringTableOffsetENS_9StringRefE")
  //</editor-fold>
  private /*uint*/int getStringTableOffset(StringRef S) {
    // A string table offset of zero is always the empty string.
    if (S.empty()) {
      return 0;
    }
    StringMapIteratorUInt I = StringTable.find(/*NO_COPY*/S);
    assert (I.$noteq(StringTable.end()));
    return I.$arrow().second;
  }

  
  /// An array of absolute paths. Eventually this may include the file checksum.
  private SmallVector<StringRef> Filenames;
  
  /// The offset of the first and last .cv_loc directive for a given function
  /// id.
  private std.mapUIntType<std.pairUIntUInt> MCCVLineStartStop;
  
  /// A collection of MCCVLineEntry for each section.
  private std.vector<MCCVLineEntry> MCCVLines;
  
  @Override public String toString() {
    return "" + "StringTable=" + StringTable // NOI18N
              + ", StrTabFragment=" + StrTabFragment // NOI18N
              + ", InsertedStrTabFragment=" + InsertedStrTabFragment // NOI18N
              + ", Filenames=" + Filenames // NOI18N
              + ", MCCVLineStartStop=" + MCCVLineStartStop // NOI18N
              + ", MCCVLines=" + MCCVLines; // NOI18N
  }
}
