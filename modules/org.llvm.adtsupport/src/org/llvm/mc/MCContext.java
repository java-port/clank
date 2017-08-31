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
import org.clank.java.stdimpl.aliases.*;
import org.llvm.support.sys.*;
import static org.llvm.adt.java.ADTRTTI.*;
import static org.llvm.mc.MCContextGlobals.$new_uint_MCContext_uint;
import static org.llvm.mc.MCDwarfLoc.*;
import static org.llvm.mc.impl.MCContextStatics.AsSecureLogFileName;


/// Context object for machine code objects.  This class owns all of the
/// sections that it creates.
///
//<editor-fold defaultstate="collapsed" desc="llvm::MCContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 51,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 49,
 FQN="llvm::MCContext", NM="_ZN4llvm9MCContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContextE")
//</editor-fold>
public class MCContext implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::MCContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 52,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 50,
   FQN="llvm::MCContext::MCContext", NM="_ZN4llvm9MCContextC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContextC1ERKS0_")
  //</editor-fold>
  protected/*private*/ MCContext(final /*const*/ MCContext /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 53,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 51,
   FQN="llvm::MCContext::operator=", NM="_ZN4llvm9MCContextaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContextaSERKS0_")
  //</editor-fold>
  protected/*private*/ MCContext /*&*/ $assign(final /*const*/ MCContext /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  // JAVA: typedef StringMap<MCSymbol *, BumpPtrAllocator &> SymbolTable
//  public final class SymbolTable extends StringMap<MCSymbol /*P*/ , BumpPtrAllocatorImpl /*&*/ >{ };
/*private:*/
  /// The SourceMgr for this object, if any.
  private /*const*/ SourceMgr /*P*/ SrcMgr;
  
  /// The MCAsmInfo for this target.
  private /*const*/ MCAsmInfo /*P*/ MAI;
  
  /// The MCRegisterInfo for this target.
  private /*const*/ MCRegisterInfo /*P*/ MRI;
  
  /// The MCObjectFileInfo for this target.
  private /*const*/ MCObjectFileInfo /*P*/ MOFI;
  
  private std.unique_ptr<CodeViewContext> CVContext;
  
  /// Allocator object used for creating machine code objects.
  ///
  /// We use a bump pointer allocator to avoid the need to track all allocated
  /// objects.
  private BumpPtrAllocatorImpl Allocator;
  
  private SpecificBumpPtrAllocator<MCSectionCOFF> COFFAllocator;
  private SpecificBumpPtrAllocator<MCSectionELF> ELFAllocator;
  private SpecificBumpPtrAllocator<MCSectionMachO> MachOAllocator;
  
  /// Bindings of names to symbols.
  private StringMap<MCSymbol /*P*//* , BumpPtrAllocatorImpl*/ /*&*/ > Symbols;
  
  /// ELF sections can have a corresponding symbol. This maps one to the
  /// other.
  private DenseMap</*const*/ MCSectionELF /*P*/ , MCSymbolELF /*P*/ > SectionSymbols;
  
  /// A mapping from a local label number and an instance count to a symbol.
  /// For example, in the assembly
  ///     1:
  ///     2:
  ///     1:
  /// We have three labels represented by the pairs (1, 0), (2, 0) and (1, 1)
  private DenseMap<std.pairUIntUInt, MCSymbol /*P*/ > LocalSymbols;
  
  /// Keeps tracks of names that were used both for used declared and
  /// artificial symbols. The value is "true" if the name has been used for a
  /// non-section symbol (there can be at most one of those, plus an unlimited
  /// number of section symbols with the same name).
  private StringMapBool/*<BumpPtrAllocator & >*/ UsedNames;
  
  /// The next ID to dole out to an unnamed assembler temporary symbol with
  /// a given prefix.
  private StringMapUInt NextID;
  
  /// Instances of directional local labels.
  private DenseMapUIntType<MCLabel /*P*/ > Instances;
  /// NextInstance() creates the next instance of the directional local label
  /// for the LocalLabelVal and adds it to the map if needed.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::NextInstance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 222,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 225,
   FQN="llvm::MCContext::NextInstance", NM="_ZN4llvm9MCContext12NextInstanceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext12NextInstanceEj")
  //</editor-fold>
  private /*uint*/int NextInstance(/*uint*/int LocalLabelVal) {
    final type$ref<MCLabel /*P*/ /*&*/> Label = Instances.ref$at(LocalLabelVal);
    if (!(Label.$deref() != null)) {
      Label.$set(/*NEW_EXPR [operator new] NM=_ZnwjRN4llvm9MCContextEj*/
      /*new (*this)*/ $new_uint_MCContext_uint(/*Deref*/this, (type$ptr<?> New$Mem)->{
          return new MCLabel(0);
       }));
    }
    return Label.$deref().incInstance();
  }

  /// GetInstance() gets the current instance of the directional local label
  /// for the LocalLabelVal and adds it to the map if needed.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::GetInstance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 229,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 232,
   FQN="llvm::MCContext::GetInstance", NM="_ZN4llvm9MCContext11GetInstanceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext11GetInstanceEj")
  //</editor-fold>
  private /*uint*/int GetInstance(/*uint*/int LocalLabelVal) {
    final type$ref<MCLabel /*P*/ /*&*/> Label = Instances.ref$at(LocalLabelVal);
    if (!(Label.$deref() != null)) {
      Label.$set(/*NEW_EXPR [operator new] NM=_ZnwjRN4llvm9MCContextEj*/
      /*new (*this)*/ MCContextGlobals.$new_uint_MCContext_uint(/*Deref*/this, (type$ptr<?> New$Mem)->{
          return new MCLabel(0);
       }));
    }
    return Label.$deref().getInstance();
  }

  
  /// The file name of the log file from the environment variable
  /// AS_SECURE_LOG_FILE.  Which must be set before the .secure_log_unique
  /// directive is used or it is an error.
  private char$ptr/*char P*/ SecureLogFile;
  /// The stream that gets written to for the .secure_log_unique directive.
  private std.unique_ptr<raw_fd_ostream> SecureLog;
  /// Boolean toggled when .secure_log_unique / .secure_log_reset is seen to
  /// catch errors if .secure_log_unique appears twice without
  /// .secure_log_reset appearing between them.
  private boolean SecureLogUsed;
  
  /// The compilation directory to use for DW_AT_comp_dir.
  private SmallString/*128*/ CompilationDir;
  
  /// The main file name if passed in explicitly.
  private std.string MainFileName;
  
  /// The dwarf file and directory tables from the dwarf .file directive.
  /// We now emit a line table for each compile unit. To reduce the prologue
  /// size of each line table, the files and directories used by each compile
  /// unit are separated.
  private std.mapUIntType<MCDwarfLineTable> MCDwarfLineTablesCUMap;
  
  /// The current dwarf line information from the last dwarf .loc directive.
  private MCDwarfLoc CurrentDwarfLoc;
  private boolean DwarfLocSeen;
  
  /// The current CodeView line information from the last .cv_loc directive.
  private MCCVLoc CurrentCVLoc/* = MCCVLoc(0, 0, 0, 0, false, true)*/;
  private boolean CVLocSeen/* = false*/;
  
  /// Generate dwarf debugging info for assembly source files.
  private boolean GenDwarfForAssembly;
  
  /// The current dwarf file number when generate dwarf debugging info for
  /// assembly source files.
  private /*uint*/int GenDwarfFileNumber;
  
  /// Sections for generating the .debug_ranges and .debug_aranges sections.
  private SetVector<MCSection /*P*/ > SectionsForRanges;
  
  /// The information gathered from labels that will have dwarf label
  /// entries when generating dwarf assembly source files.
  private std.vector<MCGenDwarfLabelEntry> MCGenDwarfLabelEntries;
  
  /// The string to embed in the debug information for the compile unit, if
  /// non-empty.
  private StringRef DwarfDebugFlags;
  
  /// The string to embed in as the dwarf AT_producer for the compile unit, if
  /// non-empty.
  private StringRef DwarfDebugProducer;
  
  /// The maximum version of dwarf that we should emit.
  private /*uint16_t*/char DwarfVersion;
  
  /// Honor temporary labels, this is useful for debugging semantic
  /// differences between temporary and non-temporary labels (primarily on
  /// Darwin).
  private boolean AllowTemporaryLabels;
  private boolean UseNamesOnTempLabels/* = true*/;
  
  /// The Compile Unit ID that we are currently processing.
  private /*uint*/int DwarfCompileUnitID;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::ELFSectionKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 182,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 172,
   FQN="llvm::MCContext::ELFSectionKey", NM="_ZN4llvm9MCContext13ELFSectionKeyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext13ELFSectionKeyE")
  //</editor-fold>
  private static class/*struct*/ ELFSectionKey implements Destructors.ClassWithDestructor, NativeCloneable<ELFSectionKey>, NativeMoveable<ELFSectionKey> {
    public std.string SectionName;
    public StringRef GroupName;
    public /*uint*/int UniqueID;
    //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::ELFSectionKey::ELFSectionKey">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 186,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 176,
     FQN="llvm::MCContext::ELFSectionKey::ELFSectionKey", NM="_ZN4llvm9MCContext13ELFSectionKeyC1ENS_9StringRefES2_j",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext13ELFSectionKeyC1ENS_9StringRefES2_j")
    //</editor-fold>
    public ELFSectionKey(StringRef SectionName, StringRef GroupName, 
        /*uint*/int UniqueID) {
      // : SectionName(SectionName.operator basic_string()), GroupName(GroupName), UniqueID(UniqueID) 
      //START JInit
      this.SectionName = SectionName.$string();
      this.GroupName = new StringRef(GroupName);
      this.UniqueID = UniqueID;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::ELFSectionKey::operator<">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 190,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 180,
     FQN="llvm::MCContext::ELFSectionKey::operator<", NM="_ZNK4llvm9MCContext13ELFSectionKeyltERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext13ELFSectionKeyltERKS1_")
    //</editor-fold>
    public boolean $less(final /*const*/ ELFSectionKey /*&*/ Other) /*const*/ {
      if ($noteq_string$C(SectionName, Other.SectionName)) {
        return $less_string$C(SectionName, Other.SectionName);
      }
      if ($noteq_StringRef(/*NO_COPY*/GroupName, /*NO_COPY*/Other.GroupName)) {
        return $less_StringRef(/*NO_COPY*/GroupName, /*NO_COPY*/Other.GroupName);
      }
      return $less_uint(UniqueID, Other.UniqueID);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::ELFSectionKey::ELFSectionKey">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 182,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 172,
     FQN="llvm::MCContext::ELFSectionKey::ELFSectionKey", NM="_ZN4llvm9MCContext13ELFSectionKeyC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext13ELFSectionKeyC1EOS1_")
    //</editor-fold>
    public /*inline*/ ELFSectionKey(JD$Move _dparam, final ELFSectionKey /*&&*/$Prm0) {
      // : SectionName(static_cast<ELFSectionKey &&>().SectionName), GroupName(static_cast<ELFSectionKey &&>().GroupName), UniqueID(static_cast<ELFSectionKey &&>().UniqueID) 
      //START JInit
      this.SectionName = new std.string(JD$Move.INSTANCE, $Prm0.SectionName);
      this.GroupName = new StringRef(JD$Move.INSTANCE, $Prm0.GroupName);
      this.UniqueID = $Prm0.UniqueID;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::ELFSectionKey::~ELFSectionKey">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 182,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 172,
     FQN="llvm::MCContext::ELFSectionKey::~ELFSectionKey", NM="_ZN4llvm9MCContext13ELFSectionKeyD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext13ELFSectionKeyD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      SectionName.$destroy();
      //END JDestroy
    }

    private ELFSectionKey(string SectionName, StringRef GroupName, int UniqueID) {
      this.SectionName = SectionName;
      this.GroupName = GroupName;
      this.UniqueID = UniqueID;
    }

    @Override
    public ELFSectionKey clone() {
      return new ELFSectionKey(SectionName, GroupName, UniqueID);
    }

    @Override
    public ELFSectionKey move() {
      return new ELFSectionKey(JD$Move.INSTANCE, this);
    }
    
    @Override public String toString() {
      return "" + "SectionName=" + SectionName // NOI18N
                + ", GroupName=" + GroupName // NOI18N
                + ", UniqueID=" + UniqueID; // NOI18N
    }

  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::COFFSectionKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 199,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 189,
   FQN="llvm::MCContext::COFFSectionKey", NM="_ZN4llvm9MCContext14COFFSectionKeyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext14COFFSectionKeyE")
  //</editor-fold>
  private static class/*struct*/ COFFSectionKey implements Destructors.ClassWithDestructor, NativeCloneable<COFFSectionKey> {
    public std.string SectionName;
    public StringRef GroupName;
    public int SelectionKey;
    public /*uint*/int UniqueID;
    //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::COFFSectionKey::COFFSectionKey">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 204,
     FQN="llvm::MCContext::COFFSectionKey::COFFSectionKey", NM="_ZN4llvm9MCContext14COFFSectionKeyC1ENS_9StringRefES2_ij",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext14COFFSectionKeyC1ENS_9StringRefES2_ij")
    //</editor-fold>
    public COFFSectionKey(StringRef SectionName, StringRef GroupName, 
        int SelectionKey, /*uint*/int UniqueID) {
      // : SectionName(SectionName.operator basic_string()), GroupName(GroupName), SelectionKey(SelectionKey), UniqueID(UniqueID) 
      //START JInit
      this.SectionName = SectionName.$string();
      this.GroupName = new StringRef(GroupName);
      this.SelectionKey = SelectionKey;
      this.UniqueID = UniqueID;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::COFFSectionKey::operator<">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 208,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 197,
     FQN="llvm::MCContext::COFFSectionKey::operator<", NM="_ZNK4llvm9MCContext14COFFSectionKeyltERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext14COFFSectionKeyltERKS1_")
    //</editor-fold>
    public boolean $less(final /*const*/ COFFSectionKey /*&*/ Other) /*const*/ {
      if ($noteq_string$C(SectionName, Other.SectionName)) {
        return $less_string$C(SectionName, Other.SectionName);
      }
      if ($noteq_StringRef(/*NO_COPY*/GroupName, /*NO_COPY*/Other.GroupName)) {
        return $less_StringRef(/*NO_COPY*/GroupName, /*NO_COPY*/Other.GroupName);
      }
      if (SelectionKey != Other.SelectionKey) {
        return SelectionKey < Other.SelectionKey;
      }
      return $less_uint(UniqueID, Other.UniqueID);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::COFFSectionKey::COFFSectionKey">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 199,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 189,
     FQN="llvm::MCContext::COFFSectionKey::COFFSectionKey", NM="_ZN4llvm9MCContext14COFFSectionKeyC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext14COFFSectionKeyC1ERKS1_")
    //</editor-fold>
    public /*inline*/ COFFSectionKey(final /*const*/ COFFSectionKey /*&*/ $Prm0) {
      // : SectionName(.SectionName), GroupName(.GroupName), SelectionKey(.SelectionKey), UniqueID(.UniqueID) 
      //START JInit
      this.SectionName = new std.string($Prm0.SectionName);
      this.GroupName = new StringRef($Prm0.GroupName);
      this.SelectionKey = $Prm0.SelectionKey;
      this.UniqueID = $Prm0.UniqueID;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::COFFSectionKey::COFFSectionKey">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 199,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 189,
     FQN="llvm::MCContext::COFFSectionKey::COFFSectionKey", NM="_ZN4llvm9MCContext14COFFSectionKeyC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext14COFFSectionKeyC1EOS1_")
    //</editor-fold>
    public /*inline*/ COFFSectionKey(JD$Move _dparam, final COFFSectionKey /*&&*/$Prm0) {
      // : SectionName(static_cast<COFFSectionKey &&>().SectionName), GroupName(static_cast<COFFSectionKey &&>().GroupName), SelectionKey(static_cast<COFFSectionKey &&>().SelectionKey), UniqueID(static_cast<COFFSectionKey &&>().UniqueID) 
      //START JInit
      this.SectionName = new std.string(JD$Move.INSTANCE, $Prm0.SectionName);
      this.GroupName = new StringRef(JD$Move.INSTANCE, $Prm0.GroupName);
      this.SelectionKey = $Prm0.SelectionKey;
      this.UniqueID = $Prm0.UniqueID;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::COFFSectionKey::~COFFSectionKey">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 199,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 189,
     FQN="llvm::MCContext::COFFSectionKey::~COFFSectionKey", NM="_ZN4llvm9MCContext14COFFSectionKeyD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext14COFFSectionKeyD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      SectionName.$destroy();
      //END JDestroy
    }

    @Override
    public COFFSectionKey clone() {
      return new COFFSectionKey(this);
    }
    
    @Override public String toString() {
      return "" + "SectionName=" + SectionName // NOI18N
                + ", GroupName=" + GroupName // NOI18N
                + ", SelectionKey=" + SelectionKey // NOI18N
                + ", UniqueID=" + UniqueID; // NOI18N
    }

  };
  
  private StringMap<MCSectionMachO /*P*/ > MachOUniquingMap;
  private std.mapTypePtr<ELFSectionKey, MCSectionELF /*P*/ > ELFUniquingMap;
  private std.mapTypePtr<COFFSectionKey, MCSectionCOFF /*P*/ > COFFUniquingMap;
  private StringMapBool ELFRelSecNames;
  
  private SpecificBumpPtrAllocator<MCSubtargetInfo> MCSubtargetAllocator;
  
  /// Do automatic reset in destructor
  private boolean AutoReset;
  
  private boolean HadError;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::createSymbolImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 155,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 161,
   FQN="llvm::MCContext::createSymbolImpl", NM="_ZN4llvm9MCContext16createSymbolImplEPKNS_14StringMapEntryIbEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext16createSymbolImplEPKNS_14StringMapEntryIbEEb")
  //</editor-fold>
  private MCSymbol /*P*/ createSymbolImpl(/*const*/StringMapEntryBool/*P*/ Name, 
                  boolean IsTemporary) {
    if ((MOFI != null)) {
      switch (MOFI.getObjectFileType()) {
       case IsCOFF:
        return /*NEW_EXPR [MCSymbol::new]*//*new (Name, *this)*/ MCSymbol.$new(Name, /*Deref*/this, (type$ptr<?> New$Mem)->{
            return new MCSymbolCOFF(Name, IsTemporary);
         });
       case IsELF:
        return /*NEW_EXPR [MCSymbol::new]*//*new (Name, *this)*/ MCSymbol.$new(Name, /*Deref*/this, (type$ptr<?> New$Mem)->{
            return new MCSymbolELF(Name, IsTemporary);
         });
       case IsMachO:
        return /*NEW_EXPR [MCSymbol::new]*//*new (Name, *this)*/ MCSymbol.$new(Name, /*Deref*/this, (type$ptr<?> New$Mem)->{
            return new MCSymbolMachO(Name, IsTemporary);
         });
      }
    }
    return /*NEW_EXPR [MCSymbol::new]*//*new (Name, *this)*/ MCSymbol.$new(Name, /*Deref*/this, (type$ptr<?> New$Mem)->{
        return new MCSymbol(MCSymbol.SymbolKind.SymbolKindUnset, Name, 
                IsTemporary);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::createSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 171,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 177,
   FQN="llvm::MCContext::createSymbol", NM="_ZN4llvm9MCContext12createSymbolENS_9StringRefEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext12createSymbolENS_9StringRefEbb")
  //</editor-fold>
  private MCSymbol /*P*/ createSymbol(StringRef Name, boolean AlwaysAddSuffix, 
              boolean CanBeUnnamed) {
    if (CanBeUnnamed && !UseNamesOnTempLabels) {
      return createSymbolImpl((/*const*/StringMapEntryBool/*P*/ )null, true);
    }
    
    // Determine whether this is an user writter assembler temporary or normal
    // label, if used.
    boolean IsTemporary = CanBeUnnamed;
    if (AllowTemporaryLabels && !IsTemporary) {
      IsTemporary = Name.startswith(/*STRINGREF_STR*/MAI.getPrivateGlobalPrefix());
    }
    
    SmallString/*128*/ NewName = new SmallString/*128*/(new StringRef(Name), 128);
    boolean AddSuffix = AlwaysAddSuffix;
    final uint$ref/*uint &*/ NextUniqueID = NextID.ref$at(/*NO_COPY*/Name);
    for (;;) {
      if (AddSuffix) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          NewName.resize(Name.size());
          $c$.clean($c$.track(new raw_svector_ostream(NewName)).$out_uint(NextUniqueID.$set$postInc()));
        } finally {
          $c$.$destroy();
        }
      }
      std.pairTypeBool<StringMapIteratorBool> NameEntry = UsedNames.insert(new std.pairTypeBool<StringRef>(JD$Pair$_U1$_U2.INSTANCE, /*Fwd*/new SmallString/*128*/(/*Fwd2*/NewName).$StringRef(), /*Fwd2*//*Fwd*/true));
      if (NameEntry.second || !NameEntry.first.$arrow().second) {
        // Ok, we found a name.
        // Mark it as used for a non-section symbol.
        NameEntry.first.$arrow().second = true;
        // Have the MCSymbol object itself refer to the copy of the string that is
        // embedded in the UsedNames entry.
        return createSymbolImpl($AddrOf(NameEntry.first.$star()), IsTemporary);
      }
      assert (IsTemporary) : "Cannot rename non-temporary symbols";
      AddSuffix = true;
    }
    //throw new llvm_unreachable("Infinite loop");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getOrCreateDirectionalLocalSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 236,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 239,
   FQN="llvm::MCContext::getOrCreateDirectionalLocalSymbol", NM="_ZN4llvm9MCContext33getOrCreateDirectionalLocalSymbolEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext33getOrCreateDirectionalLocalSymbolEjj")
  //</editor-fold>
  private MCSymbol /*P*/ getOrCreateDirectionalLocalSymbol(/*uint*/int LocalLabelVal, 
                                   /*uint*/int Instance) {
    final type$ref<MCSymbol /*P*/ /*&*/> Sym = LocalSymbols.ref$at(std.make_pair_uint_uint(LocalLabelVal, Instance));
    if (!(Sym.$deref() != null)) {
      Sym.$set(createTempSymbol(false));
    }
    return Sym.$deref();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::MCContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 44,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 37,
   FQN="llvm::MCContext::MCContext", NM="_ZN4llvm9MCContextC1EPKNS_9MCAsmInfoEPKNS_14MCRegisterInfoEPKNS_16MCObjectFileInfoEPKNS_9SourceMgrEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContextC1EPKNS_9MCAsmInfoEPKNS_14MCRegisterInfoEPKNS_16MCObjectFileInfoEPKNS_9SourceMgrEb")
  //</editor-fold>
  public MCContext(/*const*/ MCAsmInfo /*P*/ mai, /*const*/ MCRegisterInfo /*P*/ mri, 
      /*const*/ MCObjectFileInfo /*P*/ mofi) {
    this(mai, mri, 
      mofi, (/*const*/ SourceMgr /*P*/ )null, 
      true);
  }
  public MCContext(/*const*/ MCAsmInfo /*P*/ mai, /*const*/ MCRegisterInfo /*P*/ mri, 
      /*const*/ MCObjectFileInfo /*P*/ mofi, /*const*/ SourceMgr /*P*/ mgr/*= null*/) {
    this(mai, mri, 
      mofi, mgr, 
      true);
  }
  public MCContext(/*const*/ MCAsmInfo /*P*/ mai, /*const*/ MCRegisterInfo /*P*/ mri, 
      /*const*/ MCObjectFileInfo /*P*/ mofi, /*const*/ SourceMgr /*P*/ mgr/*= null*/, 
      boolean DoAutoReset/*= true*/) {
    // : SrcMgr(mgr), MAI(mai), MRI(mri), MOFI(mofi), CVContext(), Allocator(), COFFAllocator(), ELFAllocator(), MachOAllocator(), Symbols(Allocator), SectionSymbols(), LocalSymbols(), UsedNames(Allocator), NextID(), Instances(), SecureLog(), CompilationDir(), MainFileName(), MCDwarfLineTablesCUMap(), CurrentDwarfLoc(0, 0, 0, (1 << 0), 0, 0), DwarfLocSeen(false), CurrentCVLoc(MCCVLoc(0, 0, 0, 0, false, true)), CVLocSeen(false), GenDwarfForAssembly(false), GenDwarfFileNumber(0), SectionsForRanges(), MCGenDwarfLabelEntries(), DwarfDebugFlags(), DwarfDebugProducer(), DwarfVersion(4), AllowTemporaryLabels(true), UseNamesOnTempLabels(true), DwarfCompileUnitID(0), MachOUniquingMap(), ELFUniquingMap(), COFFUniquingMap(), ELFRelSecNames(), MCSubtargetAllocator(), AutoReset(DoAutoReset), HadError(false) 
    //START JInit
    this.SrcMgr = mgr;
    this.MAI = mai;
    this.MRI = mri;
    this.MOFI = mofi;
    this.CVContext = new std.unique_ptr<CodeViewContext>();
    this.Allocator = new BumpPtrAllocatorImpl();
    this.COFFAllocator = new SpecificBumpPtrAllocator<MCSectionCOFF>(MCSectionCOFF.class);
    this.ELFAllocator = new SpecificBumpPtrAllocator<MCSectionELF>(MCSectionELF.class);
    this.MachOAllocator = new SpecificBumpPtrAllocator<MCSectionMachO>(MCSectionMachO.class);
    this.Symbols = new StringMap<MCSymbol /*P*/ /*, BumpPtrAllocatorImpl &*/ >(Allocator, new MCSymbol());
    this.SectionSymbols = new DenseMap</*const*/ MCSectionELF /*P*/ , MCSymbolELF /*P*/ >(DenseMapInfo$LikePtr.$Info(), (MCSymbolELF /*P*/ )null);
    this.LocalSymbols = new DenseMap<std.pairUIntUInt, MCSymbol /*P*/ >(DenseMapInfoPairUIntUInt.$Info(), (MCSymbol /*P*/ )null);
    this.UsedNames = new StringMapBool/*<BumpPtrAllocator & >*/(new BumpPtrAllocatorImpl(Allocator), false);
    this.NextID = new StringMapUInt((/*uint*/int)0);
    this.Instances = new DenseMapUIntType<MCLabel /*P*/ >(DenseMapInfoUInt.$Info(), (MCLabel /*P*/ )null);
    this.SecureLog = new std.unique_ptr<raw_fd_ostream>();
    this.CompilationDir = new SmallString/*128*/(128);
    this.MainFileName = new std.string();
    this.MCDwarfLineTablesCUMap = new std.mapUIntType<MCDwarfLineTable>(new MCDwarfLineTable());
    this.CurrentDwarfLoc = new MCDwarfLoc(0, 0, 0, DWARF2_FLAG_IS_STMT, 0, 0);
    this.DwarfLocSeen = false;
    /*InClass*/this.CurrentCVLoc = new MCCVLoc(0, 0, 0, (char)0, false, true);
    /*InClass*/this.CVLocSeen = false;
    this.GenDwarfForAssembly = false;
    this.GenDwarfFileNumber = 0;
    this.SectionsForRanges = new SetVector<MCSection /*P*/ >((MCSection /*P*/ )null);
    this.MCGenDwarfLabelEntries = new std.vector<MCGenDwarfLabelEntry>(new MCGenDwarfLabelEntry());
    this.DwarfDebugFlags = new StringRef();
    this.DwarfDebugProducer = new StringRef();
    this.DwarfVersion = $int2ushort(4);
    this.AllowTemporaryLabels = true;
    /*InClass*/this.UseNamesOnTempLabels = true;
    this.DwarfCompileUnitID = 0;
    this.MachOUniquingMap = new StringMap<MCSectionMachO /*P*/ >((MCSectionMachO /*P*/ )null);
    this.ELFUniquingMap = new std.mapTypePtr<ELFSectionKey, MCSectionELF /*P*/ >();
    this.COFFUniquingMap = new std.mapTypePtr<COFFSectionKey, MCSectionCOFF /*P*/ >();
    this.ELFRelSecNames = new StringMapBool(false);
    this.MCSubtargetAllocator = new SpecificBumpPtrAllocator<MCSubtargetInfo>(MCSubtargetInfo.class);
    this.AutoReset = DoAutoReset;
    this.HadError = false;
    //END JInit
    SecureLogFile = $tryClone(AsSecureLogFileName.$T());
    SecureLog.$assign_nullptr_t(null);
    SecureLogUsed = false;
    if ((SrcMgr != null) && (SrcMgr.getNumBuffers() != 0)) {
      MainFileName.$assign_T$C$P(
          SrcMgr.getMemoryBuffer(SrcMgr.getMainFileID()).getBufferIdentifier()
      );
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::~MCContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 62,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 60,
   FQN="llvm::MCContext::~MCContext", NM="_ZN4llvm9MCContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContextD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (AutoReset) {
      reset();
    }
    // NOTE: The symbols are all allocated out of a bump pointer allocator,
    // we don't need to free them here.
    //START JDestroy
    MCSubtargetAllocator.$destroy();
    ELFRelSecNames.$destroy();
    COFFUniquingMap.$destroy();
    ELFUniquingMap.$destroy();
    MachOUniquingMap.$destroy();
    MCGenDwarfLabelEntries.$destroy();
    SectionsForRanges.$destroy();
    MCDwarfLineTablesCUMap.$destroy();
    MainFileName.$destroy();
    CompilationDir.$destroy();
    SecureLog.$destroy();
    Instances.$destroy();
    NextID.$destroy();
    UsedNames.$destroy();
    LocalSymbols.$destroy();
    SectionSymbols.$destroy();
    Symbols.$destroy();
    MachOAllocator.$destroy();
    ELFAllocator.$destroy();
    COFFAllocator.$destroy();
    Allocator.$destroy();
    CVContext.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 245,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 232,
   FQN="llvm::MCContext::getSourceManager", NM="_ZNK4llvm9MCContext16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext16getSourceManagerEv")
  //</editor-fold>
  public /*const*/ SourceMgr /*P*/ getSourceManager() /*const*/ {
    return SrcMgr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getAsmInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 247,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 234,
   FQN="llvm::MCContext::getAsmInfo", NM="_ZNK4llvm9MCContext10getAsmInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext10getAsmInfoEv")
  //</editor-fold>
  public /*const*/ MCAsmInfo /*P*/ getAsmInfo() /*const*/ {
    return MAI;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getRegisterInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 249,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 236,
   FQN="llvm::MCContext::getRegisterInfo", NM="_ZNK4llvm9MCContext15getRegisterInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext15getRegisterInfoEv")
  //</editor-fold>
  public /*const*/ MCRegisterInfo /*P*/ getRegisterInfo() /*const*/ {
    return MRI;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getObjectFileInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 251,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 238,
   FQN="llvm::MCContext::getObjectFileInfo", NM="_ZNK4llvm9MCContext17getObjectFileInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext17getObjectFileInfoEv")
  //</editor-fold>
  public /*const*/ MCObjectFileInfo /*P*/ getObjectFileInfo() /*const*/ {
    return MOFI;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getCVContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 491,
   FQN="llvm::MCContext::getCVContext", NM="_ZN4llvm9MCContext12getCVContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext12getCVContextEv")
  //</editor-fold>
  public CodeViewContext /*&*/ getCVContext() {
    if (!(CVContext.get() != null)) {
      CVContext.reset(new CodeViewContext());
    }
    return $Deref(CVContext.get());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setAllowTemporaryLabels">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 255,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 240,
   FQN="llvm::MCContext::setAllowTemporaryLabels", NM="_ZN4llvm9MCContext23setAllowTemporaryLabelsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext23setAllowTemporaryLabelsEb")
  //</editor-fold>
  public void setAllowTemporaryLabels(boolean Value) {
    AllowTemporaryLabels = Value;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setUseNamesOnTempLabels">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 256,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 241,
   FQN="llvm::MCContext::setUseNamesOnTempLabels", NM="_ZN4llvm9MCContext23setUseNamesOnTempLabelsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext23setUseNamesOnTempLabelsEb")
  //</editor-fold>
  public void setUseNamesOnTempLabels(boolean Value) {
    UseNamesOnTempLabels = Value;
  }

  
  /// \name Module Lifetime Management
  /// @{
  
  /// reset - return object to right after construction state to prepare
  /// to process a new module
  
  //===----------------------------------------------------------------------===//
  // Module Lifetime Management
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 74,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 72,
   FQN="llvm::MCContext::reset", NM="_ZN4llvm9MCContext5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext5resetEv")
  //</editor-fold>
  public void reset() {
    // Call the destructors so the fragments are freed
    COFFAllocator.DestroyAll();
    ELFAllocator.DestroyAll();
    MachOAllocator.DestroyAll();
    
    MCSubtargetAllocator.DestroyAll();
    UsedNames.clear();
    Symbols.clear();
    SectionSymbols.clear();
    Allocator.Reset();
    Instances.clear();
    CompilationDir.clear();
    MainFileName.clear();
    MCDwarfLineTablesCUMap.clear();
    SectionsForRanges.clear();
    MCGenDwarfLabelEntries.clear();
    DwarfDebugFlags.$assignMove(new StringRef());
    DwarfCompileUnitID = 0;
    CurrentDwarfLoc.$assignMove(new MCDwarfLoc(0, 0, 0, MCDwarfLoc.DWARF2_FLAG_IS_STMT, 0, 0));
    
    CVContext.reset();
    
    MachOUniquingMap.clear();
    ELFUniquingMap.clear();
    COFFUniquingMap.clear();
    
    NextID.clear();
    AllowTemporaryLabels = true;
    DwarfLocSeen = false;
    GenDwarfForAssembly = false;
    GenDwarfFileNumber = 0;
    
    HadError = false;
  }

  
  /// @}
  
  /// \name Symbol Management
  /// @{
  
  /// Create and return a new linker temporary symbol with a unique but
  /// unspecified name.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::createLinkerPrivateTempSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 212,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 215,
   FQN="llvm::MCContext::createLinkerPrivateTempSymbol", NM="_ZN4llvm9MCContext29createLinkerPrivateTempSymbolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext29createLinkerPrivateTempSymbolEv")
  //</editor-fold>
  public MCSymbol /*P*/ createLinkerPrivateTempSymbol() {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SmallString/*128*/ NameSV/*J*/= new SmallString/*128*/(128);
      $c$.clean($c$.track(new raw_svector_ostream(NameSV)).$out(MAI.getLinkerPrivateGlobalPrefix()).$out(/*KEEP_STR*/"tmp"));
      return createSymbol(NameSV.$StringRef(), true, false);
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Create and return a new assembler temporary symbol with a unique but
  /// unspecified name.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::createTempSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 218,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 221,
   FQN="llvm::MCContext::createTempSymbol", NM="_ZN4llvm9MCContext16createTempSymbolEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext16createTempSymbolEb")
  //</editor-fold>
  public MCSymbol /*P*/ createTempSymbol() {
    return createTempSymbol(true);
  }
  public MCSymbol /*P*/ createTempSymbol(boolean CanBeUnnamed/*= true*/) {
    return createTempSymbol(new Twine(/*KEEP_STR*/"tmp"), true, CanBeUnnamed);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::createTempSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 205,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 208,
   FQN="llvm::MCContext::createTempSymbol", NM="_ZN4llvm9MCContext16createTempSymbolERKNS_5TwineEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext16createTempSymbolERKNS_5TwineEbb")
  //</editor-fold>
  public MCSymbol /*P*/ createTempSymbol(final /*const*/ Twine /*&*/ Name, boolean AlwaysAddSuffix) {
    return createTempSymbol(Name, AlwaysAddSuffix, 
                  true);
  }
  public MCSymbol /*P*/ createTempSymbol(final /*const*/ Twine /*&*/ Name, boolean AlwaysAddSuffix, 
                  boolean CanBeUnnamed/*= true*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SmallString/*128*/ NameSV/*J*/= new SmallString/*128*/(128);
      $c$.clean($out_raw_ostream_Twine$C($c$.track(new raw_svector_ostream(NameSV)).$out(MAI.getPrivateGlobalPrefix()), Name));
      return createSymbol(NameSV.$StringRef(), AlwaysAddSuffix, CanBeUnnamed);
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Create the definition of a directional local symbol for numbered label
  /// (used for "1:" definitions).
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::createDirectionalLocalSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 244,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 247,
   FQN="llvm::MCContext::createDirectionalLocalSymbol", NM="_ZN4llvm9MCContext28createDirectionalLocalSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext28createDirectionalLocalSymbolEj")
  //</editor-fold>
  public MCSymbol /*P*/ createDirectionalLocalSymbol(/*uint*/int LocalLabelVal) {
    /*uint*/int Instance = NextInstance(LocalLabelVal);
    return getOrCreateDirectionalLocalSymbol(LocalLabelVal, Instance);
  }

  
  /// Create and return a directional local symbol for numbered label (used
  /// for "1b" or 1f" references).
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getDirectionalLocalSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 249,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 252,
   FQN="llvm::MCContext::getDirectionalLocalSymbol", NM="_ZN4llvm9MCContext25getDirectionalLocalSymbolEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext25getDirectionalLocalSymbolEjb")
  //</editor-fold>
  public MCSymbol /*P*/ getDirectionalLocalSymbol(/*uint*/int LocalLabelVal, 
                           boolean Before) {
    /*uint*/int Instance = GetInstance(LocalLabelVal);
    if (!Before) {
      ++Instance;
    }
    return getOrCreateDirectionalLocalSymbol(LocalLabelVal, Instance);
  }

  
  /// Lookup the symbol inside with the specified \p Name.  If it exists,
  /// return it.  If not, create a forward reference and return it.
  ///
  /// \param Name - The symbol name, which must be unique across all symbols.
  
  //===----------------------------------------------------------------------===//
  // Symbol Manipulation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getOrCreateSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 114,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 110,
   FQN="llvm::MCContext::getOrCreateSymbol", NM="_ZN4llvm9MCContext17getOrCreateSymbolERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext17getOrCreateSymbolERKNS_5TwineE")
  //</editor-fold>
  public MCSymbol /*P*/ getOrCreateSymbol(final /*const*/ Twine /*&*/ Name) {
    SmallString/*128*/ NameSV/*J*/= new SmallString/*128*/(128);
    StringRef NameRef = Name.toStringRef(NameSV);
    assert (!NameRef.empty()) : "Normal symbols cannot be unnamed!";
    
    final type$ref<MCSymbol /*P*/ /*&*/> Sym = Symbols.ref$at(/*NO_COPY*/NameRef);
    if (!(Sym.$deref() != null)) {
      Sym.$set(createSymbol(new StringRef(NameRef), false, false));
    }
    
    return Sym.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getOrCreateSectionSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 127,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 123,
   FQN="llvm::MCContext::getOrCreateSectionSymbol", NM="_ZN4llvm9MCContext24getOrCreateSectionSymbolERKNS_12MCSectionELFE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext24getOrCreateSectionSymbolERKNS_12MCSectionELFE")
  //</editor-fold>
  public MCSymbolELF /*P*/ getOrCreateSectionSymbol(final /*const*/ MCSectionELF /*&*/ Section) {
    final type$ref<MCSymbolELF /*P*/ /*&*/> Sym = SectionSymbols.ref$at($AddrOf(Section));
    if ((Sym.$deref() != null)) {
      return Sym.$deref();
    }
    
    StringRef Name = Section.getSectionName();
    StringMapIteratorBool NameIter = new StringMapIteratorBool(JD$Move.INSTANCE, UsedNames.insert(std.make_pair_T_bool($Clone(Name), false)).first);
    Sym.$set(/*NEW_EXPR [MCSymbol::new]*//*new (&* NameIter, *this)*/ MCSymbol.$new($AddrOf(NameIter.$star()), /*Deref*/this, (type$ptr<?> New$Mem)->{
        return new MCSymbolELF($AddrOf(NameIter.$star()), /*isTemporary*/ false);
     }));
    
    return Sym.$deref();
  }

  
  /// Gets a symbol that will be defined to the final stack offset of a local
  /// variable after codegen.
  ///
  /// \param Idx - The index of a local variable passed to @llvm.localescape.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getOrCreateFrameAllocSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 139,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 145,
   FQN="llvm::MCContext::getOrCreateFrameAllocSymbol", NM="_ZN4llvm9MCContext27getOrCreateFrameAllocSymbolENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext27getOrCreateFrameAllocSymbolENS_9StringRefEj")
  //</editor-fold>
  public MCSymbol /*P*/ getOrCreateFrameAllocSymbol(StringRef FuncName, 
                             /*uint*/int Idx) {
    return getOrCreateSymbol($add_Twine$C($add_Twine$C($add_Twine$C(new Twine(MAI.getPrivateGlobalPrefix()), new Twine(FuncName)), 
                new Twine(/*KEEP_STR*/"$frame_escape_")), new Twine(JD$UInt.INSTANCE, Idx)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getOrCreateParentFrameOffsetSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 145,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 151,
   FQN="llvm::MCContext::getOrCreateParentFrameOffsetSymbol", NM="_ZN4llvm9MCContext34getOrCreateParentFrameOffsetSymbolENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext34getOrCreateParentFrameOffsetSymbolENS_9StringRefE")
  //</editor-fold>
  public MCSymbol /*P*/ getOrCreateParentFrameOffsetSymbol(StringRef FuncName) {
    return getOrCreateSymbol($add_Twine$C($add_Twine$C(new Twine(MAI.getPrivateGlobalPrefix()), new Twine(FuncName)), 
            new Twine(/*KEEP_STR*/"$parent_frame_offset")));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getOrCreateLSDASymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 150,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 156,
   FQN="llvm::MCContext::getOrCreateLSDASymbol", NM="_ZN4llvm9MCContext21getOrCreateLSDASymbolENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext21getOrCreateLSDASymbolENS_9StringRefE")
  //</editor-fold>
  public MCSymbol /*P*/ getOrCreateLSDASymbol(StringRef FuncName) {
    return getOrCreateSymbol($add_Twine$C($add_Twine$C(new Twine(MAI.getPrivateGlobalPrefix()), new Twine(/*KEEP_STR*/"__ehtable$")), 
            new Twine(FuncName)));
  }

  
  /// Get the symbol for \p Name, or null.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::lookupSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 257,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 260,
   FQN="llvm::MCContext::lookupSymbol", NM="_ZNK4llvm9MCContext12lookupSymbolERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext12lookupSymbolERKNS_5TwineE")
  //</editor-fold>
  public MCSymbol /*P*/ lookupSymbol(final /*const*/ Twine /*&*/ Name) /*const*/ {
    SmallString/*128*/ NameSV/*J*/= new SmallString/*128*/(128);
    StringRef NameRef = Name.toStringRef(NameSV);
    return Symbols.lookup(new StringRef(NameRef));
  }

  
  /// getSymbols - Get a reference for the symbol table for clients that
  /// want to, for example, iterate over all symbols. 'const' because we
  /// still want any modifications to the table itself to use the MCContext
  /// APIs.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 314,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 299,
   FQN="llvm::MCContext::getSymbols", NM="_ZNK4llvm9MCContext10getSymbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext10getSymbolsEv")
  //</editor-fold>
  public /*const*/ StringMap<MCSymbol /*P*//* , BumpPtrAllocatorImpl &*/ > /*&*/ getSymbols() /*const*/ {
    return Symbols;
  }

  
  /// @}
  
  /// \name Section Management
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 321,
   FQN="llvm::MCContext::(anonymous)", NM="_ZN4llvm9MCContextE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContextE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
    /// Pass this value as the UniqueID during section creation to get the
    /// generic section with the given name and characteristics. The usual
    /// sections such as .text use this ID.
    public static final /*uint*/int GenericSectionID = ~0/*U*/;
  /*}*/;
  
  /// Return the MCSection for the specified mach-o section.  This requires
  /// the operands to be valid.
  
  //===----------------------------------------------------------------------===//
  // Section Management
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getMachOSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 267,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 270,
   FQN="llvm::MCContext::getMachOSection", NM="_ZN4llvm9MCContext15getMachOSectionENS_9StringRefES1_jjNS_11SectionKindEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext15getMachOSectionENS_9StringRefES1_jjNS_11SectionKindEPKc")
  //</editor-fold>
  public MCSectionMachO /*P*/ getMachOSection(StringRef Segment, StringRef Section, 
                 /*uint*/int TypeAndAttributes, 
                 /*uint*/int Reserved2, SectionKind Kind) {
    return getMachOSection(Segment, Section, 
                 TypeAndAttributes, 
                 Reserved2, Kind, 
                 (/*const*/char$ptr/*char P*/ )null);
  }
  public MCSectionMachO /*P*/ getMachOSection(StringRef Segment, StringRef Section, 
                 /*uint*/int TypeAndAttributes, 
                 /*uint*/int Reserved2, SectionKind Kind, 
                 /*const*/char$ptr/*char P*/ BeginSymName/*= null*/) {
    
    // We unique sections by their segment/section pair.  The returned section
    // may not have the same flags as the requested section, if so this should be
    // diagnosed by the client as an error.
    
    // Form the name to look up.
    SmallString/*64*/ Name/*J*/= new SmallString/*64*/(64);
    Name.$addassign(/*NO_COPY*/Segment);
    Name.push_back($$COMMA);
    Name.$addassign(/*NO_COPY*/Section);
    
    // Do the lookup, if we have a hit, return it.
    final type$ref<MCSectionMachO /*P*/ /*&*/> Entry = MachOUniquingMap.ref$at(Name.$StringRef());
    if ((Entry.$deref() != null)) {
      return Entry.$deref();
    }
    
    MCSymbol /*P*/ Begin = null;
    if (Native.$bool(BeginSymName)) {
      Begin = createTempSymbol(new Twine(BeginSymName), false);
    }
    
    // Otherwise, return a new section.
    MCSymbol /*P*/ Begin_final = Begin;
    return Entry.$set(((/*JCast*/MCSectionMachO /*P*/ )(/*NEW_EXPR [System] MachOAllocator.Allocate() =*/ /*new (MachOAllocator.Allocate())*/ $new_uint_voidPtr(MachOAllocator.Allocate(), (type$ptr<?> New$Mem)->{
        return new MCSectionMachO(new StringRef(Segment), new StringRef(Section), TypeAndAttributes, Reserved2, new SectionKind(Kind), Begin_final);
     }))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getMachOSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 335,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 313,
   FQN="llvm::MCContext::getMachOSection", NM="_ZN4llvm9MCContext15getMachOSectionENS_9StringRefES1_jNS_11SectionKindEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext15getMachOSectionENS_9StringRefES1_jNS_11SectionKindEPKc")
  //</editor-fold>
  public MCSectionMachO /*P*/ getMachOSection(StringRef Segment, StringRef Section, 
                 /*uint*/int TypeAndAttributes, SectionKind K) {
    return getMachOSection(Segment, Section, 
                 TypeAndAttributes, K, 
                 (/*const*/char$ptr/*char P*/ )null);
  }
  public MCSectionMachO /*P*/ getMachOSection(StringRef Segment, StringRef Section, 
                 /*uint*/int TypeAndAttributes, SectionKind K, 
                 /*const*/char$ptr/*char P*/ BeginSymName/*= null*/) {
    return getMachOSection(new StringRef(Segment), new StringRef(Section), TypeAndAttributes, 0, new SectionKind(K), 
        BeginSymName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getELFSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 342,
   FQN="llvm::MCContext::getELFSection", NM="_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjj")
  //</editor-fold>
  public MCSectionELF /*P*/ getELFSection(final /*const*/ Twine /*&*/ Section, /*uint*/int Type, 
               /*uint*/int Flags) {
    return getELFSection(Section, Type, Flags, (/*const*/char$ptr/*char P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getELFSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 347,
   FQN="llvm::MCContext::getELFSection", NM="_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjjPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjjPKc")
  //</editor-fold>
  public MCSectionELF /*P*/ getELFSection(final /*const*/ Twine /*&*/ Section, /*uint*/int Type, 
               /*uint*/int Flags, /*const*/char$ptr/*char P*/ BeginSymName) {
    return getELFSection(Section, Type, Flags, 0, new Twine(/*KEEP_STR*/$EMPTY), BeginSymName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getELFSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 352,
   FQN="llvm::MCContext::getELFSection", NM="_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjjjS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjjjS3_")
  //</editor-fold>
  public MCSectionELF /*P*/ getELFSection(final /*const*/ Twine /*&*/ Section, /*uint*/int Type, 
               /*uint*/int Flags, /*uint*/int EntrySize, 
               final /*const*/ Twine /*&*/ Group) {
    return getELFSection(Section, Type, Flags, EntrySize, Group, (/*const*/char$ptr/*char P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getELFSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 358,
   FQN="llvm::MCContext::getELFSection", NM="_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjjjS3_PKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjjjS3_PKc")
  //</editor-fold>
  public MCSectionELF /*P*/ getELFSection(final /*const*/ Twine /*&*/ Section, /*uint*/int Type, 
               /*uint*/int Flags, /*uint*/int EntrySize, 
               final /*const*/ Twine /*&*/ Group, /*const*/char$ptr/*char P*/ BeginSymName) {
    return getELFSection(Section, Type, Flags, EntrySize, Group, ~0, 
        BeginSymName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getELFSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 365,
   FQN="llvm::MCContext::getELFSection", NM="_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjjjS3_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjjjS3_j")
  //</editor-fold>
  public MCSectionELF /*P*/ getELFSection(final /*const*/ Twine /*&*/ Section, /*uint*/int Type, 
               /*uint*/int Flags, /*uint*/int EntrySize, 
               final /*const*/ Twine /*&*/ Group, /*uint*/int UniqueID) {
    return getELFSection(Section, Type, Flags, EntrySize, Group, UniqueID, 
        (/*const*/char$ptr/*char P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getELFSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 333,
   FQN="llvm::MCContext::getELFSection", NM="_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjjjS3_jPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjjjS3_jPKc")
  //</editor-fold>
  public MCSectionELF /*P*/ getELFSection(final /*const*/ Twine /*&*/ Section, /*uint*/int Type, 
               /*uint*/int Flags, /*uint*/int EntrySize, 
               final /*const*/ Twine /*&*/ Group, /*uint*/int UniqueID, 
               /*const*/char$ptr/*char P*/ BeginSymName) {
    MCSymbolELF /*P*/ GroupSym = null;
    if (!Group.isTriviallyEmpty() && !Group.str().empty()) {
      GroupSym = cast_MCSymbolELF(getOrCreateSymbol(Group));
    }
    
    return getELFSection(Section, Type, Flags, EntrySize, GroupSym, UniqueID, 
        BeginSymName, (/*const*/ MCSectionELF /*P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getELFSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 345,
   FQN="llvm::MCContext::getELFSection", NM="_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjjjPKNS_11MCSymbolELFEjPKcPKNS_12MCSectionELFE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext13getELFSectionERKNS_5TwineEjjjPKNS_11MCSymbolELFEjPKcPKNS_12MCSectionELFE")
  //</editor-fold>
  public MCSectionELF /*P*/ getELFSection(final /*const*/ Twine /*&*/ Section, /*uint*/int Type, 
               /*uint*/int Flags, /*uint*/int EntrySize, 
               /*const*/ MCSymbolELF /*P*/ GroupSym, 
               /*uint*/int UniqueID, 
               /*const*/char$ptr/*char P*/ BeginSymName, 
               /*const*/ MCSectionELF /*P*/ Associated) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      StringRef Group = new StringRef(/*KEEP_STR*/$EMPTY);
      if ((GroupSym != null)) {
        Group.$assignMove(GroupSym.getName());
      }
      // Do the lookup, if we have a hit, return it.
      std.pairTypeBool<std.mapTypePtr.iterator</*const*/ ELFSectionKey, MCSectionELF /*P*/ >> IterBool = $c$.clean(ELFUniquingMap.insert$T($c$.track(std.make_pair_T_nullptr_t(
             $Move($c$.track(/*{ */new ELFSectionKey(new StringRef(Section.str()), new StringRef(Group), UniqueID)/* }*/)), null))));
      final pair<ELFSectionKey, MCSectionELF> Entry = IterBool.first.$star();
      if (!IterBool.second) {
        return Entry.second;
      }
      
      StringRef CachedName = new StringRef(Entry.first.SectionName);
      
      SectionKind Kind/*J*/= new SectionKind();
      if (((Flags & ELF.SHF_EXECINSTR) != 0)) {
        Kind.$assignMove(SectionKind.getText());
      } else {
        Kind.$assignMove(SectionKind.getReadOnly());
      }
      
      MCSymbol /*P*/ Begin = null;
      if (Native.$bool(BeginSymName)) {
        Begin = createTempSymbol(new Twine(BeginSymName), false);
      }
      
      MCSymbol /*P*/ Begin_final = Begin;
      MCSectionELF /*P*/ Result = ((/*JCast*/MCSectionELF /*P*/ )(/*NEW_EXPR [System] ELFAllocator.Allocate() =*/ /*new (ELFAllocator.Allocate())*/ $new_uint_voidPtr(ELFAllocator.Allocate(), (type$ptr<?> New$Mem)->{
          return new MCSectionELF(new StringRef(CachedName), Type, Flags, new SectionKind(Kind), EntrySize, GroupSym, UniqueID, 
                  Begin_final, Associated);
       })));
      Entry.second = Result;
      return Result;
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Get a section with the provided group identifier. This section is
  /// named by concatenating \p Prefix with '.' then \p Suffix. The \p Type
  /// describes the type of the section and \p Flags are used to further
  /// configure this named section.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getELFNamedSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 326,
   FQN="llvm::MCContext::getELFNamedSection", NM="_ZN4llvm9MCContext18getELFNamedSectionERKNS_5TwineES3_jjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext18getELFNamedSectionERKNS_5TwineES3_jjj")
  //</editor-fold>
  public MCSectionELF /*P*/ getELFNamedSection(final /*const*/ Twine /*&*/ Prefix, 
                    final /*const*/ Twine /*&*/ Suffix, /*uint*/int Type, 
                    /*uint*/int Flags) {
    return getELFNamedSection(Prefix, 
                    Suffix, Type, 
                    Flags, 
                    0);
  }
  public MCSectionELF /*P*/ getELFNamedSection(final /*const*/ Twine /*&*/ Prefix, 
                    final /*const*/ Twine /*&*/ Suffix, /*uint*/int Type, 
                    /*uint*/int Flags, 
                    /*uint*/int EntrySize/*= 0*/) {
    return getELFSection($add_Twine$C($add_Twine$C(Prefix, new Twine(/*KEEP_STR*/$DOT)), Suffix), Type, Flags, EntrySize, Suffix);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::createELFRelSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 312,
   FQN="llvm::MCContext::createELFRelSection", NM="_ZN4llvm9MCContext19createELFRelSectionERKNS_5TwineEjjjPKNS_11MCSymbolELFEPKNS_12MCSectionELFE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext19createELFRelSectionERKNS_5TwineEjjjPKNS_11MCSymbolELFEPKNS_12MCSectionELFE")
  //</editor-fold>
  public MCSectionELF /*P*/ createELFRelSection(final /*const*/ Twine /*&*/ Name, /*uint*/int Type, 
                     /*uint*/int Flags, /*uint*/int EntrySize, 
                     /*const*/ MCSymbolELF /*P*/ Group, 
                     /*const*/ MCSectionELF /*P*/ Associated) {
    StringMapIteratorBool I/*J*/= new StringMapIteratorBool();
    boolean Inserted;
    pairTypeBool<StringMapIteratorBool> insert = ELFRelSecNames.insert(new std.pairTypeBool<StringRef>(JD$Pair$_U1$_U2.INSTANCE, new StringRef(/*Fwd*/new std.string(JD$Move.INSTANCE, /*Fwd2*/Name.str())), /*Fwd2*//*Fwd*/true));
    I.$assign(insert.first);
    Inserted = insert.second;
    //std.tie(I, Inserted).$assign(
    //    ELFRelSecNames.insert(new std.pairTypeBool<StringRef>(JD$Pair$_U1$_U2.INSTANCE, new StringRef(/*Fwd*/new std.string(JD$Move.INSTANCE, /*Fwd2*/Name.str())), /*Fwd2*//*Fwd*/true))
    //);
    
    return /*NEW_EXPR [System] ELFAllocator.Allocate() =*/ /*new (ELFAllocator.Allocate())*/ $new_uint_voidPtr(ELFAllocator.Allocate(), (type$ptr<?> New$Mem)->{
        return new MCSectionELF(I.$arrow().getKey(), Type, Flags, SectionKind.getReadOnly(), 
                EntrySize, Group, /*true*/1, (MCSymbol /*P*/ )null, Associated);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::renameELFSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 296,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 299,
   FQN="llvm::MCContext::renameELFSection", NM="_ZN4llvm9MCContext16renameELFSectionEPNS_12MCSectionELFENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext16renameELFSectionEPNS_12MCSectionELFENS_9StringRefE")
  //</editor-fold>
  public void renameELFSection(MCSectionELF /*P*/ Section, StringRef Name) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      StringRef GroupName/*J*/= new StringRef();
      {
        /*const*/ MCSymbol /*P*/ Group = Section.getGroup();
        if ((Group != null)) {
          GroupName.$assignMove(Group.getName());
        }
      }
      
      /*uint*/int UniqueID = Section.getUniqueID();
      $c$.clean(ELFUniquingMap.erase($c$.track(/*{ */new ELFSectionKey(Section.getSectionName(), new StringRef(GroupName), UniqueID)/* }*/)));
      std.mapTypePtr.iterator</*const*/ ELFSectionKey, MCSectionELF /*P*/ > I = $c$.clean(new std.mapTypePtr.iterator</*const*/ ELFSectionKey, MCSectionELF /*P*/ >(JD$Move.INSTANCE, ELFUniquingMap.insert$T(
              $c$.track(std.make_pair_T_Ptr($Move($c$.track(/*{ */new ELFSectionKey(new StringRef(Name), new StringRef(GroupName), UniqueID)/* }*/)), Section
                ))).
            first));
      StringRef CachedName = new StringRef(I.$arrow().first.SectionName);
      ((/*const_cast*/MCSectionELF /*P*/ )(Section)).setSectionName(new StringRef(CachedName));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::createELFGroupSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 380,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 375,
   FQN="llvm::MCContext::createELFGroupSection", NM="_ZN4llvm9MCContext21createELFGroupSectionEPKNS_11MCSymbolELFE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext21createELFGroupSectionEPKNS_11MCSymbolELFE")
  //</editor-fold>
  public MCSectionELF /*P*/ createELFGroupSection(/*const*/ MCSymbolELF /*P*/ Group) {
    MCSectionELF /*P*/ Result = /*NEW_EXPR [System] ELFAllocator.Allocate() =*/ /*new (ELFAllocator.Allocate())*/ $new_uint_voidPtr(ELFAllocator.Allocate(), (type$ptr<?> New$Mem)->{
        return new MCSectionELF(new StringRef(/*KEEP_STR*/".group"), ELF.SHT_GROUP, 0, SectionKind.getReadOnly(), 4, 
                Group, ~0, (MCSymbol /*P*/ )null, (/*const*/ MCSectionELF /*P*/ )null);
     });
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getCOFFSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 387,
   FQN="llvm::MCContext::getCOFFSection", NM="_ZN4llvm9MCContext14getCOFFSectionENS_9StringRefEjNS_11SectionKindES1_ijPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext14getCOFFSectionENS_9StringRefEjNS_11SectionKindES1_ijPKc")
  //</editor-fold>
  public MCSectionCOFF /*P*/ getCOFFSection(StringRef Section, 
                /*uint*/int Characteristics, 
                SectionKind Kind, 
                StringRef COMDATSymName, int Selection) {
    return getCOFFSection(Section, 
                Characteristics, 
                Kind, 
                COMDATSymName, Selection, 
                GenericSectionID, 
                (/*const*/char$ptr/*char P*/ )null);
  }
  public MCSectionCOFF /*P*/ getCOFFSection(StringRef Section, 
                /*uint*/int Characteristics, 
                SectionKind Kind, 
                StringRef COMDATSymName, int Selection, 
                /*uint*/int UniqueID/*= GenericSectionID*/) {
    return getCOFFSection(Section, 
                Characteristics, 
                Kind, 
                COMDATSymName, Selection, 
                UniqueID, 
                (/*const*/char$ptr/*char P*/ )null);
  }
  public MCSectionCOFF /*P*/ getCOFFSection(StringRef Section, 
                /*uint*/int Characteristics, 
                SectionKind Kind, 
                StringRef COMDATSymName, int Selection, 
                /*uint*/int UniqueID/*= GenericSectionID*/, 
                /*const*/char$ptr/*char P*/ BeginSymName/*= null*/) {
    COFFSectionKey T = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      MCSymbol /*P*/ COMDATSymbol = null;
      if (!COMDATSymName.empty()) {
        COMDATSymbol = getOrCreateSymbol(new Twine(COMDATSymName));
        COMDATSymName.$assignMove(COMDATSymbol.getName());
      }
      
      // Do the lookup, if we have a hit, return it.
      T/*J*/= /*{ */new COFFSectionKey(new StringRef(Section), new StringRef(COMDATSymName), Selection, UniqueID)/* }*/;
      std.pairTypeBool<std.mapTypePtr.iterator</*const*/ COFFSectionKey, MCSectionCOFF /*P*/ >> IterBool = $c$.clean(COFFUniquingMap.insert$T($c$.track(std.make_pair_T_nullptr_t($Clone(T), null))));
      std.mapTypePtr.iterator</*const*/ COFFSectionKey, MCSectionCOFF /*P*/ > Iter = new std.mapTypePtr.iterator</*const*/ COFFSectionKey, MCSectionCOFF /*P*/ >(IterBool.first);
      if (!IterBool.second) {
        return Iter.$arrow().second;
      }
      
      MCSymbol /*P*/ Begin = null;
      if (Native.$bool(BeginSymName)) {
        Begin = createTempSymbol(new Twine(BeginSymName), false);
      }
      
      StringRef CachedName = new StringRef(Iter.$arrow().first.SectionName);
      MCSymbol /*P*/ Begin_final = Begin;
      MCSymbol /*P*/ COMDATSymbol_final = COMDATSymbol;
      MCSectionCOFF /*P*/ Result = ((/*JCast*/MCSectionCOFF /*P*/ )(/*NEW_EXPR [System] COFFAllocator.Allocate() =*/ /*new (COFFAllocator.Allocate())*/ $new_uint_voidPtr(COFFAllocator.Allocate(), (type$ptr<?> New$Mem)->{
          return new MCSectionCOFF(new StringRef(CachedName), Characteristics, COMDATSymbol_final, Selection, new SectionKind(Kind), Begin_final);
       })));
      
      Iter.$arrow().second = Result;
      return Result;
    } finally {
      if (T != null) { T.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getCOFFSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 419,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 412,
   FQN="llvm::MCContext::getCOFFSection", NM="_ZN4llvm9MCContext14getCOFFSectionENS_9StringRefEjNS_11SectionKindEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext14getCOFFSectionENS_9StringRefEjNS_11SectionKindEPKc")
  //</editor-fold>
  public MCSectionCOFF /*P*/ getCOFFSection(StringRef Section, 
                /*uint*/int Characteristics, 
                SectionKind Kind) {
    return getCOFFSection(Section, 
                Characteristics, 
                Kind, 
                (/*const*/char$ptr/*char P*/ )null);
  }
  public MCSectionCOFF /*P*/ getCOFFSection(StringRef Section, 
                /*uint*/int Characteristics, 
                SectionKind Kind, 
                /*const*/char$ptr/*char P*/ BeginSymName/*= null*/) {
    return getCOFFSection(new StringRef(Section), Characteristics, new SectionKind(Kind), new StringRef(/*KEEP_STR*/$EMPTY), 0, GenericSectionID, 
        BeginSymName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getCOFFSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 427,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 419,
   FQN="llvm::MCContext::getCOFFSection", NM="_ZN4llvm9MCContext14getCOFFSectionENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext14getCOFFSectionENS_9StringRefE")
  //</editor-fold>
  public MCSectionCOFF /*P*/ getCOFFSection(StringRef Section) {
    COFFSectionKey T = null;
    try {
      T/*J*/= /*{ */new COFFSectionKey(new StringRef(Section), new StringRef(/*KEEP_STR*/$EMPTY), 0, GenericSectionID)/* }*/;
      std.mapTypePtr.iterator</*const*/ COFFSectionKey, MCSectionCOFF /*P*/ > Iter = COFFUniquingMap.find(T);
      if (Iter.$eq(COFFUniquingMap.end())) {
        return null;
      }
      return Iter.$arrow().second;
    } finally {
      if (T != null) { T.$destroy(); }
    }
  }

  
  /// Gets or creates a section equivalent to Sec that is associated with the
  /// section containing KeySym. For example, to create a debug info section
  /// associated with an inline function, pass the normal debug info section
  /// as Sec and the function symbol as KeySym.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getAssociativeCOFFSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 435,
   FQN="llvm::MCContext::getAssociativeCOFFSection", NM="_ZN4llvm9MCContext25getAssociativeCOFFSectionEPNS_13MCSectionCOFFEPKNS_8MCSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext25getAssociativeCOFFSectionEPNS_13MCSectionCOFFEPKNS_8MCSymbolEj")
  //</editor-fold>
  public MCSectionCOFF /*P*/ getAssociativeCOFFSection(MCSectionCOFF /*P*/ Sec, 
                           /*const*/ MCSymbol /*P*/ KeySym) {
    return getAssociativeCOFFSection(Sec, 
                           KeySym, 
                           GenericSectionID);
  }
  public MCSectionCOFF /*P*/ getAssociativeCOFFSection(MCSectionCOFF /*P*/ Sec, 
                           /*const*/ MCSymbol /*P*/ KeySym, 
                           /*uint*/int UniqueID/*= GenericSectionID*/) {
    // Return the normal section if we don't have to be associative or unique.
    if (!(KeySym != null) && UniqueID == GenericSectionID) {
      return Sec;
    }
    
    // If we have a key symbol, make an associative section with the same name and
    // kind as the normal section.
    /*uint*/int Characteristics = Sec.getCharacteristics();
    if ((KeySym != null)) {
      Characteristics |= COFF.SectionCharacteristics.IMAGE_SCN_LNK_COMDAT;
      return getCOFFSection(Sec.getSectionName(), Characteristics, 
          Sec.getKind(), KeySym.getName(), 
          COFF.COMDATType.IMAGE_COMDAT_SELECT_ASSOCIATIVE.getValue(), UniqueID);
    }
    
    return getCOFFSection(Sec.getSectionName(), Characteristics, Sec.getKind(), 
        new StringRef(/*KEEP_STR*/$EMPTY), 0, UniqueID);
  }

  
  // Create and save a copy of STI and return a reference to the copy.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getSubtargetCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 456,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 442,
   FQN="llvm::MCContext::getSubtargetCopy", NM="_ZN4llvm9MCContext16getSubtargetCopyERKNS_15MCSubtargetInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext16getSubtargetCopyERKNS_15MCSubtargetInfoE")
  //</editor-fold>
  public MCSubtargetInfo /*&*/ getSubtargetCopy(final /*const*/ MCSubtargetInfo /*&*/ STI) {
    return $Deref(/*NEW_EXPR [System] MCSubtargetAllocator.Allocate() =*/ /*new (MCSubtargetAllocator.Allocate())*/ $new_uint_voidPtr(MCSubtargetAllocator.Allocate(), (type$ptr<?> New$Mem)->{
        return new MCSubtargetInfo(STI);
     }));
  }

  
  /// @}
  
  /// \name Dwarf Management
  /// @{
  
  /// \brief Get the compilation directory for DW_AT_comp_dir
  /// The compilation directory should be set with \c setCompilationDir before
  /// calling this function. If it is unset, an empty string will be returned.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getCompilationDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 431,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 401,
   FQN="llvm::MCContext::getCompilationDir", NM="_ZNK4llvm9MCContext17getCompilationDirEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext17getCompilationDirEv")
  //</editor-fold>
  public StringRef getCompilationDir() /*const*/ {
    return CompilationDir.$StringRef();
  }

  
  /// \brief Set the compilation directory for DW_AT_comp_dir
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setCompilationDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 434,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 405,
   FQN="llvm::MCContext::setCompilationDir", NM="_ZN4llvm9MCContext17setCompilationDirENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext17setCompilationDirENS_9StringRefE")
  //</editor-fold>
  public void setCompilationDir(StringRef S) {
    CompilationDir.$assign(new StringRef(S.str()));
  }

  
  /// \brief Get the main file name for use in error messages and debug
  /// info. This can be set to ensure we've got the correct file name
  /// after preprocessing or for -save-temps.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getMainFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 439,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 410,
   FQN="llvm::MCContext::getMainFileName", NM="_ZNK4llvm9MCContext15getMainFileNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext15getMainFileNameEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getMainFileName() /*const*/ {
    return MainFileName;
  }

  
  /// \brief Set the main file name and override the default.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setMainFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 442,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 413,
   FQN="llvm::MCContext::setMainFileName", NM="_ZN4llvm9MCContext15setMainFileNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext15setMainFileNameENS_9StringRefE")
  //</editor-fold>
  public void setMainFileName(StringRef S) {
    MainFileName.$assignMove(S.$string());
  }

  
  /// Creates an entry in the dwarf file and directory tables.
  
  //===----------------------------------------------------------------------===//
  // Dwarf Management
  //===----------------------------------------------------------------------===//
  
  /// getDwarfFile - takes a file name an number to place in the dwarf file and
  /// directory tables.  If the file number has already been allocated it is an
  /// error and zero is returned and the client reports the error, else the
  /// allocated file number is returned.  The file numbers may be in any order.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getDwarfFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 468,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 454,
   FQN="llvm::MCContext::getDwarfFile", NM="_ZN4llvm9MCContext12getDwarfFileENS_9StringRefES1_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext12getDwarfFileENS_9StringRefES1_jj")
  //</editor-fold>
  public /*uint*/int getDwarfFile(StringRef Directory, StringRef FileName, 
              /*uint*/int FileNumber, /*uint*/int CUID) {
    final MCDwarfLineTable /*&*/ Table = MCDwarfLineTablesCUMap.$at_T$C$R(CUID);
    return Table.getFile(Directory, FileName, FileNumber);
  }

  
  
  /// isValidDwarfFileNumber - takes a dwarf file number and returns true if it
  /// currently is assigned and false otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::isValidDwarfFileNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 476,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 462,
   FQN="llvm::MCContext::isValidDwarfFileNumber", NM="_ZN4llvm9MCContext22isValidDwarfFileNumberEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext22isValidDwarfFileNumberEjj")
  //</editor-fold>
  public boolean isValidDwarfFileNumber(/*uint*/int FileNumber) {
    return isValidDwarfFileNumber(FileNumber, 0);
  }
  public boolean isValidDwarfFileNumber(/*uint*/int FileNumber, /*uint*/int CUID/*= 0*/) {
    final /*const*/ SmallVectorImpl<MCDwarfFile> /*&*/ MCDwarfFiles = getMCDwarfFiles(CUID);
    if (FileNumber == 0 || $greatereq_uint(FileNumber, MCDwarfFiles.size())) {
      return false;
    }
    
    return !MCDwarfFiles.$at$Const(FileNumber).Name.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getMCDwarfLineTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 450,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 421,
   FQN="llvm::MCContext::getMCDwarfLineTables", NM="_ZNK4llvm9MCContext20getMCDwarfLineTablesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext20getMCDwarfLineTablesEv")
  //</editor-fold>
  public /*const*/std.mapUIntType<MCDwarfLineTable> /*&*/ getMCDwarfLineTables() /*const*/ {
    return MCDwarfLineTablesCUMap;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getMCDwarfLineTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 454,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 425,
   FQN="llvm::MCContext::getMCDwarfLineTable", NM="_ZN4llvm9MCContext19getMCDwarfLineTableEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext19getMCDwarfLineTableEj")
  //</editor-fold>
  public MCDwarfLineTable /*&*/ getMCDwarfLineTable(/*uint*/int CUID) {
    return MCDwarfLineTablesCUMap.$at_T$C$R(CUID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getMCDwarfLineTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 458,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 429,
   FQN="llvm::MCContext::getMCDwarfLineTable", NM="_ZNK4llvm9MCContext19getMCDwarfLineTableEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext19getMCDwarfLineTableEj")
  //</editor-fold>
  public /*const*/ MCDwarfLineTable /*&*/ getMCDwarfLineTable$Const(/*uint*/int CUID) /*const*/ {
    StdMapUIntType.iterator<MCDwarfLineTable> I = MCDwarfLineTablesCUMap.find$Const(CUID);
    assert (I.$noteq(MCDwarfLineTablesCUMap.end$Const()));
    return I.$arrow().second;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getMCDwarfFiles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 464,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 435,
   FQN="llvm::MCContext::getMCDwarfFiles", NM="_ZN4llvm9MCContext15getMCDwarfFilesEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext15getMCDwarfFilesEj")
  //</editor-fold>
  public /*const*/ SmallVectorImpl<MCDwarfFile> /*&*/ getMCDwarfFiles() {
    return getMCDwarfFiles(0);
  }
  public /*const*/ SmallVectorImpl<MCDwarfFile> /*&*/ getMCDwarfFiles(/*uint*/int CUID/*= 0*/) {
    return getMCDwarfLineTable(CUID).getMCDwarfFiles();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getMCDwarfDirs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 467,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 438,
   FQN="llvm::MCContext::getMCDwarfDirs", NM="_ZN4llvm9MCContext14getMCDwarfDirsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext14getMCDwarfDirsEj")
  //</editor-fold>
  public /*const*/ SmallVectorImpl<std.string> /*&*/ getMCDwarfDirs() {
    return getMCDwarfDirs(0);
  }
  public /*const*/ SmallVectorImpl<std.string> /*&*/ getMCDwarfDirs(/*uint*/int CUID/*= 0*/) {
    return getMCDwarfLineTable(CUID).getMCDwarfDirs();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::hasMCLineSections">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 471,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 442,
   FQN="llvm::MCContext::hasMCLineSections", NM="_ZNK4llvm9MCContext17hasMCLineSectionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext17hasMCLineSectionsEv")
  //</editor-fold>
  public boolean hasMCLineSections() /*const*/ {
    for (final /*const*/std.pairUIntType<MCDwarfLineTable> /*&*/ Table : MCDwarfLineTablesCUMap)  {
      if (!Table.second.getMCDwarfFiles$Const().empty() || (Table.second.getLabel() != null)) {
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getDwarfCompileUnitID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 477,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 448,
   FQN="llvm::MCContext::getDwarfCompileUnitID", NM="_ZN4llvm9MCContext21getDwarfCompileUnitIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext21getDwarfCompileUnitIDEv")
  //</editor-fold>
  public /*uint*/int getDwarfCompileUnitID() {
    return DwarfCompileUnitID;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setDwarfCompileUnitID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 478,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 449,
   FQN="llvm::MCContext::setDwarfCompileUnitID", NM="_ZN4llvm9MCContext21setDwarfCompileUnitIDEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext21setDwarfCompileUnitIDEj")
  //</editor-fold>
  public void setDwarfCompileUnitID(/*uint*/int CUIndex) {
    DwarfCompileUnitID = CUIndex;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setMCLineTableCompilationDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 481,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 452,
   FQN="llvm::MCContext::setMCLineTableCompilationDir", NM="_ZN4llvm9MCContext28setMCLineTableCompilationDirEjNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext28setMCLineTableCompilationDirEjNS_9StringRefE")
  //</editor-fold>
  public void setMCLineTableCompilationDir(/*uint*/int CUID, StringRef CompilationDir) {
    getMCDwarfLineTable(CUID).setCompilationDir(new StringRef(CompilationDir));
  }

  
  /// Saves the information from the currently parsed dwarf .loc directive
  /// and sets DwarfLocSeen.  When the next instruction is assembled an entry
  /// in the line number table with this information and the address of the
  /// instruction will be created.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setCurrentDwarfLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 489,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 460,
   FQN="llvm::MCContext::setCurrentDwarfLoc", NM="_ZN4llvm9MCContext18setCurrentDwarfLocEjjjjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext18setCurrentDwarfLocEjjjjjj")
  //</editor-fold>
  public void setCurrentDwarfLoc(/*uint*/int FileNum, /*uint*/int Line, /*uint*/int Column, 
                    /*uint*/int Flags, /*uint*/int Isa, 
                    /*uint*/int Discriminator) {
    CurrentDwarfLoc.setFileNum(FileNum);
    CurrentDwarfLoc.setLine(Line);
    CurrentDwarfLoc.setColumn(Column);
    CurrentDwarfLoc.setFlags(Flags);
    CurrentDwarfLoc.setIsa(Isa);
    CurrentDwarfLoc.setDiscriminator(Discriminator);
    DwarfLocSeen = true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::clearDwarfLocSeen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 500,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 471,
   FQN="llvm::MCContext::clearDwarfLocSeen", NM="_ZN4llvm9MCContext17clearDwarfLocSeenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext17clearDwarfLocSeenEv")
  //</editor-fold>
  public void clearDwarfLocSeen() {
    DwarfLocSeen = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getDwarfLocSeen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 502,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 473,
   FQN="llvm::MCContext::getDwarfLocSeen", NM="_ZN4llvm9MCContext15getDwarfLocSeenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext15getDwarfLocSeenEv")
  //</editor-fold>
  public boolean getDwarfLocSeen() {
    return DwarfLocSeen;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getCurrentDwarfLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 503,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 474,
   FQN="llvm::MCContext::getCurrentDwarfLoc", NM="_ZN4llvm9MCContext18getCurrentDwarfLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext18getCurrentDwarfLocEv")
  //</editor-fold>
  public /*const*/ MCDwarfLoc /*&*/ getCurrentDwarfLoc() {
    return CurrentDwarfLoc;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getGenDwarfForAssembly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 505,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 476,
   FQN="llvm::MCContext::getGenDwarfForAssembly", NM="_ZN4llvm9MCContext22getGenDwarfForAssemblyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext22getGenDwarfForAssemblyEv")
  //</editor-fold>
  public boolean getGenDwarfForAssembly() {
    return GenDwarfForAssembly;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setGenDwarfForAssembly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 506,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 477,
   FQN="llvm::MCContext::setGenDwarfForAssembly", NM="_ZN4llvm9MCContext22setGenDwarfForAssemblyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext22setGenDwarfForAssemblyEb")
  //</editor-fold>
  public void setGenDwarfForAssembly(boolean Value) {
    GenDwarfForAssembly = Value;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getGenDwarfFileNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 507,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 478,
   FQN="llvm::MCContext::getGenDwarfFileNumber", NM="_ZN4llvm9MCContext21getGenDwarfFileNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext21getGenDwarfFileNumberEv")
  //</editor-fold>
  public /*uint*/int getGenDwarfFileNumber() {
    return GenDwarfFileNumber;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setGenDwarfFileNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 508,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 479,
   FQN="llvm::MCContext::setGenDwarfFileNumber", NM="_ZN4llvm9MCContext21setGenDwarfFileNumberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext21setGenDwarfFileNumberEj")
  //</editor-fold>
  public void setGenDwarfFileNumber(/*uint*/int FileNumber) {
    GenDwarfFileNumber = FileNumber;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getGenDwarfSectionSyms">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 511,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 482,
   FQN="llvm::MCContext::getGenDwarfSectionSyms", NM="_ZN4llvm9MCContext22getGenDwarfSectionSymsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext22getGenDwarfSectionSymsEv")
  //</editor-fold>
  public /*const*/SetVector<MCSection /*P*/ > /*&*/ getGenDwarfSectionSyms() {
    return SectionsForRanges;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::addGenDwarfSection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 514,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 485,
   FQN="llvm::MCContext::addGenDwarfSection", NM="_ZN4llvm9MCContext18addGenDwarfSectionEPNS_9MCSectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext18addGenDwarfSectionEPNS_9MCSectionE")
  //</editor-fold>
  public boolean addGenDwarfSection(MCSection /*P*/ Sec) {
    return SectionsForRanges.insert(Sec);
  }

  
  
  /// Remove empty sections from SectionStartEndSyms, to avoid generating
  /// useless debug info for them.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::finalizeDwarfSections">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 486,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 472,
   FQN="llvm::MCContext::finalizeDwarfSections", NM="_ZN4llvm9MCContext21finalizeDwarfSectionsERNS_10MCStreamerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext21finalizeDwarfSectionsERNS_10MCStreamerE")
  //</editor-fold>
  public void finalizeDwarfSections(final MCStreamer /*&*/ MCOS) {
    SectionsForRanges.remove_if(/*[&, &MCOS]*/ (MCSection /*P*/ Sec) -> {
              return !MCOS.mayHaveInstructions($Deref(Sec));
            });
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getMCGenDwarfLabelEntries">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 519,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 490,
   FQN="llvm::MCContext::getMCGenDwarfLabelEntries", NM="_ZNK4llvm9MCContext25getMCGenDwarfLabelEntriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext25getMCGenDwarfLabelEntriesEv")
  //</editor-fold>
  public /*const*/std.vector<MCGenDwarfLabelEntry> /*&*/ getMCGenDwarfLabelEntries() /*const*/ {
    return MCGenDwarfLabelEntries;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::addMCGenDwarfLabelEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 522,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 493,
   FQN="llvm::MCContext::addMCGenDwarfLabelEntry", NM="_ZN4llvm9MCContext23addMCGenDwarfLabelEntryERKNS_20MCGenDwarfLabelEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext23addMCGenDwarfLabelEntryERKNS_20MCGenDwarfLabelEntryE")
  //</editor-fold>
  public void addMCGenDwarfLabelEntry(final /*const*/ MCGenDwarfLabelEntry /*&*/ E) {
    MCGenDwarfLabelEntries.push_back_T$C$R(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setDwarfDebugFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 526,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 497,
   FQN="llvm::MCContext::setDwarfDebugFlags", NM="_ZN4llvm9MCContext18setDwarfDebugFlagsENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext18setDwarfDebugFlagsENS_9StringRefE")
  //</editor-fold>
  public void setDwarfDebugFlags(StringRef S) {
    DwarfDebugFlags.$assign(S);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getDwarfDebugFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 527,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 498,
   FQN="llvm::MCContext::getDwarfDebugFlags", NM="_ZN4llvm9MCContext18getDwarfDebugFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext18getDwarfDebugFlagsEv")
  //</editor-fold>
  public StringRef getDwarfDebugFlags() {
    return new StringRef(DwarfDebugFlags);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setDwarfDebugProducer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 529,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 500,
   FQN="llvm::MCContext::setDwarfDebugProducer", NM="_ZN4llvm9MCContext21setDwarfDebugProducerENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext21setDwarfDebugProducerENS_9StringRefE")
  //</editor-fold>
  public void setDwarfDebugProducer(StringRef S) {
    DwarfDebugProducer.$assign(S);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getDwarfDebugProducer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 530,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 501,
   FQN="llvm::MCContext::getDwarfDebugProducer", NM="_ZN4llvm9MCContext21getDwarfDebugProducerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext21getDwarfDebugProducerEv")
  //</editor-fold>
  public StringRef getDwarfDebugProducer() {
    return new StringRef(DwarfDebugProducer);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setDwarfVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 532,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 503,
   FQN="llvm::MCContext::setDwarfVersion", NM="_ZN4llvm9MCContext15setDwarfVersionEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext15setDwarfVersionEt")
  //</editor-fold>
  public void setDwarfVersion(/*uint16_t*/char v) {
    DwarfVersion = v;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getDwarfVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 533,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 504,
   FQN="llvm::MCContext::getDwarfVersion", NM="_ZNK4llvm9MCContext15getDwarfVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm9MCContext15getDwarfVersionEv")
  //</editor-fold>
  public /*uint16_t*/char getDwarfVersion() /*const*/ {
    return DwarfVersion;
  }

  
  /// @}
  
  /// \name CodeView Management
  /// @{
  
  /// Creates an entry in the cv file table.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getCVFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 497,
   FQN="llvm::MCContext::getCVFile", NM="_ZN4llvm9MCContext9getCVFileENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext9getCVFileENS_9StringRefEj")
  //</editor-fold>
  public /*uint*/int getCVFile(StringRef FileName, /*uint*/int FileNumber) {
    return getCVContext().addFile(FileNumber, new StringRef(FileName)) ? FileNumber : 0;
  }

  
  /// Saves the information from the currently parsed .cv_loc directive
  /// and sets CVLocSeen.  When the next instruction is assembled an entry
  /// in the line number table with this information and the address of the
  /// instruction will be created.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setCurrentCVLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 548,
   FQN="llvm::MCContext::setCurrentCVLoc", NM="_ZN4llvm9MCContext15setCurrentCVLocEjjjjbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext15setCurrentCVLocEjjjjbb")
  //</editor-fold>
  public void setCurrentCVLoc(/*uint*/int FunctionId, /*uint*/int FileNo, /*uint*/int Line, 
                 /*uint*/int Column, boolean PrologueEnd, boolean IsStmt) {
    CurrentCVLoc.setFunctionId(FunctionId);
    CurrentCVLoc.setFileNum(FileNo);
    CurrentCVLoc.setLine(Line);
    CurrentCVLoc.setColumn(Column);
    CurrentCVLoc.setPrologueEnd(PrologueEnd);
    CurrentCVLoc.setIsStmt(IsStmt);
    CVLocSeen = true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::clearCVLocSeen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 558,
   FQN="llvm::MCContext::clearCVLocSeen", NM="_ZN4llvm9MCContext14clearCVLocSeenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext14clearCVLocSeenEv")
  //</editor-fold>
  public void clearCVLocSeen() {
    CVLocSeen = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getCVLocSeen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 560,
   FQN="llvm::MCContext::getCVLocSeen", NM="_ZN4llvm9MCContext12getCVLocSeenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext12getCVLocSeenEv")
  //</editor-fold>
  public boolean getCVLocSeen() {
    return CVLocSeen;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getCurrentCVLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 561,
   FQN="llvm::MCContext::getCurrentCVLoc", NM="_ZN4llvm9MCContext15getCurrentCVLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext15getCurrentCVLocEv")
  //</editor-fold>
  public /*const*/ MCCVLoc /*&*/ getCurrentCVLoc() {
    return CurrentCVLoc;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::isValidCVFileNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 501,
   FQN="llvm::MCContext::isValidCVFileNumber", NM="_ZN4llvm9MCContext19isValidCVFileNumberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext19isValidCVFileNumberEj")
  //</editor-fold>
  public boolean isValidCVFileNumber(/*uint*/int FileNumber) {
    return getCVContext().isValidFileNumber(FileNumber);
  }

  /// @}
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getSecureLogFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 566,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 508,
   FQN="llvm::MCContext::getSecureLogFile", NM="_ZN4llvm9MCContext16getSecureLogFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext16getSecureLogFileEv")
  //</editor-fold>
  public char$ptr/*char P*/ getSecureLogFile() {
    return SecureLogFile;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getSecureLog">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 567,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 509,
   FQN="llvm::MCContext::getSecureLog", NM="_ZN4llvm9MCContext12getSecureLogEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext12getSecureLogEv")
  //</editor-fold>
  public raw_fd_ostream /*P*/ getSecureLog() {
    return SecureLog.get();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::getSecureLogUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 568,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 510,
   FQN="llvm::MCContext::getSecureLogUsed", NM="_ZN4llvm9MCContext16getSecureLogUsedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext16getSecureLogUsedEv")
  //</editor-fold>
  public boolean getSecureLogUsed() {
    return SecureLogUsed;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setSecureLog">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 569,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 511,
   FQN="llvm::MCContext::setSecureLog", NM="_ZN4llvm9MCContext12setSecureLogESt10unique_ptrINS_14raw_fd_ostreamESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext12setSecureLogESt10unique_ptrINS_14raw_fd_ostreamESt14default_deleteIS2_EE")
  //</editor-fold>
  public void setSecureLog(std.unique_ptr<raw_fd_ostream> Value) {
    SecureLog.$assignMove(std.move(Value));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::setSecureLogUsed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 572,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 514,
   FQN="llvm::MCContext::setSecureLogUsed", NM="_ZN4llvm9MCContext16setSecureLogUsedEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext16setSecureLogUsedEb")
  //</editor-fold>
  public void setSecureLogUsed(boolean Value) {
    SecureLogUsed = Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::allocate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 574,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 516,
   FQN="llvm::MCContext::allocate", NM="_ZN4llvm9MCContext8allocateEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext8allocateEjj")
  //</editor-fold>
  public Object/*void P*/ allocate(/*uint*/int Size) {
    return allocate(Size, 8);
  }
  public Object/*void P*/ allocate(/*uint*/int Size, /*uint*/int Align/*= 8*/) {
    return Allocator.Allocate(Size, Align);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::deallocate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 577,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 519,
   FQN="llvm::MCContext::deallocate", NM="_ZN4llvm9MCContext10deallocateEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext10deallocateEPv")
  //</editor-fold>
  public void deallocate(Object/*void P*/ Ptr) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::hadError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", line = 579,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCContext.h", old_line = 521,
   FQN="llvm::MCContext::hadError", NM="_ZN4llvm9MCContext8hadErrorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext8hadErrorEv")
  //</editor-fold>
  public boolean hadError() {
    return HadError;
  }

  
  //===----------------------------------------------------------------------===//
  // Error Reporting
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::reportError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 509,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 481,
   FQN="llvm::MCContext::reportError", NM="_ZN4llvm9MCContext11reportErrorENS_5SMLocERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext11reportErrorENS_5SMLocERKNS_5TwineE")
  //</editor-fold>
  public void reportError(SMLoc Loc, final /*const*/ Twine /*&*/ Msg) {
    HadError = true;
    
    // If we have a source manager use it. Otherwise just use the generic
    // report_fatal_error().
    if (!(SrcMgr != null)) {
      report_fatal_error(Msg, false);
    }
    
    // Use the source manager to print the message.
    SrcMgr.PrintMessage(new SMLoc(Loc), SourceMgr.DiagKind.DK_Error, Msg);
  }

  // Unrecoverable error has occurred. Display the best diagnostic we can
  // and bail via exit(1). For now, most MC backend errors are unrecoverable.
  // FIXME: We should really do something about that.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCContext::reportFatalError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", line = 521,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCContext.cpp", old_line = 493,
   FQN="llvm::MCContext::reportFatalError", NM="_ZN4llvm9MCContext16reportFatalErrorENS_5SMLocERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm9MCContext16reportFatalErrorENS_5SMLocERKNS_5TwineE")
  //</editor-fold>
  public void reportFatalError(SMLoc Loc, final /*const*/ Twine /*&*/ Msg) {
    reportError(new SMLoc(Loc), Msg);
    
    // If we reached here, we are failing ungracefully. Run the interrupt handlers
    // to make sure any special cleanups get done, in particular that we remove
    // files registered with RemoveFileOnSignal.
    sys.RunInterruptHandlers();
    exit(1);
  }

  
  @Override public String toString() {
    return "" + "SrcMgr=" + SrcMgr // NOI18N
              + ", MAI=" + MAI // NOI18N
              + ", MRI=" + MRI // NOI18N
              + ", MOFI=" + MOFI // NOI18N
              + ", CVContext=" + "[Unique_ptr$CodeViewContext]" // NOI18N
              + ", Allocator=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", COFFAllocator=" + COFFAllocator // NOI18N
              + ", ELFAllocator=" + ELFAllocator // NOI18N
              + ", MachOAllocator=" + MachOAllocator // NOI18N
              + ", Symbols=" + "[StringMap$MCSymbol$BumpPtrAllocatorImpl]" // NOI18N
              + ", SectionSymbols=" + SectionSymbols // NOI18N
              + ", LocalSymbols=" + LocalSymbols // NOI18N
              + ", UsedNames=" + UsedNames // NOI18N
              + ", NextID=" + NextID // NOI18N
              + ", Instances=" + Instances // NOI18N
              + ", SecureLogFile=" + SecureLogFile // NOI18N
              + ", SecureLog=" + SecureLog // NOI18N
              + ", SecureLogUsed=" + SecureLogUsed // NOI18N
              + ", CompilationDir=" + CompilationDir // NOI18N
              + ", MainFileName=" + MainFileName // NOI18N
              + ", MCDwarfLineTablesCUMap=" + MCDwarfLineTablesCUMap // NOI18N
              + ", CurrentDwarfLoc=" + CurrentDwarfLoc // NOI18N
              + ", DwarfLocSeen=" + DwarfLocSeen // NOI18N
              + ", CurrentCVLoc=" + CurrentCVLoc // NOI18N
              + ", CVLocSeen=" + CVLocSeen // NOI18N
              + ", GenDwarfForAssembly=" + GenDwarfForAssembly // NOI18N
              + ", GenDwarfFileNumber=" + GenDwarfFileNumber // NOI18N
              + ", SectionsForRanges=" + SectionsForRanges // NOI18N
              + ", MCGenDwarfLabelEntries=" + MCGenDwarfLabelEntries // NOI18N
              + ", DwarfDebugFlags=" + DwarfDebugFlags // NOI18N
              + ", DwarfDebugProducer=" + DwarfDebugProducer // NOI18N
              + ", DwarfVersion=" + $ushort2uint(DwarfVersion) // NOI18N
              + ", AllowTemporaryLabels=" + AllowTemporaryLabels // NOI18N
              + ", UseNamesOnTempLabels=" + UseNamesOnTempLabels // NOI18N
              + ", DwarfCompileUnitID=" + DwarfCompileUnitID // NOI18N
              + ", MachOUniquingMap=" + MachOUniquingMap // NOI18N
              + ", ELFUniquingMap=" + ELFUniquingMap // NOI18N
              + ", COFFUniquingMap=" + COFFUniquingMap // NOI18N
              + ", ELFRelSecNames=" + ELFRelSecNames // NOI18N
              + ", MCSubtargetAllocator=" + MCSubtargetAllocator // NOI18N
              + ", AutoReset=" + AutoReset // NOI18N
              + ", HadError=" + HadError; // NOI18N
  }
}
