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

package org.clang.codegen;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.bitcode.*;
import org.clang.frontend.*;
import static org.llvm.java.LlvmRTTI.isa_COFFObjectFile;
import org.llvm.object.ObjectFile;
import org.llvm.object.SectionRef;


/// A PCHContainerReader implementation that uses LLVM to
/// wraps Clang modules inside a COFF, ELF, or Mach-O container.
//<editor-fold defaultstate="collapsed" desc="clang::ObjectFilePCHContainerReader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/ObjectFilePCHContainerOperations.h", line = 35,
 FQN="clang::ObjectFilePCHContainerReader", NM="_ZN5clang28ObjectFilePCHContainerReaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN5clang28ObjectFilePCHContainerReaderE")
//</editor-fold>
public class ObjectFilePCHContainerReader extends /*public*/ PCHContainerReader implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ObjectFilePCHContainerReader::getFormat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/ObjectFilePCHContainerOperations.h", line = 36,
   FQN="clang::ObjectFilePCHContainerReader::getFormat", NM="_ZNK5clang28ObjectFilePCHContainerReader9getFormatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK5clang28ObjectFilePCHContainerReader9getFormatEv")
  //</editor-fold>
  @Override public/*private*/ StringRef getFormat() /*const*//* override*/ {
    return new StringRef(/*KEEP_STR*/"obj");
  }

  
  /// Initialize an llvm::BitstreamReader with the serialized
  /// AST inside the PCH container Buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjectFilePCHContainerReader::ExtractPCH">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp", line = 315,
   FQN="clang::ObjectFilePCHContainerReader::ExtractPCH", NM="_ZNK5clang28ObjectFilePCHContainerReader10ExtractPCHEN4llvm15MemoryBufferRefERNS1_15BitstreamReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK5clang28ObjectFilePCHContainerReader10ExtractPCHEN4llvm15MemoryBufferRefERNS1_15BitstreamReaderE")
  //</editor-fold>
  @Override public/*private*/ void ExtractPCH(MemoryBufferRef Buffer, final BitstreamReader /*&*/ StreamFile) /*const*//* override*/ {
    {
      Expected<unique_ptr<ObjectFile> > OF = null;
      try {
        OF = ObjectFile.createObjectFile(new MemoryBufferRef(Buffer));
        if (OF.$bool()) {
          ObjectFile /*P*/ Obj = OF.get().get();
          boolean IsCOFF = isa_COFFObjectFile(Obj);
          // Find the clang AST section in the container.
          for (final /*const*/ SectionRef /*&*/ Section : OF.$arrow().get().sections()) {
            StringRef Name/*J*/= new StringRef();
            Section.getName(Name);
            if ((!IsCOFF && $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"__clangast"))
               || (IsCOFF && $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"clangast"))) {
              StringRef Buf/*J*/= new StringRef();
              Section.getContents(Buf);
              StreamFile.init(reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Buf.begin()), 
                  reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Buf.end()));
              return;
            }
          }
        }
      } finally {
        if (OF != null) { OF.$destroy(); }
      }
    }
    
    // As a fallback, treat the buffer as a raw AST.
    StreamFile.init(reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Buffer.getBufferStart()), 
        reinterpret_cast(/*const*/char$ptr/*uchar P*/ .class, Buffer.getBufferEnd()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjectFilePCHContainerReader::~ObjectFilePCHContainerReader">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/ObjectFilePCHContainerOperations.h", line = 35,
   FQN="clang::ObjectFilePCHContainerReader::~ObjectFilePCHContainerReader", NM="_ZN5clang28ObjectFilePCHContainerReaderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN5clang28ObjectFilePCHContainerReaderD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ObjectFilePCHContainerReader::ObjectFilePCHContainerReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/ObjectFilePCHContainerOperations.h", line = 35,
   FQN="clang::ObjectFilePCHContainerReader::ObjectFilePCHContainerReader", NM="_ZN5clang28ObjectFilePCHContainerReaderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp -nm=_ZN5clang28ObjectFilePCHContainerReaderC1Ev")
  //</editor-fold>
  public /*inline*/ ObjectFilePCHContainerReader() {
    // : PCHContainerReader() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
