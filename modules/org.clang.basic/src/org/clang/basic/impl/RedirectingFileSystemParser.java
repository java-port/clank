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

package org.clang.basic.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.vfs.*;
import org.clang.basic.impl.RedirectingFileEntry.NameKind;
import org.clang.basic.llvm.impl.DenseMapInfoStringRef;
import static org.clang.basic.vfs.VfsGlobals.getNextVirtualUniqueID;
import org.llvm.support.sys.TimeValue;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.fs.file_type;
import org.llvm.support.sys.path;
import org.llvm.support.yaml.*;


/// \brief A helper class to hold the common YAML parsing state.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 966,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 891,
 FQN="(anonymous namespace)::RedirectingFileSystemParser", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParserE")
//</editor-fold>
public class RedirectingFileSystemParser {
  private Stream /*&*/ Stream;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 969,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 894,
   FQN="(anonymous namespace)::RedirectingFileSystemParser::error", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParser5errorEPN4llvm4yaml4NodeERKNS1_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParser5errorEPN4llvm4yaml4NodeERKNS1_5TwineE")
  //</editor-fold>
  private void error(Node /*P*/ N, /*const*/ Twine /*&*/ Msg) {
    Stream.printError(N, Msg);
  }

  
  // false on error
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::parseScalarString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 974,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 899,
   FQN="(anonymous namespace)::RedirectingFileSystemParser::parseScalarString", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParser17parseScalarStringEPN4llvm4yaml4NodeERNS1_9StringRefERNS1_15SmallVectorImplIcEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParser17parseScalarStringEPN4llvm4yaml4NodeERNS1_9StringRefERNS1_15SmallVectorImplIcEE")
  //</editor-fold>
  private boolean parseScalarString(Node /*P*/ N, StringRef /*&*/ Result, 
                   SmallString/*&*/ Storage) {
    ScalarNode /*P*/ S = dyn_cast(ScalarNode.class, N);
    if (!(S != null)) {
      error(N, new Twine(/*KEEP_STR*/"expected string"));
      return false;
    }
    Result.$assignMove(S.getValue(Storage));
    return true;
  }

  
  // false on error
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::parseScalarBool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 986,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 911,
   FQN="(anonymous namespace)::RedirectingFileSystemParser::parseScalarBool", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParser15parseScalarBoolEPN4llvm4yaml4NodeERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParser15parseScalarBoolEPN4llvm4yaml4NodeERb")
  //</editor-fold>
  private boolean parseScalarBool(Node /*P*/ N, bool$ref/*bool &*/ Result) {
    SmallString/*5*/ Storage/*J*/= new SmallString/*5*/(5);
    StringRef Value/*J*/= new StringRef();
    if (!parseScalarString(N, Value, Storage)) {
      return false;
    }
    if (Value.equals_lower(/*STRINGREF_STR*/"true") || Value.equals_lower(/*STRINGREF_STR*/"on")
       || Value.equals_lower(/*STRINGREF_STR*/"yes") || $eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"1")) {
      Result.$set(true);
      return true;
    } else if (Value.equals_lower(/*STRINGREF_STR*/"false") || Value.equals_lower(/*STRINGREF_STR*/"off")
       || Value.equals_lower(/*STRINGREF_STR*/"no") || $eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"0")) {
      Result.$set(false);
      return true;
    }
    
    error(N, new Twine(/*KEEP_STR*/"expected boolean value"));
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::KeyStatus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1006,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 931,
   FQN="(anonymous namespace)::RedirectingFileSystemParser::KeyStatus", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParser9KeyStatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParser9KeyStatusE")
  //</editor-fold>
  private static class/*struct*/ KeyStatus implements NativePOD<KeyStatus> {
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::KeyStatus::KeyStatus">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1007,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 932,
     FQN="(anonymous namespace)::RedirectingFileSystemParser::KeyStatus::KeyStatus", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParser9KeyStatusC1Eb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParser9KeyStatusC1Eb")
    //</editor-fold>
    public KeyStatus() {
      this(false);
    }
    public KeyStatus(boolean Required/*= false*/) {
      /* : Required(Required), Seen(false)*/ 
      //START JInit
      this.Required = Required;
      this.Seen = false;
      //END JInit
    }

    public boolean Required;
    public boolean Seen;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::KeyStatus::KeyStatus">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1006,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 931,
     FQN="(anonymous namespace)::RedirectingFileSystemParser::KeyStatus::KeyStatus", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParser9KeyStatusC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParser9KeyStatusC1ERKS1_")
    //</editor-fold>
    public /*inline*/ KeyStatus(/*const*/ KeyStatus /*&*/ $Prm0) {
      /* : Required(.Required), Seen(.Seen)*/ 
      //START JInit
      this.Required = $Prm0.Required;
      this.Seen = $Prm0.Seen;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::KeyStatus::KeyStatus">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1006,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 931,
     FQN="(anonymous namespace)::RedirectingFileSystemParser::KeyStatus::KeyStatus", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParser9KeyStatusC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParser9KeyStatusC1EOS1_")
    //</editor-fold>
    public /*inline*/ KeyStatus(JD$Move _dparam, KeyStatus /*&&*/$Prm0) {
      /* : Required(static_cast<KeyStatus &&>().Required), Seen(static_cast<KeyStatus &&>().Seen)*/ 
      //START JInit
      this.Required = $Prm0.Required;
      this.Seen = $Prm0.Seen;
      //END JInit
    }

    @Override
    public KeyStatus $assign(KeyStatus value) {
      this.Required = value.Required;
      this.Seen = value.Seen;
      return this;
    }

    @Override
    public KeyStatus clone() {
      return new KeyStatus(this);
    }
    
    public String toString() {
      return "" + "Required=" + Required // NOI18N
                + ", Seen=" + Seen; // NOI18N
    }
  };
  /*typedef std::pair<StringRef, KeyStatus> KeyStatusPair*/
//  public final class KeyStatusPair extends std.pair<StringRef, RedirectingFileSystemParser.KeyStatus>{ };
  
  // false on error
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::checkDuplicateOrUnknownKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1014,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 939,
   FQN="(anonymous namespace)::RedirectingFileSystemParser::checkDuplicateOrUnknownKey", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParser26checkDuplicateOrUnknownKeyEPN4llvm4yaml4NodeENS1_9StringRefERNS1_8DenseMapIS5_NS0_9KeyStatusENS1_12DenseMapInfoIS5_EENS1_6detail12DenseMapPairIS5_S7_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParser26checkDuplicateOrUnknownKeyEPN4llvm4yaml4NodeENS1_9StringRefERNS1_8DenseMapIS5_NS0_9KeyStatusENS1_12DenseMapInfoIS5_EENS1_6detail12DenseMapPairIS5_S7_EEEE")
  //</editor-fold>
  private boolean checkDuplicateOrUnknownKey(Node /*P*/ KeyNode, StringRef Key, 
                            DenseMap<StringRef, KeyStatus>/*&*/ Keys) {
    if (!(Keys.count(Key) != 0)) {
      error(KeyNode, new Twine(/*KEEP_STR*/"unknown key"));
      return false;
    }
    KeyStatus /*&*/ S = Keys.$at(Key);
    if (S.Seen) {
      error(KeyNode, $add_Twine($add_Twine(new Twine(/*KEEP_STR*/"duplicate key '"), new Twine(Key)), new Twine(/*KEEP_STR*/$SGL_QUOTE)));
      return false;
    }
    S.Seen = true;
    return true;
  }

  
  // false on error
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::checkMissingKeys">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1030,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 955,
   FQN="(anonymous namespace)::RedirectingFileSystemParser::checkMissingKeys", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParser16checkMissingKeysEPN4llvm4yaml4NodeERNS1_8DenseMapINS1_9StringRefENS0_9KeyStatusENS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_S7_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParser16checkMissingKeysEPN4llvm4yaml4NodeERNS1_8DenseMapINS1_9StringRefENS0_9KeyStatusENS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_S7_EEEE")
  //</editor-fold>
  private boolean checkMissingKeys(Node /*P*/ Obj, DenseMap<StringRef, KeyStatus>/*&*/ Keys) {
    for (DenseMapIterator<StringRef, KeyStatus> I = Keys.begin(), 
        E = Keys.end();
         I.$noteq(/*NO_ITER_COPY*/E); I.$preInc()) {
      if (I.$arrow().second.Required && !I.$arrow().second.Seen) {
        error(Obj, $add_Twine($add_Twine(new Twine(/*KEEP_STR*/"missing key '"), new Twine(I.$arrow().first)), new Twine(/*KEEP_STR*/$SGL_QUOTE)));
        return false;
      }
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::lookupOrCreateEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1042,
   FQN="(anonymous namespace)::RedirectingFileSystemParser::lookupOrCreateEntry", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParser19lookupOrCreateEntryEPNS_21RedirectingFileSystemEN4llvm9StringRefEPNS_5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParser19lookupOrCreateEntryEPNS_21RedirectingFileSystemEN4llvm9StringRefEPNS_5EntryE")
  //</editor-fold>
  private Entry /*P*/ lookupOrCreateEntry(RedirectingFileSystem /*P*/ FS, StringRef Name) {
    return lookupOrCreateEntry(FS, Name, 
                     (Entry /*P*/ )null);
  }
  private Entry /*P*/ lookupOrCreateEntry(RedirectingFileSystem /*P*/ FS, StringRef Name, 
                     Entry /*P*/ ParentEntry/*= null*/) {
    std.unique_ptr<Entry> E = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!(ParentEntry != null)) { // Look for a existent root
        for (/*const*/ std.unique_ptr<Entry> /*&*/ Root : FS.Roots) {
          if (Name.equals(Root.$arrow().getName())) {
            ParentEntry = Root.get();
            return ParentEntry;
          }
        }
      } else { // Advance to the next component
        RedirectingDirectoryEntry /*P*/ DE = dyn_cast(RedirectingDirectoryEntry.class, ParentEntry);
        for (std.unique_ptr<Entry> /*&*/ Content : llvm.make_range(DE.contents_begin(), DE.contents_end())) {
          RedirectingDirectoryEntry /*P*/ DirContent = dyn_cast(RedirectingDirectoryEntry.class, Content.get());
          if ((DirContent != null) && Name.equals(Content.$arrow().getName())) {
            return DirContent;
          }
        }
      }
      
      // ... or create a new one
      E = $c$.clean(new std.unique_ptr<Entry>($c$.track(llvm.make_unique(new RedirectingDirectoryEntry(Name, new Status(new StringRef(/*KEEP_STR*/$EMPTY), getNextVirtualUniqueID(), TimeValue.now(), 0, 0, 
                  0, file_type.directory_file, fs.perms.all_all))))));
      if (!(ParentEntry != null)) { // Add a new root to the overlay
        FS.Roots.push_back_T$RR(std.move(E));
        ParentEntry = FS.Roots.back().get();
        return ParentEntry;
      }
      
      RedirectingDirectoryEntry /*P*/ DE = dyn_cast(RedirectingDirectoryEntry.class, ParentEntry);
      DE.addContent($c$.track(new std.unique_ptr<Entry>(JD$Move.INSTANCE, std.move(E)))); $c$.clean();
      return DE.getLastContent();
    } finally {
      if (E != null) { E.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::uniqueOverlayTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1077,
   FQN="(anonymous namespace)::RedirectingFileSystemParser::uniqueOverlayTree", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParser17uniqueOverlayTreeEPNS_21RedirectingFileSystemEPNS_5EntryES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParser17uniqueOverlayTreeEPNS_21RedirectingFileSystemEPNS_5EntryES4_")
  //</editor-fold>
  private void uniqueOverlayTree(RedirectingFileSystem /*P*/ FS, Entry /*P*/ SrcE) {
    uniqueOverlayTree(FS, SrcE, 
                   (Entry /*P*/ )null);
  }
  private void uniqueOverlayTree(RedirectingFileSystem /*P*/ FS, Entry /*P*/ SrcE, 
                   Entry /*P*/ NewParentE/*= null*/) {
    StringRef Name = SrcE.getName();
    switch (SrcE.getKind()) {
     case EK_Directory:
      {
        RedirectingDirectoryEntry /*P*/ DE = dyn_cast(RedirectingDirectoryEntry.class, SrcE);
        assert ((DE != null)) : "Must be a directory";
        // Empty directories could be present in the YAML as a way to
        // describe a file for a current directory after some of its subdir
        // is parsed. This only leads to redundant walks, ignore it.
        if (!Name.empty()) {
          NewParentE = lookupOrCreateEntry(FS, new StringRef(Name), NewParentE);
        }
        for (std.unique_ptr<Entry> /*&*/ SubEntry : llvm.make_range(DE.contents_begin(), DE.contents_end()))  {
          uniqueOverlayTree(FS, SubEntry.get(), NewParentE);
        }
        break;
      }
     case EK_File:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          RedirectingFileEntry /*P*/ FE = dyn_cast(RedirectingFileEntry.class, SrcE);
          assert ((FE != null)) : "Must be a file";
          assert ((NewParentE != null)) : "Parent entry must exist";
          RedirectingDirectoryEntry /*P*/ DE = dyn_cast(RedirectingDirectoryEntry.class, NewParentE);
          DE.addContent($c$.track(new std.unique_ptr<Entry>($c$.track(llvm.make_unique(new RedirectingFileEntry(Name, FE.getExternalContentsPath(), FE.getUseName())))))); $c$.clean();
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::parseEntry">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1106,
   FQN="(anonymous namespace)::RedirectingFileSystemParser::parseEntry", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParser10parseEntryEPN4llvm4yaml4NodeEPNS_21RedirectingFileSystemE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParser10parseEntryEPN4llvm4yaml4NodeEPNS_21RedirectingFileSystemE")
  //</editor-fold>
  private std.unique_ptr<Entry> parseEntry(Node /*P*/ N, RedirectingFileSystem /*P*/ FS) {
    std.vector<std.unique_ptr<Entry> > EntryArrayContents = null;
    std.unique_ptr<Entry> Result = null;
    try {
      MappingNode /*P*/ M = dyn_cast(MappingNode.class, N);
      if (!(M != null)) {
        error(N, new Twine(/*KEEP_STR*/"expected mapping node for file or directory entry"));
        return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
      }
      
      std.pair<StringRef, RedirectingFileSystemParser.KeyStatus> Fields[/*5*/] = new std.pair [/*5*/] {
        new std.pair<StringRef, RedirectingFileSystemParser.KeyStatus>(new StringRef("name"), new KeyStatus(true)), 
        new std.pair<StringRef, RedirectingFileSystemParser.KeyStatus>(new StringRef("type"), new KeyStatus(true)), 
        new std.pair<StringRef, RedirectingFileSystemParser.KeyStatus>(new StringRef("contents"), new KeyStatus(false)), 
        new std.pair<StringRef, RedirectingFileSystemParser.KeyStatus>(new StringRef("external-contents"), new KeyStatus(false)), 
        new std.pair<StringRef, RedirectingFileSystemParser.KeyStatus>(new StringRef("use-external-name"), new KeyStatus(false))
      };
      
      DenseMap<StringRef, KeyStatus> Keys/*J*/= new DenseMap<StringRef, KeyStatus>(new DenseMapInfoStringRef(), std.begin(Fields), std.end(Fields), new KeyStatus());
      
      boolean HasContents = false; // external or otherwise
      EntryArrayContents/*J*/= new std.vector<std.unique_ptr<Entry> >(new std.unique_ptr<Entry>());
      std.string ExternalContentsPath/*J*/= new std.string();
      std.string Name/*J*/= new std.string();
      NameKind UseExternalName = RedirectingFileEntry.NameKind.NK_NotSet;
      EntryKind Kind = EntryKind.EK_Directory;// JAVA: should be Uninitialized?
      
      for (basic_collection_iterator<MappingNode, KeyValueNode> I = M.begin(), E = M.end(); I.$noteq(E);
           I.$preInc()) {
        StringRef Key/*J*/= new StringRef();
        // Reuse the buffer for key and value, since we don't look at key after
        // parsing value.
        SmallString/*256*/ Buffer/*J*/= new SmallString/*256*/(256);
        if (!parseScalarString(I.$arrow().getKey(), Key, Buffer)) {
          return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
        }
        if (!checkDuplicateOrUnknownKey(I.$arrow().getKey(), new StringRef(Key), Keys)) {
          return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
        }
        
        StringRef Value/*J*/= new StringRef();
        if ($eq_StringRef(/*NO_COPY*/Key, /*STRINGREF_STR*/"name")) {
          if (!parseScalarString(I.$arrow().getValue(), Value, Buffer)) {
            return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
          }
          if (FS.UseCanonicalizedPaths) {
            SmallString/*256*/ Path/*J*/= new SmallString/*256*/(256, new StringRef(Value));
            // Guarantee that old YAML files containing paths with ".." and "."
            // are properly canonicalized before read into the VFS.
            Path.$assign(path.remove_leading_dotslash(Path.$StringRef()));
            path.remove_dots(Path, /*remove_dot_dot=*/ true);
            Name.$assignMove(Path.str().$string());
          } else {
            Name.$assignMove(Value.$string());
          }
        } else if ($eq_StringRef(/*NO_COPY*/Key, /*STRINGREF_STR*/"type")) {
          if (!parseScalarString(I.$arrow().getValue(), Value, Buffer)) {
            return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
          }
          if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"file")) {
            Kind = EntryKind.EK_File;
          } else if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"directory")) {
            Kind = EntryKind.EK_Directory;
          } else {
            error(I.$arrow().getValue(), new Twine(/*KEEP_STR*/"unknown value for 'type'"));
            return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
          }
        } else if ($eq_StringRef(/*NO_COPY*/Key, /*STRINGREF_STR*/"contents")) {
          if (HasContents) {
            error(I.$arrow().getKey(), 
                new Twine(/*KEEP_STR*/"entry already has 'contents' or 'external-contents'"));
            return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
          }
          HasContents = true;
          SequenceNode /*P*/ Contents = dyn_cast(SequenceNode.class, I.$arrow().getValue());
          if (!(Contents != null)) {
            // FIXME: this is only for directories, what about files?
            error(I.$arrow().getValue(), new Twine(/*KEEP_STR*/"expected array"));
            return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
          }
          
          for (basic_collection_iterator<SequenceNode, Node> _I = Contents.begin(), 
              _E = Contents.end();
               _I.$noteq(_E); _I.$preInc()) {
            {
              std.unique_ptr<Entry> _Entry = null;
              try {
                _Entry = parseEntry($AddrOf(_I.$star()), FS);
                if (_Entry.$bool()) {
                  EntryArrayContents.push_back_T$RR(std.move(_Entry));
                } else {
                  return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
                }
              } finally {
                if (_Entry != null) { _Entry.$destroy(); }
              }
            }
          }
        } else if ($eq_StringRef(/*NO_COPY*/Key, /*STRINGREF_STR*/"external-contents")) {
          if (HasContents) {
            error(I.$arrow().getKey(), 
                new Twine(/*KEEP_STR*/"entry already has 'contents' or 'external-contents'"));
            return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
          }
          HasContents = true;
          if (!parseScalarString(I.$arrow().getValue(), Value, Buffer)) {
            return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
          }
          
          SmallString/*256*/ FullPath/*J*/= new SmallString/*256*/(256);
          if (FS.IsRelativeOverlay$Ref.$deref()) {
            FullPath.$assign(FS.getExternalContentsPrefixDir());
            assert (!FullPath.empty()) : "External contents prefix directory must exist";
            path.append(FullPath, new Twine(Value));
          } else {
            FullPath.$assign(/*NO_COPY*/Value);
          }
          if (FS.UseCanonicalizedPaths) {
            // Guarantee that old YAML files containing paths with ".." and "."
            // are properly canonicalized before read into the VFS.
            FullPath.$assign(path.remove_leading_dotslash(FullPath.$StringRef()));
            path.remove_dots(FullPath, /*remove_dot_dot=*/ true);
          }
          ExternalContentsPath.$assignMove(FullPath.str().$string());
        } else if ($eq_StringRef(/*NO_COPY*/Key, /*STRINGREF_STR*/"use-external-name")) {
          bool$ref Val = create_bool$ref();
          if (!parseScalarBool(I.$arrow().getValue(), Val)) {
            return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
          }
          UseExternalName = Val.$deref() ? RedirectingFileEntry.NameKind.NK_External : RedirectingFileEntry.NameKind.NK_Virtual;
        } else {
          throw new llvm_unreachable("key missing from Keys");
        }
      }
      if (Stream.failed()) {
        return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
      }
      
      // check for missing keys
      if (!HasContents) {
        error(N, new Twine(/*KEEP_STR*/"missing key 'contents' or 'external-contents'"));
        return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
      }
      if (!checkMissingKeys(N, Keys)) {
        return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
      }
      
      // check invalid configuration
      if (Kind == EntryKind.EK_Directory
         && UseExternalName != RedirectingFileEntry.NameKind.NK_NotSet) {
        error(N, new Twine(/*KEEP_STR*/"'use-external-name' is not supported for directories"));
        return new std.unique_ptr<Entry>(JD$NullPtr.INSTANCE, null);
      }
      
      // Remove trailing slash(es), being careful not to remove the root path
      StringRef Trimmed/*J*/= new StringRef(Name);
      /*size_t*/int RootPathLen = path.root_path(/*NO_COPY*/Trimmed).size();
      while ($greater_uint(Trimmed.size(), RootPathLen)
         && path.is_separator(Trimmed.back())) {
        Trimmed.$assignMove(Trimmed.slice(0, Trimmed.size() - 1));
      }
      // Get the last component
      StringRef LastComponent = path.filename(/*NO_COPY*/Trimmed);
      
      Result/*J*/= new std.unique_ptr<Entry>();
      switch (Kind) {
       case EK_File:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(Result.$assign$ConvertibleNotArray($c$.track(llvm.make_unique(new RedirectingFileEntry(LastComponent, new StringRef(std.move(ExternalContentsPath)), UseExternalName)))));
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case EK_Directory:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(Result.$assign$ConvertibleNotArray($c$.track(llvm.make_unique(new RedirectingDirectoryEntry(LastComponent, std.move(EntryArrayContents), 
                    new Status(new StringRef(/*KEEP_STR*/$EMPTY), getNextVirtualUniqueID(), TimeValue.now(), 0, 0, 0, 
                        file_type.directory_file, fs.perms.all_all))))));
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      StringRef Parent = path.parent_path(/*NO_COPY*/Trimmed);
      if (Parent.empty()) {
        return new std.unique_ptr<Entry>(JD$Move.INSTANCE, Result);
      }
      
      // if 'name' contains multiple components, create implicit directory entries
      for (path.reverse_iterator I = path.rbegin(/*NO_COPY*/Parent), 
          E = path.rend(/*NO_COPY*/Parent);
           I.$noteq(E); I.$preInc()) {
        std.vector<std.unique_ptr<Entry> > Entries = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          Entries/*J*/= new std.vector<std.unique_ptr<Entry> >(new std.unique_ptr<Entry>());
          Entries.push_back_T$RR(std.move(Result));
          $c$.clean(Result.$assign$ConvertibleNotArray($c$.track(llvm.make_unique(new RedirectingDirectoryEntry(I.$star(), std.move(Entries), 
                  new Status(new StringRef(/*KEEP_STR*/$EMPTY), getNextVirtualUniqueID(), TimeValue.now(), 0, 0, 0, 
                      file_type.directory_file, fs.perms.all_all))))));
        } finally {
          if (Entries != null) { Entries.$destroy(); }
          $c$.$destroy();
        }
      }
      return new std.unique_ptr<Entry>(JD$Move.INSTANCE, Result);
    } finally {
      if (Result != null) { Result.$destroy(); }
      if (EntryArrayContents != null) { EntryArrayContents.$destroy(); }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::RedirectingFileSystemParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1289,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1123,
   FQN="(anonymous namespace)::RedirectingFileSystemParser::RedirectingFileSystemParser", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParserC1ERN4llvm4yaml6StreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParserC1ERN4llvm4yaml6StreamE")
  //</editor-fold>
  public RedirectingFileSystemParser(Stream /*&*/ S) {
    /* : Stream(S)*/ 
    //START JInit
    this./*&*/Stream=/*&*/S;
    //END JInit
  }

  
  // false on error
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileSystemParser::parse">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1292,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1126,
   FQN="(anonymous namespace)::RedirectingFileSystemParser::parse", NM="_ZN12_GLOBAL__N_127RedirectingFileSystemParser5parseEPN4llvm4yaml4NodeEPNS_21RedirectingFileSystemE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_127RedirectingFileSystemParser5parseEPN4llvm4yaml4NodeEPNS_21RedirectingFileSystemE")
  //</editor-fold>
  public boolean parse(Node /*P*/ Root, RedirectingFileSystem /*P*/ FS) {
    std.vector<std.unique_ptr<Entry> > RootEntries = null;
    try {
      MappingNode /*P*/ Top = dyn_cast(MappingNode.class, Root);
      if (!(Top != null)) {
        error(Root, new Twine(/*KEEP_STR*/"expected mapping node"));
        return false;
      }
      
    std.pair<StringRef, RedirectingFileSystemParser.KeyStatus> Fields[/*4*/] = new std.pair [/*4*/] {
      new std.pair<StringRef, RedirectingFileSystemParser.KeyStatus>(new StringRef("version"), new KeyStatus(true)), 
      new std.pair<StringRef, RedirectingFileSystemParser.KeyStatus>(new StringRef("case-sensitive"), new KeyStatus(false)), 
      new std.pair<StringRef, RedirectingFileSystemParser.KeyStatus>(new StringRef("use-external-names"), new KeyStatus(false)), 
      new std.pair<StringRef, RedirectingFileSystemParser.KeyStatus>(new StringRef("overlay-relative"), new KeyStatus(false)), 
      new std.pair<StringRef, RedirectingFileSystemParser.KeyStatus>(new StringRef("roots"), new KeyStatus(true))
      };
      
      DenseMap<StringRef, KeyStatus> Keys/*J*/= new DenseMap<StringRef, KeyStatus>(new DenseMapInfoStringRef(), std.begin(Fields), std.end(Fields), new KeyStatus());
      RootEntries/*J*/= new std.vector<std.unique_ptr<Entry> >(new std.unique_ptr<Entry>());
      
      // Parse configuration and 'roots'
      for (basic_collection_iterator<MappingNode, KeyValueNode> I = Top.begin(), E = Top.end(); I.$noteq(E);
           I.$preInc()) {
        SmallString/*10*/ KeyBuffer/*J*/= new SmallString/*10*/(10);
        StringRef Key/*J*/= new StringRef();
        if (!parseScalarString(I.$arrow().getKey(), Key, KeyBuffer)) {
          return false;
        }
        if (!checkDuplicateOrUnknownKey(I.$arrow().getKey(), new StringRef(Key), Keys)) {
          return false;
        }
        if ($eq_StringRef(/*NO_COPY*/Key, /*STRINGREF_STR*/"roots")) {
          SequenceNode /*P*/ Roots = dyn_cast(SequenceNode.class, I.$arrow().getValue());
          if (!(Roots != null)) {
            error(I.$arrow().getValue(), new Twine(/*KEEP_STR*/"expected array"));
            return false;
          }
          
          for (basic_collection_iterator<SequenceNode, Node> _I = Roots.begin(), _E = Roots.end();
               _I.$noteq(_E); _I.$preInc()) {
            {
              std.unique_ptr<Entry> _Entry = null;
              try {
                _Entry = parseEntry($AddrOf(_I.$star()), FS);
                if (_Entry.$bool()) {
                  RootEntries.push_back_T$RR(std.move(_Entry));
                } else {
                  return false;
                }
              } finally {
                if (_Entry != null) { _Entry.$destroy(); }
              }
            }
          }
        } else if ($eq_StringRef(/*NO_COPY*/Key, /*STRINGREF_STR*/"version")) {
          StringRef VersionString/*J*/= new StringRef();
          SmallString/*4*/ Storage/*J*/= new SmallString/*4*/(4);
          if (!parseScalarString(I.$arrow().getValue(), VersionString, Storage)) {
            return false;
          }
        int$ref Version = create_int$ref();
          if (VersionString.getAsInteger$Signed(10, Version)) {
            error(I.$arrow().getValue(), new Twine(/*KEEP_STR*/"expected integer"));
            return false;
          }
          if (Version.$deref() < 0) {
            error(I.$arrow().getValue(), new Twine(/*KEEP_STR*/"invalid version number"));
            return false;
          }
          if (Version.$deref() != 0) {
            error(I.$arrow().getValue(), new Twine(/*KEEP_STR*/"version mismatch, expected 0"));
            return false;
          }
        } else if ($eq_StringRef(/*NO_COPY*/Key, /*STRINGREF_STR*/"case-sensitive")) {
          if (!parseScalarBool(I.$arrow().getValue(), FS.CaseSensitive$Ref)) {
            return false;
          }
        } else if ($eq_StringRef(/*NO_COPY*/Key, /*STRINGREF_STR*/"overlay-relative")) {
          if (!parseScalarBool(I.$arrow().getValue(), FS.IsRelativeOverlay$Ref)) {
            return false;
          }
        } else if ($eq_StringRef(/*NO_COPY*/Key, /*STRINGREF_STR*/"use-external-names")) {
          if (!parseScalarBool(I.$arrow().getValue(), FS.UseExternalNames$Ref)) {
            return false;
          }
        } else {
          throw new llvm_unreachable("key missing from Keys");
        }
      }
      if (Stream.failed()) {
        return false;
      }
      if (!checkMissingKeys(Top, Keys)) {
        return false;
      }
      
      // Now that we sucessefully parsed the YAML file, canonicalize the internal
      // representation to a proper directory tree so that we can search faster
      // inside the VFS.
      for (std.unique_ptr<Entry> /*&*/ E : RootEntries)  {
        uniqueOverlayTree(FS, E.get());
      }
      
      return true;
    } finally {
      if (RootEntries != null) { RootEntries.$destroy(); }
    }
  }

  
  public String toString() {
    return "" + "Stream=" + Stream; // NOI18N
  }
}
