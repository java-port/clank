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

package org.clang.frontend.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.frontend.impl.*;
import org.llvm.support.sys.*;
import org.llvm.support.endian.*;
import static org.llvm.support.llvm.support.endianness.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*had to fix ctrs in Unnamed_union1*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 61,
 FQN="(anonymous namespace)::PTHEntryKeyVariant", NM="_ZN12_GLOBAL__N_118PTHEntryKeyVariantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_118PTHEntryKeyVariantE")
//</editor-fold>
public class PTHEntryKeyVariant {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 62,
   FQN="(anonymous namespace)::PTHEntryKeyVariant::(anonymous)", NM="_ZN12_GLOBAL__N_118PTHEntryKeyVariantE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_118PTHEntryKeyVariantE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 {
    public /*const*/ FileEntry /*P*/ FE;
    public /*const*/char$ptr/*char P*/ Path;

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    private Unnamed_union1() {
    }
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 62,
     FQN="(anonymous namespace)::PTHEntryKeyVariant::(anonymous union)::", NM="_ZN12_GLOBAL__N_118PTHEntryKeyVariant3$_0C1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_118PTHEntryKeyVariant3$_0C1ERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(Unnamed_union1 $Prm0) {
      this.FE = $Prm0.FE;
      this.Path = $Prm0.Path;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 62,
     FQN="(anonymous namespace)::PTHEntryKeyVariant::(anonymous union)::", NM="_ZN12_GLOBAL__N_118PTHEntryKeyVariant3$_0C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_118PTHEntryKeyVariant3$_0C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(JD$Move _dparam, Unnamed_union1 $Prm0) {
      this.FE = $Prm0.FE;
      this.Path = $Prm0.Path;
    }

    
    @Override public String toString() {
      return "" + "FE=" + FE // NOI18N
                + ", Path=" + Path; // NOI18N
    }
  };
  private Unnamed_union1 Unnamed_field;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 63,
   FQN="(anonymous namespace)::PTHEntryKeyVariant::(anonymous)", NM="_ZN12_GLOBAL__N_118PTHEntryKeyVariantE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_118PTHEntryKeyVariantE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int IsFE = 0x1;
    public static final /*uint*/int IsDE = 0x2;
    public static final /*uint*/int IsNoExist = 0x0;
  /*}*/;
  private /*ANONYMOUS_HEX_CONSTANTS*/int Kind;
  private FileData /*P*/ Data;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::PTHEntryKeyVariant">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*init unnamed union*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 67,
   FQN="(anonymous namespace)::PTHEntryKeyVariant::PTHEntryKeyVariant", NM="_ZN12_GLOBAL__N_118PTHEntryKeyVariantC1EPKN5clang9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_118PTHEntryKeyVariantC1EPKN5clang9FileEntryE")
  //</editor-fold>
  public PTHEntryKeyVariant(/*const*/ FileEntry /*P*/ fe) {
    // : FE(fe), Kind(IsFE), Data(null) 
    this.Unnamed_field = new Unnamed_union1();
    //START JInit
    /*Indirect*/this.Unnamed_field.FE = fe;
    this.Kind = IsFE;
    this.Data = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::PTHEntryKeyVariant">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*init unnamed union*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 69,
   FQN="(anonymous namespace)::PTHEntryKeyVariant::PTHEntryKeyVariant", NM="_ZN12_GLOBAL__N_118PTHEntryKeyVariantC1EPN5clang8FileDataEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_118PTHEntryKeyVariantC1EPN5clang8FileDataEPKc")
  //</editor-fold>
  public PTHEntryKeyVariant(FileData /*P*/ Data, /*const*/char$ptr/*char P*/ path) {
    // : Path(path), Kind(IsDE), Data(new FileData(*Data)) 
    this.Unnamed_field = new Unnamed_union1();
    //START JInit
    /*Indirect*/this.Unnamed_field.Path = $tryClone(path);
    this.Kind = IsDE;
    this.Data = new FileData(/*Deref*/Data);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::PTHEntryKeyVariant">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*init unnamed union*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 72,
   FQN="(anonymous namespace)::PTHEntryKeyVariant::PTHEntryKeyVariant", NM="_ZN12_GLOBAL__N_118PTHEntryKeyVariantC1EPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_118PTHEntryKeyVariantC1EPKc")
  //</editor-fold>
  public /*explicit*/ PTHEntryKeyVariant(/*const*/char$ptr/*char P*/ path) {
    // : Path(path), Kind(IsNoExist), Data(null) 
    this.Unnamed_field = new Unnamed_union1();
    //START JInit
    /*Indirect*/this.Unnamed_field.Path = $tryClone(path);
    this.Kind = IsNoExist;
    this.Data = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::isFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 75,
   FQN="(anonymous namespace)::PTHEntryKeyVariant::isFile", NM="_ZNK12_GLOBAL__N_118PTHEntryKeyVariant6isFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZNK12_GLOBAL__N_118PTHEntryKeyVariant6isFileEv")
  //</editor-fold>
  public boolean isFile() /*const*/ {
    return Kind == IsFE;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::getString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 77,
   FQN="(anonymous namespace)::PTHEntryKeyVariant::getString", NM="_ZNK12_GLOBAL__N_118PTHEntryKeyVariant9getStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZNK12_GLOBAL__N_118PTHEntryKeyVariant9getStringEv")
  //</editor-fold>
  public StringRef getString() /*const*/ {
    return new StringRef(Kind == IsFE ? Unnamed_field.FE.getName() : Unnamed_field.Path);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 81,
   FQN="(anonymous namespace)::PTHEntryKeyVariant::getKind", NM="_ZNK12_GLOBAL__N_118PTHEntryKeyVariant7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZNK12_GLOBAL__N_118PTHEntryKeyVariant7getKindEv")
  //</editor-fold>
  public /*uint*/int getKind() /*const*/ {
    return (/*uint*/int)Kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::EmitData">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 83,
   FQN="(anonymous namespace)::PTHEntryKeyVariant::EmitData", NM="_ZN12_GLOBAL__N_118PTHEntryKeyVariant8EmitDataERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_118PTHEntryKeyVariant8EmitDataERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void EmitData(raw_ostream /*&*/ Out) {
    //JAVA: using namespace llvm::support;
    Writer LE/*J*/= new Writer(little, Out);
    switch (Kind) {
     case IsFE:
      {
        // Emit stat information.
        fs.UniqueID UID = new fs.UniqueID(Unnamed_field.FE.getUniqueID());
        LE.write_uint64(UID.getFile());
        LE.write_uint64(UID.getDevice());
        LE.write_uint64($long2ullong(Unnamed_field.FE.getModificationTime()));
        LE.write_uint64($long2ullong(Unnamed_field.FE.getSize()));
      }
      break;
     case IsDE:
      // Emit stat information.
      LE.write_uint64(Data.UniqueID.getFile());
      LE.write_uint64(Data.UniqueID.getDevice());
      LE.write_uint64($long2ullong(Data.ModTime));
      LE.write_uint64(Data.Size);
      if (Data != null) { Data.$destroy();};
      break;
     default:
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::getRepresentationLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 108,
   FQN="(anonymous namespace)::PTHEntryKeyVariant::getRepresentationLength", NM="_ZNK12_GLOBAL__N_118PTHEntryKeyVariant23getRepresentationLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZNK12_GLOBAL__N_118PTHEntryKeyVariant23getRepresentationLengthEv")
  //</editor-fold>
  public /*uint*/int getRepresentationLength() /*const*/ {
    return Kind == IsNoExist ? 0 : 4 * 8;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::PTHEntryKeyVariant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 61,
   FQN="(anonymous namespace)::PTHEntryKeyVariant::PTHEntryKeyVariant", NM="_ZN12_GLOBAL__N_118PTHEntryKeyVariantC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_118PTHEntryKeyVariantC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PTHEntryKeyVariant(/*const*/ PTHEntryKeyVariant /*&*/ $Prm0) {
    // : Unnamed_field(.), Kind(.Kind), Data(.Data) 
    //START JInit
    this.Unnamed_field = new Unnamed_union1($Prm0.Unnamed_field);
    this.Kind = $Prm0.Kind;
    this.Data = $Prm0.Data;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PTHEntryKeyVariant::PTHEntryKeyVariant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 61,
   FQN="(anonymous namespace)::PTHEntryKeyVariant::PTHEntryKeyVariant", NM="_ZN12_GLOBAL__N_118PTHEntryKeyVariantC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN12_GLOBAL__N_118PTHEntryKeyVariantC1EOS0_")
  //</editor-fold>
  public /*inline*/ PTHEntryKeyVariant(JD$Move _dparam, PTHEntryKeyVariant /*&&*/$Prm0) {
    // : Unnamed_field(static_cast<PTHEntryKeyVariant &&>().), Kind(static_cast<PTHEntryKeyVariant &&>().Kind), Data(static_cast<PTHEntryKeyVariant &&>().Data) 
    //START JInit
    this.Unnamed_field = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field);
    this.Kind = $Prm0.Kind;
    this.Data = $Prm0.Data;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Unnamed_field=" + Unnamed_field // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", Data=" + Data; // NOI18N
  }
}
