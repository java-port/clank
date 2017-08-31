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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.Native.NativePOD;


//===----------------------------------------------------------------------===//
// Line Table Implementation
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::LineEntry">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 29,
 FQN="clang::LineEntry", NM="_ZN5clang9LineEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang9LineEntryE")
//</editor-fold>
public class/*struct*/ LineEntry implements Native.OpCapable, NativePOD<LineEntry> {
  /// \brief The offset in this file that the line entry occurs at.
  public /*uint*/int FileOffset;
  
  /// \brief The presumed line number of this line entry: \#line 4.
  public /*uint*/int LineNo;
  
  /// \brief The ID of the filename identified by this line entry:
  /// \#line 4 "foo.c".  This is -1 if not specified.
  public int FilenameID;
  
  /// \brief Set the 0 if no flags, 1 if a system header,
  public SrcMgr.CharacteristicKind FileKind;
  
  /// \brief The offset of the virtual include stack location,
  /// which is manipulated by GNU linemarker directives.
  ///
  /// If this is 0 then there is no virtual \#includer.
  public /*uint*/int IncludeOffset;
  
  //<editor-fold defaultstate="collapsed" desc="clang::LineEntry::get">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 49,
   FQN="clang::LineEntry::get", NM="_ZN5clang9LineEntry3getEjjiNS_6SrcMgr18CharacteristicKindEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang9LineEntry3getEjjiNS_6SrcMgr18CharacteristicKindEj")
  //</editor-fold>
  public static LineEntry get(/*uint*/int Offs, /*uint*/int Line, int Filename, 
     SrcMgr.CharacteristicKind FileKind, 
     /*uint*/int IncludeOffset) {
    LineEntry E/*J*/= new LineEntry();
    E.FileOffset = Offs;
    E.LineNo = Line;
    E.FilenameID = Filename;
    E.FileKind = FileKind;
    E.IncludeOffset = IncludeOffset;
    return E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LineEntry::LineEntry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 29,
   FQN="clang::LineEntry::LineEntry", NM="_ZN5clang9LineEntryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang9LineEntryC1Ev")
  //</editor-fold>
  public /*inline*/ LineEntry() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LineEntry::LineEntry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 29,
   FQN="clang::LineEntry::LineEntry", NM="_ZN5clang9LineEntryC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang9LineEntryC1EOS0_")
  //</editor-fold>
  public /*inline*/ LineEntry(JD$Move _dparam, LineEntry /*&&*/$Prm0) {
    /* : FileOffset(static_cast<LineEntry &&>().FileOffset), LineNo(static_cast<LineEntry &&>().LineNo), FilenameID(static_cast<LineEntry &&>().FilenameID), FileKind(static_cast<LineEntry &&>().FileKind), IncludeOffset(static_cast<LineEntry &&>().IncludeOffset)*/ 
    //START JInit
    this.FileOffset = $Prm0.FileOffset;
    this.LineNo = $Prm0.LineNo;
    this.FilenameID = $Prm0.FilenameID;
    this.FileKind = $Prm0.FileKind;
    this.IncludeOffset = $Prm0.IncludeOffset;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LineEntry::LineEntry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 29,
   FQN = "clang::LineEntry::LineEntry", NM = "_ZN5clang9LineEntryC1ERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang9LineEntryC1ERKS0_")
  //</editor-fold>
  public /*inline*/ LineEntry(/*const*/LineEntry /*&*/ $Prm0)/* throw()*/ {
    /* : FileOffset(.FileOffset), LineNo(.LineNo), FilenameID(.FilenameID), FileKind(.FileKind), IncludeOffset(.IncludeOffset)*/ 
    //START JInit
    this.FileOffset = $Prm0.FileOffset;
    this.LineNo = $Prm0.LineNo;
    this.FilenameID = $Prm0.FilenameID;
    this.FileKind = $Prm0.FileKind;
    this.IncludeOffset = $Prm0.IncludeOffset;
    //END JInit
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::LineEntry::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 29,
   FQN = "clang::LineEntry::operator=", NM = "_ZN5clang9LineEntryaSERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang9LineEntryaSERKS0_")
  //</editor-fold>
  public /*inline*/ LineEntry /*&*/ $assign(/*const*/LineEntry /*&*/ $Prm0)/* throw()*/ {
    this.FileOffset = $Prm0.FileOffset;
    this.LineNo = $Prm0.LineNo;
    this.FilenameID = $Prm0.FilenameID;
    this.FileKind = $Prm0.FileKind;
    this.IncludeOffset = $Prm0.IncludeOffset;
    return /*Deref*/this;
  }

  @Override
  public Boolean $op(Op k, Object obj) {
    // support this < obj
    if (k == Op.LESS) {
      if (obj instanceof Number) {
        return BasicClangGlobals.$less_LineEntry$C_uint(this, ((Number)obj).intValue());
      } else if (obj instanceof LineEntry) {
        return BasicClangGlobals.$less_LineEntry$C(this, (LineEntry)obj);
      }
    } else if (k == Op.GREATER) {
      if (obj instanceof Number) {
        return BasicClangGlobals.$less_uint_LineEntry$C(((Number) obj).intValue(), this);
      }
      assert !(obj instanceof LineEntry) : "it's strange to see call for GREATER, shouldn't be used LESS?";
    }
    return null;
  }

  @Override
  public LineEntry clone() {
    return new LineEntry(this);
  }
  
  @Override
  public String toString() {
    return "" + "FileOffset=" + FileOffset // NOI18N
              + ", LineNo=" + LineNo // NOI18N
              + ", FilenameID=" + FilenameID // NOI18N
              + ", FileKind=" + FileKind // NOI18N
              + ", IncludeOffset=" + IncludeOffset; // NOI18N
  }
}
