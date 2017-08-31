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

package org.clang.basic;

import org.clang.basic.java.ClankAliases;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import static org.clang.basic.impl.ModuleStatics.*;


/// \brief Describes a module or submodule.
//<editor-fold defaultstate="collapsed" desc="clang::Module">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 47,
 FQN = "clang::Module", NM = "_ZN5clang6ModuleE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6ModuleE")
//</editor-fold>
public class Module implements Destructors.ClassWithDestructor {
    
/*public:*/
  /// \brief The name of this module.
  public std.string Name;
  
  /// \brief The location of the module definition.
  public SourceLocation DefinitionLoc;
  
  /// \brief The parent of this module. This will be NULL for the top-level
  /// module.
  public Module /*P*/ Parent;
  
  /// \brief The build directory of this module. This is the directory in
  /// which the module is notionally built, and relative to which its headers
  /// are found.
  public /*const*/ DirectoryEntry /*P*/ Directory;
  
  /// \brief The umbrella header or directory.
  public PointerUnion</*const*/ DirectoryEntry /*P*/ , /*const*/ FileEntry /*P*/ > Umbrella;
  
  /// \brief The module signature.
  public long/*uint64_t*/ Signature;
  
  /// \brief The name of the umbrella entry, as written in the module map.
  public std.string UmbrellaAsWritten;
/*private:*/
  /// \brief The submodules of this module, indexed by name.
  private std.vector<Module /*P*/ > SubModules;
  
  /// \brief A mapping from the submodule name to the index into the 
  /// \c SubModules vector at which that submodule resides.
  private StringMapUInt SubModuleIndex;
  
  /// \brief The AST file if this is a top-level module which has a
  /// corresponding serialized AST file, or null otherwise.
  private /*const*/ FileEntry /*P*/ ASTFile;
  
  /// \brief The top-level headers associated with this module.
  private SmallSetVector</*const*/ FileEntry /*P*/> TopHeaders;
  
  /// \brief top-level header filenames that aren't resolved to FileEntries yet.
  private std.vectorString TopHeaderNames;
  
  /// \brief Cache of modules visible to lookup in this module.
  private /*mutable */DenseSet</*const*/ Module /*P*/ > VisibleModulesCache;
  
  /// The ID used when referencing this module within a VisibleModuleSet.
  private /*uint*/int VisibilityID;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Module::HeaderKind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 98,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 89,
   FQN = "clang::Module::HeaderKind", NM = "_ZN5clang6Module10HeaderKindE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module10HeaderKindE")
  //</editor-fold>
  public enum HeaderKind implements Native.ComparableLower {
    HK_Normal(0),
    HK_Textual(HK_Normal.getValue() + 1),
    HK_Private(HK_Textual.getValue() + 1),
    HK_PrivateTextual(HK_Private.getValue() + 1),
    HK_Excluded(HK_PrivateTextual.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static HeaderKind valueOf(int val) {
      HeaderKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final HeaderKind[] VALUES;
      private static final HeaderKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (HeaderKind kind : HeaderKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new HeaderKind[min < 0 ? (1-min) : 0];
        VALUES = new HeaderKind[max >= 0 ? (1+max) : 0];
        for (HeaderKind kind : HeaderKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private HeaderKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((HeaderKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((HeaderKind)obj).value);}
    //</editor-fold>
  };
  public static /*const*/int NumHeaderKinds = HeaderKind.HK_Excluded.getValue() + 1;
  
  /// \brief Information about a header directive as found in the module map
  /// file.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::Header">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 109,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 100,
   FQN = "clang::Module::Header", NM = "_ZN5clang6Module6HeaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module6HeaderE")
  //</editor-fold>
  public static class/*struct*/ Header implements Destructors.ClassWithDestructor, Native.NativePOD<Header>, NativeMoveable<Header>, Native.Native$Bool  {
    public final std.string NameAsWritten;
    public /*const*/ FileEntry /*P*/ Entry;
    
    //<editor-fold defaultstate="collapsed" desc="clang::Module::Header::operator bool">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 113,
     FQN="clang::Module::Header::operator bool", NM="_ZN5clang6Module6HeadercvbEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module6HeadercvbEv")
    //</editor-fold>
    public boolean $bool() {
      return (Entry != null);
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::Module::Header::Header">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 109,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 100,
     FQN = "clang::Module::Header::Header", NM = "_ZN5clang6Module6HeaderC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module6HeaderC1EOS1_")
    //</editor-fold>
    public /*inline*/ Header(JD$Move _dparam, Header /*&&*/$Prm0) {
      assert $Prm0 != EMPTY;
      /* : NameAsWritten(static_cast<Header &&>().NameAsWritten), Entry(static_cast<Header &&>().Entry)*/ 
      //START JInit
      this.NameAsWritten = new std.string(JD$Move.INSTANCE, $Prm0.NameAsWritten);
      this.Entry = $Prm0.Entry;
      //END JInit
    }
    
    //<editor-fold defaultstate="collapsed" desc="clang::Module::Header::~Header">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 109,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 100,
     FQN = "clang::Module::Header::~Header", NM = "_ZN5clang6Module6HeaderD0Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module6HeaderD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      assert this != EMPTY;
      //START JDestroy
      NameAsWritten.$destroy();
      //END JDestroy
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Module::Header::Header">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 109,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 100,
     FQN = "clang::Module::Header::Header", NM = "_ZN5clang6Module6HeaderC1ERKS1_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang6Module6HeaderC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Header(/*const*/ Header /*&*/ $Prm0) {
      /* : NameAsWritten(.NameAsWritten), Entry(.Entry)*/ 
      //START JInit
      this.NameAsWritten = new std.string($Prm0.NameAsWritten);
      this.Entry = $Prm0.Entry;
      //END JInit
    }
    
    
    public String toString() {
      return "" + "NameAsWritten=" + NameAsWritten // NOI18N
                + ", Entry=" + Entry; // NOI18N
    }

    // JAVA: default constuctor
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public static final Header EMPTY = new Header();
    
    private Header() {
      this.NameAsWritten = new std.string();
      this.Entry = null;
    }

    // JAVA: initialization constuctor
    public Header(string NameAsWritten, FileEntry Entry) {
      this.NameAsWritten = NameAsWritten;
      this.Entry = Entry;
    }
    public Header(StringRef NameAsWritten, FileEntry Entry) {
      this.NameAsWritten = NameAsWritten.$string();
      this.Entry = Entry;
    }
    public Header(char$ptr NameAsWritten, FileEntry Entry) {
      this.NameAsWritten = new std.string(NameAsWritten);
      this.Entry = Entry;
    }
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    @Override
    public Header $assign(Header other) {
      assert this != EMPTY;
      this.NameAsWritten.$assign(other.NameAsWritten);
      this.Entry = other.Entry;
      return this;
    }
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    @Override
    public Header $assignMove(Header other) {
      assert other != EMPTY;
      assert this != EMPTY;
      this.NameAsWritten.$assignMove(other.NameAsWritten);
      this.Entry = other.Entry;
      return this;
    }

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    @Override
    public Header clone() {
      return new Header(this);
    }

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    @Override
    public Header move() {
      return new Header(JD$Move.INSTANCE, this);
    }

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    @Override
    public boolean $noteq(Header other) {
      return !$eq(other);
    }

    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    @Override
    public boolean $eq(Header other) {
      return this.Entry == other.Entry && this.NameAsWritten.$eq(other.NameAsWritten);
    }
  };
  
  /// \brief Information about a directory name as found in the module map
  /// file.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::DirectoryName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 118,
   FQN="clang::Module::DirectoryName", NM="_ZN5clang6Module13DirectoryNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module13DirectoryNameE")
  //</editor-fold>
  public static class/*struct*/ DirectoryName implements Destructors.ClassWithDestructor, Native.Native$Bool  {
    public std.string NameAsWritten;
    public /*const*/ DirectoryEntry /*P*/ Entry;

    //<editor-fold defaultstate="collapsed" desc="clang::Module::DirectoryName::operator bool">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 122,
     FQN="clang::Module::DirectoryName::operator bool", NM="_ZN5clang6Module13DirectoryNamecvbEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module13DirectoryNamecvbEv")
    //</editor-fold>
    public boolean $bool() {
      return (Entry != null);
    }
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public /*inline*/ DirectoryName(char$ptr NameAsWritten, /*const*/ DirectoryEntry /*P*/ Entry) {
      this.NameAsWritten = new std.string(NameAsWritten);
      this.Entry = Entry;
    }
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public /*inline*/ DirectoryName(std.string NameAsWritten, /*const*/ DirectoryEntry /*P*/ Entry) {
      this.NameAsWritten = NameAsWritten;
      this.Entry = Entry;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Module::DirectoryName::DirectoryName">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 118,
     FQN="clang::Module::DirectoryName::DirectoryName", NM="_ZN5clang6Module13DirectoryNameC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module13DirectoryNameC1EOS1_")
    //</editor-fold>
    public /*inline*/ DirectoryName(JD$Move _dparam, DirectoryName /*&&*/$Prm0) {
      /* : NameAsWritten(static_cast<DirectoryName &&>().NameAsWritten), Entry(static_cast<DirectoryName &&>().Entry)*/ 
      //START JInit
      this.NameAsWritten = new std.string(JD$Move.INSTANCE, $Prm0.NameAsWritten);
      this.Entry = $Prm0.Entry;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Module::DirectoryName::~DirectoryName">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 118,
     FQN="clang::Module::DirectoryName::~DirectoryName", NM="_ZN5clang6Module13DirectoryNameD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module13DirectoryNameD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      NameAsWritten.$destroy();
      //END JDestroy
    }


    public String toString() {
      return "" + "NameAsWritten=" + NameAsWritten // NOI18N
                + ", Entry=" + Entry; // NOI18N
    }
  }
  
  /// \brief The headers that are part of this module.
  public SmallVector<Header> Headers[/*5*/] = new SmallVector[5];
  
  /// \brief Stored information about a header directive that was found in the
  /// module map file but has not been resolved to a file.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedHeaderDirective">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 130,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 110,
   FQN = "clang::Module::UnresolvedHeaderDirective", NM = "_ZN5clang6Module25UnresolvedHeaderDirectiveE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module25UnresolvedHeaderDirectiveE")
  //</editor-fold>
  public static class/*struct*/ UnresolvedHeaderDirective implements Destructors.ClassWithDestructor, Native.NativePOD<UnresolvedHeaderDirective> {
    public SourceLocation FileNameLoc;
    public std.string FileName;
    public boolean IsUmbrella;   
    //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedHeaderDirective::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 130,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 110,
     FQN = "clang::Module::UnresolvedHeaderDirective::operator=", NM = "_ZN5clang6Module25UnresolvedHeaderDirectiveaSERKS1_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module25UnresolvedHeaderDirectiveaSERKS1_")
    //</editor-fold>
    @Override public /*inline*/ UnresolvedHeaderDirective /*&*/ $assign(/*const*/ UnresolvedHeaderDirective /*&*/ $Prm0) {
      this.FileNameLoc.$assign($Prm0.FileNameLoc);
      this.FileName.$assign($Prm0.FileName);
      this.IsUmbrella = $Prm0.IsUmbrella;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedHeaderDirective::~UnresolvedHeaderDirective">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 130,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 110,
     FQN = "clang::Module::UnresolvedHeaderDirective::~UnresolvedHeaderDirective", NM = "_ZN5clang6Module25UnresolvedHeaderDirectiveD0Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module25UnresolvedHeaderDirectiveD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      FileName.$destroy();
      //END JDestroy
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedHeaderDirective::UnresolvedHeaderDirective">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 130,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 110,
     FQN="clang::Module::UnresolvedHeaderDirective::UnresolvedHeaderDirective", NM="_ZN5clang6Module25UnresolvedHeaderDirectiveC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang6Module25UnresolvedHeaderDirectiveC1ERKS1_")
    //</editor-fold>
    public /*inline*/ UnresolvedHeaderDirective(/*const*/ UnresolvedHeaderDirective /*&*/ $Prm0) {
      /* : FileNameLoc(.FileNameLoc), FileName(.FileName), IsUmbrella(.IsUmbrella)*/ 
      //START JInit
      this.FileNameLoc = new SourceLocation($Prm0.FileNameLoc);
      this.FileName = new std.string($Prm0.FileName);
      this.IsUmbrella = $Prm0.IsUmbrella;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedHeaderDirective::UnresolvedHeaderDirective">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 130,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 110,
     FQN="clang::Module::UnresolvedHeaderDirective::UnresolvedHeaderDirective", NM="_ZN5clang6Module25UnresolvedHeaderDirectiveC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang6Module25UnresolvedHeaderDirectiveC1EOS1_")
    //</editor-fold>
    public /*inline*/ UnresolvedHeaderDirective(JD$Move _dparam, UnresolvedHeaderDirective /*&&*/$Prm0) {
      /* : FileNameLoc(static_cast<UnresolvedHeaderDirective &&>().FileNameLoc), FileName(static_cast<UnresolvedHeaderDirective &&>().FileName), IsUmbrella(static_cast<UnresolvedHeaderDirective &&>().IsUmbrella)*/ 
      //START JInit
      this.FileNameLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.FileNameLoc);
      this.FileName = new std.string(JD$Move.INSTANCE, $Prm0.FileName);
      this.IsUmbrella = $Prm0.IsUmbrella;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedHeaderDirective::UnresolvedHeaderDirective">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 130,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 110,
     FQN="clang::Module::UnresolvedHeaderDirective::UnresolvedHeaderDirective", NM="_ZN5clang6Module25UnresolvedHeaderDirectiveC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang6Module25UnresolvedHeaderDirectiveC1Ev")
    //</editor-fold>
    public /*inline*/ UnresolvedHeaderDirective() {
      /* : FileNameLoc(), FileName()*/ 
      //START JInit
      this.FileNameLoc = new SourceLocation();
      this.FileName = new std.string();
      //END JInit
      this.IsUmbrella = false;
    }
    
    
    public String toString() {
      return "" + "FileNameLoc=" + FileNameLoc // NOI18N
                + ", FileName=" + FileName // NOI18N
                + ", IsUmbrella=" + IsUmbrella; // NOI18N
    }

    @Override
    public UnresolvedHeaderDirective clone() {
      return new UnresolvedHeaderDirective().$assign(this);
    }

    @Override
    public boolean $noteq(UnresolvedHeaderDirective other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(UnresolvedHeaderDirective other) {
      return this.IsUmbrella == other.IsUmbrella && this.FileNameLoc.$eq(other.FileNameLoc) &&
              this.FileName.$eq(other.FileName);
    }
  };
  
  /// \brief Headers that are mentioned in the module map file but could not be
  /// found on the file system.
  public SmallVector<UnresolvedHeaderDirective> MissingHeaders;
  
  /// \brief An individual requirement: a feature name and a flag indicating
  /// the required state of that feature.
  /*typedef std::pair<std::string, bool> Requirement*/
//  public final class Requirement extends std.pairTypeBool<std.string>{ };
  
  /// \brief An individual requirement: a feature name and a flag indicating
  /// the required state of that feature.
  /*typedef std::pair<std::string, bool> Requirement*/
  public final class Requirement extends std.pairTypeBool<std.string>{

    private Requirement() {
      super(new std.string(), false);
    }
    
    public Requirement(string first, boolean second) {
      super(first, second);
    }

    @Override
    public pairTypeBool<string> clone() {
      return new Requirement(super.first, super.second);
    }
  };
  
  /// \brief The set of language features required to use this module.
  ///
  /// If any of these requirements are not available, the \c IsAvailable bit
  /// will be false to indicate that this (sub)module is not available.
  public SmallVector<Requirement> Requirements;
  
  /// \brief Whether this module is missing a feature from \c Requirements.
  public /*JBIT unsigned int*/ boolean IsMissingRequirement /*: 1*/;
  
  /// \brief Whether we tried and failed to load a module file for this module.
  public /*JBIT unsigned int*/ boolean HasIncompatibleModuleFile /*: 1*/;
  
  /// \brief Whether this module is available in the current translation unit.
  ///
  /// If the module is missing headers or does not meet all requirements then
  /// this bit will be 0.
  public /*JBIT unsigned int*/ boolean IsAvailable /*: 1*/;
  
  /// \brief Whether this module was loaded from a module file.
  public /*JBIT unsigned int*/ boolean IsFromModuleFile /*: 1*/;
  
  /// \brief Whether this is a framework module.
  public /*JBIT unsigned int*/ boolean IsFramework /*: 1*/;
  
  /// \brief Whether this is an explicit submodule.
  public /*JBIT unsigned int*/ boolean IsExplicit /*: 1*/;
  
  /// \brief Whether this is a "system" module (which assumes that all
  /// headers in it are system headers).
  public /*JBIT unsigned int*/ boolean IsSystem /*: 1*/;
  
  /// \brief Whether this is an 'extern "C"' module (which implicitly puts all
  /// headers in it within an 'extern "C"' block, and allows the module to be
  /// imported within such a block).
  public /*JBIT unsigned int*/ boolean IsExternC /*: 1*/;
  
  /// \brief Whether this is an inferred submodule (module * { ... }).
  public /*JBIT unsigned int*/ boolean IsInferred /*: 1*/;
  
  /// \brief Whether we should infer submodules for this module based on 
  /// the headers.
  ///
  /// Submodules can only be inferred for modules with an umbrella header.
  public /*JBIT unsigned int*/ boolean InferSubmodules /*: 1*/;
  
  /// \brief Whether, when inferring submodules, the inferred submodules
  /// should be explicit.
  public /*JBIT unsigned int*/ boolean InferExplicitSubmodules /*: 1*/;
  
  /// \brief Whether, when inferring submodules, the inferr submodules should
  /// export all modules they import (e.g., the equivalent of "export *").
  public /*JBIT unsigned int*/ boolean InferExportWildcard /*: 1*/;
  
  /// \brief Whether the set of configuration macros is exhaustive.
  ///
  /// When the set of configuration macros is exhaustive, meaning
  /// that no identifier not in this list should affect how the module is
  /// built.
  public /*JBIT unsigned int*/ boolean ConfigMacrosExhaustive /*: 1*/;
  
  /// \brief Describes the visibility of the various names within a
  /// particular module.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::NameVisibilityKind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 206,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 183,
   FQN="clang::Module::NameVisibilityKind", NM="_ZN5clang6Module18NameVisibilityKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module18NameVisibilityKindE")
  //</editor-fold>
  public enum NameVisibilityKind implements Native.ComparableLower {
    /// \brief All of the names in this module are hidden.
    Hidden(0),
    /// \brief All of the names in this module are visible.
    AllVisible(Hidden.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NameVisibilityKind valueOf(int val) {
      NameVisibilityKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NameVisibilityKind[] VALUES;
      private static final NameVisibilityKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NameVisibilityKind kind : NameVisibilityKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NameVisibilityKind[min < 0 ? (1-min) : 0];
        VALUES = new NameVisibilityKind[max >= 0 ? (1+max) : 0];
        for (NameVisibilityKind kind : NameVisibilityKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private NameVisibilityKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NameVisibilityKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NameVisibilityKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief The visibility of names within this particular module.
  public NameVisibilityKind NameVisibility;
  
  /// \brief The location of the inferred submodule.
  public SourceLocation InferredSubmoduleLoc;
  
  /// \brief The set of modules imported by this module, and on which this
  /// module depends.
  public SmallSetVector<Module /*P*/> Imports;
  
  /// \brief Describes an exported module.
  ///
  /// The pointer is the module being re-exported, while the bit will be true
  /// to indicate that this is a wildcard export.
  /*typedef llvm::PointerIntPair<Module *, 1, bool> ExportDecl*/
//  public final class ExportDecl extends PointerBoolPair</*const*/ Module/*P*/>{ };
  
  /// \brief The set of export declarations.
  public SmallVector<PointerInt2Pair</*const*/ Module/*P*/>> Exports;
  
  /// \brief Describes an exported module that has not yet been resolved
  /// (perhaps because the module it refers to has not yet been loaded).
  //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedExportDecl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 234,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 217,
   FQN = "clang::Module::UnresolvedExportDecl", NM = "_ZN5clang6Module20UnresolvedExportDeclE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module20UnresolvedExportDeclE")
  //</editor-fold>
  public static class/*struct*/ UnresolvedExportDecl implements Native.NativePOD<UnresolvedExportDecl> {
    /// \brief The location of the 'export' keyword in the module map file.
    public SourceLocation ExportLoc;

    /// \brief The name of the module.
    public ClankAliases.ModuleId Id;

    /// \brief Whether this export declaration ends in a wildcard, indicating
    /// that all of its submodules should be exported (rather than the named
    /// module itself).
    public boolean Wildcard;
    //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedExportDecl::~UnresolvedExportDecl">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 234,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 217,
     FQN="clang::Module::UnresolvedExportDecl::~UnresolvedExportDecl", NM="_ZN5clang6Module20UnresolvedExportDeclD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module20UnresolvedExportDeclD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Id.$destroy();
      //END JDestroy
    }
    

    //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedExportDecl::UnresolvedExportDecl">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 234,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 217,
     FQN="clang::Module::UnresolvedExportDecl::UnresolvedExportDecl", NM="_ZN5clang6Module20UnresolvedExportDeclC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang6Module20UnresolvedExportDeclC1EOS1_")
    //</editor-fold>
    public /*inline*/ UnresolvedExportDecl(JD$Move _dparam, UnresolvedExportDecl /*&&*/$Prm0) {
      /* : ExportLoc(static_cast<UnresolvedExportDecl &&>().ExportLoc), Id(static_cast<UnresolvedExportDecl &&>().Id), Wildcard(static_cast<UnresolvedExportDecl &&>().Wildcard)*/ 
      //START JInit
      this.ExportLoc = $Prm0.ExportLoc;
      this.Id = $Prm0.Id;
      this.Wildcard = $Prm0.Wildcard;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedExportDecl::operator=">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 234,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 217,
     FQN="clang::Module::UnresolvedExportDecl::operator=", NM="_ZN5clang6Module20UnresolvedExportDeclaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang6Module20UnresolvedExportDeclaSEOS1_")
    //</editor-fold>
    public /*inline*/ UnresolvedExportDecl /*&*/ $assignMove(UnresolvedExportDecl /*&&*/$Prm0) {
      this.ExportLoc.$assignMove($Prm0.ExportLoc);
      this.Id.$assignMove($Prm0.Id);
      this.Wildcard = $Prm0.Wildcard;
      return /*Deref*/this;
    }    
    

    //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedExportDecl::UnresolvedExportDecl">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 234,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 217,
     FQN="clang::Module::UnresolvedExportDecl::UnresolvedExportDecl", NM="_ZN5clang6Module20UnresolvedExportDeclC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang6Module20UnresolvedExportDeclC1ERKS1_")
    //</editor-fold>
    public /*inline*/ UnresolvedExportDecl(/*const*/ UnresolvedExportDecl /*&*/ $Prm0) {
      /* : ExportLoc(.ExportLoc), Id(.Id), Wildcard(.Wildcard)*/ 
      //START JInit
      this.ExportLoc = new SourceLocation($Prm0.ExportLoc);
      this.Id = new ClankAliases.ModuleId($Prm0.Id);
      this.Wildcard = $Prm0.Wildcard;
      //END JInit
    }
    
    public UnresolvedExportDecl(SourceLocation ExportLoc, ClankAliases.ModuleId Id, boolean Wildcard) {
      this.ExportLoc = new SourceLocation(ExportLoc);
      this.Id = Id;
      this.Wildcard = Wildcard;
    }

    public UnresolvedExportDecl() {
      this.ExportLoc = new SourceLocation();
      this.Id = new ClankAliases.ModuleId();
      this.Wildcard = false;
    }

    public String toString() {
      return "" + "ExportLoc=" + ExportLoc // NOI18N
              + ", Id=" + Id // NOI18N
              + ", Wildcard=" + Wildcard; // NOI18N
    }

    @Override
    public UnresolvedExportDecl $assign(UnresolvedExportDecl other) {
      this.ExportLoc.$assign(other.ExportLoc);
      this.Id.$assign(other.Id);
      this.Wildcard = other.Wildcard;
      return this;
    }

    @Override
    @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
    public UnresolvedExportDecl clone() {
      return new UnresolvedExportDecl().$assign(this);
    }

    @Override
    public boolean $noteq(UnresolvedExportDecl other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(UnresolvedExportDecl other) {
      return this.Wildcard == other.Wildcard && this.ExportLoc.$eq(other.ExportLoc) &&
              this.Id.$eq(other.Id);
    }
  };
  
  /// \brief The set of export declarations that have yet to be resolved.
  public SmallVector<UnresolvedExportDecl> UnresolvedExports;
  
  /// \brief The directly used modules.
  public SmallVector<Module /*P*/> DirectUses;
  
  /// \brief The set of use declarations that have yet to be resolved.
  public SmallVector<ClankAliases.ModuleId> UnresolvedDirectUses;
  
  /// \brief A library or framework to link against when an entity from this
  /// module is used.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::LinkLibrary">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 258,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 241,
   FQN = "clang::Module::LinkLibrary", NM = "_ZN5clang6Module11LinkLibraryE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module11LinkLibraryE")
  //</editor-fold>
  public static class/*struct*/ LinkLibrary implements Destructors.ClassWithDestructor, Native.NativePOD<LinkLibrary> {
    //<editor-fold defaultstate="collapsed" desc="clang::Module::LinkLibrary::LinkLibrary">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 259,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 242,
     FQN = "clang::Module::LinkLibrary::LinkLibrary", NM = "_ZN5clang6Module11LinkLibraryC1Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module11LinkLibraryC1Ev")
    //</editor-fold>
    public LinkLibrary() {
      /* : Library(), IsFramework(false)*/ 
      //START JInit
      this.Library = new std.string();
      this.IsFramework = false;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Module::LinkLibrary::LinkLibrary">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 260,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 243,
     FQN = "clang::Module::LinkLibrary::LinkLibrary", NM = "_ZN5clang6Module11LinkLibraryC1ERKSsb",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module11LinkLibraryC1ERKSsb")
    //</editor-fold>
    public LinkLibrary(/*const*/std.string/*&*/ Library, boolean IsFramework) {
      /* : Library(Library), IsFramework(IsFramework)*/ 
      //START JInit
      this.Library = new std.string(Library);
      this.IsFramework = IsFramework;
      //END JInit
    }

    
    /// \brief The library to link against.
    ///
    /// This will typically be a library or framework name, but can also
    /// be an absolute path to the library or framework.
    public std.string Library;
    
    /// \brief Whether this is a framework rather than a library.
    public boolean IsFramework;
    //<editor-fold defaultstate="collapsed" desc="clang::Module::LinkLibrary::~LinkLibrary">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 258,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 241,
     FQN = "clang::Module::LinkLibrary::~LinkLibrary", NM = "_ZN5clang6Module11LinkLibraryD0Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module11LinkLibraryD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Library.$destroy();
      //END JDestroy
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Module::LinkLibrary::LinkLibrary">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 258,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 241,
     FQN="clang::Module::LinkLibrary::LinkLibrary", NM="_ZN5clang6Module11LinkLibraryC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang6Module11LinkLibraryC1EOS1_")
    //</editor-fold>
    public /*inline*/ LinkLibrary(JD$Move _dparam, LinkLibrary /*&&*/$Prm0) {
      /* : Library(static_cast<LinkLibrary &&>().Library), IsFramework(static_cast<LinkLibrary &&>().IsFramework)*/ 
      //START JInit
      this.Library = new std.string(JD$Move.INSTANCE, $Prm0.Library);
      this.IsFramework = $Prm0.IsFramework;
      //END JInit
    }

    
    public String toString() {
      return "" + "Library=" + Library // NOI18N
                + ", IsFramework=" + IsFramework; // NOI18N
    }

    @Override
    public LinkLibrary $assign(LinkLibrary other) {
      this.Library.$assign(other.Library);
      this.IsFramework = other.IsFramework;
      return this;
    }

    @Override
    @SuppressWarnings({"CloneDeclaresCloneNotSupported", "CloneDoesntCallSuperClone"})
    public LinkLibrary clone() {
      return new LinkLibrary(this.Library, this.IsFramework);
    }

    @Override
    public boolean $noteq(LinkLibrary other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(LinkLibrary other) {
      return this.IsFramework == other.IsFramework && this.Library.$eq(other.Library);
    }
  };
  
  /// \brief The set of libraries or frameworks to link against when
  /// an entity from this module is used.
  public SmallVector<LinkLibrary> LinkLibraries;
  
  /// \brief The set of "configuration macros", which are macros that
  /// (intentionally) change how this module is built.
  public std.vectorString ConfigMacros;
  
  /// \brief An unresolved conflict with another module.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedConflict">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 282,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 265,
   FQN = "clang::Module::UnresolvedConflict", NM = "_ZN5clang6Module18UnresolvedConflictE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module18UnresolvedConflictE")
  //</editor-fold>
  public static class/*struct*/ UnresolvedConflict implements Destructors.ClassWithDestructor, NativePOD<UnresolvedConflict> {
    /// \brief The (unresolved) module id.
    public ClankAliases.ModuleId Id;
    
    /// \brief The message provided to the user when there is a conflict.
    public std.string Message;
    //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedConflict::~UnresolvedConflict">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 282,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 265,
     FQN = "clang::Module::UnresolvedConflict::~UnresolvedConflict", NM = "_ZN5clang6Module18UnresolvedConflictD0Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module18UnresolvedConflictD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Message.$destroy();
      Id.$destroy();
      //END JDestroy
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedConflict::UnresolvedConflict">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 282,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 265,
     FQN="clang::Module::UnresolvedConflict::UnresolvedConflict", NM="_ZN5clang6Module18UnresolvedConflictC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang6Module18UnresolvedConflictC1ERKS1_")
    //</editor-fold>
    public /*inline*/ UnresolvedConflict(/*const*/ UnresolvedConflict /*&*/ $Prm0) {
      /* : Id(.Id), Message(.Message)*/ 
      //START JInit
      this.Id = new ClankAliases.ModuleId($Prm0.Id);
      this.Message = new std.string($Prm0.Message);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Module::UnresolvedConflict::UnresolvedConflict">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 282,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 265,
     FQN="clang::Module::UnresolvedConflict::UnresolvedConflict", NM="_ZN5clang6Module18UnresolvedConflictC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang6Module18UnresolvedConflictC1Ev")
    //</editor-fold>
    public /*inline*/ UnresolvedConflict() {
      /* : Id(), Message()*/ 
      //START JInit
      this.Id = new ClankAliases.ModuleId();
      this.Message = new std.string();
      //END JInit
    }

    @Override
    public UnresolvedConflict $assign(UnresolvedConflict other) {
      this.Id = new ClankAliases.ModuleId(other.Id);
      this.Message = new std.string(other.Message);
      return this;
    }

    @Override
    public UnresolvedConflict clone() {
      return new UnresolvedConflict(this);
    }

    @Override
    public UnresolvedConflict $assignMove(UnresolvedConflict other) {
      this.Id = other.Id;
      this.Message = other.Message;
      other.Id = null;
      other.Message = null;
      return this;
    }
    
    public String toString() {
      return "" + "Id=" + Id // NOI18N
                + ", Message=" + Message; // NOI18N
    }
  };
  
  /// \brief The list of conflicts for which the module-id has not yet been
  /// resolved.
  public std.vector<UnresolvedConflict> UnresolvedConflicts;
  
  /// \brief A conflict between two modules.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::Conflict">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 295,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 278,
   FQN = "clang::Module::Conflict", NM = "_ZN5clang6Module8ConflictE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module8ConflictE")
  //</editor-fold>
  public static class/*struct*/ Conflict implements Destructors.ClassWithDestructor, NativePOD<Conflict> {
    /// \brief The module that this module conflicts with.
    public Module /*P*/ Other;
    
    /// \brief The message provided to the user when there is a conflict.
    public std.string Message;
    //<editor-fold defaultstate="collapsed" desc="clang::Module::Conflict::~Conflict">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 295,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 278,
     FQN = "clang::Module::Conflict::~Conflict", NM = "_ZN5clang6Module8ConflictD0Ev",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module8ConflictD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Message.$destroy();
      //END JDestroy
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Module::Conflict::Conflict">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 295,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 278,
     FQN="clang::Module::Conflict::Conflict", NM="_ZN5clang6Module8ConflictC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang6Module8ConflictC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Conflict(/*const*/ Conflict /*&*/ $Prm0) {
      /* : Other(.Other), Message(.Message)*/ 
      //START JInit
      this.Other = $Prm0.Other;
      this.Message = new std.string($Prm0.Message);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Module::Conflict::Conflict">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 295,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 278,
     FQN="clang::Module::Conflict::Conflict", NM="_ZN5clang6Module8ConflictC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang6Module8ConflictC1EOS1_")
    //</editor-fold>
    public /*inline*/ Conflict(JD$Move _dparam, Conflict /*&&*/$Prm0) {
      /* : Other(static_cast<Conflict &&>().Other), Message(static_cast<Conflict &&>().Message)*/ 
      //START JInit
      this.Other = $Prm0.Other;
      this.Message = new std.string(JD$Move.INSTANCE, $Prm0.Message);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Module::Conflict::Conflict">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 295,
     old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 278,
     FQN="clang::Module::Conflict::Conflict", NM="_ZN5clang6Module8ConflictC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang6Module8ConflictC1Ev")
    //</editor-fold>
    public /*inline*/ Conflict() {
      /* : Message()*/ 
      //START JInit
      this.Message = new std.string();
      //END JInit
    }

    
    public String toString() {
      return "" + "Other=" + Other // NOI18N
                + ", Message=" + Message; // NOI18N
    }

    @Override
    public Conflict $assign(Conflict other) {
      this.Other = other.Other;
      this.Message = new std.string(other.Message);
      return this;
    }

    @Override
    public Conflict clone() {
      return new Conflict(this);
    }

    @Override
    public Conflict $assignMove(Conflict other) {
      this.Other = other.Other;
      this.Message = other.Message;
      other.Other = null;
      other.Message = null;
      return this;
    }
  };
  
  /// \brief The list of conflicts.
  public std.vector<Conflict> Conflicts;
  
  /// \brief Construct a new module or submodule.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::Module">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 27,
   FQN="clang::Module::Module", NM="_ZN5clang6ModuleC1EN4llvm9StringRefENS_14SourceLocationEPS0_bbj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6ModuleC1EN4llvm9StringRefENS_14SourceLocationEPS0_bbj")
  //</editor-fold>
  public Module(StringRef Name, SourceLocation DefinitionLoc, Module /*P*/ Parent, 
      boolean IsFramework, boolean IsExplicit, /*uint*/int VisibilityID) {
    /* : Name(Name.operator basic_string()), DefinitionLoc(DefinitionLoc), Parent(Parent), Directory(implicit const DirectoryEntry * ()), Umbrella(), Signature(0), UmbrellaAsWritten(), SubModules(), SubModuleIndex(), ASTFile(null), TopHeaders(), TopHeaderNames(), VisibleModulesCache(), VisibilityID(VisibilityID), Headers(), MissingHeaders(), Requirements(), IsMissingRequirement(false), HasIncompatibleModuleFile(false), IsAvailable(true), IsFromModuleFile(false), IsFramework(IsFramework), IsExplicit(IsExplicit), IsSystem(false), IsExternC(false), IsInferred(false), InferSubmodules(false), InferExplicitSubmodules(false), InferExportWildcard(false), ConfigMacrosExhaustive(false), NameVisibility(Hidden), InferredSubmoduleLoc(), Imports(), Exports(), UnresolvedExports(), DirectUses(), UnresolvedDirectUses(), LinkLibraries(), ConfigMacros(), UnresolvedConflicts(), Conflicts()*/ 
    //START JInit
    this.Name = Name.$string();
    this.DefinitionLoc = new SourceLocation(DefinitionLoc);
    this.Parent = Parent;
    this.Directory = /*implicit-init*/((/*const*/ DirectoryEntry /*P*/ )/*zero-init*/null);
    this.Umbrella = new PointerUnion</*const*/ DirectoryEntry /*P*/ , /*const*/ FileEntry /*P*/ >(DirectoryEntry.class);
    this.Signature = 0;
    this.UmbrellaAsWritten = new std.string();
    this.SubModules = new std.vector<Module /*P*/ >((Module /*P*/) null);
    this.SubModuleIndex = new StringMapUInt(0);
    this.ASTFile = null;
    this.TopHeaders = new SmallSetVector</*const*/ FileEntry /*P*/>(2, (FileEntry/*P*/)null);
    this.TopHeaderNames = new std.vectorString(std.string.EMPTY);
    this.VisibleModulesCache = new DenseSet</*const*/ Module /*P*/ >(DenseMapInfo$LikePtr.$Info());
    this.VisibilityID = VisibilityID;
    this.Headers = new$T(new SmallVector[5], ()->new SmallVector<Header>(2, Header.EMPTY));
    this.MissingHeaders = new SmallVector<UnresolvedHeaderDirective>(1, new UnresolvedHeaderDirective());
    this.Requirements = new SmallVector<Requirement>(2, new Requirement());
    this.IsMissingRequirement = false;
    this.HasIncompatibleModuleFile = false;
    this.IsAvailable = true;
    this.IsFromModuleFile = false;
    this.IsFramework = IsFramework;
    this.IsExplicit = IsExplicit;
    this.IsSystem = false;
    this.IsExternC = false;
    this.IsInferred = false;
    this.InferSubmodules = false;
    this.InferExplicitSubmodules = false;
    this.InferExportWildcard = false;
    this.ConfigMacrosExhaustive = false;
    this.NameVisibility = NameVisibilityKind.Hidden;
    this.InferredSubmoduleLoc = new SourceLocation();
    this.Imports = new SmallSetVector<Module /*P*/>(2, (Module /*P*/) null);
    this.Exports = new SmallVector<PointerInt2Pair</*const*/ Module/*P*/>>(2, new PointerInt2Pair</*const*/ Module/*P*/>());
    this.UnresolvedExports = new SmallVector<UnresolvedExportDecl>(2, new UnresolvedExportDecl());
    this.DirectUses = new SmallVector<Module /*P*/>(2, (Module /*P*/)null);
    this.UnresolvedDirectUses = new SmallVector<ClankAliases.ModuleId>(2, new ClankAliases.ModuleId());
    this.LinkLibraries = new SmallVector<LinkLibrary>(2, new LinkLibrary());
    this.ConfigMacros = new std.vectorString(std.string.EMPTY);
    this.UnresolvedConflicts = new std.vector<UnresolvedConflict>(new UnresolvedConflict());
    this.Conflicts = new std.vector<Conflict>(new Conflict());
    //END JInit
    if ((Parent != null)) {
      if (!Parent.isAvailable()) {
        IsAvailable = false;
      }
      if (Parent.IsSystem) {
        IsSystem = true;
      }
      if (Parent.IsExternC) {
        IsExternC = true;
      }
      IsMissingRequirement = Parent.IsMissingRequirement;

      Parent.SubModuleIndex.$set(/*NO_COPY*/Name, Parent.SubModules.size());
      Parent.SubModules.push_back(this);
    }
  }

  public Module(char$ptr/*char P*/ Buffer) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Module::~Module">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 51,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 50,
   FQN = "clang::Module::~Module", NM = "_ZN5clang6ModuleD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6ModuleD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (std.vector.iterator<Module /*P*/ > I = submodule_begin(), IEnd = submodule_end();
         $noteq___normal_iterator$C(I, IEnd); I.$preInc()) {
      if (I.$star() != null) { I.$star().$destroy();};
    }
    //START JDestroy
    Conflicts.$destroy();
    UnresolvedConflicts.$destroy();
    ConfigMacros.$destroy();
    LinkLibraries.$destroy();
    UnresolvedDirectUses.$destroy();
    DirectUses.$destroy();
    UnresolvedExports.$destroy();
    Exports.$destroy();
    Imports.$destroy();
    Requirements.$destroy();
    MissingHeaders.$destroy();
    Destructors.$destroyArray(Headers);
    VisibleModulesCache.$destroy();
    TopHeaderNames.$destroy();
    TopHeaders.$destroy();
    SubModuleIndex.$destroy();
    SubModules.$destroy();
    UmbrellaAsWritten.$destroy();
    Name.$destroy();
    //END JDestroy
  }

  
  /// \brief Determine whether this module is available for use within the
  /// current translation unit.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::isAvailable">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 314,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 297,
   FQN = "clang::Module::isAvailable", NM = "_ZNK5clang6Module11isAvailableEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module11isAvailableEv")
  //</editor-fold>
  public boolean isAvailable() /*const*/ {
    return IsAvailable;
  }

  
  /// \brief Determine whether this module is available for use within the
  /// current translation unit.
  ///
  /// \param LangOpts The language options used for the current
  /// translation unit.
  ///
  /// \param Target The target options used for the current translation unit.
  ///
  /// \param Req If this module is unavailable, this parameter
  /// will be set to one of the requirements that is not met for use of
  /// this module.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::isAvailable">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 80,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 73,
   FQN = "clang::Module::isAvailable", NM = "_ZNK5clang6Module11isAvailableERKNS_11LangOptionsERKNS_10TargetInfoERSt4pairISsbERNS0_25UnresolvedHeaderDirectiveE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module11isAvailableERKNS_11LangOptionsERKNS_10TargetInfoERSt4pairISsbERNS0_25UnresolvedHeaderDirectiveE")
  //</editor-fold>
  public boolean isAvailable(/*const*/ LangOptions /*&*/ LangOpts, /*const*/ TargetInfo /*&*/ Target, 
             std.pairTypeBool<std.string>/*&*/ Req, 
             UnresolvedHeaderDirective /*&*/ MissingHeader) /*const*/ {
    if (IsAvailable) {
      return true;
    }
    
    for (/*const*/ Module /*P*/ Current = this; (Current != null); Current = Current.Parent) {
      for (/*uint*/int I = 0, N = Current.Requirements.size(); I != N; ++I) {
        if (hasFeature(new StringRef(Current.Requirements.$at(I).first), LangOpts, Target)
           != Current.Requirements.$at(I).second) {
          Req.$assign(Current.Requirements.$at(I));
          return false;
        }
      }
      if (!Current.MissingHeaders.empty()) {
        MissingHeader.$assign(Current.MissingHeaders.front());
        return false;
      }
    }
    throw new llvm_unreachable("could not find a reason why module is unavailable");
  }

  
  /// \brief Determine whether this module is a submodule.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::isSubModule">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 333,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 316,
   FQN = "clang::Module::isSubModule", NM = "_ZNK5clang6Module11isSubModuleEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module11isSubModuleEv")
  //</editor-fold>
  public boolean isSubModule() /*const*/ {
    return Parent != null;
  }

  
  /// \brief Determine whether this module is a submodule of the given other
  /// module.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::isSubModuleOf">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 103,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 96,
   FQN = "clang::Module::isSubModuleOf", NM = "_ZNK5clang6Module13isSubModuleOfEPKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module13isSubModuleOfEPKS0_")
  //</editor-fold>
  public boolean isSubModuleOf(/*const*/ Module /*P*/ Other) /*const*/ {
    /*const*/ Module /*P*/ This = this;
    do {
      if (This == Other) {
        return true;
      }
      
      This = This.Parent;
    } while ((This != null));
    
    return false;
  }

  
  /// \brief Determine whether this module is a part of a framework,
  /// either because it is a framework module or because it is a submodule
  /// of a framework module.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::isPartOfFramework">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 342,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 325,
   FQN = "clang::Module::isPartOfFramework", NM = "_ZNK5clang6Module17isPartOfFrameworkEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module17isPartOfFrameworkEv")
  //</editor-fold>
  public boolean isPartOfFramework() /*const*/ {
    for (/*const*/ Module /*P*/ Mod = this; (Mod != null); Mod = Mod.Parent)  {
      if (Mod.IsFramework) {
        return true;
      }
    }
    
    return false;
  }

  
  /// \brief Determine whether this module is a subframework of another
  /// framework.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::isSubFramework">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 352,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 335,
   FQN = "clang::Module::isSubFramework", NM = "_ZNK5clang6Module14isSubFrameworkEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module14isSubFrameworkEv")
  //</editor-fold>
  public boolean isSubFramework() /*const*/ {
    return IsFramework && (Parent != null) && Parent.isPartOfFramework();
  }

  
  /// \brief Retrieve the full name of this module, including the path from
  /// its top-level module.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::getFullModuleName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 123,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 116,
   FQN = "clang::Module::getFullModuleName", NM = "_ZNK5clang6Module17getFullModuleNameEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module17getFullModuleNameEv")
  //</editor-fold>
  public std.string getFullModuleName() /*const*/ {
    SmallVector<StringRef> Names/*J*/= new SmallVector<StringRef>(2, new StringRef());
    
    // Build up the set of module names (from innermost to outermost).
    for (/*const*/ Module /*P*/ M = this; (M != null); M = M.Parent)  {
      Names.push_back(new StringRef(M.Name));
    }
    
    std.string Result/*J*/= new std.string();
    for (std.reverse_iterator<StringRef> I = Names.rbegin(), 
        IEnd = Names.rend();
         $noteq_reverse_iterator$C(I, IEnd); I.$preInc()) {
      if (!Result.empty()) {
        Result.$addassign($$DOT);
      }
      
      $addassign_str_StringRef(Result, /*NO_COPY*/I.$star());
    }
    
    return Result;
  }
  
  
  /// \brief Whether the full name of this module is equal to joining
  /// \p nameParts with "."s.
  ///
  /// This is more efficient than getFullModuleName().
  //<editor-fold defaultstate="collapsed" desc="clang::Module::fullModuleNameIs">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 143,
   FQN="clang::Module::fullModuleNameIs", NM="_ZNK5clang6Module16fullModuleNameIsEN4llvm8ArrayRefINS1_9StringRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module16fullModuleNameIsEN4llvm8ArrayRefINS1_9StringRefEEE")
  //</editor-fold>
  public boolean fullModuleNameIs(ArrayRef<StringRef> nameParts) /*const*/ {
    for (/*const*/ Module /*P*/ M = this; (M != null); M = M.Parent) {
      if (nameParts.empty() || $noteq_StringRef(new StringRef(M.Name), /*NO_COPY*/nameParts.back())) {
        return false;
      }
      nameParts.$assignMove(nameParts.drop_back());
    }
    return nameParts.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Module::getTopLevelModule">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 368,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 345,
   FQN="clang::Module::getTopLevelModule", NM="_ZN5clang6Module17getTopLevelModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module17getTopLevelModuleEv")
  //</editor-fold>
  public Module /*P*/ getTopLevelModule() {
    return ((/*const_cast*/Module /*P*/ )(((/*const_cast*//*const*/ Module /*P*/ )(this)).getTopLevelModule$Const()));
  }

  // JAVA: commented out function above and uncommented the one below
  /// \brief Retrieve the top-level module for this (sub)module, which may
  /// be this module.
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 115,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 108,
   FQN="clang::Module::getTopLevelModule", NM="_ZNK5clang6Module17getTopLevelModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module17getTopLevelModuleEv")
  //</editor-fold>
  public /*const*/ Module /*P*/ getTopLevelModule$Const() /*const*/ {
    /*const*/ Module /*P*/ Result = this;
    while ((Result.Parent != null)) {
      Result = Result.Parent;
    }
    
    return Result;
  }

  
  
  /// \brief Retrieve the name of the top-level module.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Module::getTopLevelModuleName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 379,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 356,
   FQN = "clang::Module::getTopLevelModuleName", NM = "_ZNK5clang6Module21getTopLevelModuleNameEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module21getTopLevelModuleNameEv")
  //</editor-fold>
  public StringRef getTopLevelModuleName() /*const*/ {
    return new StringRef(getTopLevelModule().Name);
  }

  
  /// \brief The serialized AST file for this module, if one was created.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::getASTFile">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 384,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 361,
   FQN = "clang::Module::getASTFile", NM = "_ZNK5clang6Module10getASTFileEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module10getASTFileEv")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ getASTFile() /*const*/ {
    return getTopLevelModule().ASTFile;
  }

  
  /// \brief Set the serialized AST file for the top-level module of this module.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::setASTFile">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 389,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 366,
   FQN = "clang::Module::setASTFile", NM = "_ZN5clang6Module10setASTFileEPKNS_9FileEntryE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module10setASTFileEPKNS_9FileEntryE")
  //</editor-fold>
  public void setASTFile(/*const*/ FileEntry /*P*/ File) {
    assert ((File == null || getASTFile() == null || getASTFile() == File)) : "file path changed";
    getTopLevelModule().ASTFile = File;
  }

  
  /// \brief Retrieve the directory for which this module serves as the
  /// umbrella.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::getUmbrellaDir">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 152,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 136,
   FQN="clang::Module::getUmbrellaDir", NM="_ZNK5clang6Module14getUmbrellaDirEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module14getUmbrellaDirEv")
  //</editor-fold>
  public Module.DirectoryName getUmbrellaDir() /*const*/ {
    {
      Header U = null;
      try {
        U = getUmbrellaHeader();
        if (U.$bool()) {
          return new Module.DirectoryName($EMPTY, U.Entry.getDir());
        }
      } finally {
        if (U != null) { U.$destroy(); }
      }
    }

    return new Module.DirectoryName(UmbrellaAsWritten, Umbrella.dyn_cast(/*const*/ DirectoryEntry.class /*P*/));
  }

  
  /// \brief Retrieve the header that serves as the umbrella header for this
  /// module.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::getUmbrellaHeader">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 401,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 378,
   FQN="clang::Module::getUmbrellaHeader", NM="_ZNK5clang6Module17getUmbrellaHeaderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module17getUmbrellaHeaderEv")
  //</editor-fold>
  public Header getUmbrellaHeader() /*const*/ {
    {
      /*const*/ FileEntry /*P*/ E = Umbrella.dyn_cast(/*const*/ FileEntry.class /*P*/ );
      if ((E != null)) {
        return new Header(UmbrellaAsWritten, E);
      }
    }
    return new Header(/*zero-init*/);
  }

  
  /// \brief Determine whether this module has an umbrella directory that is
  /// not based on an umbrella header.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::hasUmbrellaDir">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 409,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 384,
   FQN = "clang::Module::hasUmbrellaDir", NM = "_ZNK5clang6Module14hasUmbrellaDirEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module14hasUmbrellaDirEv")
  //</editor-fold>
  public boolean hasUmbrellaDir() /*const*/ {
    return Umbrella.$bool() && (Umbrella.is(/*const*/DirectoryEntry.class /*P*/) != 0);
  }

  
  /// \brief Add a top-level header associated with this module.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::addTopHeader">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 414,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 389,
   FQN = "clang::Module::addTopHeader", NM = "_ZN5clang6Module12addTopHeaderEPKNS_9FileEntryE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module12addTopHeaderEPKNS_9FileEntryE")
  //</editor-fold>
  public void addTopHeader(/*const*/FileEntry /*P*/ File) {
    assert (File != null);
    TopHeaders.insert(File);
  }

  
  /// \brief Add a top-level header filename associated with this module.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::addTopHeaderFilename">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 420,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 395,
   FQN = "clang::Module::addTopHeaderFilename", NM = "_ZN5clang6Module20addTopHeaderFilenameEN4llvm9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module20addTopHeaderFilenameEN4llvm9StringRefE")
  //</editor-fold>
  public void addTopHeaderFilename(StringRef Filename) {
    TopHeaderNames.push_back(Filename.$string());
  }

  
  /// \brief The top-level headers associated with this module.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::getTopHeaders">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 159,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 143,
   FQN = "clang::Module::getTopHeaders", NM = "_ZN5clang6Module13getTopHeadersERNS_11FileManagerE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module13getTopHeadersERNS_11FileManagerE")
  //</editor-fold>
  public ArrayRef</*const*/ FileEntry /*P*/ > getTopHeaders(FileManager /*&*/ FileMgr) {
    if (!TopHeaderNames.empty()) {
      for (std.vectorString.iterator I = TopHeaderNames.begin(), E = TopHeaderNames.end(); $noteq___normal_iterator$C(I, E); I.$preInc()) {
        {
          /*const*/ FileEntry /*P*/ FE = FileMgr.getFile(new StringRef(I.$star()));
          if ((FE != null)) {
            TopHeaders.insert(FE);
          }
        }
      }
      TopHeaderNames.clear();
    }
    
    return llvm.makeArrayRef(TopHeaders.begin(), TopHeaders.end(), true);
  }
  
  
  /// \brief Determine whether this module has declared its intention to
  /// directly use another module.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::directlyUses">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 172,
   FQN="clang::Module::directlyUses", NM="_ZNK5clang6Module12directlyUsesEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module12directlyUsesEPKS0_")
  //</editor-fold>
  public boolean directlyUses(/*const*/ Module /*P*/ Requested) /*const*/ {
    /*const*/ Module /*P*/ Top = getTopLevelModule();

    // A top-level module implicitly uses itself.
    if (Requested.isSubModuleOf(Top)) {
      return true;
    }

    for (Module /*P*/ Use : Top.DirectUses)  {
      if (Requested.isSubModuleOf(Use)) {
        return true;
      }
    }
    return false;
  }

  
  /// \brief Add the given feature requirement to the list of features
  /// required by this module.
  ///
  /// \param Feature The feature that is required by this module (and
  /// its submodules).
  ///
  /// \param RequiredState The required state of this feature: \c true
  /// if it must be present, \c false if it must be absent.
  ///
  /// \param LangOpts The set of language options that will be used to
  /// evaluate the availability of this feature.
  ///
  /// \param Target The target options that will be used to evaluate the
  /// availability of this feature.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::addRequirement">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 185,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 156,
   FQN = "clang::Module::addRequirement", NM = "_ZN5clang6Module14addRequirementEN4llvm9StringRefEbRKNS_11LangOptionsERKNS_10TargetInfoE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module14addRequirementEN4llvm9StringRefEbRKNS_11LangOptionsERKNS_10TargetInfoE")
  //</editor-fold>
  public void addRequirement(StringRef Feature, boolean RequiredState, 
                /*const*/ LangOptions /*&*/ LangOpts, 
                /*const*/ TargetInfo /*&*/ Target) {
    Requirements.push_back(new Requirement(Feature.$string(), RequiredState));
    
    // If this feature is currently available, we're done.
    if (hasFeature(new StringRef(Feature), LangOpts, Target) == RequiredState) {
      return;
    }
    
    markUnavailable(/*MissingRequirement*/ true);
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @FunctionalInterface
  private interface markUnavailable_lambda {
    boolean $call(Module /*P*/ M);
  }
  
  /// \brief Mark this module and all of its submodules as unavailable.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::markUnavailable">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 197,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 168,
   FQN="clang::Module::markUnavailable", NM="_ZN5clang6Module15markUnavailableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module15markUnavailableEb")
  //</editor-fold>
  public void markUnavailable() {
    markUnavailable(false);
  }
  public void markUnavailable(boolean MissingRequirement/*= false*/) {
    markUnavailable_lambda needUpdate =  (M) -> 
      {
        return M.IsAvailable || (!M.IsMissingRequirement && MissingRequirement);
      }
  ;
    if (!needUpdate.$call(this)) {
      return;
    }

    SmallVector<Module /*P*/> Stack/*J*/= new SmallVector<Module /*P*/>(2, (Module /*P*/)null);
    Stack.push_back(this);
    while (!Stack.empty()) {
      Module /*P*/ Current = Stack.back();
      Stack.pop_back();
      if (!needUpdate.$call(Current)) {
        continue;
      }

      Current.IsAvailable = false;
      Current.IsMissingRequirement |= MissingRequirement;
      for (std.vector.iterator<Module /*P*/ > Sub = Current.submodule_begin(), 
          SubEnd = Current.submodule_end();
           $noteq___normal_iterator$C(Sub, SubEnd); Sub.$preInc()) {
        if (needUpdate.$call(Sub.$star())) {
          Stack.push_back(Sub.$star());
        }
      }
    }
  }

  
  /// \brief Find the submodule with the given name.
  ///
  /// \returns The submodule if found, or NULL otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::findSubmodule">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 225,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 192,
   FQN = "clang::Module::findSubmodule", NM = "_ZNK5clang6Module13findSubmoduleEN4llvm9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module13findSubmoduleEN4llvm9StringRefE")
  //</editor-fold>
  public Module /*P*/ findSubmodule(StringRef Name) /*const*/ {
    StringMapIteratorUInt Pos = SubModuleIndex.find(/*NO_COPY*/Name);
    if (Pos.$eq(SubModuleIndex.end())) {
      return null;
    }
    
    return SubModules.$at(Pos.$arrow().getValue());
  }

  
  /// \brief Determine whether the specified module would be visible to
  /// a lookup at the end of this module.
  ///
  /// FIXME: This may return incorrect results for (submodules of) the
  /// module currently being built, if it's queried before we see all
  /// of its imports.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::isModuleVisible">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 463,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 434,
   FQN = "clang::Module::isModuleVisible", NM = "_ZNK5clang6Module15isModuleVisibleEPKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module15isModuleVisibleEPKS0_")
  //</editor-fold>
  public boolean isModuleVisible(/*const*/ Module /*P*/ M) /*const*/ {
    if (VisibleModulesCache.empty()) {
      buildVisibleModulesCache();
    }
    return VisibleModulesCache.count(M) != 0;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::Module::getVisibilityID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 469,
   FQN="clang::Module::getVisibilityID", NM="_ZNK5clang6Module15getVisibilityIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module15getVisibilityIDEv")
  //</editor-fold>
  public /*uint*/int getVisibilityID() /*const*/ {
    return VisibilityID;
  }
  
  
  /*typedef std::vector<Module *>::iterator submodule_iterator*/
//  public final class submodule_iterator extends std.vector.iterator<Module /*P*/ >{ };
  /*typedef std::vector<Module *>::const_iterator submodule_const_iterator*/
//  public final class submodule_const_iterator extends std.vector.iterator<Module /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Module::submodule_begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 474,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 443,
   FQN = "clang::Module::submodule_begin", NM = "_ZN5clang6Module15submodule_beginEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module15submodule_beginEv")
  //</editor-fold>
  public std.vector.iterator<Module /*P*/ > submodule_begin() {
    return SubModules.begin();
  }

  ////<editor-fold defaultstate="collapsed" desc="clang::Module::submodule_begin">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 475,
//   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 444,
//   FQN="clang::Module::submodule_begin", NM="_ZNK5clang6Module15submodule_beginEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module15submodule_beginEv")
//  //</editor-fold>
//  public std.vector.iterator<Module /*P*/ > submodule_begin() /*const*/ {
//    return SubModules.begin();
//  }

  //<editor-fold defaultstate="collapsed" desc="clang::Module::submodule_end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 476,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 445,
   FQN = "clang::Module::submodule_end", NM = "_ZN5clang6Module13submodule_endEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module13submodule_endEv")
  //</editor-fold>
  public std.vector.iterator<Module /*P*/ > submodule_end() {
    return SubModules.end();
  }

  ////<editor-fold defaultstate="collapsed" desc="clang::Module::submodule_end">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 477,
//   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 446,
//   FQN="clang::Module::submodule_end", NM="_ZNK5clang6Module13submodule_endEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module13submodule_endEv")
//  //</editor-fold>
//  public std.vector.iterator<Module /*P*/ > submodule_end() /*const*/ {
//    return SubModules.end();
//  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Module::submodules">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 479,
   FQN="clang::Module::submodules", NM="_ZN5clang6Module10submodulesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module10submodulesEv")
  //</editor-fold>
  public iterator_range<Module /*P*/ > submodules() {
    return llvm.make_range(submodule_begin(), submodule_end());
  }
  
  ////<editor-fold defaultstate="collapsed" desc="clang::Module::submodules">
  //@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 482,
  // FQN="clang::Module::submodules", NM="_ZNK5clang6Module10submodulesEv",
  // cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module10submodulesEv")
  ////</editor-fold>
  //public iterator_range<std.vector.iterator<Module /*P*/ > > submodules() /*const*/ {
  //  return llvm.make_range(submodule_begin(), submodule_end());
  //}
  
  
  /// \brief Appends this module's list of exported modules to \p Exported.
  ///
  /// This provides a subset of immediately imported modules (the ones that are
  /// directly exported), not the complete set of exported modules.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::getExportedModules">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 241,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 208,
   FQN = "clang::Module::getExportedModules", NM = "_ZNK5clang6Module18getExportedModulesERN4llvm15SmallVectorImplIPS0_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module18getExportedModulesERN4llvm15SmallVectorImplIPS0_EE")
  //</editor-fold>
  public void getExportedModules(SmallVectorImpl<Module /*P*/ > /*&*/ Exported) /*const*/ {
    // All non-explicit submodules are exported.
    for (std.vector.iterator<Module /*P*/ > I = SubModules.begin(), 
        E = SubModules.end();
         $noteq___normal_iterator(I, E); I.$preInc()) {
      Module /*P*/ Mod = I.$star();
      if (!Mod.IsExplicit) {
        Exported.push_back(Mod);
      }
    }

    // Find re-exported modules by filtering the list of imported modules.
    boolean AnyWildcard = false;
    boolean UnrestrictedWildcard = false;
    SmallVector<Module /*P*/> WildcardRestrictions/*J*/= new SmallVector<Module /*P*/>(4, (Module /*P*/)null);
    for (/*uint*/int I = 0, N = Exports.size(); I != N; ++I) {
      Module /*P*/ Mod = Exports.$at(I).getPointer();
      if (!(Exports.$at(I).getInt() != 0)) {
        // Export a named module directly; no wildcards involved.
        Exported.push_back(Mod);

        continue;
      }

      // Wildcard export: export all of the imported modules that match
      // the given pattern.
      AnyWildcard = true;
      if (UnrestrictedWildcard) {
        continue;
      }
      {

        Module /*P*/ Restriction = Exports.$at(I).getPointer();
        if ((Restriction != null)) {
          WildcardRestrictions.push_back(Restriction);
        } else {
          WildcardRestrictions.clear();
          UnrestrictedWildcard = true;
        }
      }
    }

    // If there were any wildcards, push any imported modules that were
    // re-exported by the wildcard restriction.
    if (!AnyWildcard) {
      return;
    }

    for (/*uint*/int I = 0, N = Imports.size(); I != N; ++I) {
      Module /*P*/ Mod = Imports.$at(I);
      boolean Acceptable = UnrestrictedWildcard;
      if (!Acceptable) {
        // Check whether this module meets one of the restrictions.
        for (/*uint*/int R = 0, NR = WildcardRestrictions.size(); R != NR; ++R) {
          Module /*P*/ Restriction = WildcardRestrictions.$at(R);
          if (Mod == Restriction || Mod.isSubModuleOf(Restriction)) {
            Acceptable = true;
            break;
          }
        }
      }
      if (!Acceptable) {
        continue;
      }

      Exported.push_back(Mod);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Module::getModuleInputBufferName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", line = 492,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Module.h", old_line = 454,
   FQN = "clang::Module::getModuleInputBufferName", NM = "_ZN5clang6Module24getModuleInputBufferNameEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZN5clang6Module24getModuleInputBufferNameEv")
  //</editor-fold>
  public static StringRef getModuleInputBufferName() {
    return new StringRef(/*KEEP_STR*/"<module-includes>");
  }

  
  /// \brief Print the module map for this module to the given stream. 
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::Module::print">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 321,
   FQN="clang::Module::print", NM="_ZNK5clang6Module5printERN4llvm11raw_ostreamEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module5printERN4llvm11raw_ostreamEj")
  //</editor-fold>
  public void print(raw_ostream /*&*/ OS) /*const*/ {
    print(OS, 0);
  }
  public void print(raw_ostream /*&*/ OS, /*uint*/int Indent/*= 0*/) /*const*/ {
    OS.indent(Indent);
    if (IsFramework) {
      OS.$out(/*KEEP_STR*/"framework ");
    }
    if (IsExplicit) {
      OS.$out(/*KEEP_STR*/"explicit ");
    }
    OS.$out(/*KEEP_STR*/"module ").$out(Name);
    if (IsSystem || IsExternC) {
      OS.indent(Indent + 2);
      if (IsSystem) {
        OS.$out(/*KEEP_STR*/" [system]");
      }
      if (IsExternC) {
        OS.$out(/*KEEP_STR*/" [extern_c]");
      }
    }
    
    OS.$out(/*KEEP_STR*/" {\n");
    if (!Requirements.empty()) {
      OS.indent(Indent + 2);
      OS.$out(/*KEEP_STR*/"requires ");
      for (/*uint*/int I = 0, N = Requirements.size(); I != N; ++I) {
        if ((I != 0)) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        if (!Requirements.$at(I).second) {
          OS.$out(/*KEEP_STR*/$EXCLAIM);
        }
        OS.$out(Requirements.$at(I).first);
      }
      OS.$out(/*KEEP_STR*/$LF);
    }
    {
      Header H = null;
      try {
        
        H = getUmbrellaHeader();
        if (H.$bool()) {
          OS.indent(Indent + 2);
          OS.$out(/*KEEP_STR*/"umbrella header \"");
          OS.write_escaped(new StringRef(H.NameAsWritten));
          OS.$out(/*KEEP_STR*/$QUOTE_LF);
        } else {
          DirectoryName D = null;
          try {
            D = getUmbrellaDir();
            if (D.$bool()) {
              OS.indent(Indent + 2);
              OS.$out(/*KEEP_STR*/"umbrella \"");
              OS.write_escaped(new StringRef(D.NameAsWritten));
              OS.$out(/*KEEP_STR*/$QUOTE_LF);
            }
          } finally {
            if (D != null) { D.$destroy(); }
          }
        }
      } finally {
        if (H != null) { H.$destroy(); }
      }
    }
    if (!ConfigMacros.empty() || ConfigMacrosExhaustive) {
      OS.indent(Indent + 2);
      OS.$out(/*KEEP_STR*/"config_macros ");
      if (ConfigMacrosExhaustive) {
        OS.$out(/*KEEP_STR*/"[exhaustive]");
      }
      for (/*uint*/int I = 0, N = ConfigMacros.size(); I != N; ++I) {
        if ((I != 0)) {
          OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        OS.$out(ConfigMacros.$at(I));
      }
      OS.$out(/*KEEP_STR*/$LF);
    }
    
    //<editor-fold defaultstate="collapsed" desc="">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 377,
     FQN="", NM="_ZNK5clang6Module5printERN4llvm11raw_ostreamEj_Unnamed_struct",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module5printERN4llvm11raw_ostreamEj_Unnamed_struct")
    //</editor-fold>
     class/*struct*/ Unnamed_struct {
      public StringRef Prefix;
      public HeaderKind Kind;
      
      public Unnamed_struct(StringRef Prefix, HeaderKind Kind) {
        this.Prefix = Prefix;
        this.Kind = Kind;
      }
      
      public String toString() {
        return "" + "Prefix=" + Prefix // NOI18N
                  + ", Kind=" + Kind; // NOI18N
      }
    };
      Unnamed_struct Kinds[/*5*/] = new  Unnamed_struct[/*5*/] {
      new Unnamed_struct(new StringRef(/*KEEP_STR*/""), HeaderKind.HK_Normal), 
      new Unnamed_struct(new StringRef(/*KEEP_STR*/"textual "), HeaderKind.HK_Textual), 
      new Unnamed_struct(new StringRef(/*KEEP_STR*/"private "), HeaderKind.HK_Private), 
      new Unnamed_struct(new StringRef(/*KEEP_STR*/"private textual "), HeaderKind.HK_PrivateTextual), 
      new Unnamed_struct(new StringRef(/*KEEP_STR*/"exclude "), HeaderKind.HK_Excluded)};
    
    for (Unnamed_struct K : Kinds) {
      for (/*const*/ Header /*&*/ H : Headers[K.Kind.getValue()]) {
        OS.indent(Indent + 2);
        OS.$out(/*NO_COPY*/K.Prefix).$out(/*KEEP_STR*/"header \"");
        OS.write_escaped(new StringRef(H.NameAsWritten));
        OS.$out(/*KEEP_STR*/$QUOTE_LF);
      }
    }
    
    for (std.vector.iterator<Module /*P*/ > MI = submodule_begin(), MIEnd = submodule_end();
         $noteq___normal_iterator$C(MI, MIEnd); MI.$preInc())  {
      // Print inferred subframework modules so that we don't need to re-infer
      // them (requires expensive directory iteration + stat calls) when we build
      // the module. Regular inferred submodules are OK, as we need to look at all
      // those header files anyway.
      if (!(MI.$star()).IsInferred || (MI.$star()).IsFramework) {
        (MI.$star()).print(OS, Indent + 2);
      }
    }
    
    for (/*uint*/int I = 0, N = Exports.size(); I != N; ++I) {
      OS.indent(Indent + 2);
      OS.$out(/*KEEP_STR*/"export ");
      {
        Module /*P*/ Restriction = Exports.$at(I).getPointer();
        if ((Restriction != null)) {
          OS.$out(Restriction.getFullModuleName());
          if (Exports.$at(I).getInt() != 0) {
            OS.$out(/*KEEP_STR*/$DOT_STAR);
          }
        } else {
          OS.$out(/*KEEP_STR*/$STAR);
        }
      }
      OS.$out(/*KEEP_STR*/$LF);
    }
    
    for (/*uint*/int I = 0, N = UnresolvedExports.size(); I != N; ++I) {
      OS.indent(Indent + 2);
      OS.$out(/*KEEP_STR*/"export ");
      printModuleId(OS, UnresolvedExports.$at(I).Id);
      if (UnresolvedExports.$at(I).Wildcard) {
        OS.$out((UnresolvedExports.$at(I).Id.empty() ? $STAR : $DOT_STAR));
      }
      OS.$out(/*KEEP_STR*/$LF);
    }
    
    for (/*uint*/int I = 0, N = DirectUses.size(); I != N; ++I) {
      OS.indent(Indent + 2);
      OS.$out(/*KEEP_STR*/"use ");
      OS.$out(DirectUses.$at(I).getFullModuleName());
      OS.$out(/*KEEP_STR*/$LF);
    }
    
    for (/*uint*/int I = 0, N = UnresolvedDirectUses.size(); I != N; ++I) {
      OS.indent(Indent + 2);
      OS.$out(/*KEEP_STR*/"use ");
      printModuleId(OS, UnresolvedDirectUses.$at(I));
      OS.$out(/*KEEP_STR*/$LF);
    }
    
    for (/*uint*/int I = 0, N = LinkLibraries.size(); I != N; ++I) {
      OS.indent(Indent + 2);
      OS.$out(/*KEEP_STR*/"link ");
      if (LinkLibraries.$at(I).IsFramework) {
        OS.$out(/*KEEP_STR*/"framework ");
      }
      OS.$out(/*KEEP_STR*/$DBL_QUOTE);
      OS.write_escaped(new StringRef(LinkLibraries.$at(I).Library));
      OS.$out(/*KEEP_STR*/$DBL_QUOTE);
    }
    
    for (/*uint*/int I = 0, N = UnresolvedConflicts.size(); I != N; ++I) {
      OS.indent(Indent + 2);
      OS.$out(/*KEEP_STR*/"conflict ");
      printModuleId(OS, UnresolvedConflicts.$at(I).Id);
      OS.$out(/*KEEP_STR*/", \"");
      OS.write_escaped(new StringRef(UnresolvedConflicts.$at(I).Message));
      OS.$out(/*KEEP_STR*/$QUOTE_LF);
    }
    
    for (/*uint*/int I = 0, N = Conflicts.size(); I != N; ++I) {
      OS.indent(Indent + 2);
      OS.$out(/*KEEP_STR*/"conflict ");
      OS.$out(Conflicts.$at(I).Other.getFullModuleName());
      OS.$out(/*KEEP_STR*/", \"");
      OS.write_escaped(new StringRef(Conflicts.$at(I).Message));
      OS.$out(/*KEEP_STR*/$QUOTE_LF);
    }
    if (InferSubmodules) {
      OS.indent(Indent + 2);
      if (InferExplicitSubmodules) {
        OS.$out(/*KEEP_STR*/"explicit ");
      }
      OS.$out(/*KEEP_STR*/"module * {\n");
      if (InferExportWildcard) {
        OS.indent(Indent + 4);
        OS.$out(/*KEEP_STR*/"export *\n");
      }
      OS.indent(Indent + 2);
      OS.$out(/*KEEP_STR*/"}\n");
    }
    
    OS.indent(Indent);
    OS.$out(/*KEEP_STR*/"}\n");
  }

  
  /// \brief Dump the contents of this module to the given output stream.
  //<editor-fold defaultstate="collapsed" desc="clang::Module::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 485,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 489,
   FQN="clang::Module::dump", NM="_ZNK5clang6Module4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(llvm.errs());
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Module::buildVisibleModulesCache">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 304,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 271,
   FQN = "clang::Module::buildVisibleModulesCache", NM = "_ZNK5clang6Module24buildVisibleModulesCacheEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZNK5clang6Module24buildVisibleModulesCacheEv")
  //</editor-fold>
  private void buildVisibleModulesCache() /*const*/ {
    assert (VisibleModulesCache.empty()) : "cache does not need building";

    // This module is visible to itself.
    VisibleModulesCache.insert(this);

    // Every imported module is visible.
    SmallVector<Module /*P*/> Stack/*J*/= new SmallVector<Module /*P*/>(16, Imports.begin(), Imports.end(), (Module /*P*/)null);
    while (!Stack.empty()) {
      Module /*P*/ CurrModule = Stack.pop_back_val();

      // Every module transitively exported by an imported module is visible.
      if (VisibleModulesCache.insert(CurrModule).second) {
        CurrModule.getExportedModules(Stack);
      }
    }
  }

  
  public String toString() { 
    return "" + "Name=" + Name // NOI18N
              + ", DefinitionLoc=" + DefinitionLoc // NOI18N
              + ", Parent=" + NativeTrace.getIdentityStr(Parent) // NOI18N
              + ", Directory=" + Directory // NOI18N
              + ", Umbrella=" + Umbrella // NOI18N
              + ", Signature=" + Signature // NOI18N
              + ", UmbrellaAsWritten=" + UmbrellaAsWritten // NOI18N
              + ", SubModules=" + SubModules.size() // NOI18N
              + ", SubModuleIndex=" + SubModuleIndex // NOI18N
              + ", ASTFile=" + ASTFile // NOI18N
              + ", TopHeaders=" + TopHeaders.size() // NOI18N
              + ", TopHeaderNames=" + TopHeaderNames.size() // NOI18N
              + ", VisibleModulesCache=" + VisibleModulesCache.size() // NOI18N
              + ", VisibilityID=" + VisibilityID // NOI18N
              + ", Headers=" + Headers.length // NOI18N
              + ", MissingHeaders=" + MissingHeaders.size() // NOI18N
              + ", Requirements=" + Requirements.size() // NOI18N
              + ", IsMissingRequirement=" + IsMissingRequirement // NOI18N
              + ", HasIncompatibleModuleFile=" + HasIncompatibleModuleFile // NOI18N
              + ", IsAvailable=" + IsAvailable // NOI18N
              + ", IsFromModuleFile=" + IsFromModuleFile // NOI18N
              + ", IsFramework=" + IsFramework // NOI18N
              + ", IsExplicit=" + IsExplicit // NOI18N
              + ", IsSystem=" + IsSystem // NOI18N
              + ", IsExternC=" + IsExternC // NOI18N
              + ", IsInferred=" + IsInferred // NOI18N
              + ", InferSubmodules=" + InferSubmodules // NOI18N
              + ", InferExplicitSubmodules=" + InferExplicitSubmodules // NOI18N
              + ", InferExportWildcard=" + InferExportWildcard // NOI18N
              + ", ConfigMacrosExhaustive=" + ConfigMacrosExhaustive // NOI18N
              + ", NameVisibility=" + NameVisibility // NOI18N
              + ", InferredSubmoduleLoc=" + InferredSubmoduleLoc // NOI18N
              + ", Imports=" + Imports.size() // NOI18N
              + ", Exports=" + Exports.size() // NOI18N
              + ", UnresolvedExports=" + UnresolvedExports.size() // NOI18N
              + ", DirectUses=" + DirectUses.size() // NOI18N
              + ", UnresolvedDirectUses=" + UnresolvedDirectUses.size() // NOI18N
              + ", LinkLibraries=" + LinkLibraries.size() // NOI18N
              + ", ConfigMacros=" + ConfigMacros.size() // NOI18N
              + ", UnresolvedConflicts=" + UnresolvedConflicts.size() // NOI18N
              + ", Conflicts=" + Conflicts.size(); // NOI18N
  }
}