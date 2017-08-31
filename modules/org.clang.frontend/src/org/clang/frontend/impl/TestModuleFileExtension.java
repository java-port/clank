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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.serialization.*;
import org.clang.frontend.impl.*;
import org.llvm.adt.HashingGlobals.hash_code;
import static org.llvm.adt.HashingGlobals.*;
import org.llvm.bitcode.*;


/// A module file extension used for testing purposes.
//<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.h", line = 21,
 FQN="clang::TestModuleFileExtension", NM="_ZN5clang23TestModuleFileExtensionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZN5clang23TestModuleFileExtensionE")
//</editor-fold>
public class TestModuleFileExtension extends /*public*/ ModuleFileExtension implements Destructors.ClassWithDestructor {
  private std.string BlockName;
  private /*uint*/int MajorVersion;
  private /*uint*/int MinorVersion;
  private boolean Hashed;
  private std.string UserInfo;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension::Writer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.h", line = 28,
   FQN="clang::TestModuleFileExtension::Writer", NM="_ZN5clang23TestModuleFileExtension6WriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZN5clang23TestModuleFileExtension6WriterE")
  //</editor-fold>
  private static class Writer extends /*public*/ ModuleFileExtensionWriter implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension::Writer::Writer">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.h", line = 30,
     FQN="clang::TestModuleFileExtension::Writer::Writer", NM="_ZN5clang23TestModuleFileExtension6WriterC1EPNS_19ModuleFileExtensionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZN5clang23TestModuleFileExtension6WriterC1EPNS_19ModuleFileExtensionE")
    //</editor-fold>
    public Writer(ModuleFileExtension /*P*/ Ext) {
      // : ModuleFileExtensionWriter(Ext) 
      //START JInit
      super(Ext);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension::Writer::~Writer">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", line = 19,
     FQN="clang::TestModuleFileExtension::Writer::~Writer", NM="_ZN5clang23TestModuleFileExtension6WriterD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZN5clang23TestModuleFileExtension6WriterD0Ev")
    //</editor-fold>
    @Override public void $destroy()/* override*/ {
      super.$destroy();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension::Writer::writeExtensionContents">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", line = 21,
     FQN="clang::TestModuleFileExtension::Writer::writeExtensionContents", NM="_ZN5clang23TestModuleFileExtension6Writer22writeExtensionContentsERNS_4SemaERN4llvm15BitstreamWriterE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZN5clang23TestModuleFileExtension6Writer22writeExtensionContentsERNS_4SemaERN4llvm15BitstreamWriterE")
    //</editor-fold>
    @Override public void writeExtensionContents(Sema /*&*/ SemaRef, 
                          BitstreamWriter /*&*/ Stream)/* override*/ {
      //JAVA: using namespace llvm;
      
      // Write an abbreviation for this record.
      BitCodeAbbrev /*P*/ Abv = new BitCodeAbbrev();
      Abv.Add(new BitCodeAbbrevOp(ExtensionBlockRecordTypes.FIRST_EXTENSION_RECORD_ID));
      Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, 6)); // # of characters
      Abv.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // message
      /*uint*/int Abbrev = Stream.EmitAbbrev(Abv);
      
      // Write a message into the extension block.
      SmallString/*64*/ Message/*J*/= new SmallString/*64*/(64);
      {
        raw_svector_ostream OS = null;
        try {
          TestModuleFileExtension /*P*/ Ext = ((/*static_cast*/TestModuleFileExtension /*P*/ )(getExtension()));
          OS/*J*/= new raw_svector_ostream(Message);
          OS.$out(/*KEEP_STR*/"Hello from ").$out(Ext.BlockName).$out(/*KEEP_STR*/" v").$out_uint(Ext.MajorVersion).$out(/*KEEP_STR*/$DOT).$out_uint(
              Ext.MinorVersion
          );
        } finally {
          if (OS != null) { OS.$destroy(); }
        }
      }
      long/*uint64_t*/ Record[/*2*/] = new$long(2, ExtensionBlockRecordTypes.FIRST_EXTENSION_RECORD_ID, $uint2ulong(Message.size()));
      Stream.EmitRecordWithBlob(Abbrev, Record, Message.$StringRef());
    }

    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension::Reader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.h", line = 37,
   FQN="clang::TestModuleFileExtension::Reader", NM="_ZN5clang23TestModuleFileExtension6ReaderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZN5clang23TestModuleFileExtension6ReaderE")
  //</editor-fold>
  private static class Reader extends /*public*/ ModuleFileExtensionReader implements Destructors.ClassWithDestructor {
    private BitstreamCursor Stream;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension::Reader::~Reader">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", line = 77,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", old_line = 79,
     FQN="clang::TestModuleFileExtension::Reader::~Reader", NM="_ZN5clang23TestModuleFileExtension6ReaderD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZN5clang23TestModuleFileExtension6ReaderD0Ev")
    //</editor-fold>
    @Override public void $destroy()/* override*/ {
      //START JDestroy
      Stream.$destroy();
      super.$destroy();
      //END JDestroy
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension::Reader::Reader">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", line = 45,
     old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", old_line = 47,
     FQN="clang::TestModuleFileExtension::Reader::Reader", NM="_ZN5clang23TestModuleFileExtension6ReaderC1EPNS_19ModuleFileExtensionERKN4llvm15BitstreamCursorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZN5clang23TestModuleFileExtension6ReaderC1EPNS_19ModuleFileExtensionERKN4llvm15BitstreamCursorE")
    //</editor-fold>
    public Reader(ModuleFileExtension /*P*/ Ext, 
        /*const*/ BitstreamCursor /*&*/ InStream) {
      // : ModuleFileExtensionReader(Ext), Stream(InStream) 
      //START JInit
      super(Ext);
      this.Stream = new BitstreamCursor(InStream);
      //END JInit
      // Read the extension block.
      SmallVectorULong Record/*J*/= new SmallVectorULong(4, 0);
      while (true) {
        BitstreamEntry Entry = Stream.advanceSkippingSubblocks();
        switch (Entry.Kind) {
         case SubBlock:
         case EndBlock:
         case Error:
          return;
         case Record:
          break;
        }
        
        Record.clear();
        StringRef Blob/*J*/= new StringRef();
        /*uint*/int RecCode = Stream.readRecord(Entry.ID, Record, /*AddrOf*/Blob);
        switch (RecCode) {
         case ExtensionBlockRecordTypes.FIRST_EXTENSION_RECORD_ID:
          {
            StringRef Message = Blob.substr(0, $ullong2uint(Record.$at(0)));
            fprintf(stderr, /*KEEP_STR*/"Read extension block message: %s\n", 
                Message.str().c_str());
            break;
          }
        }
      }
    }

    
    @Override public String toString() {
      return "" + "Stream=" + Stream // NOI18N
                + super.toString(); // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension::TestModuleFileExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.h", line = 47,
   FQN="clang::TestModuleFileExtension::TestModuleFileExtension", NM="_ZN5clang23TestModuleFileExtensionC1EN4llvm9StringRefEjjbS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZN5clang23TestModuleFileExtensionC1EN4llvm9StringRefEjjbS2_")
  //</editor-fold>
  public TestModuleFileExtension(StringRef BlockName, 
      /*uint*/int MajorVersion, 
      /*uint*/int MinorVersion, 
      boolean Hashed, 
      StringRef UserInfo) {
    // : ModuleFileExtension(), BlockName(BlockName.operator basic_string()), MajorVersion(MajorVersion), MinorVersion(MinorVersion), Hashed(Hashed), UserInfo(UserInfo.operator basic_string()) 
    //START JInit
    super();
    this.BlockName = BlockName.$string();
    this.MajorVersion = MajorVersion;
    this.MinorVersion = MinorVersion;
    this.Hashed = Hashed;
    this.UserInfo = UserInfo.$string();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension::~TestModuleFileExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", line = 79,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", old_line = 81,
   FQN="clang::TestModuleFileExtension::~TestModuleFileExtension", NM="_ZN5clang23TestModuleFileExtensionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZN5clang23TestModuleFileExtensionD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    UserInfo.$destroy();
    BlockName.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension::getExtensionMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", line = 81,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", old_line = 83,
   FQN="clang::TestModuleFileExtension::getExtensionMetadata", NM="_ZNK5clang23TestModuleFileExtension20getExtensionMetadataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZNK5clang23TestModuleFileExtension20getExtensionMetadataEv")
  //</editor-fold>
  @Override public ModuleFileExtensionMetadata getExtensionMetadata() /*const*//* override*/ {
    return new ModuleFileExtensionMetadata(BlockName, MajorVersion, MinorVersion, UserInfo);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension::hashExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", line = 86,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", old_line = 88,
   FQN="clang::TestModuleFileExtension::hashExtension", NM="_ZNK5clang23TestModuleFileExtension13hashExtensionEN4llvm9hash_codeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZNK5clang23TestModuleFileExtension13hashExtensionEN4llvm9hash_codeE")
  //</editor-fold>
  @Override public hash_code hashExtension(hash_code Code) /*const*//* override*/ {
    if (Hashed) {
      Code.$assignMove(hash_combine(Code, BlockName));
      Code.$assignMove(hash_combine(Code, MajorVersion));
      Code.$assignMove(hash_combine(Code, MinorVersion));
      Code.$assignMove(hash_combine(Code, UserInfo));
    }
    
    return new hash_code(JD$Move.INSTANCE, Code);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension::createExtensionWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", line = 98,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", old_line = 100,
   FQN="clang::TestModuleFileExtension::createExtensionWriter", NM="_ZN5clang23TestModuleFileExtension21createExtensionWriterERNS_9ASTWriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZN5clang23TestModuleFileExtension21createExtensionWriterERNS_9ASTWriterE")
  //</editor-fold>
  @Override public std.unique_ptr<ModuleFileExtensionWriter> createExtensionWriter(ASTWriter /*&*/ $Prm0)/* override*/ {
    return new std.unique_ptr<ModuleFileExtensionWriter>(new Writer(this));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TestModuleFileExtension::createExtensionReader">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", line = 103,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp", old_line = 105,
   FQN="clang::TestModuleFileExtension::createExtensionReader", NM="_ZN5clang23TestModuleFileExtension21createExtensionReaderERKNS_27ModuleFileExtensionMetadataERNS_9ASTReaderERNS_13serialization10ModuleFileERKN4llvm15BitstreamCursorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp -nm=_ZN5clang23TestModuleFileExtension21createExtensionReaderERKNS_27ModuleFileExtensionMetadataERNS_9ASTReaderERNS_13serialization10ModuleFileERKN4llvm15BitstreamCursorE")
  //</editor-fold>
  @Override public std.unique_ptr<ModuleFileExtensionReader> createExtensionReader(/*const*/ ModuleFileExtensionMetadata /*&*/ Metadata, 
                       ASTReader /*&*/ Reader, ModuleFile /*&*/ Mod, 
                       /*const*/ BitstreamCursor /*&*/ Stream)/* override*/ {
    assert ($eq_str$C(Metadata.BlockName, BlockName)) : "Wrong block name";
    if ($noteq_pair$_T1$_T2$C(std.make_pair_uint_uint(Metadata.MajorVersion, Metadata.MinorVersion), 
        std.make_pair_uint_uint(MajorVersion, MinorVersion))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_StringRef($c$.track(Reader.getDiags().Report(/*NO_COPY*/Mod.ImportLoc, 
                                diag.err_test_module_file_extension_version)), 
                            new StringRef(BlockName)), Metadata.MajorVersion), Metadata.MinorVersion), 
                MajorVersion), MinorVersion));
        return new std.unique_ptr<ModuleFileExtensionReader>(JD$NullPtr.INSTANCE, null);
      } finally {
        $c$.$destroy();
      }
    }
    
    return new std.unique_ptr<ModuleFileExtensionReader>(new TestModuleFileExtension.Reader(this, Stream));
  }

  
  @Override public String toString() {
    return "" + "BlockName=" + BlockName // NOI18N
              + ", MajorVersion=" + MajorVersion // NOI18N
              + ", MinorVersion=" + MinorVersion // NOI18N
              + ", Hashed=" + Hashed // NOI18N
              + ", UserInfo=" + UserInfo // NOI18N
              + super.toString(); // NOI18N
  }
}
