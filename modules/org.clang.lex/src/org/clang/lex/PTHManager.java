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

package org.clang.lex;

import static org.clank.support.Native.$Deref;
import org.clang.lex.java.impl.PTHFileLookup;
import org.clang.lex.java.impl.PTHManagerSingleFile;
import org.clang.lex.java.impl.PTHStringIdLookup;
import org.clang.lex.java.PTHManagerDriver;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.lex.*;
import org.clang.lex.impl.*;
import static org.clang.lex.impl.PTHLexerStatics.*;
import org.clang.lex.impl.PTHStatCache;
import org.clank.java.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import org.clank.support.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.support.aligned;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;
import static org.llvm.support.llvm.support.unaligned;

//<editor-fold defaultstate="collapsed" desc="clang::PTHManager">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", line = 38,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", old_line = 37,
 FQN = "clang::PTHManager", NM = "_ZN5clang10PTHManagerE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManagerE")
//</editor-fold>
public class PTHManager extends NativeTrace.CreateDestroy$Tracker implements IdentifierInfoLookup, Destructors.ClassWithDestructor {
  /*friend  class PTHLexer*/;

 //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHStringLookupTrait">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", line = 43,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 369,
   FQN = "clang::PTHManager::PTHStringLookupTrait", NM = "_ZN5clang10PTHManager20PTHStringLookupTraitE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager20PTHStringLookupTraitE")
  //</editor-fold>
  public static final class PTHStringLookupTrait implements OnDiskChainedHashTable.InfoInterface</*const*/std.pairTypeInt</*const*/char$ptr/*char P*/>, /*const*/std.pairTypeInt</*const*/char$ptr/*char P*/>, Number> {
    
  /*public:*/
    /*typedef uint32_t data_type*/;
    /*typedef const std::pair<const char *, unsigned int> external_key_type*/
//    public final class external_key_type extends /*const*/std.pairTypeUInt</*const*/char$ptr/*char P*/>{ };
    /*typedef external_key_type internal_key_type*/
//    public final class internal_key_type extends /*const*/std.pairTypeUInt</*const*/char$ptr/*char P*/>{ };
    /*typedef uint32_t hash_value_type*/;
    /*typedef unsigned int offset_type*/;
    
    //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHStringLookupTrait::EqualKey">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 377,
     FQN = "clang::PTHManager::PTHStringLookupTrait::EqualKey", NM = "_ZN5clang10PTHManager20PTHStringLookupTrait8EqualKeyERKSt4pairIPKcjES7_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager20PTHStringLookupTrait8EqualKeyERKSt4pairIPKcjES7_")
    //</editor-fold>
    @Override public boolean EqualKey(/*const*/std.pairTypeInt</*const*/char$ptr/*char P*/>/*&*/ a, 
            /*const*/std.pairTypeInt</*const*/char$ptr/*char P*/>/*&*/ b) {
      return (a.second == b.second) ? memcmp(a.first, b.first, a.second) == 0 : false;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHStringLookupTrait::ComputeHash">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 383,
     FQN = "clang::PTHManager::PTHStringLookupTrait::ComputeHash", NM = "_ZN5clang10PTHManager20PTHStringLookupTrait11ComputeHashERKSt4pairIPKcjE",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager20PTHStringLookupTrait11ComputeHashERKSt4pairIPKcjE")
    //</editor-fold>
    @Override public /*uint32_t*/int ComputeHash(/*const*/std.pairTypeInt</*const*/char$ptr/*char P*/>/*&*/ a) {
      return llvm.HashString(a.first, a.second);
    }

    
    // This hopefully will just get inlined and removed by the optimizer.
    //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHStringLookupTrait::GetInternalKey">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 388,
     FQN = "clang::PTHManager::PTHStringLookupTrait::GetInternalKey", NM = "_ZN5clang10PTHManager20PTHStringLookupTrait14GetInternalKeyERKSt4pairIPKcjE",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager20PTHStringLookupTrait14GetInternalKeyERKSt4pairIPKcjE")
    //</editor-fold>
    @Override public /*const*/std.pairTypeInt</*const*/char$ptr/*char P*/>/*&*/ GetInternalKey(/*const*/std.pairTypeInt</*const*/char$ptr/*char P*/>/*&*/ x) {
      return x;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHStringLookupTrait::ReadKeyDataLength">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 391,
     FQN = "clang::PTHManager::PTHStringLookupTrait::ReadKeyDataLength", NM = "_ZN5clang10PTHManager20PTHStringLookupTrait17ReadKeyDataLengthERPKh",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager20PTHStringLookupTrait17ReadKeyDataLengthERPKh")
    //</editor-fold>
    @Override public /*std.pair<uint, uint>*/long ReadKeyDataLength(char$ptr/*const uchar P&*/ d, int OffsetInBuf) {
      //JAVA: using namespace llvm::support;
      // Key-Length is written, Data-Length is always 4 bytes for UINT
      return wrap_int_int_pair(endian.read_uint16(endianness.little, unaligned, d, OffsetInBuf), 
          sizeof$uint32());
    }

    @Override
    public /*uint*/int getReadKeyDataLengthBytes() {
      return sizeof$uint16();
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHStringLookupTrait::ReadKey">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 399,
     FQN = "clang::PTHManager::PTHStringLookupTrait::ReadKey", NM = "_ZN5clang10PTHManager20PTHStringLookupTrait7ReadKeyEPKhj",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager20PTHStringLookupTrait7ReadKeyEPKhj")
    //</editor-fold>
    @Override public std.pairTypeInt</*const*/char$ptr/*char P*/> ReadKey(/*const*/char$ptr/*uchar P*/ d, int OffsetInBuf, /*uint*/int n) {
      assert (n >= 2 && d.$at(OffsetInBuf + n - 1) == '\0') : "n="+n +";"+d.$add(OffsetInBuf);
      return $getKey(d.$array(), d.$index()+OffsetInBuf, n-1);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHStringLookupTrait::ReadData">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 405,
     FQN = "clang::PTHManager::PTHStringLookupTrait::ReadData", NM = "_ZN5clang10PTHManager20PTHStringLookupTrait8ReadDataERKSt4pairIPKcjEPKhj",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager20PTHStringLookupTrait8ReadDataERKSt4pairIPKcjEPKhj")
    //</editor-fold>
    @Override public Number/*uint32_t*/ ReadData(/*const*/std.pairTypeInt</*const*/char$ptr/*char P*/>/*&*/ k, /*const*/char$ptr/*uchar P*/ d,
            int OffsetInBuf, /*uint*/int $Prm2) {
      //JAVA: using namespace llvm::support;
      return $Value.setValue(endian.read_uint32(endianness.little, unaligned, d, OffsetInBuf));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHStringLookupTrait::PTHStringLookupTrait">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 369,
     FQN = "clang::PTHManager::PTHStringLookupTrait::PTHStringLookupTrait", NM = "_ZN5clang10PTHManager20PTHStringLookupTraitC1ERKS1_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager20PTHStringLookupTraitC1ERKS1_")
    //</editor-fold>
    public /*inline*/ PTHStringLookupTrait(/*const*/ PTHStringLookupTrait /*&*/ $Prm0) {
    }

    // JAVA: default constructor
    public PTHStringLookupTrait() {
    }
    // Reusable Value and Key
    private final MutableInteger $Value = new MutableInteger(0);
    
    
    private boolean $KeyInUse = false;
    private final std.pairTypeInt</*const*/char$ptr/*char P*/> $Key = new std.pairTypeInt</*const*/char$ptr/*char P*/>(create_reusable_char$ptr(), 0);
    private std.pairTypeInt</*const*/char$ptr/*char P*/> $getKey(byte[] firstArray, int firstArrayIndex, /*uint*/int second) {
      assert (!$KeyInUse) && ($KeyInUse = true);
      assert $Key.first != null;
      assert $Key.first.$array() == null || $Key.first.$array() == firstArray : "Different buffer?";
      Native.$setArrayAndIndex($Key.first, firstArray, firstArrayIndex);
      $Key.second = second;
      return $Key;
    }
    public void $releaseKey(std.pairTypeInt</*const*/char$ptr/*char P*/> Key) {
      assert Key == $Key;
      assert $KeyInUse;
      assert ($KeyInUse = false) || true;
    }
    
    @Override
    public pairTypeInt<char$ptr> GetExternalKey(pairTypeInt<char$ptr> x) {
      throw new UnsupportedOperationException("Must Not Be called for this class");
    }
    
    public String toString() {
      return ""; // NOI18N
    }
 };
  
  /// The memory mapped PTH file.
  protected final MemoryBuffer Buf;
  
  /// Alloc - Allocator used for IdentifierInfo objects.
  private final BumpPtrAllocator Alloc;
  
  /// IdMap - A lazily generated cache mapping from persistent identifiers to
  ///  IdentifierInfo*.
//  private final std.unique_ptr_with_deleter<IdentifierInfo /*P*/ [] /*, FreeDeleter*/> PerIDCache;
  protected final IdentifierInfo /*P*/ [] PerIDCache; // JAVA: own pointer

  /// FileLookup - Abstract data structure used for mapping between files
  ///  and token data in the PTH file.
  private final PTHFileLookup FileLookup;
  
  /// IdDataTable - Array representing the mapping from persistent IDs to the
  ///  data offset within the PTH file containing the information to
  ///  reconsitute an IdentifierInfo.
  protected final /*const*/char$ptr/*uchar P*//*const*/ IdDataTable;
  
  /// SortedIdTable - Abstract data structure mapping from strings to
  ///  persistent IDs.  This is used by get().
  private final PTHStringIdLookup StringIdLookup;
  
  /// NumIds - The number of identifiers in the PTH file.
  private final /*const*//*uint*/int NumIds;
  
  /// PP - The Preprocessor object that will use this PTHManager to create
  ///  PTHLexer objects.
  protected Preprocessor /*P*/ PP;
  
  /// SpellingBase - The base offset within the PTH memory buffer that
  ///  contains the cached spellings for literals.
  protected final /*const*/char$ptr/*uchar P*//*const*/ SpellingBase;
  
  /// OriginalSourceFile - A null-terminated C-string that specifies the name
  ///  if the file (if any) that was to used to generate the PTH cache.
  private final /*const*/char$ptr/*char P*/ OriginalSourceFile;
  
  /// This constructor is intended to only be called by the static 'Create'
  /// method.
  
  //===----------------------------------------------------------------------===//
  // PTHManager methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHManager">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 416,
   FQN = "clang::PTHManager::PTHManager", NM = "_ZN5clang10PTHManagerC1ESt10unique_ptrIKN4llvm12MemoryBufferESt14default_deleteIS4_EES1_INS2_22OnDiskChainedHashTableINS0_18PTHFileLookupTraitEEES5_ISA_EEPKhS1_IA_PNS_14IdentifierInfoENS2_11FreeDeleterEES1_INS8_INS0_20PTHStringLookupTraitEEES5_ISL_EEjSE_PKc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManagerC1ESt10unique_ptrIKN4llvm12MemoryBufferESt14default_deleteIS4_EES1_INS2_22OnDiskChainedHashTableINS0_18PTHFileLookupTraitEEES5_ISA_EEPKhS1_IA_PNS_14IdentifierInfoENS2_11FreeDeleterEES1_INS8_INS0_20PTHStringLookupTraitEEES5_ISL_EEjSE_PKc")
  //</editor-fold>
  protected PTHManager(/*const*/ MemoryBuffer buf, 
      PTHFileLookup fileLookup, /*const*/char$ptr/*uchar P*/ idDataTable, 
      IdentifierInfo /*P*/ [] perIDCache, 
      PTHStringIdLookup stringIdLookup, /*uint*/int numIds, 
      /*const*/char$ptr/*uchar P*/ spellingBase, /*const*/char$ptr/*char P*/ originalSourceFile) {
    /* : IdentifierInfoLookup(), Buf(std::move(buf)), Alloc(), PerIDCache(std::move(perIDCache)), FileLookup(std::move(fileLookup)), IdDataTable(idDataTable), StringIdLookup(std::move(stringIdLookup)), NumIds(numIds), PP(null), SpellingBase(spellingBase), OriginalSourceFile(originalSourceFile)*/ 
    //START JInit
    super();
    this.Buf = buf;
    this.Alloc = new BumpPtrAllocator();
    this.PerIDCache = perIDCache;
    this.FileLookup = fileLookup;
    this.IdDataTable = $toConst(idDataTable);
    this.StringIdLookup = stringIdLookup;
    this.NumIds = numIds;
    this.PP = null;
    this.SpellingBase = $toConst(spellingBase);
    this.OriginalSourceFile = $toConst(originalSourceFile);
    //END JInit
  }

  protected PTHManager() {
    // JAVA: special entry point for Java's PTHManagerDriver
    assert this.getClass() == PTHManagerDriver.class : "this is the special entry point for PTHManagerDriver "
            + "which is the special PTHManager allowed to be created without the real PTH token-cache file";
    this.Buf = null;
    this.Alloc = null;
    this.PerIDCache = null;
    this.FileLookup = null;
    this.IdDataTable = null;
    this.StringIdLookup = null;
    this.NumIds = -1;
    this.SpellingBase = null;
    this.OriginalSourceFile = null;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", line = 95,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", old_line = 94,
   FQN="clang::PTHManager::PTHManager", NM="_ZN5clang10PTHManagerC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang10PTHManagerC1ERKS0_")
  //</editor-fold>
  private PTHManager(/*const*/ PTHManager /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", line = 96,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", old_line = 95,
   FQN="clang::PTHManager::operator=", NM="_ZN5clang10PTHManageraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPLexerChange.cpp -nm=_ZN5clang10PTHManageraSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ PTHManager /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  /// getSpellingAtPTHOffset - Used by PTHLexer classes to get the cached
  ///  spelling for a token.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::getSpellingAtPTHOffset">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", line = 100,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", old_line = 99,
   FQN = "clang::PTHManager::getSpellingAtPTHOffset", NM = "_ZN5clang10PTHManager22getSpellingAtPTHOffsetEjRPKc",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager22getSpellingAtPTHOffsetEjRPKc")
  //</editor-fold>
  private /*uint*/int getSpellingAtPTHOffset(/*uint*/int PTHOffset, /*const*/type$ref<char$ptr>/*char P&*/ Buffer) {
    throw new UnsupportedOperationException("getSpellingAtPTHOffset doesn't have implementation");
  }

  
  /// GetIdentifierInfo - Used to reconstruct IdentifierInfo objects from the
  ///  PTH file.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::GetIdentifierInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", line = 104,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", old_line = 103,
   FQN = "clang::PTHManager::GetIdentifierInfo", NM = "_ZN5clang10PTHManager17GetIdentifierInfoEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager17GetIdentifierInfoEj")
  //</editor-fold>
  /*friend*/public /*private*/ /*inline*/ IdentifierInfo /*P*/ GetIdentifierInfo(/*uint*/int PersistentID) {
    {
      // Check if the IdentifierInfo has already been resolved.
      IdentifierInfo /*P*/ II = PerIDCache[(int)PersistentID];
      if ((II != null)) {
        return II;
      }
    }
    return LazilyCreateIdentifierInfo(PersistentID);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::LazilyCreateIdentifierInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 559,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 560,
   FQN = "clang::PTHManager::LazilyCreateIdentifierInfo", NM = "_ZN5clang10PTHManager26LazilyCreateIdentifierInfoEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager26LazilyCreateIdentifierInfoEj")
  //</editor-fold>
  private IdentifierInfo /*P*/ LazilyCreateIdentifierInfo(/*uint*/int PersistentID) {
    // Look in the PTH file for the string data for the IdentifierInfo object.
    /*const*/int/*uchar P*/ TableEntry = /*IdDataTable.$add*/(sizeof$uint32() * PersistentID);
    /*const*/char$ptr/*uchar P*/ IDData = 
            Buf.getBufferStart().$add(endian.read_uint32(endianness.little, aligned, IdDataTable, TableEntry));
                                             // PERF: TableEntry += sizeof$uint32();//shift index
    assert (IDData.$less(Buf.getBufferEnd())) : IDData.$index() + " vs. " + Buf.getBufferEnd().$index();
    
    // Allocate the object.
//    std.pair<IdentifierInfo, /*const*/char$ptr/*uchar P*/ > /*P*/ Mem = $tryClone((std.pair<IdentifierInfo, /*const*/char$ptr/*uchar P*/ > )Alloc.Allocate(std.pair.class));

    // JAVA: in native here is sequential memory of IdentifierInfo followed by pointer to the IDData
    // JAVA: then IdentifierInfo casts itself to pair and do magic in getLength and getNameStart
//    std.pair<IdentifierInfo, /*const*/char$ptr/*uchar P*/ > /*P*/ Mem = new std.pair<IdentifierInfo, /*const*/char$ptr/*uchar P*/ >();
    
//    Mem.second = $tryClone(IDData);
    assert (IDData.$at(0) != '\0');
    // JAVA: help with IdentifierInfo approach used inside getLength and getNameStart
    // JAVA: len is kept in previous two bytes according to PTHIdentifierTableTrait.EmitKeyDataLength
    // PERF: reuse IDData
//    /*const*/char$ptr/*char P*/ p = IDData.$sub(2);
//    int Len = ($char(IDData.$at(0)) | ($char(p.$at(1)) << 8)) - 1;
    assert IDData.$index() >= 2 : "must have two bytes prefix with len " + IDData.$index();
    int Len = ($char(IDData.$at(-2)) | ($char(IDData.$at(-1)) << 8)) - 1;
    // JAVA: complete creation of Java version which reuses Entry-based IdentifierInfo implementation
    assert strlen(IDData) == Len : "check wasn't here, but could it be non null-termed string?" + Len + " vs. " + IDData;
    IdentifierInfo /*P*/ II = /*FIXME:*/new /*((void *)Mem)*/ IdentifierInfo(IDData, Len);
    II.$completeJavaPTHCreation();
    // JAVA: check correctness
    assert II.getLength() == Len : Len + " vs. " + II.getLength();
    assert memcmp(IDData, II.getNameStart(), Len) == 0 : "IDData:" + IDData + " \nvs.\nName:" + II.getNameStart();
    
    // Store the new IdentifierInfo in the cache.
    PerIDCache[(int)PersistentID] = II;
    assert ((II.getNameStart() != null) && II.getNameStart().$at(0) != '\0');
    return II;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHFileLookupTrait">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", line = 44,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 346,
   FQN = "clang::PTHManager::PTHFileLookupTrait", NM = "_ZN5clang10PTHManager18PTHFileLookupTraitE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager18PTHFileLookupTraitE")
  //</editor-fold>
  public static final class PTHFileLookupTrait extends /*public*/ PTHFileLookupCommonTrait<FileEntry, PTHFileData> {
  /*public:*/
    /*typedef const FileEntry *external_key_type*/
  //  public final class external_key_type extends /*const*/ FileEntry /*P*/ { };
    /*typedef PTHFileData data_type*/
  //  public final class data_type extends PTHFileData{ };

    //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHFileLookupTrait::GetInternalKey">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 351,
     FQN = "clang::PTHManager::PTHFileLookupTrait::GetInternalKey", NM = "_ZN5clang10PTHManager18PTHFileLookupTrait14GetInternalKeyEPKNS_9FileEntryE",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager18PTHFileLookupTrait14GetInternalKeyEPKNS_9FileEntryE")
    //</editor-fold>
    @Override public std.pairUCharType</*const*/char$ptr/*char P*/ > GetInternalKey(/*const*/ FileEntry /*P*/ FE) {
      $IKey.first = (/*uchar*/byte)0x1;
      $IKey.second = FE.getName();
      return $IKey;
    }
    private final std.pairUCharType<char$ptr> $IKey = new std.pairUCharType<char$ptr>((byte)0xFF, null);

    //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHFileLookupTrait::EqualKey">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 355,
     FQN = "clang::PTHManager::PTHFileLookupTrait::EqualKey", NM = "_ZN5clang10PTHManager18PTHFileLookupTrait8EqualKeyESt4pairIhPKcES5_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager18PTHFileLookupTrait8EqualKeyESt4pairIhPKcES5_")
    //</editor-fold>
    @Override public boolean EqualKey(std.pairUCharType</*const*/char$ptr/*char P*/ > a, std.pairUCharType</*const*/char$ptr/*char P*/ > b) {
      return a.first == b.first && strcmp(a.second, b.second) == 0;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHFileLookupTrait::ReadData">
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 359,
     FQN = "clang::PTHManager::PTHFileLookupTrait::ReadData", NM = "_ZN5clang10PTHManager18PTHFileLookupTrait8ReadDataERKSt4pairIhPKcEPKhj",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager18PTHFileLookupTrait8ReadDataERKSt4pairIhPKcEPKhj")
    //</editor-fold>
    @Override public PTHFileData ReadData(/*const*/std.pairUCharType</*const*/char$ptr/*char P*/ >/*&*/ k, 
            /*const*/char$ptr/*uchar P*/ d, int OffsetInBuf, /*uint*/int $Prm2) {
      assert (k.first == 0x1) : "Only file lookups can match!";
      //JAVA: using namespace llvm::support;
      int/*uint32_t*/ x = endian.read_uint32(endianness.little, unaligned, d, OffsetInBuf);
                                OffsetInBuf+=sizeof$uint32(); // shift index
      int/*uint32_t*/ y = endian.read_uint32(endianness.little, unaligned, d, OffsetInBuf);
                                // PERF: OffsetInBuf+=sizeof$uint32(); // shift index
      return new PTHFileData(x, y);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::PTHFileLookupTrait::PTHFileLookupTrait">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 346,
     FQN = "clang::PTHManager::PTHFileLookupTrait::PTHFileLookupTrait", NM = "_ZN5clang10PTHManager18PTHFileLookupTraitC1ERKS1_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager18PTHFileLookupTraitC1ERKS1_")
    //</editor-fold>
    public /*inline*/ PTHFileLookupTrait(/*const*/ PTHFileLookupTrait /*&*/ $Prm0) {
      /* : PTHFileLookupCommonTrait()*/ 
      //START JInit
      super($Prm0);
      //END JInit
    }

    // JAVA: default constructor
    public PTHFileLookupTrait() {
      super();
    }

    @Override
    public FileEntry GetExternalKey(pairUCharType<char$ptr> x) {
      throw new UnsupportedOperationException("Must Not Be called for this class.");
    }

    public String toString() {
      return "" + super.toString(); // NOI18N
    }
  }

/*public:*/
  // The current PTH version.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", line = 114,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", old_line = 113,
   FQN = "clang::PTHManager::(anonymous)", NM = "_ZN5clang10PTHManagerE_Unnamed_enum",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManagerE_Unnamed_enum")
  //</editor-fold>
  public static final class Unnamed_enum {
  /*enum ANONYMOUS_HEX_CONSTANTS {*/
    public static final int Version = 10;
  /*}*/;
  };
  
  // JAVA: prepare for reuse
  private boolean resetOnDesroyForSharedPTHManager;
  
  public MemoryBuffer $markShared(boolean shared) {
    checkAlive();
    this.resetOnDesroyForSharedPTHManager = shared;
    return this.Buf;
  }
  public boolean $isShared() {
    return this.resetOnDesroyForSharedPTHManager;
  }
  public MemoryBuffer $getTokenCache() {
    return this.Buf;
  }
  
  private static final boolean CLEAR_SHARED_PTH_IDENTIFIERS = Boolean.parseBoolean(System.getProperty("clank.clear.pth.identifier", "false"));
  @SuppressWarnings("AssertWithSideEffects")
  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::~PTHManager">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 427,
   FQN = "clang::PTHManager::~PTHManager", NM = "_ZN5clang10PTHManagerD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManagerD0Ev")
  //</editor-fold>
  @Override public void $destroy() {
    // JAVA: reset instead of destroy for shared PTHManager 
    checkAlive();
    assert PP != null : "destory unused?";
    if (resetOnDesroyForSharedPTHManager) {
      // do not destroy
      $release();
      return;
    }
    //START JDestroy
    Native.destroy(StringIdLookup);
    Native.destroy(FileLookup);
    Native.destroy(PerIDCache);
    assert (Buf == null) == (Alloc == null) : "must be both null or non-null " + Buf + " vs. " + Alloc;
    if (Buf != null) {
      Alloc.$destroy();
      Buf.$destroy();
    }
    /*super.$destroy();*/
    //END JDestroy
    set$destroyed();
  }

  protected void $release() {
    PP = null;
    if (PerIDCache != null) {
      IdentifierInfo[] cache = PerIDCache;
      if (cache != null) {
        for (int i = 0; i < cache.length; i++) {
          if (CLEAR_SHARED_PTH_IDENTIFIERS) {
            cache[i] = null;
          } else {
            IdentifierInfo II = cache[i];
            if (II != null) {
              StringMapImpl.resetStringMapEntryToInitialState(II);
            }
          }
        }
      }
    }
  }

  /// getOriginalSourceFile - Return the full path to the original header
  ///  file name that was used to generate the PTH cache.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::getOriginalSourceFile">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", line = 120,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", old_line = 119,
   FQN = "clang::PTHManager::getOriginalSourceFile", NM = "_ZNK5clang10PTHManager21getOriginalSourceFileEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZNK5clang10PTHManager21getOriginalSourceFileEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getOriginalSourceFile() /*const*/ {
    return OriginalSourceFile;
  }

  
  /// get - Return the identifier token info for the specified named identifier.
  ///  Unlike the version in IdentifierTable, this returns a pointer instead
  ///  of a reference.  If the pointer is NULL then the IdentifierInfo cannot
  ///  be found.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::get">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 582,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 583,
   FQN = "clang::PTHManager::get", NM = "_ZN5clang10PTHManager3getEN4llvm9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager3getEN4llvm9StringRefE")
  //</editor-fold>
  @Override public IdentifierInfo /*P*/ get(char$ptr Name, int Len)/* override*/ {
    if (Native.$is_array_based(Name)) {
      if (NativeTrace.isDebugMode()) NativeTrace.assertTrueInConsole(false, "use get(byte[],...) version directly if possible");
      return get(Name.$array(), Name.$index(), Len);
    }
    if (false) NativeTrace.assertTrueInConsole(false, "using slow get(char$ptr[],...) version for " + Name.getClass());
    // Double check our assumption that the last character isn't '\0'.
    assert (Len == 0 || Name.$at(Len-1) != '\0');
    Number I = StringIdLookup.get(Name, Len);
    if (I == null) {
      // No identifier found?
      return null;
    }
    Number Data = I;

    // Match found.  Return the identifier!
    assert (Data.intValue() > 0);
    return GetIdentifierInfo(Data.intValue() - 1);
  }
  @Override public IdentifierInfo /*P*/ get(byte[] Name, int NameStIndex, int Len)/* override*/ {
    // Double check our assumption that the last character isn't '\0'.
    assert (Len == 0 || Name[NameStIndex + Len -1] != '\0');
    Number I = StringIdLookup.get(Name, NameStIndex, Len);
    if (I == null) {
      // No identifier found?
      return null;
    }
    Number Data = I;

    // Match found.  Return the identifier!
    assert (Data.intValue() > 0);
    return GetIdentifierInfo(Data.intValue() - 1);
  }

  // JAVA: entry point to request MemoryBuffer creation for token-cache PTH file
  public static ErrorOr<std_ptr.unique_ptr<MemoryBuffer>> CreateMemoryBuffer(string TokenCacheFilePath) {
    // Memory map the PTH file.
    return MemoryBuffer.getFile(new Twine(TokenCacheFilePath));
  }
          
  /// Create - This method creates PTHManager objects.  The 'file' argument
  ///  is the name of the PTH file.  This method returns NULL upon failure.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, optimized = Converted.Optimization.COMPLEX,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 434,
   FQN="clang::PTHManager::Create", NM="_ZN5clang10PTHManager6CreateEN4llvm9StringRefERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager6CreateEN4llvm9StringRefERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public static PTHManager /*P*/ Create(StringRef file, DiagnosticsEngine /*&*/ Diags) {
    return Create(file.$string(), Diags);
  }
  public static PTHManager /*P*/ Create(/*const*/std.string/*&*/ file, 
        DiagnosticsEngine /*&*/ Diags) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ErrorOr<std.unique_ptr<MemoryBuffer> > FileOrErr = CreateMemoryBuffer(file);
      if (!FileOrErr.$bool()) {
        // FIXME: Add ec.message() to this diag.
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_invalid_pth_file)), new StringRef(file)));
        return null;
      }
      MemoryBuffer File = FileOrErr.get().release();
      return Create(File, Diags);
    } finally {
      $c$.$destroy();
    }    
  }
  public static PTHManager /*P*/ Create(/*const*/MemoryBuffer File, 
        DiagnosticsEngine /*&*/ Diags) {
    return CreatePTHManagerImpl(File, Diags, null);
  }
  protected static PTHManager /*P*/ CreatePTHManagerImpl(/*const*/MemoryBuffer File, 
        DiagnosticsEngine /*&*/ Diags, PTHManagerDriver ParentPTHManager) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      //JAVA: using namespace llvm::support;
      char$ptr file = File.getBufferIdentifier();
      // Get the buffer ranges and check if there are at least three 32-bit
      // words at the end of the file.
      /*const*/char$ptr/*uchar P*/ BufBeg = $toConst(File.getBufferStart());
      /*const*/char$ptr/*uchar P*/ BufEnd = $toConst(File.getBufferEnd());

      // Check the prologue of the file.
      if ((BufEnd.$sub(BufBeg)) < (int)(SIZEOF_CFE_PTH + 4 + 4)
         || memcmp(BufBeg, $cfe_pth, SIZEOF_CFE_PTH) != 0) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_invalid_pth_file)), new StringRef(file)));
        return null;
      }

      // Read the PTH version.
      /*const*/char$ptr/*uchar P*/ p = BufBeg.$add((SIZEOF_CFE_PTH));
      /*uint*/int Version = endian.readNext_uint32(endianness.little, aligned, p);
      if (Version < PTHManager.Unnamed_enum.Version) {
        InvalidPTH(Diags, 
            Version < PTHManager.Unnamed_enum.Version ? $("PTH file uses an older PTH format that is no longer supported") : $("PTH file uses a newer PTH format that cannot be read"));
        return null;
      }

      // Compute the address of the index table at the end of the PTH file.
      /*const*/char$ptr/*uchar P*/ PrologueOffset = $noClone(p);//PERF reuse p 
      if (PrologueOffset.$greatereq(BufEnd)) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_invalid_pth_file)), new StringRef(file)));
        return null;
      }

      // Construct the file lookup table.  This will be used for mapping from
      // FileEntry*'s to cached tokens.
      /*const*/int/*uchar P*/ FileTableOffset = /*PrologueOffset.$add*/(sizeof$uint32() * 2);
      /*const*/char$ptr/*uchar P*/ FileTable = BufBeg.$add(endian.read_uint32(endianness.little, aligned, PrologueOffset, FileTableOffset));
                                                                  // PERF: FileTableOffset += sizeof$uint32(); // shift index
      if (!(FileTable.$greater(BufBeg) && FileTable.$less(BufEnd))) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_invalid_pth_file)), new StringRef(file)));
        return null; // FIXME: Proper error diagnostic?
      }

      PTHFileLookup FL/*J*/= PTHFileLookup.CreatePTHFileLookup($noClone(FileTable), $noClone(BufBeg), new PTHFileLookupTrait());

      // Warn if the PTH file is empty.  We still want to create a PTHManager
      // as the PTH could be used with -include-pth.
      if (FL.isEmpty()) {
        InvalidPTH(Diags, $("PTH file contains no cached source data"));
      }

      // Get the location of the table mapping from persistent ids to the
      // data needed to reconstruct identifiers.
      /*const*/int/*uchar P*/ IDTableOffset = /*PrologueOffset.$add*/(sizeof$uint32() * 0);
      /*const*/char$ptr/*uchar P*/ IData = BufBeg.$add(endian.read_uint32(endianness.little, aligned, PrologueOffset, IDTableOffset));
                                                              // PERF: IDTableOffset += sizeof$uint32(); // shift index
      if (!(IData.$greatereq(BufBeg) && IData.$less(BufEnd))) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_invalid_pth_file)), new StringRef(file)));
        return null;
      }

      // Get the location of the hashtable mapping between strings and
      // persistent IDs.
      /*const*/int/*uchar P*/ StringIdTableOffset = /*PrologueOffset.$add*/(sizeof$uint32() * 1);
      /*const*/char$ptr/*uchar P*/ StringIdTable = BufBeg.$add(endian.read_uint32(endianness.little, aligned, PrologueOffset, StringIdTableOffset));
                                                                      // PERF: StringIdTableOffset += sizeof$uint32(); // shift index
      if (!(StringIdTable.$greatereq(BufBeg) && StringIdTable.$less(BufEnd))) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_invalid_pth_file)), new StringRef(file)));
        return null;
      }

      PTHStringIdLookup SL/*J*/= PTHStringIdLookup.CreatePTHStringIdLookup($noClone(StringIdTable), $noClone(BufBeg), new PTHStringLookupTrait());

      // Get the location of the spelling cache.
      /*const*/int/*uchar P*/ spellingBaseOffset = /*PrologueOffset.$add*/(sizeof$uint32() * 3);
      /*const*/char$ptr/*uchar P*/ spellingBase = BufBeg.$add(endian.read_uint32(endianness.little, aligned, PrologueOffset, spellingBaseOffset));
                                                                      // PERF: spellingBaseOffset += sizeof$uint32(); // shift index
      if (!(spellingBase.$greatereq(BufBeg) && spellingBase.$less(BufEnd))) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_invalid_pth_file)), new StringRef(file)));
        return null;
      }

      // Get the number of IdentifierInfos and pre-allocate the identifier cache.
      int/*uint32_t*/ NumIds = endian.readNext_uint32(endianness.little, aligned, IData);

      // Pre-allocate the persistent ID -> IdentifierInfo* cache.  We use calloc()
      // so that we in the best case only zero out memory once when the OS returns
      // us new pages.
      IdentifierInfo /*P*/ [] PerIDCache/*J*/= null;
      if ((NumIds != 0)) {
//        PerIDCache.reset((IdentifierInfo[] )calloc(NumIds, sizeof (PerIDCache.$star()[0])).$array());
        PerIDCache = new IdentifierInfo[NumIds];
        if (!(PerIDCache != null)) {
          InvalidPTH(Diags, $("Could not allocate memory for processing PTH file"));
          return null;
        }
      }

      // Compute the address of the original source file.
      /*const*/char$ptr/*uchar P*/ originalSourceBase = PrologueOffset.$add(sizeof$uint32() * 4);
      /*uint*/char len = endian.readNext_uint16(endianness.little, unaligned, originalSourceBase);
      if (!(len != 0)) {
        originalSourceBase = null;
      }

      // Create the new PTHManager.
      if (ParentPTHManager != null) {
        return new PTHManagerSingleFile(ParentPTHManager, File, FL, $noClone(IData), 
            PerIDCache, SL, NumIds, 
            $noClone(spellingBase), $noClone(originalSourceBase));
      } else {
        return new PTHManager(File, FL, $noClone(IData), 
            PerIDCache, SL, NumIds, 
            $noClone(spellingBase), $noClone(originalSourceBase));
      }
    } finally {
      $c$.$destroy();
    }
  }
  private static final int SIZEOF_CFE_PTH = strlen($cfe_pth)+1/*TERM*/;
  static {
    assert SIZEOF_CFE_PTH == sizeof$str("cfe-pth");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::setPreprocessor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", line = 134,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PTHManager.h", old_line = 133,
   FQN = "clang::PTHManager::setPreprocessor", NM = "_ZN5clang10PTHManager15setPreprocessorEPNS_12PreprocessorE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager15setPreprocessorEPNS_12PreprocessorE")
  //</editor-fold>
  public void setPreprocessor(Preprocessor /*P*/ pp) {
    assert PP == null : "forgot to release shared PTHManager?" + this.resetOnDesroyForSharedPTHManager + "\n" + PP;
    PP = pp;
  }

  
  /// CreateLexer - Return a PTHLexer that "lexes" the cached tokens for the
  ///  specified file.  This method returns NULL if no cached tokens exist.
  ///  It is the responsibility of the caller to 'delete' the returned object.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::CreateLexer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, 
   optimized = Converted.Optimization.VALUE_TYPE,       
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 595,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 596,
   FQN = "clang::PTHManager::CreateLexer", NM = "_ZN5clang10PTHManager11CreateLexerENS_6FileIDE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager11CreateLexerENS_6FileIDE")
  //</editor-fold>
  public final PTHLexer /*P*/ CreateLexer(FileID FID) {
    return CreateLexer(FID.$ID());
  }
  public PTHLexer /*P*/ CreateLexer(int FID) {
    /*const*/ FileEntry /*P*/ FE = PP.getSourceManager().getFileEntryForID(FID);
    if (!(FE != null)) {
      return null;
    }

    //JAVA: using namespace llvm::support;

    // Lookup the FileEntry object in our file lookup data structure.  It will
    // return a variant that indicates whether or not there is an offset within
    // the PTH file that contains cached tokens.
    PTHFileData I = FileLookup.$get(FE);
    if (I == null) {
      // No tokens available?
      return null;
    }

    /*const*/ PTHFileData /*&*/ FileData = I;

    /*const*/char$ptr/*uchar P*/ BufStart = $noClone(Buf.getBufferStart());
    // Compute the offset of the token data within the buffer.
    /*const*/char$ptr/*uchar P*/ data = BufStart.$add(FileData.getTokenOffset());

    // Get the location of pp-conditional table.
    int ppCondOffset = FileData.getPPCondOffset();
    int/*uint32_t*/ Len = endian.read_uint32(endianness.little, aligned, BufStart, ppCondOffset);
                                ppCondOffset += sizeof$uint32(); // shift index
    /*const*/char$ptr/*uchar P*/ ppcond;
    if (Len == 0) {
      ppcond = null;
    } else {
      ppcond = BufStart.$add(ppCondOffset);
    }
    assert ((PP != null)) : "No preprocessor set yet!";
    return new PTHLexer($Deref(PP), FID, $noClone(data), $noClone(ppcond), /*Deref*/this);
  }

  
  /// createStatCache - Returns a FileSystemStatCache object for use with
  ///  FileManager objects.  These objects use the PTH data to speed up
  ///  calls to stat by memoizing their results from when the PTH file
  ///  was generated.
  //<editor-fold defaultstate="collapsed" desc="clang::PTHManager::createStatCache">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", line = 726,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp", old_line = 727,
   FQN = "clang::PTHManager::createStatCache", NM = "_ZN5clang10PTHManager15createStatCacheEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PTHLexer.cpp -nm=_ZN5clang10PTHManager15createStatCacheEv")
  //</editor-fold>
  public std.unique_ptr<FileSystemStatCache> createStatCache() {
    return new std.unique_ptr<FileSystemStatCache>(new PTHStatCache(FileLookup));
  }

  private void checkAlive() {
    check$Alive();
  }

  @Override
  public String toString() {
    return "{" + "NumIds=" + NumIds + 
            ", OriginalSourceFile=" + OriginalSourceFile + 
            ",\nsuppressDesroyOfSharedPTHManager=" + resetOnDesroyForSharedPTHManager + '}';
  }
}
