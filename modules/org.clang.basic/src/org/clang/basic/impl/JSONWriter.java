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

import org.clank.support.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.vfs.*;
import org.llvm.support.sys.path;
import org.llvm.support.sys.path.const_iterator;
import org.llvm.support.yaml.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JSONWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1607,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1397,
 FQN="(anonymous namespace)::JSONWriter", NM="_ZN12_GLOBAL__N_110JSONWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_110JSONWriterE")
//</editor-fold>
public class JSONWriter implements Destructors.ClassWithDestructor {
  private raw_ostream /*&*/ OS;
  private SmallVector<StringRef> DirStack;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JSONWriter::getDirIndent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1610,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1400,
   FQN="(anonymous namespace)::JSONWriter::getDirIndent", NM="_ZN12_GLOBAL__N_110JSONWriter12getDirIndentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_110JSONWriter12getDirIndentEv")
  //</editor-fold>
  private /*inline*/ /*uint*/int getDirIndent() {
    return 4 * DirStack.size();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JSONWriter::getFileIndent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1611,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1401,
   FQN="(anonymous namespace)::JSONWriter::getFileIndent", NM="_ZN12_GLOBAL__N_110JSONWriter13getFileIndentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_110JSONWriter13getFileIndentEv")
  //</editor-fold>
  private /*inline*/ /*uint*/int getFileIndent() {
    return 4 * (DirStack.size() + 1);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JSONWriter::containedIn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1626,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1414,
   FQN="(anonymous namespace)::JSONWriter::containedIn", NM="_ZN12_GLOBAL__N_110JSONWriter11containedInEN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_110JSONWriter11containedInEN4llvm9StringRefES2_")
  //</editor-fold>
  private boolean containedIn(StringRef Parent, StringRef Path) {
    //JAVA: using namespace llvm::sys;
    // Compare each path component.
    const_iterator IParent = path.begin(/*NO_COPY*/Parent), EParent = path.end(/*NO_COPY*/Parent);
    for (const_iterator IChild = path.begin(/*NO_COPY*/Path), EChild = path.end(/*NO_COPY*/Path);
         IParent.$noteq(EParent) && IChild.$noteq(EChild); IParent.$preInc() , IChild.$preInc()) {
      if ($noteq_StringRef(/*NO_COPY*/IParent.$star(), /*NO_COPY*/IChild.$star())) {
        return false;
      }
    }
    // Have we exhausted the parent path?
    return IParent.$eq(EParent);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JSONWriter::containedPart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1639,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1427,
   FQN="(anonymous namespace)::JSONWriter::containedPart", NM="_ZN12_GLOBAL__N_110JSONWriter13containedPartEN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_110JSONWriter13containedPartEN4llvm9StringRefES2_")
  //</editor-fold>
  private StringRef containedPart(StringRef Parent, StringRef Path) {
    assert (!Parent.empty());
    assert (containedIn(new StringRef(Parent), new StringRef(Path)));
    return Path.slice(Parent.size() + 1, StringRef.npos);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JSONWriter::startDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1645,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1433,
   FQN="(anonymous namespace)::JSONWriter::startDirectory", NM="_ZN12_GLOBAL__N_110JSONWriter14startDirectoryEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_110JSONWriter14startDirectoryEN4llvm9StringRefE")
  //</editor-fold>
  private void startDirectory(StringRef Path) {
    StringRef Name = DirStack.empty() ? new StringRef(Path) : containedPart(new StringRef(DirStack.back()), new StringRef(Path));
    DirStack.push_back(Path);
    /*uint*/int Indent = getDirIndent();
    OS.indent(Indent).$out(/*KEEP_STR*/"{\n");
    OS.indent(Indent + 2).$out(/*KEEP_STR*/"'type': 'directory',\n");
    OS.indent(Indent + 2).$out(/*KEEP_STR*/"'name': \"").$out(YamlGlobals.escape(new StringRef(Name))).$out(/*KEEP_STR*/"\",\n");
    OS.indent(Indent + 2).$out(/*KEEP_STR*/"'contents': [\n");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JSONWriter::endDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1656,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1444,
   FQN="(anonymous namespace)::JSONWriter::endDirectory", NM="_ZN12_GLOBAL__N_110JSONWriter12endDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_110JSONWriter12endDirectoryEv")
  //</editor-fold>
  private void endDirectory() {
    /*uint*/int Indent = getDirIndent();
    OS.indent(Indent + 2).$out(/*KEEP_STR*/"]\n");
    OS.indent(Indent).$out(/*KEEP_STR*/$RCURLY);
    
    DirStack.pop_back();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JSONWriter::writeEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1664,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1452,
   FQN="(anonymous namespace)::JSONWriter::writeEntry", NM="_ZN12_GLOBAL__N_110JSONWriter10writeEntryEN4llvm9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_110JSONWriter10writeEntryEN4llvm9StringRefES2_")
  //</editor-fold>
  private void writeEntry(StringRef VPath, StringRef RPath) {
    /*uint*/int Indent = getFileIndent();
    OS.indent(Indent).$out(/*KEEP_STR*/"{\n");
    OS.indent(Indent + 2).$out(/*KEEP_STR*/"'type': 'file',\n");
    OS.indent(Indent + 2).$out(/*KEEP_STR*/"'name': \"").$out(YamlGlobals.escape(new StringRef(VPath))).$out(/*KEEP_STR*/"\",\n");
    OS.indent(Indent + 2).$out(/*KEEP_STR*/"'external-contents': \"").$out(YamlGlobals.escape(new StringRef(RPath))).$out(/*KEEP_STR*/$QUOTE_LF);
    OS.indent(Indent).$out(/*KEEP_STR*/$RCURLY);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JSONWriter::JSONWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1619,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1409,
   FQN="(anonymous namespace)::JSONWriter::JSONWriter", NM="_ZN12_GLOBAL__N_110JSONWriterC1ERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_110JSONWriterC1ERN4llvm11raw_ostreamE")
  //</editor-fold>
  public JSONWriter(raw_ostream /*&*/ OS) {
    /* : OS(OS), DirStack()*/ 
    //START JInit
    this./*&*/OS=/*&*/OS;
    this.DirStack = new SmallVector<StringRef>(16, new StringRef());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JSONWriter::write">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1674,
   FQN="(anonymous namespace)::JSONWriter::write", NM="_ZN12_GLOBAL__N_110JSONWriter5writeEN4llvm8ArrayRefIN5clang3vfs12YAMLVFSEntryEEENS1_8OptionalIbEES8_S8_NS1_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_110JSONWriter5writeEN4llvm8ArrayRefIN5clang3vfs12YAMLVFSEntryEEENS1_8OptionalIbEES8_S8_NS1_9StringRefE")
  //</editor-fold>
  public void write(ArrayRef<YAMLVFSEntry> Entries, 
       OptionalBool UseExternalNames, 
       OptionalBool IsCaseSensitive, 
       OptionalBool IsOverlayRelative, 
       StringRef OverlayDir) {
    //JAVA: using namespace llvm::sys;
    
    OS.$out(/*KEEP_STR*/"{\n  'version': 0,\n");
    if (IsCaseSensitive.hasValue()) {
      OS.$out(/*KEEP_STR*/"  'case-sensitive': '").$out((IsCaseSensitive.getValue() ? $true : $false)).$out(/*KEEP_STR*/"',\n");
    }
    if (UseExternalNames.hasValue()) {
      OS.$out(/*KEEP_STR*/"  'use-external-names': '").$out((UseExternalNames.getValue() ? $true : $false)).$out(/*KEEP_STR*/"',\n");
    }
    boolean UseOverlayRelative = false;
    if (IsOverlayRelative.hasValue()) {
      UseOverlayRelative = IsOverlayRelative.getValue();
      OS.$out(/*KEEP_STR*/"  'overlay-relative': '").$out((UseOverlayRelative ? $true : $false)).$out(/*KEEP_STR*/"',\n");
    }
    OS.$out(/*KEEP_STR*/"  'roots': [\n");
    if (!Entries.empty()) {
      /*const*/ YAMLVFSEntry /*&*/ Entry = Entries.front();
      startDirectory(path.parent_path(new StringRef(Entry.VPath)));
      
      StringRef RPath = new StringRef(Entry.RPath);
      if (UseOverlayRelative) {
        /*uint*/int OverlayDirLen = OverlayDir.size();
        assert ($eq_StringRef(RPath.substr(0, OverlayDirLen), /*NO_COPY*/OverlayDir)) : "Overlay dir must be contained in RPath";
        RPath.$assignMove(RPath.slice(OverlayDirLen, RPath.size()));
      }
      
      writeEntry(path.filename(new StringRef(Entry.VPath)), new StringRef(RPath));
      
      for (/*const*/ YAMLVFSEntry /*&*/ _Entry : Entries.slice(1)) {
        StringRef Dir = path.parent_path(new StringRef(_Entry.VPath));
        if ($eq_StringRef(/*NO_COPY*/Dir, /*NO_COPY*/DirStack.back())) {
          OS.$out(/*KEEP_STR*/",\n");
        } else {
          while (!DirStack.empty() && !containedIn(new StringRef(DirStack.back()), new StringRef(Dir))) {
            OS.$out(/*KEEP_STR*/$LF);
            endDirectory();
          }
          OS.$out(/*KEEP_STR*/",\n");
          startDirectory(new StringRef(Dir));
        }
        StringRef _RPath = new StringRef(_Entry.RPath);
        if (UseOverlayRelative) {
          /*uint*/int OverlayDirLen = OverlayDir.size();
          assert ($eq_StringRef(_RPath.substr(0, OverlayDirLen), /*NO_COPY*/OverlayDir)) : "Overlay dir must be contained in RPath";
          _RPath.$assignMove(_RPath.slice(OverlayDirLen, _RPath.size()));
        }
        writeEntry(path.filename(new StringRef(_Entry.VPath)), new StringRef(_RPath));
      }
      while (!DirStack.empty()) {
        OS.$out(/*KEEP_STR*/$LF);
        endDirectory();
      }
      OS.$out(/*KEEP_STR*/$LF);
    }
    
    OS.$out(/*KEEP_STR*/"  ]\n").$out(/*KEEP_STR*/"}\n");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::JSONWriter::~JSONWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 1607,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 1397,
   FQN="(anonymous namespace)::JSONWriter::~JSONWriter", NM="_ZN12_GLOBAL__N_110JSONWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_110JSONWriterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    DirStack.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "OS=" + OS // NOI18N
              + ", DirStack=" + DirStack; // NOI18N
  }
}
