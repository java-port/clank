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

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 744,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 721,
 FQN="(anonymous namespace)::RedirectingFileEntry", NM="_ZN12_GLOBAL__N_120RedirectingFileEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_120RedirectingFileEntryE")
//</editor-fold>
public class RedirectingFileEntry extends /*public*/ Entry implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileEntry::NameKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 746,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 723,
   FQN="(anonymous namespace)::RedirectingFileEntry::NameKind", NM="_ZN12_GLOBAL__N_120RedirectingFileEntry8NameKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_120RedirectingFileEntry8NameKindE")
  //</editor-fold>
  public enum NameKind implements Native.ComparableLower {
    NK_NotSet(0),
    NK_External(NK_NotSet.getValue() + 1),
    NK_Virtual(NK_External.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NameKind valueOf(int val) {
      NameKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NameKind[] VALUES;
      private static final NameKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NameKind kind : NameKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NameKind[min < 0 ? (1-min) : 0];
        VALUES = new NameKind[max >= 0 ? (1+max) : 0];
        for (NameKind kind : NameKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private NameKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NameKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NameKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private std.string ExternalContentsPath;
  private NameKind UseName;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileEntry::RedirectingFileEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 755,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 732,
   FQN="(anonymous namespace)::RedirectingFileEntry::RedirectingFileEntry", NM="_ZN12_GLOBAL__N_120RedirectingFileEntryC1EN4llvm9StringRefES2_NS0_8NameKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_120RedirectingFileEntryC1EN4llvm9StringRefES2_NS0_8NameKindE")
  //</editor-fold>
  public RedirectingFileEntry(StringRef Name, StringRef ExternalContentsPath, 
      NameKind UseName) {
    /* : Entry(EK_File, Name), ExternalContentsPath(ExternalContentsPath.operator basic_string()), UseName(UseName)*/ 
    //START JInit
    super(EntryKind.EK_File, new StringRef(Name));
    this.ExternalContentsPath = ExternalContentsPath.$string();
    this.UseName = UseName;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileEntry::getExternalContentsPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 759,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 736,
   FQN="(anonymous namespace)::RedirectingFileEntry::getExternalContentsPath", NM="_ZNK12_GLOBAL__N_120RedirectingFileEntry23getExternalContentsPathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK12_GLOBAL__N_120RedirectingFileEntry23getExternalContentsPathEv")
  //</editor-fold>
  public StringRef getExternalContentsPath() /*const*/ {
    return new StringRef(ExternalContentsPath);
  }

  /// \brief whether to use the external path as the name for this file.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileEntry::useExternalName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 761,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 738,
   FQN="(anonymous namespace)::RedirectingFileEntry::useExternalName", NM="_ZNK12_GLOBAL__N_120RedirectingFileEntry15useExternalNameEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK12_GLOBAL__N_120RedirectingFileEntry15useExternalNameEb")
  //</editor-fold>
  public boolean useExternalName(boolean GlobalUseExternalName) /*const*/ {
    return UseName == NameKind.NK_NotSet ? GlobalUseExternalName : (UseName == NameKind.NK_External);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileEntry::getUseName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 765,
   FQN="(anonymous namespace)::RedirectingFileEntry::getUseName", NM="_ZNK12_GLOBAL__N_120RedirectingFileEntry10getUseNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK12_GLOBAL__N_120RedirectingFileEntry10getUseNameEv")
  //</editor-fold>
  public NameKind getUseName() /*const*/ {
    return UseName;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileEntry::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 766,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 742,
   FQN="(anonymous namespace)::RedirectingFileEntry::classof", NM="_ZN12_GLOBAL__N_120RedirectingFileEntry7classofEPKNS_5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_120RedirectingFileEntry7classofEPKNS_5EntryE")
  //</editor-fold>
  public static boolean classof(/*const*/ Entry /*P*/ E) {
    return E.getKind() == EntryKind.EK_File;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingFileEntry::~RedirectingFileEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 744,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 721,
   FQN="(anonymous namespace)::RedirectingFileEntry::~RedirectingFileEntry", NM="_ZN12_GLOBAL__N_120RedirectingFileEntryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_120RedirectingFileEntryD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    ExternalContentsPath.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "ExternalContentsPath=" + ExternalContentsPath // NOI18N
              + ", UseName=" + UseName // NOI18N
              + super.toString(); // NOI18N
  }
}
