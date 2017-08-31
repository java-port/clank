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

package org.clang.serialization.reader.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.serialization.*;
import org.clang.serialization.java.SerializationFunctionPointers.*;
import static org.clank.java.std_pair.wrap_uint_uint_pair;
import static org.llvm.adt.HashingGlobals.hash_combine;
import org.llvm.support.llvm.support;
import org.llvm.support.sys.path;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;


/// \brief Trait class used to search the on-disk hash table containing all of
/// the header search information.
///
/// The on-disk hash table contains a mapping from each header path to 
/// information about that header (how many times it has been included, its
/// controlling macro, etc.). Note that we actually hash based on the size
/// and mtime, and support "deep" comparisons of file names based on current
/// inode numbers, so that the search can cope with non-normalized path names
/// and symlinks.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::HeaderFileInfoTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 250,
 FQN="clang::serialization::reader::HeaderFileInfoTrait", NM="_ZN5clang13serialization6reader19HeaderFileInfoTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader19HeaderFileInfoTraitE")
//</editor-fold>
public class HeaderFileInfoTrait implements OnDiskChainedHashTable.InfoInterface<FileEntry, HeaderFileInfoTrait.internal_key_type, HeaderFileInfo> {
  private final ASTReader /*&*/ Reader;
  private final ModuleFile /*&*/ M;
  private HeaderSearch /*P*/ HS;
  private /*const*/char$ptr/*char P*/ FrameworkStrings;
/*public:*/
  // JAVA: typedef const FileEntry *external_key_type
//  public final class external_key_type extends /*const*/ FileEntry /*P*/ { };

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::HeaderFileInfoTrait::internal_key_type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 259,
   FQN="clang::serialization::reader::HeaderFileInfoTrait::internal_key_type", NM="_ZN5clang13serialization6reader19HeaderFileInfoTrait17internal_key_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader19HeaderFileInfoTrait17internal_key_typeE")
  //</editor-fold>
  public static class/*struct*/ internal_key_type {
    public long/*off_t*/ Size;
    public long/*time_t*/ ModTime;
    public /*const*/char$ptr/*char P*/ Filename;
    public boolean Imported;
    //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::HeaderFileInfoTrait::internal_key_type::internal_key_type">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 259,
     FQN="clang::serialization::reader::HeaderFileInfoTrait::internal_key_type::internal_key_type", NM="_ZN5clang13serialization6reader19HeaderFileInfoTrait17internal_key_typeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader19HeaderFileInfoTrait17internal_key_typeC1Ev")
    //</editor-fold>
    public /*inline*/ internal_key_type() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::HeaderFileInfoTrait::internal_key_type::internal_key_type">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 259,
     FQN="clang::serialization::reader::HeaderFileInfoTrait::internal_key_type::internal_key_type", NM="_ZN5clang13serialization6reader19HeaderFileInfoTrait17internal_key_typeC1ERKS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader19HeaderFileInfoTrait17internal_key_typeC1ERKS3_")
    //</editor-fold>
    public /*inline*/ internal_key_type(final /*const*/ internal_key_type /*&*/ $Prm0) {
      // : Size(.Size), ModTime(.ModTime), Filename(.Filename), Imported(.Imported) 
      //START JInit
      this.Size = $Prm0.Size;
      this.ModTime = $Prm0.ModTime;
      this.Filename = $tryClone($Prm0.Filename);
      this.Imported = $Prm0.Imported;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::HeaderFileInfoTrait::internal_key_type::internal_key_type">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 259,
     FQN="clang::serialization::reader::HeaderFileInfoTrait::internal_key_type::internal_key_type", NM="_ZN5clang13serialization6reader19HeaderFileInfoTrait17internal_key_typeC1EOS3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader19HeaderFileInfoTrait17internal_key_typeC1EOS3_")
    //</editor-fold>
    public /*inline*/ internal_key_type(JD$Move _dparam, final internal_key_type /*&&*/$Prm0) {
      // : Size(static_cast<internal_key_type &&>().Size), ModTime(static_cast<internal_key_type &&>().ModTime), Filename(static_cast<internal_key_type &&>().Filename), Imported(static_cast<internal_key_type &&>().Imported) 
      //START JInit
      this.Size = $Prm0.Size;
      this.ModTime = $Prm0.ModTime;
      this.Filename = $tryClone($Prm0.Filename);
      this.Imported = $Prm0.Imported;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public internal_key_type(long Size, long ModTime, char$ptr Filename, boolean Imported) {
      this.Size = Size;
      this.ModTime = ModTime;
      this.Filename = Filename;
      this.Imported = Imported;
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Size=" + Size // NOI18N
                + ", ModTime=" + ModTime // NOI18N
                + ", Filename=" + Filename // NOI18N
                + ", Imported=" + Imported; // NOI18N
    }
  };
  // JAVA: typedef const internal_key_type &internal_key_ref
//  public final class internal_key_ref extends /*const*/ internal_key_type /*&*/ { };
  
  // JAVA: typedef HeaderFileInfo data_type
//  public final class data_type extends HeaderFileInfo{ };
  // JAVA: typedef unsigned int hash_value_type;
  // JAVA: typedef unsigned int offset_type;
  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::HeaderFileInfoTrait::HeaderFileInfoTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 271,
   FQN="clang::serialization::reader::HeaderFileInfoTrait::HeaderFileInfoTrait", NM="_ZN5clang13serialization6reader19HeaderFileInfoTraitC1ERNS_9ASTReaderERNS0_10ModuleFileEPNS_12HeaderSearchEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader19HeaderFileInfoTraitC1ERNS_9ASTReaderERNS0_10ModuleFileEPNS_12HeaderSearchEPKc")
  //</editor-fold>
  public HeaderFileInfoTrait(final ASTReader /*&*/ Reader, final ModuleFile /*&*/ M, HeaderSearch /*P*/ HS, 
      /*const*/char$ptr/*char P*/ FrameworkStrings) {
    // : Reader(Reader), M(M), HS(HS), FrameworkStrings(FrameworkStrings) 
    //START JInit
    this./*&*/Reader=/*&*/Reader;
    this./*&*/M=/*&*/M;
    this.HS = HS;
    this.FrameworkStrings = $tryClone(FrameworkStrings);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::HeaderFileInfoTrait::ComputeHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1530,
   FQN="clang::serialization::reader::HeaderFileInfoTrait::ComputeHash", NM="_ZN5clang13serialization6reader19HeaderFileInfoTrait11ComputeHashERKNS2_17internal_key_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader19HeaderFileInfoTrait11ComputeHashERKNS2_17internal_key_typeE")
  //</editor-fold>
  @Override
  public /*uint*/int ComputeHash(final /*const*/ internal_key_type /*&*/ ikey) {
    return hash_combine(ikey.Size, ikey.ModTime).$uint();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::HeaderFileInfoTrait::GetInternalKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1534,
   FQN="clang::serialization::reader::HeaderFileInfoTrait::GetInternalKey", NM="_ZN5clang13serialization6reader19HeaderFileInfoTrait14GetInternalKeyEPKNS_9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader19HeaderFileInfoTrait14GetInternalKeyEPKNS_9FileEntryE")
  //</editor-fold>
  @Override
  public HeaderFileInfoTrait.internal_key_type GetInternalKey(/*const*/ FileEntry /*P*/ FE) {
    internal_key_type ikey = new internal_key_type(
      FE.getSize(), 
      M.HasTimestamps ? FE.getModificationTime() : 0, 
      FE.getName(), /*Imported*/ false);
    return ikey;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::HeaderFileInfoTrait::EqualKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1542,
   FQN="clang::serialization::reader::HeaderFileInfoTrait::EqualKey", NM="_ZN5clang13serialization6reader19HeaderFileInfoTrait8EqualKeyERKNS2_17internal_key_typeES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader19HeaderFileInfoTrait8EqualKeyERKNS2_17internal_key_typeES5_")
  //</editor-fold>
  @Override
  public boolean EqualKey(final /*const*/ internal_key_type /*&*/ a, final /*const*/ internal_key_type /*&*/ b) {
    if (a.Size != b.Size || ((a.ModTime != 0) && (b.ModTime != 0) && a.ModTime != b.ModTime)) {
      return false;
    }
    if (path.is_absolute(new Twine(a.Filename))
       && strcmp(a.Filename, b.Filename) == 0) {
      return true;
    }
    
    // Determine whether the actual files are equivalent.
    final FileManager /*&*/ FileMgr = Reader.getFileManager();
    internal_key_type2FileEntry GetFile = /*[&, &FileMgr, this]*/ (final /*const*/ internal_key_type /*&*/ Key) -> {
          if (!Key.Imported) {
            return FileMgr.getFile(new StringRef(Key.Filename));
          }
          
          std.string Resolved = new std.string(JD$T$C$P_T2$C$R.INSTANCE, Key.Filename);
          Reader.ResolveImportedPath(M, Resolved);
          return FileMgr.getFile(new StringRef(Resolved));
        };
    
    /*const*/ FileEntry /*P*/ FEA = GetFile.$call(a);
    /*const*/ FileEntry /*P*/ FEB = GetFile.$call(b);
    return (FEA != null) && FEA == FEB;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::HeaderFileInfoTrait::ReadKeyDataLength">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1566,
   FQN="clang::serialization::reader::HeaderFileInfoTrait::ReadKeyDataLength", NM="_ZN5clang13serialization6reader19HeaderFileInfoTrait17ReadKeyDataLengthERPKh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader19HeaderFileInfoTrait17ReadKeyDataLengthERPKh")
  //</editor-fold>
  @Override public final /*std.pair<uint, uint>*/long ReadKeyDataLength(final char$ptr/*const uchar P&*/ Buf, int OffsetInBuf) {
    //JAVA: using namespace llvm::support;
    /*uint*/int KeyLen = (/*uint*/int)$ushort2uint(endian.read_uint16(endianness.little, support.unaligned, Buf, OffsetInBuf));
                                        OffsetInBuf += NativeType.sizeof$uint16();
    /*uint*/int DataLen = (/*uint*/int)$uchar2uint(Buf.$at(OffsetInBuf++));
    return wrap_uint_uint_pair(KeyLen, DataLen);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::HeaderFileInfoTrait::ReadKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed static; added OffsetInBuf*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1574,
   FQN="clang::serialization::reader::HeaderFileInfoTrait::ReadKey", NM="_ZN5clang13serialization6reader19HeaderFileInfoTrait7ReadKeyEPKhj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader19HeaderFileInfoTrait7ReadKeyEPKhj")
  //</editor-fold>
  @Override public final  HeaderFileInfoTrait.internal_key_type ReadKey(/*const*/char$ptr/*uchar P*/ Buf, int OffsetInBuf, /*uint*/int $Prm1) {
    //JAVA: using namespace llvm::support;
    internal_key_type ikey/*J*/= new internal_key_type();
    ikey.Size = ((long/*off_t*/)($ullong2long(endian.read_uint64(endianness.little, support.unaligned, Buf, OffsetInBuf))));
                                              OffsetInBuf += NativeType.sizeof$uint64();
    ikey.ModTime = ((long/*time_t*/)($ullong2long(endian.read_uint64(endianness.little, support.unaligned, Buf, OffsetInBuf))));
                                              OffsetInBuf += NativeType.sizeof$uint64();
//    ikey.Filename = $tryClone(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, d));                                              
    ikey.Filename = Buf.$add(OffsetInBuf);
    ikey.Imported = true;
    return ikey;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::HeaderFileInfoTrait::ReadData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed static; added OffsetInBuf*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 1585,
   FQN="clang::serialization::reader::HeaderFileInfoTrait::ReadData", NM="_ZN5clang13serialization6reader19HeaderFileInfoTrait8ReadDataERKNS2_17internal_key_typeEPKhj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader19HeaderFileInfoTrait8ReadDataERKNS2_17internal_key_typeEPKhj")
  //</editor-fold>
  @Override public final HeaderFileInfo ReadData(final /*const*/ internal_key_type /*&*/ key, /*const*/char$ptr/*uchar P*/ Buf,  int OffsetInBuf,
          /*uint*/int DataLen) {
    // JAVA: TODO use index
    /*const*/int/*uchar P*/ End = (OffsetInBuf + DataLen);
    //JAVA: using namespace llvm::support;
    HeaderFileInfo HFI/*J*/= new HeaderFileInfo();
    /*uint*/int Flags = $uchar2uint(Buf.$at(OffsetInBuf++));
    // FIXME: Refactor with mergeHeaderFileInfo in HeaderSearch.cpp.
    HFI.isImport |= $uint2uint_1bit((Flags >>> 4) & 0x01);
    HFI.isPragmaOnce |= $uint2uint_1bit((Flags >>> 3) & 0x01);
    HFI.DirInfo = $uint2uint_2bits((Flags >>> 1) & 0x03);
    HFI.IndexHeaderMapHeader = $uint2uint_1bit(Flags & 0x01);
    // FIXME: Find a better way to handle this. Maybe just store a
    // "has been included" flag?
    HFI.NumIncludes = (char)std.max(endian.read_uint16(endianness.little, support.unaligned, Buf, OffsetInBuf), 
        HFI.NumIncludes);
                                    OffsetInBuf += NativeType.sizeof$uint16();
    HFI.ControllingMacroID = Reader.getGlobalIdentifierID(M, endian.read_uint32(endianness.little, support.unaligned, Buf, OffsetInBuf));
                                    OffsetInBuf += NativeType.sizeof$uint32();
    {
      /*uint*/int FrameworkOffset = endian.read_uint32(endianness.little, support.unaligned, Buf, OffsetInBuf);
                                    OffsetInBuf += NativeType.sizeof$uint32();
      if ((FrameworkOffset != 0)) {
        // The framework offset is 1 greater than the actual offset, 
        // since 0 is used as an indicator for "no framework name".
        StringRef FrameworkName/*J*/= new StringRef(FrameworkStrings.$add(FrameworkOffset).$sub(1));
        HFI.Framework.$assignMove(HS.getUniqueFrameworkName(new StringRef(FrameworkName)));
      }
    }
    assert ((End - OffsetInBuf) % 4 == 0) : "Wrong data length in HeaderFileInfo deserialization";
    while ($noteq(OffsetInBuf, End)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint32_t*/int LocalSMID = endian.read_uint32(endianness.little, support.unaligned, Buf, OffsetInBuf);
                                    OffsetInBuf += NativeType.sizeof$uint32();
        /*ModuleMap::ModuleHeaderRole*//*uint*/int HeaderRole = ((/*static_cast*//*ModuleMap::ModuleHeaderRole*//*uint*/int)(LocalSMID & 3));
        LocalSMID >>>= 2;
        
        // This header is part of a module. Associate it with the module to enable
        // implicit module import.
        /*uint32_t*/int GlobalSMID = Reader.getGlobalSubmoduleID(M, LocalSMID);
        Module /*P*/ Mod = Reader.getSubmodule(GlobalSMID);
        final FileManager /*&*/ FileMgr = Reader.getFileManager();
        final ModuleMap /*&*/ ModMap = Reader.getPreprocessor().getHeaderSearchInfo().getModuleMap();
        
        std.string Filename = new std.string(JD$T$C$P_T2$C$R.INSTANCE, key.Filename);
        if (key.Imported) {
          Reader.ResolveImportedPath(M, Filename);
        }
        // FIXME: This is not always the right filename-as-written, but we're not
        // going to use this information to rebuild the module, so it doesn't make
        // a lot of difference.
        Module.Header H = new Module.Header(key.Filename, FileMgr.getFile(new StringRef(Filename)));
        ModMap.addHeader(Mod, $c$.track(new Module.Header(H)), HeaderRole, /*Imported*/ true); $c$.clean();
        HFI.isModuleHeader |= !((HeaderRole & ModuleMap.ModuleHeaderRole.TextualHeader) != 0);
      } finally {
        $c$.$destroy();
      }
    }
    
    // This HeaderFileInfo was externally loaded.
    HFI.External = true;
    HFI.IsValid = true;
    return HFI;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::reader::HeaderFileInfoTrait::HeaderFileInfoTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderInternals.h", line = 250,
   FQN="clang::serialization::reader::HeaderFileInfoTrait::HeaderFileInfoTrait", NM="_ZN5clang13serialization6reader19HeaderFileInfoTraitC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization6reader19HeaderFileInfoTraitC1ERKS2_")
  //</editor-fold>
  public /*inline*/ HeaderFileInfoTrait(final /*const*/ HeaderFileInfoTrait /*&*/ $Prm0) {
    // : Reader(.Reader), M(.M), HS(.HS), FrameworkStrings(.FrameworkStrings) 
    //START JInit
    this./*&*/Reader=/*&*/$Prm0.Reader;
    this./*&*/M=/*&*/$Prm0.M;
    this.HS = $Prm0.HS;
    this.FrameworkStrings = $tryClone($Prm0.FrameworkStrings);
    //END JInit
  }
  
  @Override
  public int getReadKeyDataLengthBytes() {
    return NativeType.sizeof$uint16() + 1;
  }
  
  @Override public String toString() {
    return "" + "Reader=" + Reader // NOI18N
              + ", M=" + M // NOI18N
              + ", HS=" + HS // NOI18N
              + ", FrameworkStrings=" + FrameworkStrings; // NOI18N
  }
}
