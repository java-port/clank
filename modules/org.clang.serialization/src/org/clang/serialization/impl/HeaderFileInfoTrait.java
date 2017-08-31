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

package org.clang.serialization.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.serialization.*;
import static org.clank.java.std_pair.wrap_uint_uint_pair;
import static org.clank.support.literal_constants.$$TERM;
import static org.llvm.adt.HashingGlobals.hash_combine;
import org.llvm.support.OnDiskChainedHashTableGenerator.EmitInfoInterface;
import org.llvm.support.endian.Writer;
import static org.llvm.support.llvm.support.endianness.little;

// Trait used for the on-disk hash table of header search information.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1705,
 FQN="(anonymous namespace)::HeaderFileInfoTrait", NM="_ZN12_GLOBAL__N_119HeaderFileInfoTraitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_119HeaderFileInfoTraitE")
//</editor-fold>
public class HeaderFileInfoTrait implements EmitInfoInterface<HeaderFileInfoTrait.key_type, HeaderFileInfo, Void/*unused*/>, Destructors.ClassWithDestructor {
  private final ASTWriter /*&*/ Writer;
  private final /*const*/ HeaderSearch /*&*/ HS;
  
  // Keep track of the framework names we've used during serialization.
  private SmallString FrameworkStringData;
  private StringMapUInt FrameworkNameOffset;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoTrait::HeaderFileInfoTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1714,
   FQN="(anonymous namespace)::HeaderFileInfoTrait::HeaderFileInfoTrait", NM="_ZN12_GLOBAL__N_119HeaderFileInfoTraitC1ERN5clang9ASTWriterERKNS1_12HeaderSearchE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_119HeaderFileInfoTraitC1ERN5clang9ASTWriterERKNS1_12HeaderSearchE")
  //</editor-fold>
  public HeaderFileInfoTrait(final ASTWriter /*&*/ Writer, final /*const*/ HeaderSearch /*&*/ HS) {
    // : Writer(Writer), HS(HS), FrameworkStringData(), FrameworkNameOffset() 
    //START JInit
    this./*&*/Writer=/*&*/Writer;
    this./*&*/HS=/*&*/HS;
    this.FrameworkStringData = new SmallString(128);
    this.FrameworkNameOffset = new StringMapUInt((/*uint*/int)0);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoTrait::key_type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1717,
   FQN="(anonymous namespace)::HeaderFileInfoTrait::key_type", NM="_ZN12_GLOBAL__N_119HeaderFileInfoTrait8key_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_119HeaderFileInfoTrait8key_typeE")
  //</editor-fold>
  public static class/*struct*/ key_type {
    public /*const*/ FileEntry /*P*/ FE;
    public /*const*/char$ptr/*char P*/ Filename;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoTrait::key_type::key_type">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1717,
     FQN="(anonymous namespace)::HeaderFileInfoTrait::key_type::key_type", NM="_ZN12_GLOBAL__N_119HeaderFileInfoTrait8key_typeC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_119HeaderFileInfoTrait8key_typeC1ERKS1_")
    //</editor-fold>
    public /*inline*/ key_type(final /*const*/ key_type /*&*/ $Prm0) {
      // : FE(.FE), Filename(.Filename) 
      //START JInit
      this.FE = $Prm0.FE;
      this.Filename = $tryClone($Prm0.Filename);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public key_type(FileEntry FE, char$ptr Filename) {
      this.FE = FE;
      this.Filename = Filename;
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "FE=" + FE // NOI18N
                + ", Filename=" + Filename; // NOI18N
    }
  };
  // JAVA: typedef const key_type &key_type_ref
//  public final class key_type_ref extends /*const*/ key_type /*&*/ { };
  
  // JAVA: typedef HeaderFileInfo data_type
//  public final class data_type extends HeaderFileInfo{ };
  // JAVA: typedef const data_type &data_type_ref
//  public final class data_type_ref extends /*const*/ HeaderFileInfo /*&*/ { };
  // JAVA: typedef unsigned int hash_value_type;
  // JAVA: typedef unsigned int offset_type;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoTrait::ComputeHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1728,
   FQN="(anonymous namespace)::HeaderFileInfoTrait::ComputeHash", NM="_ZN12_GLOBAL__N_119HeaderFileInfoTrait11ComputeHashERKNS0_8key_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_119HeaderFileInfoTrait11ComputeHashERKNS0_8key_typeE")
  //</editor-fold>
  @Override public final /*uint*/int ComputeHash(final /*const*/ key_type /*&*/ key) {
    // The hash is based only on size/time of the file, so that the reader can
    // match even when symlinking or excess path elements ("foo/../", "../")
    // change the form of the name. However, complete path is still the key.
    return hash_combine(key.FE.getSize(), 
        Writer.getTimestampForOutput(key.FE)).$uint();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoTrait::EmitKeyDataLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1736,
   FQN="(anonymous namespace)::HeaderFileInfoTrait::EmitKeyDataLength", NM="_ZN12_GLOBAL__N_119HeaderFileInfoTrait17EmitKeyDataLengthERN4llvm11raw_ostreamERKNS0_8key_typeERKN5clang14HeaderFileInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_119HeaderFileInfoTrait17EmitKeyDataLengthERN4llvm11raw_ostreamERKNS0_8key_typeERKN5clang14HeaderFileInfoE")
  //</editor-fold>
  public std.pairUIntUInt EmitKeyDataLength(final raw_ostream /*&*/ Out, final /*const*/ key_type /*&*/ key, final /*const*/ HeaderFileInfo /*&*/ Data) {
    throw new UnsupportedOperationException("EmitKeyDataLength$WrapPair must be used");
  }  
  @Override public final /*std.pair<uint, uint>*/long EmitKeyDataLength$WrapPair(final raw_ostream /*&*/ Out, final /*const*/ key_type /*&*/ key, final /*const*/ HeaderFileInfo /*&*/ Data) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    /*uint*/int KeyLen = strlen(key.Filename) + 1 + 8 + 8;
    LE.write_uint16($uint2ushort(KeyLen));
    /*uint*/int DataLen = 1 + 2 + 4 + 4;
    for (ModuleMap.KnownHeader ModInfo : HS.getModuleMap$Const().findAllModulesForHeader(key.FE))  {
      if ((Writer.getLocalOrImportedSubmoduleID(ModInfo.getModule()) != 0)) {
        DataLen += 4;
      }
    }
    LE.write_uint8($uint2uchar(DataLen));
    return wrap_uint_uint_pair(KeyLen, DataLen);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoTrait::EmitKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1750,
   FQN="(anonymous namespace)::HeaderFileInfoTrait::EmitKey", NM="_ZN12_GLOBAL__N_119HeaderFileInfoTrait7EmitKeyERN4llvm11raw_ostreamERKNS0_8key_typeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_119HeaderFileInfoTrait7EmitKeyERN4llvm11raw_ostreamERKNS0_8key_typeEj")
  //</editor-fold>
  @Override public final void EmitKey(final raw_ostream /*&*/ Out, final /*const*/ key_type /*&*/ key, /*uint*/int KeyLen) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    LE.write_uint64($long2ullong(key.FE.getSize()));
    KeyLen -= 8;
    LE.write_uint64($long2ullong(Writer.getTimestampForOutput(key.FE)));
    KeyLen -= 8;
    Out.write(key.Filename, KeyLen);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoTrait::EmitData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1760,
   FQN="(anonymous namespace)::HeaderFileInfoTrait::EmitData", NM="_ZN12_GLOBAL__N_119HeaderFileInfoTrait8EmitDataERN4llvm11raw_ostreamERKNS0_8key_typeERKN5clang14HeaderFileInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_119HeaderFileInfoTrait8EmitDataERN4llvm11raw_ostreamERKNS0_8key_typeERKN5clang14HeaderFileInfoEj")
  //</editor-fold>
  @Override public final void EmitData(final raw_ostream /*&*/ Out, final /*const*/ key_type /*&*/ key, 
          final /*const*/ HeaderFileInfo /*&*/ Data, /*uint*/int DataLen) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    long/*uint64_t*/ Start = Out.tell();
    ///*J:(void)*/Start;
    
    /*uchar*/byte Flags = $int2uchar(((Data.isImport?1:0) << 4)
       | ((Data.isPragmaOnce?1:0) << 3)
       | ($2bits_uint2uint(Data.DirInfo) << 1)
       | (Data.IndexHeaderMapHeader?1:0));
    LE.write_uint8(Flags);
    LE.write_uint16(Data.NumIncludes);
    if (!(Data.ControllingMacro != null)) {
      LE.
              write_uint32(Data.ControllingMacroID);
    } else {
      LE.write_uint32(Writer.getIdentifierRef(Data.ControllingMacro));
    }
    
    /*uint*/int Offset = 0;
    if (!Data.Framework.empty()) {
      // If this header refers into a framework, save the framework name.
      StringMapIteratorUInt Pos = FrameworkNameOffset.find(/*NO_COPY*/Data.Framework);
      if (Pos.$eq(FrameworkNameOffset.end())) {
        Offset = FrameworkStringData.size() + 1;
        FrameworkStringData.append_T(Data.Framework.begin(), 
            Data.Framework.end());
        FrameworkStringData.push_back($$TERM);
        
        FrameworkNameOffset.$set(/*NO_COPY*/Data.Framework, Offset);
      } else {
        Offset = Pos.$arrow().second;
      }
    }
    LE.write_uint32(Offset);
    
    // FIXME: If the header is excluded, we should write out some
    // record of that fact.
    for (ModuleMap.KnownHeader ModInfo : HS.getModuleMap$Const().findAllModulesForHeader(key.FE)) {
      {
        /*uint32_t*/int ModID = Writer.getLocalOrImportedSubmoduleID(ModInfo.getModule());
        if ((ModID != 0)) {
          /*uint32_t*/int Value = (ModID << 2) | (/*uint*/int)ModInfo.getRole();
          assert ((Value >>> 2) == ModID) : "overflow in header module info";
          LE.write_uint32(Value);
        }
      }
    }
    assert (Out.tell() - Start == $uint2ullong(DataLen)) : "Wrong data length";
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoTrait::strings_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1809,
   FQN="(anonymous namespace)::HeaderFileInfoTrait::strings_begin", NM="_ZNK12_GLOBAL__N_119HeaderFileInfoTrait13strings_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK12_GLOBAL__N_119HeaderFileInfoTrait13strings_beginEv")
  //</editor-fold>
  @Override public final /*const*/char$ptr/*char P*/ strings_begin() /*const*/ {
    return FrameworkStringData.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoTrait::strings_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1810,
   FQN="(anonymous namespace)::HeaderFileInfoTrait::strings_end", NM="_ZNK12_GLOBAL__N_119HeaderFileInfoTrait11strings_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZNK12_GLOBAL__N_119HeaderFileInfoTrait11strings_endEv")
  //</editor-fold>
  @Override public final /*const*/char$ptr/*char P*/ strings_end() /*const*/ {
    return FrameworkStringData.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HeaderFileInfoTrait::~HeaderFileInfoTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1705,
   FQN="(anonymous namespace)::HeaderFileInfoTrait::~HeaderFileInfoTrait", NM="_ZN12_GLOBAL__N_119HeaderFileInfoTraitD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZN12_GLOBAL__N_119HeaderFileInfoTraitD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FrameworkNameOffset.$destroy();
    FrameworkStringData.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Writer=" + Writer // NOI18N
              + ", HS=" + HS // NOI18N
              + ", FrameworkStringData=" + FrameworkStringData // NOI18N
              + ", FrameworkNameOffset=" + FrameworkNameOffset; // NOI18N
  }
}
