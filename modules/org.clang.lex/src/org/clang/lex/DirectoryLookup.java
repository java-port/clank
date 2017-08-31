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

import org.clang.basic.*;
import static org.clank.java.std.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.JavaDifferentiators.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.path;
import static org.llvm.support.llvm.*;


/// DirectoryLookup - This class represents one entry in the search list that
/// specifies the search order for directories in \#include directives.  It
/// represents either a directory, a framework, or a headermap.
///
//<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup">
@Converted(kind = Converted.Kind.MANUAL, 
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 32,
 FQN = "clang::DirectoryLookup", NM = "_ZN5clang15DirectoryLookupE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookupE")
//</editor-fold>
public final class DirectoryLookup implements Native.NativePOD<DirectoryLookup> {
  public static DirectoryLookup DEFAULT = new DirectoryLookup();
  private DirectoryLookup() {
    /* For default value purposes */
  }
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::LookupType_t">
  @Converted(kind = Converted.Kind.AUTO, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 34,
   FQN = "clang::DirectoryLookup::LookupType_t", NM = "_ZN5clang15DirectoryLookup12LookupType_tE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookup12LookupType_tE")
  //</editor-fold>
  public enum LookupType_t implements Native.ComparableLower {
    LT_NormalDir(0),
    LT_Framework(LT_NormalDir.getValue() + 1),
    LT_HeaderMap(LT_Framework.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static LookupType_t valueOf(int val) {
      LookupType_t out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final LookupType_t[] VALUES;
      private static final LookupType_t[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (LookupType_t kind : LookupType_t.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new LookupType_t[min < 0 ? (1-min) : 0];
        VALUES = new LookupType_t[max >= 0 ? (1+max) : 0];
        for (LookupType_t kind : LookupType_t.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private LookupType_t(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((LookupType_t)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((LookupType_t)obj).value);}
    //</editor-fold>
  };
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 40,
   FQN = "clang::DirectoryLookup::(anonymous)", NM = "_ZN5clang15DirectoryLookupE_Unnamed_union1",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookupE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 {
    // This union is discriminated by isHeaderMap.
    /// Dir - This is the actual directory that we're referring to for a normal
    /// directory or a framework.
    public /*const*/DirectoryEntry /*P*/ Dir;
    
    /// Map - This is the HeaderMap if this is a headermap lookup.
    ///
    public /*const*/HeaderMap /*P*/ Map;    
    //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 40,
     FQN="clang::DirectoryLookup::(anonymous union)::", NM="_ZN5clang15DirectoryLookupUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookupUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_union1() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*prevent NPE*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 40,
     FQN="clang::DirectoryLookup::(anonymous union)::", NM="_ZN5clang15DirectoryLookupUt_C1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookupUt_C1ERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(Unnamed_union1 $Prm0)/* throw()*/ {
      this.Dir = $Prm0.Dir;
      this.Map = $Prm0.Map;
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::(anonymous union)::">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*prevent NPE*/,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 40,
     FQN="clang::DirectoryLookup::(anonymous union)::", NM="_ZN5clang15DirectoryLookupUt_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookupUt_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(JD$Move _dparam, Unnamed_union1 $Prm0) {
      this.Dir = $Prm0.Dir;
      this.Map = $Prm0.Map;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 40,
     FQN = "clang::DirectoryLookup::(anonymous union)::operator=", NM = "_ZN5clang15DirectoryLookupUt_aSERKS1_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookupUt_aSERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assign(Unnamed_union1 $Prm0) {
      this.Dir = $Prm0.Dir;
      this.Map = $Prm0.Map;
      return /*Deref*/this;
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 40,
     FQN="clang::DirectoryLookup::(anonymous union)::operator=", NM="_ZN5clang15DirectoryLookupUt_aSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookupUt_aSEOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assignMove(Unnamed_union1 $Prm0) {
      this.Dir = $Prm0.Dir;
      this.Map = $Prm0.Map;
      return /*Deref*/this;
    }

    private boolean $eq(Unnamed_union1 u) {
      return this.Map == u.Map && Dir == u.Dir;
    }

    @Override
    public String toString() {
      return "{" + "Dir=" + Dir // NOI18N
                + ", Map=" + Map +"}"; // NOI18N
    }    
  };
  private Unnamed_union1 u = new Unnamed_union1();
  
  /// DirCharacteristic - The type of directory this is: this is an instance of
  /// SrcMgr::CharacteristicKind.
  private /*JBYTE unsigned int*/ byte DirCharacteristic /*: 2*/;
  
  /// LookupType - This indicates whether this DirectoryLookup object is a
  /// normal directory, a framework, or a headermap.
  private /*JBYTE unsigned int*/ byte LookupType /*: 2*/;
  
  /// \brief Whether this is a header map used when building a framework.
  private /*JBIT unsigned int*/ boolean IsIndexHeaderMap /*: 1*/;
  
  /// \brief Whether we've performed an exhaustive search for module maps
  /// within the subdirectories of this directory.
  private /*JBIT unsigned int*/ boolean SearchedAllModuleMaps /*: 1*/;
/*public:*/
  /// DirectoryLookup ctor - Note that this ctor *does not take ownership* of
  /// 'dir'.
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::DirectoryLookup">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 68,
   FQN = "clang::DirectoryLookup::DirectoryLookup", NM = "_ZN5clang15DirectoryLookupC1EPKNS_14DirectoryEntryENS_6SrcMgr18CharacteristicKindEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookupC1EPKNS_14DirectoryEntryENS_6SrcMgr18CharacteristicKindEb")
  //</editor-fold>
  public DirectoryLookup(/*const*/DirectoryEntry /*P*/ dir, SrcMgr.CharacteristicKind DT, 
          boolean isFramework) {
    /* : u(), DirCharacteristic(DT), LookupType(isFramework ? LT_Framework : LT_NormalDir), IsIndexHeaderMap(false), SearchedAllModuleMaps(false)*/ 
    //START JInit
    this.u = new Unnamed_union1 ();
    this.DirCharacteristic = DT.getValue();
    this.LookupType = (byte) (isFramework ? LookupType_t.LT_Framework.getValue() : LookupType_t.LT_NormalDir.getValue());
    this.IsIndexHeaderMap = false;
    this.SearchedAllModuleMaps = false;
    //END JInit
    u.Dir = dir;
  }

  
  /// DirectoryLookup ctor - Note that this ctor *does not take ownership* of
  /// 'map'.
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::DirectoryLookup">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 78,
   FQN = "clang::DirectoryLookup::DirectoryLookup", NM = "_ZN5clang15DirectoryLookupC1EPKNS_9HeaderMapENS_6SrcMgr18CharacteristicKindEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookupC1EPKNS_9HeaderMapENS_6SrcMgr18CharacteristicKindEb")
  //</editor-fold>
  public DirectoryLookup(/*const*/HeaderMap /*P*/ map, SrcMgr.CharacteristicKind DT, 
          boolean isIndexHeaderMap) {
    /* : u(), DirCharacteristic(DT), LookupType(LT_HeaderMap), IsIndexHeaderMap(isIndexHeaderMap), SearchedAllModuleMaps(false)*/ 
    //START JInit
    this.u = new Unnamed_union1 ();
    this.DirCharacteristic = DT.getValue();
    this.LookupType = (byte) LookupType_t.LT_HeaderMap.getValue();
    this.IsIndexHeaderMap = isIndexHeaderMap;
    this.SearchedAllModuleMaps = false;
    //END JInit
    u.Map = map;
  }

  
  /// getLookupType - Return the kind of directory lookup that this is: either a
  /// normal directory, a framework path, or a HeaderMap.
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::getLookupType">
  @Converted(kind = Converted.Kind.AUTO, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 87,
   FQN = "clang::DirectoryLookup::getLookupType", NM = "_ZNK5clang15DirectoryLookup13getLookupTypeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup13getLookupTypeEv")
  //</editor-fold>
  public LookupType_t getLookupType() /*const*/ {
    return LookupType_t.valueOf(LookupType);
  }

  
  /// getName - Return the directory or filename corresponding to this lookup
  /// object.
  
  //===----------------------------------------------------------------------===//
  // File lookup within a DirectoryLookup scope
  //===----------------------------------------------------------------------===//
  
  /// getName - Return the directory or filename corresponding to this lookup
  /// object.
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::getName">
  @Converted(kind = Converted.Kind.AUTO, 
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 243,
   FQN = "clang::DirectoryLookup::getName", NM = "_ZNK5clang15DirectoryLookup7getNameEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup7getNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName() /*const*/ {
    if (isNormalDir()) {
      return getDir().getName();
    }
    if (isFramework()) {
      return getFrameworkDir().getName();
    }
    assert (isHeaderMap()) : "Unknown DirectoryLookup";
    return getHeaderMap().getFileName();
  }

  
  /// getDir - Return the directory that this entry refers to.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::getDir">
  @Converted(kind = Converted.Kind.AUTO, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 95,
   FQN = "clang::DirectoryLookup::getDir", NM = "_ZNK5clang15DirectoryLookup6getDirEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup6getDirEv")
  //</editor-fold>
  public /*const*/DirectoryEntry /*P*/ getDir() /*const*/ {
    return isNormalDir() ? u.Dir : null;
  }

  
  /// getFrameworkDir - Return the directory that this framework refers to.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::getFrameworkDir">
  @Converted(kind = Converted.Kind.AUTO, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 101,
   FQN = "clang::DirectoryLookup::getFrameworkDir", NM = "_ZNK5clang15DirectoryLookup15getFrameworkDirEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup15getFrameworkDirEv")
  //</editor-fold>
  public /*const*/DirectoryEntry /*P*/ getFrameworkDir() /*const*/ {
    return isFramework() ? u.Dir : null;
  }

  
  /// getHeaderMap - Return the directory that this entry refers to.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::getHeaderMap">
  @Converted(kind = Converted.Kind.AUTO, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 107,
   FQN = "clang::DirectoryLookup::getHeaderMap", NM = "_ZNK5clang15DirectoryLookup12getHeaderMapEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup12getHeaderMapEv")
  //</editor-fold>
  public /*const*/HeaderMap /*P*/ getHeaderMap() /*const*/ {
    return isHeaderMap() ? u.Map : null;
  }

  
  /// isNormalDir - Return true if this is a normal directory, not a header map.
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::isNormalDir">
  @Converted(kind = Converted.Kind.AUTO, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 112,
   FQN = "clang::DirectoryLookup::isNormalDir", NM = "_ZNK5clang15DirectoryLookup11isNormalDirEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup11isNormalDirEv")
  //</editor-fold>
  public boolean isNormalDir() /*const*/ {
    return getLookupType() == LookupType_t.LT_NormalDir;
  }

  
  /// isFramework - True if this is a framework directory.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::isFramework">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 116,
   FQN = "clang::DirectoryLookup::isFramework", NM = "_ZNK5clang15DirectoryLookup11isFrameworkEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup11isFrameworkEv")
  //</editor-fold>
  public boolean isFramework() /*const*/ {
    return getLookupType() == LookupType_t.LT_Framework;
  }

  
  /// isHeaderMap - Return true if this is a header map, not a normal directory.
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::isHeaderMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 119,
   FQN = "clang::DirectoryLookup::isHeaderMap", NM = "_ZNK5clang15DirectoryLookup11isHeaderMapEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup11isHeaderMapEv")
  //</editor-fold>
  public boolean isHeaderMap() /*const*/ {
    return getLookupType() == LookupType_t.LT_HeaderMap;
  }

  
  /// \brief Determine whether we have already searched this entire
  /// directory for module maps.
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::haveSearchedAllModuleMaps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 123,
   FQN = "clang::DirectoryLookup::haveSearchedAllModuleMaps", NM = "_ZNK5clang15DirectoryLookup25haveSearchedAllModuleMapsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup25haveSearchedAllModuleMapsEv")
  //</editor-fold>
  public boolean haveSearchedAllModuleMaps() /*const*/ {
    return SearchedAllModuleMaps;
  }

  
  /// \brief Specify whether we have already searched all of the subdirectories
  /// for module maps.
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::setSearchedAllModuleMaps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 127,
   FQN = "clang::DirectoryLookup::setSearchedAllModuleMaps", NM = "_ZN5clang15DirectoryLookup24setSearchedAllModuleMapsEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookup24setSearchedAllModuleMapsEb")
  //</editor-fold>
  public void setSearchedAllModuleMaps(boolean SAMM) {
    SearchedAllModuleMaps = SAMM;
  }

  
  /// DirCharacteristic - The type of directory this is, one of the DirType enum
  /// values.
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::getDirCharacteristic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 133,
   FQN = "clang::DirectoryLookup::getDirCharacteristic", NM = "_ZNK5clang15DirectoryLookup20getDirCharacteristicEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup20getDirCharacteristicEv")
  //</editor-fold>
  public SrcMgr.CharacteristicKind getDirCharacteristic() /*const*/ {
    return SrcMgr.CharacteristicKind.valueOf(DirCharacteristic);
  }
  public /*SrcMgr.CharacteristicKind*/byte $getDirCharacteristic() /*const*/ {
    return DirCharacteristic;
  }

  
  /// \brief Whether this describes a system header directory.
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::isSystemHeaderDirectory">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 138,
   FQN = "clang::DirectoryLookup::isSystemHeaderDirectory", NM = "_ZNK5clang15DirectoryLookup23isSystemHeaderDirectoryEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup23isSystemHeaderDirectoryEv")
  //</editor-fold>
  public boolean isSystemHeaderDirectory() /*const*/ {
    return $getDirCharacteristic() != SrcMgr.CharacteristicKind.C_User_Raw;
  }

  
  /// \brief Whether this header map is building a framework or not.
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::isIndexHeaderMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 143,
   FQN = "clang::DirectoryLookup::isIndexHeaderMap", NM = "_ZNK5clang15DirectoryLookup16isIndexHeaderMapEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup16isIndexHeaderMapEv")
  //</editor-fold>
  public boolean isIndexHeaderMap() /*const*/ {
    return isHeaderMap() && IsIndexHeaderMap;
  }

  private boolean $LookupFileTmpDirInUse = false;
  private final SmallString/*1024*/ $LookupFileTmpDir/*J*/= new SmallString(1024);
  private SmallString $getLookupFileTmpDir() {
    assert !$LookupFileTmpDirInUse && ($LookupFileTmpDirInUse = true) : 
            "already in use. Forgot to release? Or have to switch to vector-based impl?";    
    $LookupFileTmpDir.resize(0);
    return $LookupFileTmpDir;
  }
  
  private void $releaseLookupFileTmpDir(SmallString/*1024*/ TmpDir) {
    assert TmpDir == $LookupFileTmpDir : "returns different instance";
    assert $LookupFileTmpDirInUse : "releasing without get ";
    assert ($LookupFileTmpDirInUse = false) || true;
  }
  
  private boolean $LookupFilePathInUse = false;
  private final SmallString/*1024*/ $LookupFilePath/*J*/= new SmallString(1024);
  private SmallString $getLookupFilePath() {
    assert !$LookupFilePathInUse && ($LookupFilePathInUse = true) : 
            "already in use. Forgot to release? Or have to switch to vector-based impl?";    
    $LookupFilePath.resize(0);
    return $LookupFilePath;
  }
  
  private void $releaseLookupFilePath(SmallString/*1024*/ Path) {
    assert Path == $LookupFilePath : "returns different instance";
    assert $LookupFilePathInUse : "releasing without get ";
    assert ($LookupFilePathInUse = false) || true;
  }
  
  /// LookupFile - Lookup the specified file in this search path, returning it
  /// if it exists or returning null if not.
  ///
  /// \param Filename The file to look up relative to the search paths.
  ///
  /// \param HS The header search instance to search with.
  ///
  /// \param IncludeLoc the source location of the #include or #import
  /// directive.
  ///
  /// \param SearchPath If not NULL, will be set to the search path relative
  /// to which the file was found.
  ///
  /// \param RelativePath If not NULL, will be set to the path relative to
  /// SearchPath at which the file was found. This only differs from the
  /// Filename for framework includes.
  ///
  /// \param RequestingModule The module in which the lookup was performed.
  ///
  /// \param SuggestedModule If non-null, and the file found is semantically
  /// part of a known module, this will be set to the module that should
  /// be imported instead of preprocessing/parsing the file found.
  ///
  /// \param [out] InUserSpecifiedSystemFramework If the file is found,
  /// set to true if the file is located in a framework that has been
  /// user-specified to be treated as a system framework.
  ///
  /// \param [out] MappedName if this is a headermap which maps the filename to
  /// a framework include ("Foo.h" -> "Foo/Foo.h"), set the new name to this
  /// vector and point Filename to it.

  /// LookupFile - Lookup the specified file in this search path, returning it
  /// if it exists or returning null if not.
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::LookupFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 273,
   FQN="clang::DirectoryLookup::LookupFile", NM="_ZNK5clang15DirectoryLookup10LookupFileERN4llvm9StringRefERNS_12HeaderSearchENS_14SourceLocationEPNS1_15SmallVectorImplIcEES9_PNS_6ModuleEPNS_9ModuleMap11KnownHeaderERbSF_RS8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup10LookupFileERN4llvm9StringRefERNS_12HeaderSearchENS_14SourceLocationEPNS1_15SmallVectorImplIcEES9_PNS_6ModuleEPNS_9ModuleMap11KnownHeaderERbSF_RS8_")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ LookupFile(StringRef /*&*/ Filename, 
            HeaderSearch /*&*/ HS, 
            SourceLocation IncludeLoc, 
            SmallString/*P*/ SearchPath, 
            SmallString/*P*/ RelativePath, 
            Module /*P*/ RequestingModule, 
            ModuleMap.KnownHeader /*P*/ SuggestedModule, 
            bool$ref/*bool &*/ InUserSpecifiedSystemFramework, 
            bool$ref/*bool &*/ HasBeenMapped, 
            SmallString/*&*/ MappedName) /*const*/ {
    SmallString/*1024*/ TmpDir = $getLookupFileTmpDir();
    SmallString/*1024*/ Path = $getLookupFilePath();
    FileEntry out = LookupFile(TmpDir, Path, 
            Filename, 
            HS, 
            IncludeLoc,
            SearchPath, 
            RelativePath, 
            RequestingModule,
            SuggestedModule, 
            InUserSpecifiedSystemFramework,
            HasBeenMapped,
            MappedName
    );
    $releaseLookupFileTmpDir(TmpDir);
    $releaseLookupFilePath(Path);
    return out;
  }
  private /*const*/ FileEntry /*P*/ LookupFile(SmallString/*1024*/ TmpDir, SmallString/*1024*/ Path,
            StringRef /*&*/ Filename, 
            HeaderSearch /*&*/ HS, 
            SourceLocation IncludeLoc, 
            SmallString/*P*/ SearchPath, 
            SmallString/*P*/ RelativePath, 
            Module /*P*/ RequestingModule, 
            ModuleMap.KnownHeader /*P*/ SuggestedModule, 
            bool$ref/*bool &*/ InUserSpecifiedSystemFramework, 
            bool$ref/*bool &*/ HasBeenMapped, 
            SmallString/*&*/ MappedName) /*const*/ {
    InUserSpecifiedSystemFramework.$set(false);
    HasBeenMapped.$set(false);
    // JAVA PERF: reusable and must be passed externally
    assert TmpDir != null;
    assert TmpDir.size() == 0;
    if (isNormalDir()) {
      DirectoryEntry dir = getDir();
      // Concatenate the requested file onto the directory.
      TmpDir.$assign(dir.getName(), dir.getNameLen());
      path.append(TmpDir, Filename);
      if ((SearchPath != null)) {
        SearchPath.clear();
        SearchPath.append(dir.getName(), dir.getNameLen());
      }
      if ((RelativePath != null)) {
        RelativePath.clear();
        RelativePath.append(Filename);
      }

      return HS.getFileAndSuggestModule(TmpDir.$StringRef(), IncludeLoc, dir, 
          isSystemHeaderDirectory(), 
          RequestingModule, SuggestedModule);
    }
    if (isFramework()) {
      return DoFrameworkLookup(Filename, HS, SearchPath, RelativePath, 
          RequestingModule, SuggestedModule, 
          InUserSpecifiedSystemFramework);
    }
    assert (isHeaderMap()) : "Unknown directory lookup";
    /*const*/ HeaderMap /*P*/ HM = getHeaderMap();
    // JAVA PERF: reusable and must be passed externally
    assert Path != null;
    assert Path.size() == 0;
    StringRef Dest = HM.lookupFilename(Filename, Path);
    if (Dest.empty()) {
      return null;
    }

    /*const*/ FileEntry /*P*/ Result;

    // Check if the headermap maps the filename to a framework include
    // ("Foo.h" -> "Foo/Foo.h"), in which case continue header lookup using the
    // framework include.
    if (path.is_relative(new Twine(Dest))) {
      MappedName.clear();
      MappedName.append(Dest);
      Filename.$assignMove(new StringRef(MappedName.begin(), MappedName.size()));
      HasBeenMapped.$set(true);
      Result = HM.LookupFile(Filename, HS.getFileMgr());
    } else {
      Result = HS.getFileMgr().getFile(Dest);
    }
    if ((Result != null)) {
      if ((SearchPath != null)) {
        // JAVA PERF:
        /*StringRef*/char$ptr SearchPathRef/*J*/= getName();
        SearchPath.clear();
        SearchPath.append(SearchPathRef);
      }
      if ((RelativePath != null)) {
        RelativePath.clear();
        RelativePath.append(Filename);
      }
    }
    return Result; 
  }

/*private:*/
  
  /// DoFrameworkLookup - Do a lookup of the specified file in the current
  /// DirectoryLookup, which is a framework directory.
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::DoFrameworkLookup">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", line = 401,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp", old_line = 399,
   FQN="clang::DirectoryLookup::DoFrameworkLookup", NM="_ZNK5clang15DirectoryLookup17DoFrameworkLookupEN4llvm9StringRefERNS_12HeaderSearchEPNS1_15SmallVectorImplIcEES7_PNS_6ModuleEPNS_9ModuleMap11KnownHeaderERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZNK5clang15DirectoryLookup17DoFrameworkLookupEN4llvm9StringRefERNS_12HeaderSearchEPNS1_15SmallVectorImplIcEES7_PNS_6ModuleEPNS_9ModuleMap11KnownHeaderERb")
  //</editor-fold>
  private /*const*/ FileEntry /*P*/ DoFrameworkLookup(StringRef Filename, HeaderSearch /*&*/ HS, SmallString/*P*/ SearchPath, 
                   SmallString/*P*/ RelativePath, Module /*P*/ RequestingModule, 
                   ModuleMap.KnownHeader /*P*/ SuggestedModule, 
                   bool$ref/*bool &*/ InUserSpecifiedSystemFramework) /*const*/ {
    FileManager /*&*/ FileMgr = HS.getFileMgr();

    // Framework names must have a '/' in the filename.
    /*size_t*/int SlashPos = Filename.find($$SLASH);
    if (SlashPos == StringRef.npos) {
      return null;
    }

    // Find out if this is the home for the specified framework, by checking
    // HeaderSearch.  Possible answers are yes/no and unknown.
    HeaderSearch.FrameworkCacheEntry /*&*/ CacheEntry = HS.LookupFrameworkCache(Filename.substr(0, SlashPos));
    DirectoryEntry frameworkDir = getFrameworkDir(); // JAVA: call once

    // If it is known and in some other directory, fail.
    if ((CacheEntry.Directory != null) && CacheEntry.Directory != frameworkDir) {
      return null;
    }

    // Otherwise, construct the path to this framework dir.
    
    // FrameworkName = "/System/Library/Frameworks/"
    SmallString/*1024*/ FrameworkName/*J*/= new SmallString(1024);
    FrameworkName.$addassign(frameworkDir.getName(), frameworkDir.getNameLen());
    if (FrameworkName.empty() || FrameworkName.back() != $$SLASH) {
      FrameworkName.push_back($$SLASH);
    }

    // FrameworkName = "/System/Library/Frameworks/Cocoa"
    // StringRef ModuleName/*J*/= new StringRef(Filename.begin(), SlashPos);
    FrameworkName.$addassign(Filename, 0, (int)SlashPos); // JAVA PERF: unfolded line above

    // FrameworkName = "/System/Library/Frameworks/Cocoa.framework/"
    FrameworkName.$addassign(/*STRINGREF_STR*/".framework/");

    // If the cache entry was unresolved, populate it now.
    if (CacheEntry.Directory == null) {
      HS.IncrementFrameworkLookupCount();

      // If the framework dir doesn't exist, we fail.
      /*const*/DirectoryEntry /*P*/ Dir = FileMgr.getDirectory(FrameworkName.$StringRef());
      if (Dir == null) {
        return null;
      }

      // Otherwise, if it does, remember that this is the right direntry for this
      // framework.
      CacheEntry.Directory = frameworkDir;

      // If this is a user search directory, check if the framework has been
      // user-specified as a system framework.
      if (getDirCharacteristic() == SrcMgr.CharacteristicKind.C_User) {
        SmallString/*1024*/ SystemFrameworkMarker/*J*/= new SmallString/*1024*/(FrameworkName);
        SystemFrameworkMarker.$addassign(/*STRINGREF_STR*/".system_framework");
        if (fs.exists(new Twine(SystemFrameworkMarker))) {
          CacheEntry.IsUserSpecifiedSystemFramework = true;
        }
      }
    }

    // Set the 'user-specified system framework' flag.
    InUserSpecifiedSystemFramework.$set(CacheEntry.IsUserSpecifiedSystemFramework);
    if ((RelativePath != null)) {
      RelativePath.clear();
      RelativePath.append(Filename, SlashPos + 1, Filename.size());
    }

    // Check "/System/Library/Frameworks/Cocoa.framework/Headers/file.h"
    /*uint*/int OrigSize = FrameworkName.size();

    FrameworkName.$addassign(/*STRINGREF_STR*/"Headers/");
    if ((SearchPath != null)) {
      SearchPath.clear();
      // Without trailing '/'.
      SearchPath.append_T(FrameworkName.begin(), FrameworkName.end().$sub(1));
    }

    FrameworkName.append(Filename, SlashPos + 1, Filename.size());
    /*const*/ FileEntry /*P*/ FE = FileMgr.getFile(FrameworkName.$StringRef(), 
        /*openFile=*/ !(SuggestedModule != null));
    if (!(FE != null)) {
      // Check "/System/Library/Frameworks/Cocoa.framework/PrivateHeaders/file.h"
      /*const*/char$ptr/*char P*/ Private = $("Private");
      FrameworkName.insert(FrameworkName.begin().$add(OrigSize), Private, 
          Private.$add(strlen(Private)));
      if ((SearchPath != null)) {
        SearchPath.insert(SearchPath.begin().$add(OrigSize), Private, 
            Private.$add(strlen(Private)));
      }

      FE = FileMgr.getFile(FrameworkName.$StringRef(), /*openFile=*/ !(SuggestedModule != null));
    }

    // If we found the header and are allowed to suggest a module, do so now.
    if ((FE != null) && (SuggestedModule != null)) {
        DirectoryEntry dir = FE.getDir();
      // Find the framework in which this header occurs.
      StringRef FrameworkPath = new StringRef(dir.getName(), dir.getNameLen());
      boolean FoundFramework = false;
      do {
        // Determine whether this directory exists.
        /*const*/ DirectoryEntry /*P*/ Dir = FileMgr.getDirectory(/*NO_COPY*/FrameworkPath);
        if (!(Dir != null)) {
          break;
        }

        // If this is a framework directory, then we're a subframework of this
        // framework.
        if ($eq_StringRef(path.extension(/*NO_COPY*/FrameworkPath), /*STRINGREF_STR*/".framework")) {
          FoundFramework = true;
          break;
        }

        // Get the parent directory name.
        FrameworkPath.$assignMove(path.parent_path(/*NO_COPY*/FrameworkPath));
        if (FrameworkPath.empty()) {
          break;
        }
      } while (true);

      boolean IsSystem = getDirCharacteristic() != SrcMgr.CharacteristicKind.C_User;
      if (FoundFramework) {
        if (!HS.findUsableModuleForFrameworkHeader(FE, FrameworkPath, RequestingModule, SuggestedModule, IsSystem)) {
          return null;
        }
      } else {
        if (!HS.findUsableModuleForHeader(FE, getDir(), RequestingModule, 
            SuggestedModule, IsSystem)) {
          return null;
        }
      }
    }
    return FE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 32,
   FQN = "clang::DirectoryLookup::operator=", NM = "_ZN5clang15DirectoryLookupaSERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookupaSERKS0_")
  //</editor-fold>
  public /*inline*/ DirectoryLookup /*&*/ $assign(/*const*/ DirectoryLookup /*&*/ $Prm0) {
    this.u.$assign($Prm0.u);
    this.DirCharacteristic = $Prm0.DirCharacteristic;
    this.LookupType = $Prm0.LookupType;
    this.IsIndexHeaderMap = $Prm0.IsIndexHeaderMap;
    this.SearchedAllModuleMaps = $Prm0.SearchedAllModuleMaps;
    return /*Deref*/this;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 32,
   FQN="clang::DirectoryLookup::operator=", NM="_ZN5clang15DirectoryLookupaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookupaSEOS0_")
  //</editor-fold>
  public /*inline*/ DirectoryLookup /*&*/ $assignMove(DirectoryLookup /*&&*/$Prm0) {
    this.u.$assignMove($Prm0.u);
    this.DirCharacteristic = $Prm0.DirCharacteristic;
    this.LookupType = $Prm0.LookupType;
    this.IsIndexHeaderMap = $Prm0.IsIndexHeaderMap;
    this.SearchedAllModuleMaps = $Prm0.SearchedAllModuleMaps;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::DirectoryLookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 32,
   FQN = "clang::DirectoryLookup::DirectoryLookup", NM = "_ZN5clang15DirectoryLookupC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookupC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DirectoryLookup(/*const*/ DirectoryLookup /*&*/ $Prm0) {
    /* : u(.u), DirCharacteristic(.DirCharacteristic), LookupType(.LookupType), IsIndexHeaderMap(.IsIndexHeaderMap), SearchedAllModuleMaps(.SearchedAllModuleMaps)*/ 
    //START JInit
    this.u = new Unnamed_union1 ($Prm0.u);
    this.DirCharacteristic = $Prm0.DirCharacteristic;
    this.LookupType = $Prm0.LookupType;
    this.IsIndexHeaderMap = $Prm0.IsIndexHeaderMap;
    this.SearchedAllModuleMaps = $Prm0.SearchedAllModuleMaps;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DirectoryLookup::DirectoryLookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/DirectoryLookup.h", line = 32,
   FQN="clang::DirectoryLookup::DirectoryLookup", NM="_ZN5clang15DirectoryLookupC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang15DirectoryLookupC1EOS0_")
  //</editor-fold>
  public /*inline*/ DirectoryLookup(JD$Move _dparam, DirectoryLookup /*&&*/$Prm0) {
    /* : u(static_cast<DirectoryLookup &&>().u), DirCharacteristic(static_cast<DirectoryLookup &&>().DirCharacteristic), LookupType(static_cast<DirectoryLookup &&>().LookupType), IsIndexHeaderMap(static_cast<DirectoryLookup &&>().IsIndexHeaderMap), SearchedAllModuleMaps(static_cast<DirectoryLookup &&>().SearchedAllModuleMaps)*/ 
    //START JInit
    this.u = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.u);
    this.DirCharacteristic = $Prm0.DirCharacteristic;
    this.LookupType = $Prm0.LookupType;
    this.IsIndexHeaderMap = $Prm0.IsIndexHeaderMap;
    this.SearchedAllModuleMaps = $Prm0.SearchedAllModuleMaps;
    //END JInit
  }

  @Override
  public DirectoryLookup clone() {
    return new DirectoryLookup(this);
  }

  @Override
  public boolean $noteq(DirectoryLookup other) {
    return !$eq(other);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    return hash;
  }

  @Override
  public boolean $eq(DirectoryLookup other) {
    if (this.DirCharacteristic != other.DirCharacteristic) {
      return false;
    }
    if (this.LookupType != other.LookupType) {
      return false;
    }
    if (this.IsIndexHeaderMap != other.IsIndexHeaderMap) {
      return false;
    }
    if (this.SearchedAllModuleMaps != other.SearchedAllModuleMaps) {
      return false;
    }
    return this.u.$eq(other.u);
  }

  @Override
  public String toString() {
    return "DirectoryLookup{" + "u=" + u // NOI18N
              + ", DirCharacteristic=" + DirCharacteristic // NOI18N
              + ", LookupType=" + LookupType // NOI18N
              + ", IsIndexHeaderMap=" + IsIndexHeaderMap // NOI18N
              + ", SearchedAllModuleMaps=" + SearchedAllModuleMaps + "}"; // NOI18N
  }    
}
